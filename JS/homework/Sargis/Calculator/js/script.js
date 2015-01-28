function add(a,b){
    return (a+b);
}
function subtract(a,b){
    return (a-b);
}
function product(a,b){
    return a*b;
}
function divide(a,b) {
    return a/b;
}
function result(str) {
    var n = str.search(/[*\-+\/]/i);
    var operation = str.charAt(n);
    var part1 = str.slice(0,n);
    var part2 = str.slice(n+1,str.length);
    part1 = parseFloat(part1);
    part2 = parseFloat(part2);
    switch(operation) {
        case "-":
           document.getElementById("screen").value = subtract(part1, part2);
           break;
        case "+":
           document.getElementById("screen").value = add(part1,part2); 
           break;
        case "*":
           document.getElementById("screen").value = product(part1, part2);
           break; 
        case "/":
           if (part2 == 0){
               document.getElementById("screen").value = "infinity";
           }
           else {
               document.getElementById("screen").value = divide(part1, part2);
           }
           break;
    }
}
function reset(){
    document.getElementById("screen").value = '';
}
function isValidInput(str) {
    var sign = str.charAt(str.length-1);
    str = str.slice(0,str.length-1);
    str= str.replace(/[-\/*+]/g, "");
    switch(sign) {
        
        case "+":
        case "-":
        case "/":
        case "*":
            if(isNaN(str)){
                document.getElementById("screen").value = "error";
            }
    }
}
function change_value(value) {
	document.getElementById("screen").value += value;
}

