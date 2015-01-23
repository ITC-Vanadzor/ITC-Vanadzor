function result(){
    document.getElementById("screen").value = eval(document.getElementById("screen").value);
}
function reset(){
    document.getElementById("screen").value = '';
}
function change_value(value) {
    document.getElementById("screen").value += value;
}

