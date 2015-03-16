var product = [{"product": "Iqibir", "count": 3},
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
    
}
