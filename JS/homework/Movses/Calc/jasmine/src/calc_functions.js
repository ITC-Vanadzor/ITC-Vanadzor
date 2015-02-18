x = 0

function shoutY(y) {
    y = document.getElementById("field1").value;
    window.a = Number(y);
    if (a != null) {
        return a;
    } else { 
        alert ("Please Input Number"); 
        return false;
        }   
}
function shoutZ(z) {
    z = document.getElementById("field2").value;
    window.b = Number(z)
    if (b != null) {
        return b;
    } else { 
        alert ("Please Input Number"); 
        return false;
    }  
}

function plus(a,b) {
    x=" + ";
    return window.a + window.b;
}
function minus(y,z) {
    x=" - ";        
	return window.a - window.b;
}
function multi(y,z) {
    x=" * ";   
	return window.a * window.b;
}
function div(y,z) {
	x=" / "	
    try {
        if (window.b==0) throw "can't divide a number by zero";
	    return window.a / window.b;
    }catch(err) {
        alert(err);
    }
}

function eq(a,b) {
    shoutY(a);
    shoutZ(b); 
  	if (x==" + ") { 	
		document.getElementById("result").value = plus(a,b);
	}
	if (x==" - ") { 	
		document.getElementById("result").value = minus(y,z);
	}
	if (x==" * ") { 	
		document.getElementById("result").value = multi(a,b);
	}
	if (x==" / ") { 	
		document.getElementById("result").value = div(a,b);
	}
}


