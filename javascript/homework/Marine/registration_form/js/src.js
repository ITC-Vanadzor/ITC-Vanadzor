function nameValidation() {
    var nameReg =new RegExp('^[a-zA-Z ]{2,30}$');
   	var name =  document.getElementById("name").value;
    if (nameReg.test(name))	{
		document.getElementById('p1').style.color= "black";
  		document.getElementById("p1").innerHTML="*";
	} 
	else {
		document.getElementById('p1').style.color= "red";
   		document.getElementById("p1").innerHTML="* Your name is not valid. Only characters A-Z, a-z  are  acceptable";
	}
}
function lastNameValidation() {
    var lastNameReg =new RegExp('^[a-zA-Z ]{2,30}$');
   	var lastName =  document.getElementById("lastname").value;
    if (lastNameReg.test(lastName))	{
		document.getElementById('p2').style.color= "black";
    		document.getElementById("p2").innerHTML="*";
	} 
	else {
		document.getElementById('p2').style.color= "red";
  		document.getElementById("p2").innerHTML="* Your last name is not valid. Only characters A-Z, a-z  are  acceptable";
	}
}
function emailValidation() {
    var	email=document.getElementById("email").value;
	var emailReg =new RegExp('^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$');
	if (emailReg.test(email)) {
		document.getElementById('p3').style.color= "black";
		document.getElementById("p3").innerHTML='*';
	} 
	else {
		document.getElementById('p3').style.color= "red";
		document.getElementById("p3").innerHTML='* Please Enter Valid Email Address';
	}
}
function passValidation() {
	var pass=document.getElementById("pass").value;
	var passReg =new RegExp('^[a-zA-Z0-9!@#$%^&*]{6,16}$');
	if (passReg.test(pass)) {
		document.getElementById('p4').style.color= "black";
		document.getElementById("p4").innerHTML='*';
	} 
	else {
		document.getElementById('p4').style.color= "red";
		document.getElementById("p4").innerHTML='* Password should contain atleast one number and one special character';
	}
}
function validation() {
	nameValidation();
	lastNameValidation();
	emailValidation();
	passValidation();
}
function selectYear() {
	var year= new Date();
	var selYear=year.getFullYear();
	for (i=1950;i<=selYear;i++) {
		var m=document.getElementById("year");
		var op=document.createElement("option");
		op.text=i;
		m.add(op);
	}
    dayAdd(28);
}
function selectDayCount(selMonth) {
	var year=new Date();
	var y=year.getFullYear();
	if (y%4!=0) {
		l=28;
	} 
	else {
		l=29;
	}
	switch (selMonth) {
		case "January"||"March"||"May"||"July"||"August"||"October"||"December":
 			return 31;
			break;
		case "Febuary":
			return l;
			break;
		default:
			return 30;
			break;
	}		
}
function dayAdd(count) {
	for (i=1;i<=count;i++) {
		var m=document.getElementById("day");
		var op=document.createElement("option");
		op.text=i;
		m.add(op);
	}
}
function days() {
	var selMonth=document.getElementById("month").value;
	var count=selectDayCount(selMonth); 
	dayAdd(count);
	age();
}
function age() {
	var b_d = document.getElementById("day").value;
    var b_m = document.getElementById("month").value;
    var b_y = document.getElementById("year").value;
    var b_f = b_d + ", " + b_m + ", " + b_y;
	var d1 = new Date(b_f);
    var d2 = new Date();
	var year=d2.getFullYear()-d1.getFullYear();
	d1.setFullYear(d2.getFullYear());
	if (d2<d1) {
		year--
	}
	document.getElementById("age").value=year;
}

function hideField() {
	document.getElementById('date').style.display == 'none' ? document.getElementById('date').style.display = 'block' : document.getElementById('date').style.display = 'none'
	document.getElementById('age1').style.display == 'none' ? document.getElementById('age1').style.display = 'block' : document.getElementById('age1').style.display = 'none'
	document.getElementById('gender').style.display == 'none' ? document.getElementById('gender').style.display = 'block' : document.getElementById('gender').style.display = 'none'
}
