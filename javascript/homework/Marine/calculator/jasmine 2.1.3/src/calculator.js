var operator=0
function type(a) {
    var res1 = new RegExp ('^-?\d*(\.\d+)?$');
	if (! res1.test(a)) {
		return false;
	}
	else {
		return true;
	}
}
function plus(a,b) {
    operator=" + ";
    return ((10*a)+(10*b))/10;
}
function minus(a,b) {
    operator=" - ";
    return a-b;
}
function umn(a,b) {
    operator=" * ";
    return a*b;
}
function del(a,b) {
    operator=" / ";
    return a/b;
}
function clear_field() {
    document.getElementById("num1").value="";
    document.getElementById("num2").value="";
    document.getElementById("result").value="";
}
function equal() {
	var num_1=document.getElementById("num1").value;
	var num_2=document.getElementById("num2").value;
	if ( type(num_1)) {
		alert("num1 is not number");
		clear_field("num1","num2","result");
	}
	else if ( type(num_2)) {
		alert("num2 is not number");
		clear_field("num1","num2","result");
	}
	else if (operator==" + ") { 	
		document.getElementById("result").value = plus(num_1,num_2);
	}
    else if (operator==" - ") { 	
		document.getElementById("result").value = minus(num_1,num_2);
	}
    else if (operator==" * ") { 	
		document.getElementById("result").value = umn(num_1,num_2);
	}
    else if (operator==" / ") {
 		if (num_2==0) {
			alert("num2 is not 0")
		}
		else {
			document.getElementById("result").value = del(num_1,num_2);
		}
	}
 }
	