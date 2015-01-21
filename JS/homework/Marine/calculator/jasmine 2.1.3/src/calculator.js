function plus()
	{
		rezult.value=num1.value-(-1)*num2.value;
return rezult.value;
    }   
function minus()
    {
        rezult.value=num1.value-num2.value;
    }   
function umn()
    {
        rezult.value=num1.value*num2.value;
    }
function del()
    {
		try {
			if (num2.value==0) throw "num2 can not accept the value 0";
        	rezult.value=num1.value/num2.value;
}		
catch(err) {
			window.alert(err);
		}
    }   
