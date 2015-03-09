var result = 0;

function changeContent(l, r) {
    if(isNaN(l) && isNaN(r)){
        document.getElementById("leftOp").style.color = 'red';
        document.getElementById("leftOp").value = 'INVALID INPUT';
        document.getElementById("rightOp").style.color = 'red';
        document.getElementById("rightOp").value = 'INVALID INPUT';
    }
    else if( isNaN(l) ) {
        document.getElementById("leftOp").style.color = 'red';
        document.getElementById("leftOp").value = 'INVALID INPUT';
    }
    else if( isNaN(r) ) {
        document.getElementById("rightOp").style.color = 'red';
        document.getElementById("rightOp").value = 'INVALID INPUT';
    }
}

function isValidInput(l,r) {
    if ( isNaN(l) || isNaN(r) ) {
        return false;
    }
    else {
        return true;
    }
}
function calc(op,x,y) {
    if ( !isValidInput(x,y) ) {
        changeContent(x,y);
        return;
    }
    switch(op){
        case '+':
            result = (x*10 + y*10) / 10;
            return result;
            break;
        case '-':
            result = x - y;
            return result;
            break;
        case '*':
            result = x * y;
            return result;
            break;
        case '/':
            result = x / y;
            return result;
            break;
    }
    return;
}
function equal() {
    document.getElementById("Result").value = result;
}

function Mclear() {
    document.getElementById("leftOp").value = '';
    document.getElementById("rightOp").value = '';
    document.getElementById("leftOp").style.color = 'inherit';
    document.getElementById("rightOp").style.color = 'inherit';
    document.getElementById("Result").value = '';
    document.getElementById("b1").style.border = "2px outset buttonface";
    document.getElementById("b2").style.border = "2px outset buttonface";
    document.getElementById("b3").style.border = "2px outset buttonface";
    document.getElementById("b4").style.border = "2px outset buttonface";
    document.getElementById("b5").style.border = "2px outset buttonface";
}

function changeStyle(ident) {
    switch(ident) {
        case '+':
            document.getElementById("b1").style.border = "5px solid red";
            break;
        case '-':
            document.getElementById("b2").style.border = "5px solid red";
            break;
        case '*':
            document.getElementById("b3").style.border = "5px solid red";
            break;
        case '/':
            document.getElementById("b4").style.border = "5px solid red";
            break;
        case '=':
            document.getElementById("b5").style.border = "5px solid red";
            break;
    }
    return;
}
