function getQuote() {
  fetch('http://localhost:8080/quote')
    .then(response => response.json())
    .then(data => {
      const quote = data[0];
      document.getElementById('quoteText').textContent = quote.quote;
    })
    .catch(error => console.error(error));
}

function getWord() {
  fetch('http://localhost:8080/word')
    .then(response => response.json())
    .then(data => {
      const quote = data[0];
      document.getElementById('wordText').textContent = word.word;
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
        body: JSON.stringify(question),
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('answerText').textContent = data.answer;
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});
