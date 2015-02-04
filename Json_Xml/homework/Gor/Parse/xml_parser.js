// JavaScript Document

function xmlParser() {
	
	xmlDoc = loadXMLDoc("xml.xml");
	xmlParse = parser.parseFromString("xmlDoc");

	var tag = document.getElementById("input").value;
	var comb = tag.split(".");
	var result = xmlParse[comb[0]]; 
	
	for(i=1; i<result.length; i++ ) { 
		result += [comb[i]];
	}
	
	document.getElementById(parsing).innerHTML = result;
}