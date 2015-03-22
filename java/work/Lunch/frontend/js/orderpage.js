function ValidateEmail(inputText) {  
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
    if(inputText.value.match(mailformat)) {  
        //document.getElementById("email").focus();  
        return true;  
    }  
    else  {  
        //document.getElementById("email").focus();          
        return false;  
    }  
}

function login(){
    if(!ValidateEmail(document.getElementById("email"))){
        document.getElementById("errormsg").innerHTML = "You have entered an invalid email address!";  
        return false;
    }
    else if(document.getElementById("pswd").value.length < 6 ){
        document.getElementById("errormsg").innerHTML = "Password should be at least 6 symbol";
        return false;
    }
    ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 ){
               //document.getElementById("test").innerHTML =
               alert (ajaxRequest.responseText);
        }
    }
    ajaxRequest.open("POST", "http://192.168.0.102:8080/helloWorld-0.1-dev/hello", true);
    ajaxRequest.send("text");//document.getElementById("email").value);
    return true;
}


function hideDiv(el){
    el.setAttribute("style","visibility: hidden;");
}
function loadproducts(){
    var prod_text ='[{"productId":"01","productName":"qyabab"},{"productId":"02","productName":"iqibir"},{"productId":"03","productName":"hamburger"},{"productId":"04","productName":"sendwich"},{"productId":"05","productName":"et cetera"}]';
    var product_list = JSON.parse(prod_text);
    var value = document.getElementById("products").value;
    if (value.length==2){
        //sendRequestProductList(document.getElementById("places").value, document.getElementById("products").value );
        //if(requst@ OK){
        //  var jsontext = sendRequestProductList(..................).responseBody;
        //  var obj = JSON.parse(jsontext);
        //  ...
        //  ...
        var sel = document.createElement("select");
        sel.setAttribute("size",product_list.length);
        for (var j in product_list){
            var option = document.createElement("option");
            var option_text = document.createTextNode(product_list[j].productName);
            option.appendChild(option_text);
            option.setAttribute("onclick","document.getElementById('products').value = this.value; hideDiv(this.parentNode.parentNode);");
            //var product_id =      GTNEL EV HISHEL PRODUCT_ID VOR FORMI SUBMITTI JAMANAK OGTAGORXCENQ!!!!!!!!!!  ,
            sel.appendChild(option);
        }
        var parent_div = document.getElementById("product_list");
        parent_div.innerHTML = "";
        parent_div.setAttribute("style","visibility: visible;");
        parent_div.appendChild(sel);
    }
}
function getPlaces (){
    var places_list = ["Tashir", "Volodya", "Another place"];
    var head_option = document.createElement("option");
    var head_option_text = document.createTextNode("Shop/Bistro");
    head_option.appendChild(head_option_text);
    document.getElementById("places"). appendChild(head_option);
    for (var i = 0; i< places_list.length; ++i){
        var option = document.createElement("option");
        var option_text = document.createTextNode(places_list[i]);
        option.appendChild(option_text);
        document.getElementById("places"). appendChild(option);
        
    }
}
function getOrders(user_id){
    var jsontext;
    return jsontext;
}
function printOldOrders(){
    var orders = '{"order_id":['+'{"place_id":"Valod","product_id":"Iqibir","count_id":"2"},{"place_id":"Tashir","product_id":"Pizza","count_id":"2"}]}';
    var obj = JSON.parse(orders);
    for(var i = 0; i<obj.order_id.length; ++i ){
        var row = document.createElement("div");
        
        var newdiv1 = document.createElement("div");
        var textnode1 = document.createTextNode(obj.order_id[i].place_id);
        newdiv1.appendChild(textnode1);
        newdiv1.setAttribute("class", "table_part1");
        row.appendChild(newdiv1);
        var newdiv2 = document.createElement("div");
        var textnode2 = document.createTextNode(obj.order_id[i].product_id);
        newdiv2.appendChild(textnode2);
        newdiv2.setAttribute("class", "table_part2");
        row.appendChild(newdiv2);
        var newdiv3 = document.createElement("div");
        var textnode3 = document.createTextNode(obj.order_id[i].count_id);
        newdiv3.appendChild(textnode3);
        newdiv3.setAttribute("class", "table_part3");
        row.appendChild(newdiv3);
        var btn  = document.createElement("BUTTON");
        var textbtn = document.createTextNode("Delete");
        btn.appendChild(textbtn);
        btn.setAttribute("class", "table_part4");
        btn.setAttribute("onclick", "deleteRow(this)");
        row.appendChild(btn);
        document.getElementById("table").appendChild(row);
    }
}
function deleteRow(e)
{
        e.parentNode.parentNode.removeChild(e.parentNode);
}

