function jsonParse() {
    jsontext = '{"glossary": {"title": "example glossary","GlossDiv": {"title": "S","GlossList": { "GlossEntry": {"ID": "SGML","SortAs": "SGML","GlossTerm": "Standard Generalized Markup Language","Acronym": "SGML", "Abbrev": "ISO 8879:1986","GlossDef": {"para": "A meta-markup language, used to create markup languages such as DocBook.","GlossSeeAlso": ["GML", "XML"] }, "GlossSee": "markup" }}}}}';
    jstext = JSON.parse(jsontext);
    inputttext = document.getElementById("fieldid").value;
    var splitedtext = inputtext.split(".");
    var res = jstext[splitedtext[0]];
    for(i=1; i<splitedtext.length; i++) {
            result = res[splitedtext[i]];
        }
alert(result)
}
        
