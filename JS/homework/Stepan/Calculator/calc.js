function calc(form) {

var D = "0";
var A = document.getElementById("num1").value;
var B = document.getElementById("operator").value;
var C = document.getElementById("num2").value;

if (B == "+")
{
D = parseInt(A) + parseInt(C); 
}
else if(B == "-")
{
D = parseInt(A)-parseInt(C);
}
else if(B == "*")
{
D = parseInt(A)*parseInt(C);
}
else if (B == "/")
{
D = parseInt(A)/parseInt(C);
}
document.getElementById("result").innerHTML = D;
return false;
}

