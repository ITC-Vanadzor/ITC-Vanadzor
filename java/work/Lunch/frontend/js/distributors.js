var product = [ {"product": "Iqibir", "count": 3},
    {"product": "Qyabab", "count": 2},
    {"product": "Pizza", "count": 4}
];
 

function change(place) {
    localStorage["place"]=place;
}

function changeName() {
    document.getElementById("placeName").innerHTML = localStorage["place"];
}

function addProductList() {
    alert(product);
    for(i=0; i<2; i++) {
        document.getElementById("productTable").innerHTML = 
        "<tr>" + "<td>" + product[i].product + "<td>" + "<td>" + product[i].count + "<td>" + "<tr>"               
    }   
}
function addOrderList() {
    for(i=0; i<order.length; i++) {
        document.getElementById("orderTable").innerHTML = 
        "<tr>" + "<td>" + order[1].name + "<td>" + "<td>" + order[i].product + "<td>" + "<td>" + order[i].count + "<td>" + "<tr>";               
    }   
}
