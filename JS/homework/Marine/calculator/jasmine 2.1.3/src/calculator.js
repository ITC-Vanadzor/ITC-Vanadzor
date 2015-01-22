operator=0
function plus(a,b)
	{
		operatop=" + ";
		return ((10*a)+(10*b))/10;
    }   
function minus(a,b)
    {
		operator=" - ";       
		return a-b;
    }   
function umn(a,b)
    {
		operator=" * ";        
		return a*b;
    }
function del(a,b)
    {
		try {
			if (b==0) throw "num2 can not accept the value 0";
			operator=" / "
        	return a/b;
		}				
		catch(err) {
			window.alert(err);
		}
    }   
function equal() {
var num_1=document.getElementById("num1").value;
console.log(typeof	num_1);
var num_2=document.getElementById("num2").value;
console.log(num_2)
	if (operator==" + ") { 	
		document.getElementById("result").value = plus(num_1,num_2);
	}
	if (operator==" - ") { 	
		document.getElementById("result").value = minus(num_1,num_2);
	}
	if (operator==" * ") { 	
		document.getElementById("result").value = umn(num_1,num_2);
	}
	if (operator==" / ") { 	
		document.getElementById("result").value = del(num_1,num_2);
	}
}





