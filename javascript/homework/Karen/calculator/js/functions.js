function isInt(n) {
    return n % 1 === 0;
}
function whenClickInt(pressedKey){
    if (isInt(pressedKey)){
        if (operationFlag) {
            document.getElementById("view").innerHTML = "";
            operationFlag = false;
        }
        document.getElementById("view").innerHTML = document.getElementById("view").innerHTML + pressedKey;            
    }
}
function whenClickDot(pressedKey){
    if(pressedKey == "."){
        view = document.getElementById("view").innerHTML;
        if(view.indexOf('.') != -1){
            return false;
        }
        document.getElementById("view").innerHTML = document.getElementById("view").innerHTML + pressedKey;            
    }
}
function whenClickOperation(pressedKey){
    temp = parseFloat(document.getElementById("view").innerHTML);
    if(operation != false){
        operations(operation);
    }else{
        result = temp;
    }
    operation = pressedKey;
    operationFlag = true;
}
function operations(operation) {
    switch (operation) {
        case "-":
            result -= temp;
            break;
        case "+":
            result += temp;
            break;
        case "*":
            result *= temp;
            break;
        case "/":
            if(temp != 0){
                result /= temp;
            }else{
                alert('Error!!!');
                start();
            }
            break;
    }
    viewResult(result);
}
function viewResult(result) {
    operationFlag = true;
    result = parseFloat(result/10)*10;
    document.getElementById("view").innerHTML = result;
}
function start() {
    result = 0;
    operation = false;
    temp = 0;
    operationFlag = true;
    viewResult(result);
}
function keyboardParser(key) {
    if((key >= 96) && (key <= 105)){
        return key - 96;
    }
    switch(key){
        case 107:
            return "+";
            break;
        case 109:
            return "-";
            break;
        case 106:
            return "*";
            break;
        case 111:
            return "/";
            break;
        case 13:
            return "=";
            break;
        case 110:
            return ".";
            break;
        case 46:
            return "C";
            break;
        default:
            return "";
    }
}
function clickButton(buttonId) {
    buttonValue = document.getElementById(buttonId).innerHTML;   
    replyClick(buttonValue);
}
function replyClick(pressedKey) {
    if (isInt(pressedKey) || (pressedKey == ".")) {
        whenClickInt(pressedKey);
        whenClickDot(pressedKey);
    }else if(pressedKey == "C"){
        operation = false;
        start();
    }else{
        whenClickOperation(pressedKey);
    }
}
function checkKeyPressed(e){
    keyPress = keyboardParser(e.keyCode);
    replyClick(keyPress);
}

/*************************/
document.addEventListener("keydown", checkKeyPressed, false);
