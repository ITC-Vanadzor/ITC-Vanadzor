var sessionId = 0;


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
    var login_json = {"email":document.getElementById("email").value,"password":document.getElementById("pswd").value};    
    ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){// here can be added '&& ajaxRequest.statusText=="success"'
               sessionId = ajaxRequest.responseText;     
               window.location = "orderpage.html";
               //alert (ajaxRequest.responseText);
               alert(sessionId);
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){
               document.getElementById("errormsg").innerHTML = "You entered invalid email or password ";
        }
            
    }
    ajaxRequest.open("POST", "http://localhost:8080/lunch-1/login", true);
    ajaxRequest.setRequestHeader("Content-type", "application/json");
    ajaxRequest.send(JSON.stringify(login_json));
    return true;
}


function hideDiv(el){
    el.setAttribute("style","visibility: hidden;");
}
function printProducts(product_list){  
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
function loadproducts(){
   // var prod_text ='[{"productId":"01","productName":"qyabab"},{"productId":"02","productName":"iqibir"},{"productId":"03","productName":"hamburger"},{"productId":"04","productName":"sendwich"},{"productId":"05","productName":"et cetera"}]';
    var value = document.getElementById("products").value;
    var e = document.getElementById("places");
    var strPlace = e.options[e.selectedIndex].text;
    if (value.length==2){
        var prod_json = [{"place_id":strPlace, "input_str":value }];
        jaxRequest = new XMLHttpRequest();
        ajaxRequest.onreadystatechange = function(){
            if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){
                var jsontext = ajaxRequest.responseText;
                var product_list = JSON.parse(jsontext);
                printProducts(product_list);
            }
            else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){//code should be changed!!!!!!!!!
                document.getElementById("main").innerHTML = " Can't find ";
            }
        }
        ajaxRequest.open("POST", "http://localhost:8080", true);//method should be corrected
        ajaxRequest.send(JSON.stringify(prod_json));
    }
}
function getPlaces(){
    jaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){
            var jsontext = ajaxRequest.responseText;
            var places_list = JSON.parse(jsontext);
            printPlaces(places_list);
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){//code should be changed!!!!!!!!!
            document.getElementById("main").innerHTML = " Can't find ";
        }
    }
    ajaxRequest.open("POST", "http://localhost:8080", true);//method should be corrected
    ajaxRequest.send(null);
}

function printPlaces (places_list){
    //var places_list = ["Tashir", "Volodya", "Another place"];
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
function getOrderList(){
    var session_json = [{"sessionId":sessionId}];
    ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){
            var jsontext = ajaxRequest.responseText;
            var orders = JSON.parse(jsontext);
            printOldOrders(orders);
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){//code should be changed!!!!!!!!!
            document.getElementById("main").innerHTML = " Can't find ";
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==500 ){
            document.getElementById("main").innerHTML = " Crash!!!!!";
        }
    }
    ajaxRequest.open("POST", "http://localhost:8080", true);
    ajaxRequest.setRequestHeader("Content-type", "application/json");
    ajaxRequest.send(JSON.stringify(session_json))
}

function printOldOrders(orders){
 //   var orders = '[{"orderId":"01","place_id":"Valod","product_id":"Iqibir","count_id":"2"},{"orderId":"02","place_id":"Tashir","product_id":"Pizza","count_id":"2"}]';
    var obj = JSON.parse(orders);
    for(var i = 0; i<obj.length; ++i ){
        var row = document.createElement("div");
        
        var place_part_div = document.createElement("div");
        var textnode_place = document.createTextNode(obj[i].place_id);
        place_part_div.appendChild(textnode_place);
        place_part_div.setAttribute("class", "table_part1");
        row.appendChild(place_part_div);
        var product_part_div = document.createElement("div");
        var textnode_product = document.createTextNode(obj[i].product_id);
        product_part_div.appendChild(textnode_product);
        product_part_div.setAttribute("class", "table_part2");
        row.appendChild(product_part_div);
        var count_div = document.createElement("div");
        var textnode_count = document.createTextNode(obj[i].count_id);
        count_div.appendChild(textnode_count);
        count_div.setAttribute("class", "table_part3");
        row.appendChild(count_div);
        var btn  = document.createElement("BUTTON");
        var textbtn = document.createTextNode("Delete");
        btn.appendChild(textbtn);
        var value_div=document.createElement("div")
        var value =document.createTextNode(obj[i].orderId);
        value_div.setAttribute("style", "visibility: hidden");
        btn.appendChild(value_div);
        btn.setAttribute("class", "table_part4");
        btn.setAttribute("onclick", "return deleteRow(this)");
        row.appendChild(btn);
        document.getElementById("table").appendChild(row);
    }
}
function deleteRow(e){
        var orderId = e.childNodes[0].nodeValue;
        var delete_json = [{"sessionId":sessionId},{ "orderId":orderId }];
        ajaxRequest = new XMLHttpRequest();
        ajaxRequest.onreadystatechange = function(){
            if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){
                e.parentNode.parentNode.removeChild(e.parentNode);//deletes graphically row if everything is OK
                return true;
            }
            else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){//code shoul be changed!!!!!!!!!
                document.getElementById("main").innerHTML = " Can't delete becouse of wrong sesionId";
                return false;
            }
            else if(ajaxRequest.readyState == 4 && ajaxRequest.status==500 ){
                document.getElementById("main").innerHTML = " Crash!!!!!";
                return false;
            }
            else if(ajaxRequest.readyState == 4 && ajaxRequest.status==414 ){// status code should be changed
                document.getElementById("main").innerHTML = " Can't delete becouse of wrong orderId";
                return false;
            }
                
        }
        ajaxRequest.open("POST", "http://localhost:8080", true);
        ajaxRequest.setRequestHeader("Content-type", "application/json");
        ajaxRequest.send(JSON.stringify(delete_json));
        return false;
}
function validateOrder(){
    var e = document.getElementById("places");
    var placeValue = e.options[e.selectedIndex].text;
    var productValue = document.getElementById("products").value;
    var countValue =   document.getElementById("count").value;
    if( placeValue == "" || productValue == "" || countValue == "" ){
        return false;
    }
    return true;
}
function printNewRow(){

}
/*function addOrder(){
    if(validateOrder()){
        var order_json = [{"sessionId":sessionId},{"place_id":??????},{"product_id":?}, {"count":document.getElementById("count").value}];
        ajaxRequest = new XMLHttpRequest();
        ajaxRequest.onreadystatechange = function(){
            if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){
                printNewRow();                
            }
            else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){
                document.getElementById("main").innerHTML = " Can't add becouse of wrong sesionId";
            }
            else if(ajaxRequest.readyState == 4 && ajaxRequest.status==500 ){
                document.getElementById("main").innerHTML = " Crash!!!!!";
            }
            else if(ajaxRequest.readyState == 4 && ajaxRequest.status==414 ){// status code should be changed
                document.getElementById("main").innerHTML = " Can't delete becouse of wrong orderId";
                return false;
            }

        }
        ajaxRequest.open("POST", "http://localhost:8080", true);
        ajaxRequest.setRequestHeader("Content-type", "application/json");
        ajaxRequest.send(JSON.stringify(order_json));

}*/

















