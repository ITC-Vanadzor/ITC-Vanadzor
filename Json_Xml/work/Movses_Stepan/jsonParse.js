function jsonExample() {
     text1 = '{"glossary": {"title": "example glossary","GlossDiv": {"title": "S","GlossList": { "GlossEntry": {"ID": "SGML","SortAs": "SGML","GlossTerm": "Standard Generalized Markup Language","Acronym": "SGML", "Abbrev": "ISO 8879:1986","GlossDef": {"para": "A meta-markup language, used to create markup languages such as DocBook.","GlossSeeAlso": ["GML", "XML"] }, "GlossSee": "markup" }}}}}';
        obj = JSON.parse(text1);
        k = document.getElementById("field").value;
        var res = k.split(".");
        var n = obj[res[0]]; 
        for(i=1; i<res.length; i++ ) { 
            n += [res[i]];
    }
alert(n)
}
