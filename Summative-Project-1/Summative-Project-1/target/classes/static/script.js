function getQuote() {
  fetch('http://localhost:8080/quote')
    .then(response => response.json())
    .then(data => {
      const quote = data[0];
      document.getElementById('quoteText').innerHTML = "Id: " + quote.id + "<br>Quote: " + quote.quote + "<br>Author: " + quote.author;
    })
    .catch(error => console.error(error));
}

function getWord() {
  fetch('http://localhost:8080/word')
    .then(response => response.json())
    .then(data => {
      const word = data;
      document.getElementById('wordText').innerHTML = "Id: " + word.id + "<br>Word: " + word.word + "<br>Definition: " + word.definition;
    })
    .catch(error => console.error(error));
}

document.getElementById('askButton').addEventListener('click', function() {
    let question = document.getElementById('questionInput').value;
    fetch('http://localhost:8080/magic', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({question: question}),
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('answerText').innerHTML = "Id: " + data.id + "<br>Question: " + data.question + "<br>Answer: " + data.answer;
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

