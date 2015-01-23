x = 0
function plus(a,b) {
    return ((10*y)+(10*z))/10;
}
function minus() {
	return ((y*10)-(10*z))/10;
}
function times() {
	return y*z;
}
function div(y,z) {
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

function plus1() {
    var y = document.getElementById("field1").value;
    var z = document.getElementById("field2").value;
    x=" + ";        
    plus()
}

function minus1() {
    var y = document.getElementById("field1").value;
    var z = document.getElementById("field2").value;
    x=" - ";        
    minus()


}

function times1() { 
    var y = document.getElementById("field1").value;
    var z = document.getElementById("field2").value;
    x=" * "   
    times()
}
/*function div1 {
    var y = document.getElementById("field1").value;
    var z = document.getElementById("field2").value;
    x=" + "
}*/
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

