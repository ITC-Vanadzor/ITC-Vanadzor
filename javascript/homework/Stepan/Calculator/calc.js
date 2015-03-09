function calc(form) {
  var result = "0";
  var num1 = document.getElementById("number_1").value;
  var operator = document.getElementById("operator").value;
  var num2 = document.getElementById("number_2").value;

   if (operator == "+"){
    result = add(num1, num2); 
   } else if (operator == "-") {
    result = minus(num1, num2); 
   } else if (operator == "*") {
    result = multiple(num1, num2); 
   } else if (operator == "/") {
    result = division(num1, num2); 
   } else {
    alert(" Plesae insert +  or  -  or  *  or  /   ");
   }

    document.getElementById("result").innerHTML = result;
    return false;
}

function add(number_1, number_2){
  var res = parseInt(number_1) + parseInt(number_2);
  return res;
}

function minus(number_1, number_2){
  var res = parseInt(number_1) - parseInt(number_2);
  return res;
}

function multiple(number_1, number_2){
  var res = parseInt(number_1) * parseInt(number_2);
  return res;
}

function division(number_1, number_2){
  var res = parseInt(number_1) / parseInt(number_2);
  return res;
}


