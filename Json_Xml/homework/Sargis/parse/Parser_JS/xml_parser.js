//this script will be located in server before executing, otherwise send() method will not work.
xmlhttp=new XMLHttpRequest();
xmlhttp.open("GET","note.xml",false);
xmlhttp.send();
xmlDoc=xmlhttp.responseXML;

function print_content(){
    document.getElementById("content").innerHTML = xmlDoc;

}

