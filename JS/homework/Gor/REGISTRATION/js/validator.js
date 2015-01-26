/* Copyright Gor Julhakyan ** 2015 ** */

/*JavaScript Document*/


function Submit(){
	var emailRegex = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
	var wordRegex =  /^[a-zA-Z ]{2,30}$/;
	var fname = document.form.Name.value,
		lname = document.form.LastName.value,
		email = document.form.Email.value,
		password = document.form.Password.value,
		fmonth = document.form.birthday_month.value,
		fday = document.form.birthday_day.value,
		fyear = document.form.birthday_year.value;
   
	if( fname == "" ) {
		document.form.Name.focus() ;
		document.getElementById("namerrorBox").innerHTML = "Enter Your First Name";
		return false;
	}else if(!wordRegex.test(fname)){
		document.form.Name.focus();
		document.getElementById("namerrorBox").innerHTML = "Enter the valid First Name <br>*First Name must be only words & min lenght 2symbols*";
		return false;
	} 
   
	if( lname == "" ) {
		document.form.LastName.focus() ;
		document.getElementById("lnamerrorBox").innerHTML = "Enter Your Last Name";
		return false;
	}else if(!wordRegex.test(lname)){
		document.form.LastName.focus();
		document.getElementById("lnamerrorBox").innerHTML = "Enter the valid Last Name <br>*Last Name must be only words & min lenght 2symbols*";
		return false;
	}
    
	if (email == "" ) {
		document.form.Email.focus();
		document.getElementById("emailerrorBox").innerHTML = "Enter Your E-mail";
		return false;
	}else if(!emailRegex.test(email)){
		document.form.Email.focus();
		document.getElementById("emailerrorBox").innerHTML = "Enter the valid E-mail <br> (E-mail must be user@example.com)";
	return false;
	}
     
	if(password == "") {
		document.form.Password.focus();
		document.getElementById("passerrorBox").innerHTML = "Your password must be more that 6 symbols";
		return false;
	}
      
	if(fname != '' && lname != '' && email != '' && freemail != '' && password != ''){
   document.getElementById("errorBox").innerHTML = "form submitted successfully";
   }
     
}

function Visible() {
	var hidevis = document.getElementById("hidevis").style.visibility;	   
	
	if(hidevis == "visible") {
		document.getElementById("hidevis").style.visibility = "hidden";
	}else if(hidevis == "hidden") {
		document.getElementById("hidevis").style.visibility = "visible";
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