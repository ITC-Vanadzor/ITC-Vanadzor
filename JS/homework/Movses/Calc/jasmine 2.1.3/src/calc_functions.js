x = 0
function plus() {
        var y = document.getElementById("field1").value;
        var z = document.getElementById("field2").value;
	x=" + "        
	return ((10*y)+(10*z))/10;
}
function minus() {
        var y = document.getElementById("field1").value;
        var z = document.getElementById("field2").value;
	x=" - "        
	return ((y*10)-(10*z))/10;
}
function times() {
        var y = document.getElementById("field1").value;
        var z = document.getElementById("field2").value;
	x=" * "        
	return y*z;
}
function div() {
        var y = document.getElementById("field1").value;
        var z = document.getElementById("field2").value;
    try {
        if (z==0) throw "can't divide a number by zero";
	    x=" / "	
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

