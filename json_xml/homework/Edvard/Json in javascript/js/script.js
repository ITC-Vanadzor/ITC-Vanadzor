var json = {
    "glossary": {
        "title": "example glossary",
		"GlossDiv": {
            "title": "S",
			"GlossList": {
                "GlossEntry": {
                    "ID": "SGML",
					"SortAs": "SGML",
					"GlossTerm": "Standard Generalized Markup Language",
					"Acronym": "SGML",
					"Abbrev": "ISO 8879:1986",
					"GlossDef": {
                        "para": "A meta-markup language, used to create markup languages such as DocBook.",
						"GlossSeeAlso": ["GML", "XML"]
                    },
					"GlossSee": "markup"
                }
            }
        }
    }
};


document.getElementById("demo").innerHTML = rezult;

function parsing() {
   var input_value = document.getElementById("input_text").value;
   arr = input_value.split('.');
   rezult = json[arr[0]];
   no_error = json[arr[0]];
   for (var i=1; i<arr.length; i++) {
      rezult = rezult[arr[i]];
   }
      if (no_error) { 
        if (rezult) {document.getElementById("demo").innerHTML = rezult
        }
        else {alert("Error")
        }
      } 
      else {alert("Error")
      }

}