function nameValidation()
	{
    	var nameReg =new RegExp('^[a-zA-Z ]{2,30}$');
    	var name =  document.getElementById("name");
	    if (! nameReg.test(name))
			{ 
        		document.getElementById("valid1").innerHTML="* Your name is not valid. Only characters A-Z, a-z  are  acceptable";
		}
}
function lastNameValidation()
	{
    	var lastNameReg =new RegExp('^[a-zA-Z ]{2,30}$');
    	var lastName =  document.getElementById("lastname");
	    if (! lastNameReg.test(lastName))
			{ 
        		document.getElementById("p2").innerHTML="Your last name is not valid. Only characters A-Z, a-z  are  acceptable";
		}
}
function emailValidation()
	{
		email=document.getElementById("email");
		var emailReg =new RegExp('^\w+([-+.\']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$');
		if (! emailReg.test(email))
			{
				document.getElementById("p3").innerHTML='Please Enter Valid Email Address';
		}
}
function passValidation()
	{
		pass=document.getElementById("pass");
		var passReg =new RegExp('^[a-zA-Z0-9!@#$%^&*]{6,16}$');
		if (! passReg.test(pass))
			{
				document.getElementById("p4").innerHTML='password should contain atleast one number and one special character';
		}
}
function validation()
	{
		nameValidation();
		lastNameValidation();
		emailValidation();
		passValidation();
}

