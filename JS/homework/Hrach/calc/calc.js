var op = "";
var first = "";
var second = "";
var opf = "";

function cl() {
	document.getElementById('equal').value = "";
}

function ascriptionAdd() {
	op = "+";
	opf = "+";
	first = document.getElementById('equal').value;
}

function add(a, b) {
	return +a + +b;
}

function ascriptionSubtract() {
    op = "-";
	opf = "-";
	first = document.getElementById('equal').value;
}

function subtract(a, b) {
	return a - b;
}

function ascriptionMultiply() {
    op = "*";
	opf = "*";
	first = document.getElementById('equal').value;
}

function multiply(a, b) {
	return a * b;
}

function ascriptionDivide() {
    op = "/";
	opf = "/";
	first = document.getElementById('equal').value;
}

function divide(a, b) {
	return a / b;
}

function clean() {
	if (opf == "+" || opf == "-" || opf == "*" || opf == "/") {
		document.getElementById('equal').value = "";
		opf = "";
	}
}

function zero() {
	clean();
    document.getElementById('equal').value += 0;
}

function one() {
	clean();
	document.getElementById('equal').value += 1;
}

function two() {
	clean();
    document.getElementById('equal').value += 2;
}

function three() {
	clean();
    document.getElementById('equal').value += 3;
}

function four() {
	clean();
    document.getElementById('equal').value += 4;
}

function five() {
	clean();
    document.getElementById('equal').value += 5;
}

function six() {
	clean();
    document.getElementById('equal').value += 6;
}

function seven() {
	clean();
    document.getElementById('equal').value += 7;
}

function eight() {
	clean();
    document.getElementById('equal').value += 8;
}

function nine() {
	clean();
    document.getElementById('equal').value += 9;
}

function dot() {
	clean();
	document.getElementById('equal').value += '.';
}

function equal() {
	second = document.getElementById('equal').value;
	if (op == "/" && second == 0) {
		alert("Division by Zero");
	} else if (op == "+") {
		document.getElementById('equal').value = add(first, second);
	} else if (op == "-") {
        document.getElementById('equal').value = subtract(first, second);
    } else if (op == "*") {
        document.getElementById('equal').value = multiply(first, second);
    } else if (op == "/") {
        document.getElementById('equal').value = divide(first, second);
    }
}
