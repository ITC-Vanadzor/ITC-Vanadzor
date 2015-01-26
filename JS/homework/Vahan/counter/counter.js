var input = document.getElementById("screen").value;
var expr =  document.getElementById("screen").innerHTML;

function sum() {
    document.getElementById("screen").value += '+';
}

function diff() {
    document.getElementById("screen").value += '-';
}
function mult() {
    document.getElementById("screen").value += '*';
}
function div() {
    document.getElementById("screen").value += '/';
}
function equal() {
    document.getElementById("screen").value = eval(document.getElementById("screen").value);    
}

function Mclear() {
    document.getElementById("screen").value = '';
}
