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
	element = json[array[0]]
	for(i=1; i<array.length; i++){
		element= element[array[i]]
	}
	alert(element);
	document.getElementById("demo").innerHTML = element;
}
