const BASE_URL = "http://localhost:8080/api/expenses";


function addExpense() {

    const amount = document.getElementById("amount").value;
    const date = document.getElementById("date").value;
    const type = document.getElementById("type").value;
    const description = document.getElementById("description").value;

    const expense = {
        amount: parseFloat(amount),
        date: date,
        type: type,
        description: description
    };

    fetch(BASE_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(expense)
    })
    .then(response => response.json())
    .then(data => {
        alert("Transaction Added Successfully!");
        console.log(data);
    })
    .catch(error => console.error("Error:", error));
}



function getSummary() {

    const year = document.getElementById("year").value;
    const month = document.getElementById("month").value;

    fetch(`${BASE_URL}/summary?year=${year}&month=${month}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("result").innerHTML =
                "Total Income: ₹" + data.totalIncome +
                "<br>Total Expense: ₹" + data.totalExpense +
                "<br>Net Balance: ₹" + data.netBalance;
        })
        .catch(error => console.error("Error:", error));
}
function clearAll() {

    if (confirm("Are you sure you want to delete all data?")) {

        fetch("http://localhost:8080/api/expenses/clear", {
            method: "DELETE"
        })
        .then(response => response.text())
        .then(data => {
            alert(data);
            document.getElementById("result").innerHTML = "";
        })
        .catch(error => console.error("Error:", error));
    }
}

function getSummary() {

    const year = document.getElementById("year").value;
    const month = document.getElementById("month").value;

  
    fetch(`${BASE_URL}/summary?year=${year}&month=${month}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("result").innerHTML =
                "Total Income: ₹" + data.totalIncome +
                "<br>Total Expense: ₹" + data.totalExpense +
                "<br>Net Balance: ₹" + data.netBalance;
        });

 
	fetch(`${BASE_URL}/list?year=${year}&month=${month}`)
	    .then(response => response.json())
	    .then(data => {

	        const list = document.getElementById("transactionList");
	        const count = document.getElementById("transactionCount");

	        list.innerHTML = "";
	        count.innerHTML = "Total Transactions: " + data.length;

	        data.forEach(exp => {
	            const li = document.createElement("li");
	            li.textContent =
	                exp.date + " | " +
	                exp.type + " | ₹" +
	                exp.amount + " | " +
	                exp.description;

	            list.appendChild(li);
	        });
	    });

}


