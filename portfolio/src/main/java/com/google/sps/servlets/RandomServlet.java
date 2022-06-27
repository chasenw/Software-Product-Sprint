// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/random")
public final class RandomServlet extends HttpServlet {

  private final ArrayList<String> messages = new ArrayList<String>();
  

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    messages.add("Lucky message");
    messages.add("Bad");
    messages.add("Ok");

    // Convert the server stats to JSON
    
    String json = convertToJson(messages);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  /**
   * Converts a ServerStats instance into a JSON string using manual String concatentation.
   */
  private String convertToJson(ArrayList<String> array) {
    String json = "{";
    json += "\"m1\": ";
    json += "\"" + array.get(0) + "\"";
    json += ", ";
    json += "\"m2\": ";
    json += "\"" + array.get(1) + "\"";
    json += ", ";
    json += "\"m3\": ";
    json += "\"" + array.get(2) + "\"";
    
    json += "}";
    return json;
  }

  /**
   * Converts a ServerStats instance into a JSON string using the Gson library. Note: We first added
   * the Gson library dependency to pom.xml.
   */
  private String convertToJsonUsingGson(ArrayList<String> serverStats) {
    Gson gson = new Gson();
    String json = gson.toJson(serverStats);
    return json;
  }
}
