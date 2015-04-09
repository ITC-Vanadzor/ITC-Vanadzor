var host = "http://localhost:8080"
var places_list = {} ;
function findKeyJson (jsonarray, value){
    var key ;
    for (var j in jsonarray){
        if(jsonarray[j].placeName == value){
            key = jsonarray[j].placeId;
            return key;
         }
    }
    return key;
}
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
    else if(document.getElementById("pswd").value.length < 4 ){
        document.getElementById("errormsg").innerHTML = "Password should be at least 4 symbol";
        return false;
    }
    var login_json = {"email":document.getElementById("email").value,"password":document.getElementById("pswd").value};    
    ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){// here can be added '&& ajaxRequest.statusText=="success"'
               localStorage.session_json = ajaxRequest.responseText;     
               window.location = "orderpage.html";
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==500 ){
               document.getElementById("errormsg").innerHTML = "You entered invalid email or password ";
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){
               document.getElementById("errormsg").innerHTML = "Page Not Found ";
        }
    }
    ajaxRequest.open("POST", host+"/lunch-1/login", true);
    ajaxRequest.setRequestHeader("Content-type", "application/json");
    ajaxRequest.send(JSON.stringify(login_json));
    return true;
}

function hideDiv(el){
    el.setAttribute("style","visibility: hidden;");
}
function printProducts(product_list){  
        var sel = document.createElement("select");
        sel.setAttribute("size",product_list.length+1);
        for (var j in product_list){
            var option = document.createElement("option");
            var option_text = document.createTextNode(product_list[j].productName);
            option.appendChild(option_text);
            option.setAttribute('id',product_list[j].productId);
            option.setAttribute("onclick","document.getElementById('products').value = this.value; hideDiv(this.parentNode.parentNode); document.getElementById('products').setAttribute('name', this.getAttribute('id'))");//input's name attribute contains productId's value;
            sel.appendChild(option);
        }
        var parent_div = document.getElementById("product_list");
        parent_div.innerHTML = "";
        parent_div.setAttribute("style","visibility: visible;");
        parent_div.appendChild(sel);
}
function loadproducts(){
    var value = document.getElementById("products").value;
    var e = document.getElementById("places");
    var strPlace = e.options[e.selectedIndex].text;
    var strPlaceId = findKeyJson(places_list,strPlace);
    if (value.length == 2){
        var prod_json = {"placeId":strPlaceId.toString(), "inputStr":value };
        var ajaxRequest = new XMLHttpRequest();
        ajaxRequest.onreadystatechange = function(){
            if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){
                var jsontext = ajaxRequest.responseText;
                product_list = JSON.parse(jsontext);
                printProducts(product_list);
            }
            else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){
                document.getElementById("main").innerHTML = " Can't find ";
            }
            else if(ajaxRequest.readyState == 4 && ajaxRequest.status==500 ){
                document.getElementById("main").innerHTML = " nerqin Server error.  ";
            }
        }
        ajaxRequest.open("POST", host+"/lunch-1/getproductlist", true);
        ajaxRequest.send(JSON.stringify(prod_json));
    }
}

function getPlaces(){
    var ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){
            var jsontext = ajaxRequest.responseText;
            places_list = JSON.parse(jsontext);
            printPlaces(places_list);
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){
            document.getElementById("main").innerHTML = " Can't find ";
        }
    }
    ajaxRequest.open("POST", host+"/lunch-1/getplaces", true);
    ajaxRequest.send(null);
}

function printPlaces (places_list){
    //var places_list = [{"placeId":1,"placeName":"Tashir"},....];
    var head_option = document.createElement("option");
    var head_option_text = document.createTextNode("Shop/Bistro");
    head_option.appendChild(head_option_text);
    document.getElementById("places"). appendChild(head_option);
    for (var i = 0; i< places_list.length; ++i){
        var option = document.createElement("option");
        option.setAttribute('id', places_list[i].placeId);
        var option_text = document.createTextNode(places_list[i].placeName);
        option.appendChild(option_text);
        document.getElementById("places"). appendChild(option);
        
    }
}
function getOrderList(){
    var ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){
           var jsontext = ajaxRequest.responseText;
           var jsonObj = JSON.parse(jsontext); 
           printOrders(jsonObj);
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){//code should be changed!!!!!!!!!
            document.getElementById("main").innerHTML = " Can't find ";
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==500 ){
            document.getElementById("main").innerHTML = " Crash!!!!!";
        }
    }
    ajaxRequest.open("POST", host+"/lunch-1/getorderlist", true);
    ajaxRequest.setRequestHeader("Content-type", "application/json");
    ajaxRequest.send(localStorage.session_json);
}

