function xmlParse() {
xmlhttp=new XMLHttpRequest();
xmlhttp.open("GET","catalog.xml",false);
xmlhttp.send();
xmlDoc=xmlhttp.responseXML;

if (window.DOMParser) {
    parser=new DOMParser();
    xmlDoc=parser.parseFromString(xmlStr,"text/xml");
}
}
