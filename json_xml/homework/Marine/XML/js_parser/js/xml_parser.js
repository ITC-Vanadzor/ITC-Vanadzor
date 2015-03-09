txt="<glossary>";
txt=txt+"<title>example glossary</title>";
txt=txt+"<GlossDiv><title>S</title>";
txt=txt+"<GlossList>";
txt=txt+" <GlossEntry ID=\"SGML\" SortAs=\"SGML\">";
txt=txt+" <GlossTerm>Standard Generalized Markup Language</GlossTerm>";
txt=txt+" <Acronym>SGML</Acronym>";
txt=txt+" <Abbrev>ISO 8879:1986</Abbrev>";
txt=txt+"<GlossDef>";
txt=txt+"<para>A meta-markup language, used to create markup languages such as DocBook.</para>";
txt=txt+"<GlossSeeAlso OtherTerm=\"GML\">";
txt=txt+"<GlossSeeAlso OtherTerm=\"XML\">";
txt=txt+"</GlossDef>";
txt=txt+"<GlossSee OtherTerm=\"markup>\"</GlossSee>";
txt=txt+"</GlossEntry>";
txt=txt+"</GlossList>";
txt=txt+"</GlossDiv>";
txt=txt+"</glossary>";

if (window.DOMParser)
	{
	parser=new DOMParser();
	xmlDoc=parser.parseFromString(txt,"text/xml");
}
function pars(){
	var xmlTag = document.getElementById('input').value;
	res= xmlTag.split(".");
    c=res[res.length-1];
    k=c.split(':');
    res[res.length-1]=k[0];
    if (xmlTag=='') {
        alert("INPUT XML TAGS");
    }
    else {
        var b=xmlDoc.getElementsByTagName(res[0])[0];
		if(b==undefined) {
			alert(res[0]+" tag  undefined");
		}
		for (i=1;i<res.length;i++) {
			b=b.getElementsByTagName(res[i])[0];
			if (b==undefined) {
			alert(res[i]+" tag  undefined");
			}
		}
		if (k[1]==undefined ) {
			alert (b.childNodes[0].nodeValue)
		}
		else {
			m=b.getAttribute(k[1]);
			if (m==null) {
				alert (res [res.length-1]+ "  has no  "+k[1]+"   attribute" );
			}
			else {
				alert(m);
			}
		}
	}
}