function printOrders(orders){
    //var obj = JSON.parse(orders);
    for(var i = 0; i<orders.length; ++i ){
        var row = document.createElement("div");
        
        var place_part_div = document.createElement("div");
        var textnode_place = document.createTextNode(orders[i].placeName);
        place_part_div.appendChild(textnode_place);
        place_part_div.setAttribute("class", "table_part1");
        row.appendChild(place_part_div);
        var product_part_div = document.createElement("div");
        var textnode_product = document.createTextNode(orders[i].productName);
        product_part_div.appendChild(textnode_product);
        product_part_div.setAttribute("class", "table_part2");
        row.appendChild(product_part_div);
        var count_div = document.createElement("div");
        var textnode_count = document.createTextNode(orders[i].count);
        count_div.appendChild(textnode_count);
        count_div.setAttribute("class", "table_part3");
        row.appendChild(count_div);
        var btn  = document.createElement("BUTTON");
        var textbtn = document.createTextNode("Delete");
        btn.appendChild(textbtn);
        btn.setAttribute("class", "table_part4");
        btn.setAttribute("id", orders[i].orderId);
        btn.setAttribute("onclick", "return deleteRow(this)");
        row.appendChild(btn);
        document.getElementById("table").appendChild(row);
    }
}
function deleteRow(e){
        var orderId = e.getAttribute('id');
        var session_id = JSON.parse(localStorage.session_json).sessionId;
        var delete_json = {"sessionId":session_id, "orderId":orderId };
        var ajaxRequest = new XMLHttpRequest();
        ajaxRequest.onreadystatechange = function(){
            if(ajaxRequest.readyState == 4 && ajaxRequest.status==204){
                e.parentNode.parentNode.removeChild(e.parentNode);//deletes graphically row if everything is OK
                return true;
            }
            else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){//code should be changed!!!!!!!!!
                document.getElementById("main").innerHTML = " Can't delete because of wrong sesionId";
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
        ajaxRequest.open("POST", host+"/lunch-1/deleteorder", true);
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
function addOrder(){
    if(validateOrder()){
        var e = document.getElementById("places");
        var product_id = document.getElementById("products").getAttribute('name');
        var strPlace = e.options[e.selectedIndex].getAttribute('id');
        var session_id = JSON.parse(localStorage.session_json).sessionId;
        var order_json = {"sessionId":session_id,"placeId":strPlace.toString(),"productId":product_id, "count":document.getElementById("count").value};
        var ajaxRequest = new XMLHttpRequest();
        ajaxRequest.onreadystatechange = function(){
            if(ajaxRequest.readyState == 4 && ajaxRequest.status==200){
                var response = JSON.parse(ajaxRequest.responseText);
                var order_id = response.orderId;
                var added_json = [{"orderId":order_id, "placeId":strPlace,"placeName":e.options[e.selectedIndex].text,"productId":product_id,"productName":document.getElementById("products").value,"count":document.getElementById("count").value}];
                console.log(added_json);
                printOrders(added_json);                
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
        ajaxRequest.open("POST", host+"/lunch-1/addorder", true);
        ajaxRequest.setRequestHeader("Content-type", "application/json");
        ajaxRequest.send(JSON.stringify(order_json));
    }
}

function signout(){
    var ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status==204){
            window.location = "loginpage.html";
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==500 ){
        }

    }
    ajaxRequest.open("POST", host+"/lunch-1/logout", true);
    ajaxRequest.setRequestHeader("Content-type", "application/json");
    ajaxRequest.send(localStorage.session_json);


}
