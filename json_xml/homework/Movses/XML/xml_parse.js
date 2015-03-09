xmlhttp=new XMLHttpRequest();
xmlhttp.open("GET","xml.xml",false);
xmlhttp.send();
xmlDoc=xmlhttp.responseXML;
function xmlParse() {
    var k = document.getElementById("field").value; 
    var res = k.split(".");
    x=xmlDoc.getElementsByTagName("glossary");
    i=0;

    title=(x[i].getElementsByTagName("title")[0].childNodes[0].nodeValue);
    y=xmlDoc.getElementsByTagName("GlossDiv");
    title1=(y[i].getElementsByTagName("title")[0].childNodes[0].nodeValue);
    title2=(y[i].getElementsByTagName("GlossTerm")[0].childNodes[0].nodeValue);
    title3=(y[i].getElementsByTagName("Acronym")[0].childNodes[0].nodeValue);
    title4=(y[i].getElementsByTagName("Abbrev")[0].childNodes[0].nodeValue);
    title5=(y[i].getElementsByTagName("para")[0].childNodes[0].nodeValue);

    att1=xmlDoc.getElementsByTagName("GlossEntry");
    if (k == "glossary.GlossDiv.GlossList.GlossEntry:ID") {
        document.write(att1[i].getAttribute('ID'));
    }
    if (k == "glossary.GlossDiv.GlossList.GlossEntry:SortAs") {
        document.write(att1[i].getAttribute('SortAs'));
    }
    att2=xmlDoc.getElementsByTagName("GlossSeeAlso");
    if (k == "glossary.GlossDiv.GlossList.GlossEntry.GlossDef.GlossSeeAlso:OtherTerm") {
        document.write(att2[i].getAttribute('OtherTerm'));
    }

    att3=xmlDoc.getElementsByTagName("GlossSee");
    if (k == "glossary.GlossDiv.GlossList.GlossEntry.GlossSee:OtherTerm") {
        document.write(att3[i].getAttribute('OtherTerm'));
    }

    if (k == "glossary.GlossDiv.GlossList.GlossEntry.GlossDef.para") {
        document.write(title5);
    }
    if (k == "glossary.GlossDiv.GlossList.GlossEntry.Abbrev") {
        document.write(title4);
    }
    if (k == "glossary.GlossDiv.GlossList.GlossEntry.Acronym") {
        document.write(title3);
    }
    if (k == "glossary.GlossDiv.GlossList.GlossEntry.GlossTerm")  {
        document.write(title2);
    }
    if (k == "glossary.GlossDiv.title") {
        document.write(title1);
    }
    if (k == "glossary.title") {
        document.write(title);
    } 
}

