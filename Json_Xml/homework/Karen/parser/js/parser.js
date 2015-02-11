//set file path,return Object for this file  
function getObject(filePath) {
    var request = new XMLHttpRequest();
    request.open("GET", filePath, false);
    request.send(null);
    return request;
}
//set file path,return Json Object for this file  
function jsonParser(filePath) {
    var request = getObject(filePath);
    fileContent = request.responseText;
    return JSON.parse(fileContent);
}
//set file path,return Dom Object for this file  
function xmlParser(filePath) {
    var request = getObject(filePath);
    return request.responseXML;
}
function showJsonFile(filePath) {
    var jsonObj = getObject(filePath);
    htmlText = jsonObj.responseText;
    //replace enter to Html tag:<br/>
    enter = RegExp("\n", "g");
    htmlText = htmlText.replace(enter, "<br/>");
    //add Html tag div(open)
    divOpen = RegExp("{", "g");
    htmlText = htmlText.replace(divOpen, "<div><span>{</span>");
    //add Html tag div(close)
    divClose = RegExp("}", "g");
    htmlText = htmlText.replace(divClose, "<span>}</span></div>");
    document.getElementById("jsoncode").innerHTML = htmlText;
}
function showXmlFile(filePath) {
    var xmlObj = getObject(filePath);
    text = xmlObj.responseText;
    //add space in tags end
    var tagEnd = RegExp(">", 'g');
    text = text.replace(tagEnd, " >");
    //replace tags(close) to tmp word 
    var tmp = RegExp("</", 'g');
    text = text.replace(tmp, "{temp}");
    //add Html tag div(open)
    var divOpen = RegExp("<", 'g');
    text = text.replace(divOpen, "<div>< ");
    //restore tags(clase)
    tmp = RegExp("{temp}", 'g');
    text = text.replace(tmp, "< /");
    var textArray = text.split("\n");
    var outText = "";
    for (i = 0; i < textArray.length; i++) {
        if (textArray[i].indexOf("< /") != -1) {
            //add Html tag div (close)
            textArray[i] = textArray[i] + "</div>";
        }
        outText += textArray[i];
    }
    //xml tags put in span html tags
    tagEnd = RegExp(" >", 'g');
    outText = outText.replace(tagEnd, " ></span>");
    tagBegin = RegExp("< ", 'g');
    outText = outText.replace(tagBegin, "<span>< ");
    document.getElementById("xmlcode").innerHTML = outText;
}
//clear errors
function resetErrors() {
    resetOldValue();
    document.getElementById("error").innerHTML = "";
}
function resetOldValue() {
    document.getElementById("demo").innerHTML = "";
}
function viewError(tree, notExist) {
    var obj = "";
    if (tree !== false) {
        obj = "In <i>" + tree + "</i> object ";
    }
    var error = "Error:" + obj + " <span>" + notExist + "</span> object or element is not exist!!!";
    document.getElementById("error").innerHTML = error;
}
function attrError(obj, attr) {
    var error = "Error: In <i>" + obj + " </i> onject <span>" + attr + "</span> attribute is not exist!!!";
    document.getElementById("error").innerHTML = error;
}
/*json only
 * set json object, function return value or object by input text
 * */
function getElementJson(jsonObject,text) {
    var inputArray = text.split(".");
    var element = jsonObject[inputArray[0]];
    if (element == undefined) {
        viewError(false, inputArray[0]);
        return element;
    } else {
        var tree = inputArray[0];
    }
    for (i = 1; i < inputArray.length; i++) {
        isArray = inputArray[i].indexOf(":");
        if (isArray != -1) {
            number = inputArray[i].substr(isArray + 1);
            key = inputArray[i].substr(0, isArray);
            if (element[key] != undefined) {
                if (element[key][number] != undefined) {
                    element = element[key][number];
                } else {
                    attrError(tree + "." + key, number);
                }
            } else {
                viewError(tree, key);
            }
        } else if (element[inputArray[i]] != undefined) {
            element = element[inputArray[i]];
            tree += "." + inputArray[i];
        } else {
            viewError(tree, inputArray[i]);
        }
    }
    return element;
}
/*xml only
 * set Dom object, function return value or object by input text
 * */
function getElementXml(xmlObject) {
    resetErrors();
    text = document.getElementById("text").value;
    var inputArray = text.split(".");
    var element = xmlObject.getElementsByTagName(inputArray[0])[0];
    if (element == undefined) {
        viewError(false, inputArray[0]);
        return element;
    } else {
        var tree = inputArray[0];
    }
    for (i = 1; i < inputArray.length; i++) {
        attrNum = inputArray[i].indexOf(":");
        if (attrNum != -1) {
            attr = inputArray[i].substr(attrNum + 1);
            key = inputArray[i].substr(0, attrNum);
            if (element.getElementsByTagName(key)[0] != undefined) {
                if(element.getElementsByTagName(key)[0].getAttribute(attr) != undefined){
                    return element.getElementsByTagName(key)[0].getAttribute(attr);
                }else{
                    attrError(tree+"."+key,attr);
                    return undefined;
                }
            } else {
                viewError(tree, key);
                return undefined;
            }
        } else if(element.getElementsByTagName(inputArray[i])[0] != undefined){
            element = element.getElementsByTagName(inputArray[i])[0];
            tree += "."+inputArray[i];
        }else{
            viewError(tree, inputArray[i]);
            return undefined;
        }
    }
    getChiles = element.children;
    if(getChiles.length == 0){
        return element.innerHTML;
    }else{        
        var message = tree + " <span>Is an object.</span>";
        viewResult(message);
        return undefined;
    }
}
function viewResult(elem) {
    var view = elem;
    if ((elem != "[object Object]") && (elem != undefined)) {
        document.getElementById("demo").innerHTML = view;
    }
    if (elem == "[object Object]") {
        document.getElementById("demo").innerHTML = "<span>Its an object.</span>";
    }
}
function mainJson() {
    resetErrors();
    jsonObject = jsonParser("data/json.json");
    text = document.getElementById("text").value;
    elem = getElementJson(jsonObject,text);
    viewResult(elem);

}
function mainXml() {
    var xmlObject = xmlParser("data/xml.xml");
    var elem = getElementXml(xmlObject);
    viewResult(elem);
}