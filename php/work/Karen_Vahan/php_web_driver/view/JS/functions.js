function loading(){
    var apps = ["app1", "app2", "app3"];
    printApps (apps);
}
function printApps (apps) {
    var container = document.getElementById("sheet");
    var ul = document.createElement("ul");
    container.appendChild(ul);
    for (i = 0; i < apps.length; i++) {
        var li = document.createElement("li");
        ul.appendChild(li);
        var a = document.createElement("a");
        a.setAttribute("href","#");
        a.setAttribute("onclick","runApps()");
        var text = document.createTextNode(apps[i]);
        a.appendChild(text);
        li.appendChild(a);
    }
 //       document.getElementById("sheet").innerHTML = text;
}
