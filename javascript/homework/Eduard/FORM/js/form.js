
function valid() {
	errors="";
	var name_value=document.getElementById('name').value ;
	var nregexp= new RegExp ('^[a-zA-Z]{2,15}$');	
	if (nregexp.test(name_value)) {
	document.getElementById('name_val').style.color= "black";
	document.getElementById('name_val').innerHTML="*"} else {
	document.getElementById('name_val').style.color= "red";
	document.getElementById('name_val').innerHTML="* This field is empty or invalid name. Use only letters"
	errors += 1;
	}
	var lname_value=document.getElementById('lname').value ;
	var lregexp= new RegExp ('^[a-zA-Z]{2,15}$');	
	if (lregexp.test(lname_value)) {
	document.getElementById('lname_val').style.color= "black";
	document.getElementById('lname_val').innerHTML="*"} else {
	document.getElementById('lname_val').style.color= "red";
	document.getElementById('lname_val').innerHTML="* This field is empty or invalid name. Use only letters"
	errors += 1;
	}
	var mail_value=document.getElementById('mail').value ;
	var eregexp= new RegExp ('^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$');	
	if (eregexp.test(mail_value)) {
	document.getElementById('mail_val').style.color= "black";
	document.getElementById('mail_val').innerHTML="*"} else {
	document.getElementById('mail_val').style.color= "red";
	document.getElementById('mail_val').innerHTML="* This field is empty or invalid Email. Example: example@example.example"
	errors += 1;
	}
	var pass_value=document.getElementById('pass').value ;
	var pregexp= new RegExp ('^.{4,8}$');	
	if (pregexp.test(pass_value)) {
	document.getElementById('pass_val').style.color= "black";
	document.getElementById('pass_val').innerHTML="*"} else {
	document.getElementById('pass_val').style.color= "red";
	document.getElementById('pass_val').innerHTML="* This field is empty or invalid password"
	errors += 1;
	}
	if (terms.checked == 1) {
	document.getElementById('terms_val').style.color= "black"; 
	document.getElementById('terms_val').innerHTML=""} else {
	document.getElementById('terms_val').style.color= "red";
	document.getElementById('terms_val').innerHTML="You must agree to the terms !"
	errors += 1;
	}
	if (errors == "") {alert ("You are successfully registered !")}
} 
function show() {
	if (document.getElementById('hide').style.display == "none" ) {
	document.getElementById('hide').style.display = "inline" } else {
	document.getElementById('hide').style.display = "none" }

}
