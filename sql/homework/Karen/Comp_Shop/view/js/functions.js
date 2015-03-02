function getXmlHttp(){
	var xmlhttp;
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (E) {
			xmlhttp = false;
		}
	}
	if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
		xmlhttp = new XMLHttpRequest();
	}
	return xmlhttp;
}

function myLoad() {
	var req = getXmlHttp()  
		var prosucts = document.getElementById("products") 

		req.onreadystatechange = function() {  
			if (req.readyState == 4) { 
				if(req.status == 200) { 
					json = req.responseText;
					jsonObj = JSON.parse(json);
					for (i=0; i<jsonObj.names.length;i++){
						products.innerHTML += "<option>"+jsonObj.names[i]+"</option>";
					}
				}
			}
		}

	req.open('GET', '../controller/query_db.php?tablename=Products', true);  
	req.send(null);
}
function updateProducts(productName){

	var req = getXmlHttp()  
		var view = document.getElementById('view');
		view.innerHTML="";

		req.onreadystatechange = function() {  
			if (req.readyState == 4) { 
				if(req.status == 200) { 
					json = req.responseText;
					jsonObj = JSON.parse(json);
					ul = document.createElement('ul');
					view.appendChild(ul);
					for (i=0; i<jsonObj.names.length;i++){
						li = document.createElement('li');
						ul.appendChild(li);
						text = document.createTextNode(jsonObj.names[i]);
						li.appendChild(text);
					}
				}
			}
		}

	req.open('GET', '../controller/query_db.php?tablename='+productName, true);  
	req.send(null); 
}