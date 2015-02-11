var text = '{ "glossary": { "title": "example glossary","GlossDiv": {"title": "S","GlossList": {"GlossEntry": {"ID": "SGML","SortAs": "SGML","GlossTerm": "Standard Generalized Markup Language","Acronym": "SGML","Abbrev": "ISO 8879:1986","GlossDef": {"para": "A meta-markup language, used to create markup languages such as DocBook.","GlossSeeAlso": ["GML", "XML"]},"GlossSee": "markup"}}}}}';
obj = JSON.parse(text);//coverts the JSON text into JS object
function getValue(inputVal) {
   // var inputVal = document.getElementById("screen").value;
    inputVal = inputVal.replace(/\:/, ".");
    var inputSplit = inputVal.split(".")
    var demo = document.getElementById("demo");
    var expr = "obj";
    for (var i in inputSplit) {
        if ( isNaN(inputSplit) ) {
            expr += "[" + '"' +inputSplit[i] + '"'+ "]";
        }
        else {
            expr += "[" + inputSplit[i] + "]";
        }
    }
    console.log(eval(expr));
    var value = eval(expr);
    var value_string = JSON.stringify(value)
    demo.innerHTML = value_string;
//    try {
//        if (eval(expr) === undefined) throw "Wrong path!";
//        else throw eval(expr);
//    }
//    catch(err) {
//       demo.innerHTML = err; 
//    }
}
