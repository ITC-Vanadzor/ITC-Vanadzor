/* Copyright Gor Julhakyan ** 2015 ** */

/*JavaScript Document*/



	var emailRegex = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
	var wordRegex =  /^[a-zA-Z ]{2,30}$/;
		
function Fname(){
	var fname = document.form.Name.value;  
	if( fname == "" ) {
		document.form.Name.focus() ;
		document.getElementById("namerrorBox").innerHTML = "Enter Your First Name";
		return false;
	}else if(!wordRegex.test(fname)){
		document.form.Name.focus();
		document.getElementById("namerrorBox").innerHTML = "Enter the valid First Name <br>*First Name must be only words & min lenght 2symbols*";
		return false;
	} 
}

function Lname(){ 
var lname = document.form.LastName.value; 
	if( lname == "" ) {
		document.form.LastName.focus() ;
		document.getElementById("lnamerrorBox").innerHTML = "Enter Your Last Name";
		return false;
	}else if(!wordRegex.test(lname)){
		document.form.LastName.focus();
		document.getElementById("lnamerrorBox").innerHTML = "Enter the valid Last Name <br>*Last Name must be only words & min lenght 2symbols*";
		return false;
	}
}

function Email(){
	var email = document.form.Email.value;
	if (email == "" ) {
		document.form.Email.focus();
		document.getElementById("emailerrorBox").innerHTML = "Enter Your E-mail";
		return false;
	}else if(!emailRegex.test(email)){
		document.form.Email.focus();
		document.getElementById("emailerrorBox").innerHTML = "Enter the valid E-mail <br> (E-mail must be user@example.com)";
	return false;
	}
}

function Password(){
	var password = document.form.Password.value;
	if(password == "") {
		document.form.Password.focus();
		document.getElementById("passerrorBox").innerHTML = "Your password must be more that 6 symbols";
		return false;
	}
}

function Submit(){
	var f = Fname(),
		l = Lname(),
		e = Email(),
		p = Password();
	if(f != '' && l != '' && e != '' && p != ''){
   document.getElementById("errorBox").innerHTML = "form submitted successfully";
   }
     
}

function Visible() {
	var hidevis = document.getElementsByClassName("hidevis").style.visibility;	   
	
	if(hidevis == "visible") {
		document.getElementsByClassName("hidevis").style.visibility = "hidden";
	}else if(hidevis == "hidden") {
		document.getElementsByClassName("hidevis").style.visibility = "visible";
	}
}

function showHide(element_id) {

	if (document.getElementById(element_id)) {
		var obj = document.getElementById(element_id);
    if (obj.style.display != "block") {
		obj.style.display = "block"; 
	}else obj.style.display = "none"; 
	}
}

function dgi(el) {
	return document.getElementById(el);
}

var aYear = 100;

window.onload = function() {
	var month = document.form.Birthday_month.value,
		day = document.form.Birthday_day.value,
		year = document.form.Birthday_year.value;
	var y = dgi('year');
	var d = new Date();
	var _y = d.getFullYear();
	var _o = document.createElement('option');
	_o.setAttribute('value', 0);
	_o.innerHTML = 'Year';
	y.appendChild(_o);
	for(var i = 0; i < aYear; i++) {
		var o = document.createElement('option');
		o.setAttribute('value', _y);
		o.innerHTML = _y;
		y.appendChild(o);
		_y--;
	}
}

function loadMonths(obj) {
	if(obj.value != '0') {
		dgi('months').style.display = '';
	} else {
		dgi('months').style.display = 'none';
	}
}

function loadDays(obj) {
	var days = dgi('days');
		
	if(obj.value != '0') {
		clearDays();
		var number = 32 - new Date(parseInt(dgi('year').value), parseInt(dgi('months').value)-1, 32).getDate();
		
		for(var i = 1; i <= number; i++) {
			var o = document.createElement('option');
			o.setAttribute('value', i);
			o.innerHTML = i;
			days.appendChild(o);
		}
		days.style.display = '';
	} else {
		clearDays();
		hideDays();
	}
}

function clearDays() {
	var days = dgi('days');
	days.innerHTML = '';                
}

function hideDays() {
	var days = dgi('days');
	days.style.display = 'none';
}


function calculateAge(){
	var birthdayfull = document.getElementById("months").value + " " + document.getElementById("days").value + "," + document.getElementById("year").value;
	var birthdate = Date.parse(birthdayfull);
	var birthday = new Date(birthdate)
	var agenow = Date.now() - birthday;
	var agenew = new Date(agenow);
	var uage=Math.abs(agenew.getUTCFullYear() - 1970);
	document.getElementById("age").value = uage;
}