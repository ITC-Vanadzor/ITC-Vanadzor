x = 0

function shoutY(y) {
    var y = document.getElementById("field1").value;
    if ((typeof y === 'number') && (typeof y != null)) {
            continue;
            return y;
        } else { 
            alert ("Please Input Number"); 
            return false;
            }   
}
function shoutZ(z) {
    var z = document.getElementById("field2").value;
    if ((typeof z === 'number') && (typeof z != null)) {
            continue;
            return z;
        } else { 
            alert ("Please Input Number"); 
            return false;
            }   
}

function plus() {
    shoutY(y);
    shoutZ(z); 
    x=" + ";
    return y+z;
}
function minus(y,z) {
    shoutY(y);
    shoutZ(z); 
    x=" - ";        
	return ((y*10)-(z*10))/10;
}
function multi(y,z) {
    shoutY();
    shoutZ(); 
    x=" * ";   
	return y*z;
}
function div(y,z) {
    shoutY();
    shoutZ(); 
	x=" / "	
    try {
        if (z==0) throw "can't divide a number by zero";
	    return y/z;
    }catch(err) {
        alert(err);
    }
}

function eq() {
    shoutY(y);
    shoutZ(z); 
  	if (x==" + ") { 	
		document.getElementById("result").value = plus();
	}
	if (x==" - ") { 	
		document.getElementById("result").value = minus();
	}
	if (x==" * ") { 	
		document.getElementById("result").value = multi();
	}
	if (x==" / ") { 	
		document.getElementById("result").value = div();
	}
}


