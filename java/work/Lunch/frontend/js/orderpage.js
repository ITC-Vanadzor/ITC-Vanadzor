function loadproducts(){
    document.getElementById("products").value = "Qyabab";
}
function getPlaces (){
    document.getElementById("places").innerHTML = "aaa";
}
function printOldOrders(){
    var orders = '{"order_id":['+'{"place_id":"Tashir","product_id":"Pizza","count_id":"2"}]}';
    var obj = JSON.parse(orders);
    var node = document.createElement("div");
    var texnode = obj.order_id[0].place_id;
    document.getElementById("table").appendChild(node);
    //document.getElementById("table_part2").innerHTML = obj.order_id[0].product_id;
    //document.getElementById("table_part3").innerHTML = obj.order_id[0].count_id;
}

