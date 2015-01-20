function plus() {
        var y = document.getElementById("field1").value;
        var z = document.getElementById("field2").value;
        result.value = y-(-1)*z;
        document.getElementById("demo").innerHTML = result;
}
function minus() {
        var y = document.getElementById("field1").value;
        var z = document.getElementById("field2").value;
        result.value = y-z;
        document.getElementById("demo").innerHTML = result;
}
function times() {
        var y = document.getElementById("field1").value;
        var z = document.getElementById("field2").value;
        result.value = y*z;
        document.getElementById("demo").innerHTML = result;
}
function div() {
        var y = document.getElementById("field1").value;
        var z = document.getElementById("field2").value;
        result.value = y/z;
        document.getElementById("demo").innerHTML = result;
}

