var m = "na"
var d = "na"
var y = 1914
now = new Date();

function sumbit() {

}

function valid() {
	err=0;
	var name_value=document.getElementById('name').value ;
	var nregexp= new RegExp ('^[a-zA-Z]{2,15}$');	
	if (nregexp.test(name_value)) {
	document.getElementById('name_val').style.color= "#00FF00";
	document.getElementById('name_val').innerHTML="NAME : "} else {
	err+=1;
	document.getElementById('name_val').style.color= "red";
	document.getElementById('name_val').innerHTML="* This field is empty or invalid name. Use only letters"
	}
	var lname_value=document.getElementById('lname').value ;
	var lregexp= new RegExp ('^[a-zA-Z]{2,15}$');
	if (lregexp.test(lname_value)) {
	document.getElementById('lname_val').style.color= "#00FF00";
	document.getElementById('lname_val').innerHTML="LAST NAME : "} else {
	err+=1;
	document.getElementById('lname_val').style.color= "red";
	document.getElementById('lname_val').innerHTML="* This field is empty or invalid name. Use only letters"
	}
	var mail_value=document.getElementById('mail').value ;
	var eregexp= new RegExp ('^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$');	
	if (eregexp.test(mail_value)) {
	document.getElementById('mail_val').style.color= "#00FF00";
	document.getElementById('mail_val').innerHTML="EMAIL : "} else {
	err+=1;
	document.getElementById('mail_val').style.color= "red";
	document.getElementById('mail_val').innerHTML="*  This field is empty or invalid Email. Example: example@example.example"
	}
	var pass_value=document.getElementById('pass').value ;
	var pregexp= new RegExp ('^.{4,8}$');	
	if (pregexp.test(pass_value)) {
	document.getElementById('pass_val').style.color= "#00FF00";
	document.getElementById('pass_val').innerHTML="PASSWORD : "} else {
	err+=1;
	document.getElementById('pass_val').style.color= "red";
	document.getElementById('pass_val').innerHTML="* This field is empty or invalid password"
	}
	if (err==0) {
		alert("You are successfully registered !")
	}

	if (err!=0) {
		
		return false;		
	} 
	
}


function hide() {
	document.getElementsByClassName("hide")[0].style.display = ( document.getElementsByClassName("hide")[0].style.display == 'none' ) ? 'block' : 'none'
	document.getElementsByClassName("hide")[1].style.display = ( document.getElementsByClassName("hide")[1].style.display == 'none' ) ? 'block' : 'none'
	document.getElementsByClassName("hide")[2].style.display = ( document.getElementsByClassName("hide")[2].style.display == 'none' ) ? 'block' : 'none'
}

function changeDate(i) {
	m = document.getElementById('month').value;
	var e = document.getElementById('day');
	while(e.length>0)
	e.remove(e.length-1);
	var j=-1;
	if(i=="na")
	k=0;
	else if(i==2)
		k=28;
	else if(i==4||i==6||i==9||i==11)
		k=30;
	else
		k=31;
	while(j++<k){
		var s=document.createElement('option');
		var e=document.getElementById('day');
		if(j==0){
			s.text="Day";
			s.value="na";
		try{
			e.add(s,null);}
		catch(ex){
			e.add(s);}}
		else{
			s.text=j;
			s.value=j;
		try{
			e.add(s,null);}
		catch(ex){
			e.add(s);}}}}
function addYear() {	
	y = 2015;
	while (y-->1915){
		var s = document.createElement('option');
		var e = document.getElementById('year');
		s.text=y;
		s.value=y;
		try{
			e.add(s,null);}
		catch(ex){
			e.add(s);}}}

function onload() {
	addYear();
	hide();
}

function day_birdth () {
	d = document.getElementById('day').value;
	age();

}

function year_birdth() {
	y = document.getElementById('year').value;
	age();
}

function age() {
	if (d != "na" && m != "na" && y != 1914) {
		if ( m > now.getMonth() + 1 ) {
			document.getElementById('age').value = now.getFullYear() - y - 1
		} else if ( m < now.getMonth() + 1 ) {
			document.getElementById('age').value = now.getFullYear() - y
		} else {
			if ( d > now.getDate() ) {
				document.getElementById('age').value = now.getFullYear() - y - 1
			} else {
				document.getElementById('age').value = now.getFullYear() - y
}}}}
