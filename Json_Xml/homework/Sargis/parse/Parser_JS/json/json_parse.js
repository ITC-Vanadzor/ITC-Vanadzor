function getObject(filename) {
    var request = new XMLHttpRequest();
    request.open("GET", filename, false);
    request.send();
    return JSON.parse(request.responseText);
}

function printContent(filename) {
    jsonObject = getObject(filename);
    var js_string = JSON.stringify(jsonObject, null, 2);
    document.getElementById('content').innerHTML = js_string;
}
function printTag (tag) {
    var tag_string = JSON.stringify(tag, null, 2)
    document.getElementById('demo').innerHTML = tag_string; 
}
function isValid(path, path_end){
    var json_obj = getObject('json_file.json');
    var message = document.getElementById("demo");
    var value = "json_obj"+path;
    value = eval(value);
    console.log(value);
    if(value == undefined) {
        return false;
    }
    else {
        return true;
    }
}
function getValue(inputVal) {
    var demo = document.getElementById("demo");
    if (inputVal == null || inputVal == ''){
        demo.innerHTML = "Empty space!!!";    
        return;
    }
    inputVal = inputVal.replace(/\:/, ".");
    var inputSplit = inputVal.split(".");
    var expr = '';
    var json_obj = getObject('json_file.json');
    for (var i in inputSplit) {
        if ( isNaN(inputSplit) ) {
            expr += '["' +inputSplit[i] + '"]';
        }
        else {
            expr += "[" + inputSplit[i] + "]";
        }
        if( !isValid(expr, inputSplit[i]) ) {
            if (inputSplit[i] == inputSplit[0]){
                demo.innerHTML = inputSplit[i] + " is not valid path name!!";
            }
            else {
                var msg_array = inputSplit.slice(0, i);
                demo.innerHTML = inputSplit[i] + " is element from another document maybe! BUT " + msg_array + " are valid";
            }
            return;
        }
    }
    var value = "json_obj"+expr;
    value = eval(value);
   // var value_string = JSON.stringify(value)
   printTag(value);
}
