z='';
function get_1() { 
	var input_regexp= new RegExp(/^-?\d*(\.\d+)?$/);
	if (input_regexp.test(document.getElementById('input1').value)) {
	z += document.getElementById('input1').value;
	} else {
	alert('Error: Type is not number');
	clear1()
	}
	if (document.getElementById('input1').value=='0' && eval(z)=='Infinity')
	{alert('You can\'t divide by 0')
	clear1()
	}
}
function get_2() {
	var input_regexp= new RegExp(/^-?\d*(\.\d+)?$/);
	if (input_regexp.test(document.getElementById('input2').value)) {
	z += document.getElementById('input2').value;
	} else {
	alert('Error: Type is not number');
	clear1()
	}	
	if (document.getElementById('input2').value=='0' && eval(z)=='Infinity')
	{alert('You can\'t divide by 0')
	clear1()
	}
}
function doit1() {
	if (isNaN(eval(z))) {alert('Illegal operation: rezult=NaN') 
	clear1() }	else {
	document.getElementById('input3').value = eval(z);}
}
function plus1() {
	z += '+';

}
function minus1() {
	z += document.getElementById('minus').value;	
}
function mul1() {
	z += '*';
}
function div1() {
	z += document.getElementById('div').value;
}
function clear1() {
	document.getElementById('input3').value = '';
	document.getElementById('input2').value = '';
	document.getElementById('input1').value = '';
	 z='';
}
