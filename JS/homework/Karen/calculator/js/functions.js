function isInt(n) {
    return n % 1 === 0;
}
function reply_click(clicked_id) {
    click_button = document.getElementById(clicked_id).innerHTML;
    if (isInt(click_button) || (click_button==".")) {
        if (flag) {
            document.getElementById("view").innerHTML = "";
            flag = false;
        }
        document.getElementById("view").innerHTML = document.getElementById("view").innerHTML + click_button;
    } else {
        temp = parseFloat(document.getElementById("view").innerHTML);
        if (operation != false) {
            operations(operation);
            operation = click_button;
        } else {
            operation = click_button;
            result = temp;
            viewResult(result);
        }
        //document.getElementById("operation").innerHTML = operation;
        //document.getElementById("temp").innerHTML = temp;
        flag = true;
    }
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
            result /= temp;
            break;
        case "C":
            start();
            break;

    }
    result 
    viewResult(result);
}

function viewResult(result) {
    flag = true;
    result = parseFloat(result/10)*10;
    document.getElementById("view").innerHTML = result;
}
function start() {
    result = 0;
    operation = false;
    temp = 0;
    flag = true;
    viewResult(result);
}
/*************************/