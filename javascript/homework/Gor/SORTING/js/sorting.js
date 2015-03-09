// JavaScript Document

function Sorting() {
	var num = input.value.split(" ");
	var attr = document.getElementById("attr").value;
	if (attr == "min") { 
		num.sort(function(a, b)
		{return a-b});
		document.getElementById("res").innerHTML = num;
	}
	else {
		num.sort(function(a, b)
		{return b-a});
		document.getElementById("res").innerHTML = num;
	}
}