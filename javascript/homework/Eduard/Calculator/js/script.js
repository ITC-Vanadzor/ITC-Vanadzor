z='';
function get_1() { 
//	if (typeof document.getElementById("input1").value !== 'number'){
//	alert("Error")	;} 
	z += document.getElementById("input1").value;

}
function get_2() {
	z += document.getElementById('input2').value;
}
function doit1() {
	document.getElementById('input3').value = eval(z);
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
};
function clear1() {
	document.getElementById('input3').value = 0;
	document.getElementById('input2').value = 0;
	document.getElementById('input1').value = 0;
	 z='';
};
