function getFileContent(filePath){
	var request = new XMLHttpRequest();
	request.open("GET", filePath, false);
	request.send(null);
	return request.responseText;
}
function jsonParser(filePath){
	fileContent= getFileContent(filePath);
	return JSON.parse(fileContent);
}
function getElementTree(){
	text = document.getElementById("text").value;
	var array = text.split(".");
	json = jsonParser("data/json.json");
	element = json[array[0]];
	for(i=1; i<array.length; i++){
		key = array[i].indexOf(":");
		if(key !=-1){
			number = array[i].substr(key+1); 
			k=array[i].substr(0,key);
			if(element[k] != undefined){
				element = element[k][number];
			}else{
				element = undefined;
			}
		}else{
			element = element[array[i]];
		}
	}
	return element;
}
function viewResult(elem){
	var view = elem;
	if(element == "[object Object]"){
		view = "is Object";
	}else if(element == undefined){
		view = "is undefuned";
	}
	document.getElementById("demo").innerHTML = view;
}
function main(){
	elem = getElementTree();
	viewResult(elem);
}
