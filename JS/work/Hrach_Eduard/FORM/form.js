function valid() {
	var name_value=document.getElementById('name').value ;
	var nregexp= new RegExp ('^[a-zA-Z]{2,15}$');	
	if (nregexp.test(name_value)) {
	document.getElementById('name_val').style.color= "black";
	document.getElementById('name_val').innerHTML="*"} else {
	document.getElementById('name_val').style.color= "red";
	document.getElementById('name_val').innerHTML="* doesn't right"
	}
	var lname_value=document.getElementById('lname').value ;
	var lregexp= new RegExp ('^[a-zA-Z]{2,15}$');	
	if (lregexp.test(lname_value)) {
	document.getElementById('lname_val').style.color= "black";
	document.getElementById('lname_val').innerHTML="*"} else {
	document.getElementById('lname_val').style.color= "red";
	document.getElementById('lname_val').innerHTML="* doesn't right"
	}
	var mail_value=document.getElementById('mail').value ;
	var eregexp= new RegExp ('^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$');	
	if (eregexp.test(mail_value)) {
	document.getElementById('mail_val').style.color= "black";
	document.getElementById('mail_val').innerHTML="*"} else {
	document.getElementById('mail_val').style.color= "red";
	document.getElementById('mail_val').innerHTML="* doesn't right"
	}
	var pass_value=document.getElementById('pass').value ;
	var pregexp= new RegExp ('^[a-zA-Z0-9!@#$%^&*]{6,16}$');
	if (pregexp.test(pass_value)) {
	document.getElementById('pass_val').style.color= "black";
	document.getElementById('pass_val').innerHTML="*"} else {
	document.getElementById('pass_val').style.color= "red";
	document.getElementById('pass_val').innerHTML="* doesn't right"
	}
} 

