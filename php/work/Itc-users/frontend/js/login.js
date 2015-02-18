function login_valid (a,b) {

	var mail_value=document.getElementById('mail').value ;
	var pass_value=document.getElementById('pass').value ;
	var x = document.getElementById("box").checked;
	if (mail_value==a && pass_value==b) {	
	if(x) {
		alert("Checked");
	} else {
		alert("Not checked");
		}
	}
	if (mail_value!=a || pass_value!=b) {
		alert("Wrong user name or password");
		return false;
	}
}

function overlay() {
	el = document.getElementById("overlay");
	el.style.visibility = (el.style.visibility == "visible") ? "hidden" : "visible";
}

