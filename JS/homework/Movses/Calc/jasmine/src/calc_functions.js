x = 0
function plus(y,z) {
    var y = document.getElementById("field1").value;
    var z = document.getElementById("field2").value;
    x=" + ";
    return ((10*y)+(10*z))/10;
    return y;
    return z; 
}
function minus() {
    var y = document.getElementById("field1").value;
    var z = document.getElementById("field2").value;
    x=" - ";        
	return ((y*10)-(10*z))/10;
}
function times() {
    var y = document.getElementById("field1").value;
    var z = document.getElementById("field2").value;
    x=" * ";   
	return y*z;
}
function div(y,z) {
    var y = document.getElementById("field1").value;
    var z = document.getElementById("field2").value;
	x=" / "	
    try {
        if (z==0) throw "can't divide a number by zero";
	    return y/z;
    }catch(err) {
        alert(err);
    }
}

function eq() {
	if (x==" + ") { 	
		document.getElementById("result").value = plus();
	}
	if (x==" - ") { 	
		document.getElementById("result").value = minus();
	}
	if (x==" * ") { 	
		document.getElementById("result").value = times();
	}
	if (x==" / ") { 	
		document.getElementById("result").value = div();
	}
}

