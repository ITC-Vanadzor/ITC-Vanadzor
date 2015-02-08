function getObject(filePath) {
    var request = new XMLHttpRequest();
    request.open("GET", filePath, false);
    request.send(null);
    return request;
}
function jsonParser(filePath) {
    var request = getObject(filePath);
    fileContent = request.responseText;
    return JSON.parse(fileContent);
}
function xmlParser(filePath) {
    var request = getObject(filePath);
    return request.responseXML;
}
//json only
function getElementTreeJson(jsonObject) {
    text = document.getElementById("text").value;
    var array = text.split(".");
    element = jsonObject[array[0]];
    for (i = 1; i < array.length; i++) {
        key = array[i].indexOf(":");
        if (key != -1) {
            number = array[i].substr(key + 1);
            k = array[i].substr(0, key);
            if (element[k] != undefined) {
                element = element[k][number];
            } else {
                element = undefined;
            }
        } else {
            element = element[array[i]];
        }
    }
    return element;
}
//xml only
function getElementTreeXml(xmlObject) {
    text = document.getElementById("text").value;
    var array = text.split(".");
    element = xmlObject.getElementsByTagName(array[0])[0];
    for (i = 1; i < array.length; i++) {
        key = array[i].indexOf(":");
        if (key != -1) {
            number = array[i].substr(key + 1);
            k = array[i].substr(0, key);
            if (element.getElementsByTagName(k) != undefined) {
                return element.getElementsByTagName(k)[0].getAttribute(number);
            } else {
                element = undefined;
            }
        } else {
            element = element.getElementsByTagName(array[i])[0];
        }
    }
    return element.innerHTML;
}
function viewResult(elem) {
    var view = elem;
    if (element == "[object Object]") {
        view = "is Object";
    } else if (element == undefined) {
        view = "is undefuned";
    }
    document.getElementById("demo").innerHTML = view;
}
function mainJson() {    
    jsonObject = jsonParser("data/json.json");
    elem = getElementTreeJson(jsonObject,"json");
    viewResult(elem);
    
}
function mainXml() {    
    xmlObject = xmlParser("data/xml.xml");
    elem = getElementTreeXml(xmlObject,"xml");
    viewResult(elem);
}
