function ascriptionAdd() {
	document.querySelector("#op").innerHTML = "+";
}

function add(a, b) {
	return (+a + +b);
}

function ascriptionSubtract() {
    document.querySelector("#op").innerHTML = "-";
}

function subtract(a, b) {
	return (+a - +b);
}

function ascriptionMultiply() {
    document.querySelector("#op").innerHTML = "*";
}

function multiply(a, b) {
	return (+a * +b);
}

function ascriptionDivide() {
    document.querySelector("#op").innerHTML = "/";
}

function divide(a, b) {
	return (+a / +b);
}

function equal() {
	var first = document.getElementById('first').value;
	var second = document.getElementById('second').value;
	if (document.querySelector("#op").innerHTML == "/" && second == 0) {
		alert("Division by Zero")
	} else if (document.querySelector("#op").innerHTML == "+") {
		document.getElementById('equal').value = add(first, second);
	} else if (document.querySelector("#op").innerHTML == "-") {
        document.getElementById('equal').value = subtract(first, second);
    } else if (document.querySelector("#op").innerHTML == "*") {
        document.getElementById('equal').value = multiply(first, second);
    } else if (document.querySelector("#op").innerHTML == "/") {
        document.getElementById('equal').value = divide(first, second);
    }
}
