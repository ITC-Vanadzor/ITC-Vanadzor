var m = document.getElementById('month').value;
var d = document.getElementById('day').value;
var y = document.getElementById('year').value;
var now = new Date();

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
	var pregexp= new RegExp ('^^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).{6,14}$');	
	if (pregexp.test(pass_value)) {
	document.getElementById('pass_val').style.color= "black";
	document.getElementById('pass_val').innerHTML="*"} else {
	document.getElementById('pass_val').style.color= "red";
	document.getElementById('pass_val').innerHTML="* doesn't right"
	}
}

function changeDate(i){
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
	y = 2015;
	while (y-->1915){
		var s = document.createElement('option');
		var e = document.getElementById('year');
		s.text=y;
		s.value=y;
		try{
			e.add(s,null);}
		catch(ex){
			e.add(s);}}

function day(){
	d = document.getElementById('day').value;
	age();
}

function year(){
	y = document.getElementById('year').value;
	age();
}

function age(){
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
