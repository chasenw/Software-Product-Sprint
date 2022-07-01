// Copyright 2020 Google LLC
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

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Steph Curry!', 'Lebron James', 'Jayson Tatum', 'Luka Doncic'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;

  console.log(greeting)
}

/** Fetches the current date from the server and adds it to the page. */
async function showBestCity() {
    const responseFromServer = await fetch('/city');
    const textFromResponse = await responseFromServer.text();
  
    const citySpace = document.getElementById('cityContainer');
    citySpace.innerText = textFromResponse;
  }

  async function showRandomMessage() {
    const responseFromServer = await fetch('/random');
    const textFromResponse = await responseFromServer.json();

    console.log(textFromResponse)

    const rNum = Math.floor(Math.random() * 3) + 1

    const mSpace = document.getElementById('messageContainer')

    if (rNum == 1) {
        mSpace.innerText = textFromResponse.m1
    }
    if (rNum == 2) {
        mSpace.innerText = textFromResponse.m2
    }
    if (rNum == 3) {
        mSpace.innerText = textFromResponse.m3
    }
  
  //  const citySpace = document.getElementById('cityContainer');
  //  citySpace.innerText = textFromResponse;
  }


  
