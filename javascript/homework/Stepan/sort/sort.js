var points = [40, 100, 1, 5, 25, 10];
document.getElementById("ascend numbers").innerHTML = points;    

function myFunction1() {
    points.sort(function(a, b){return a-b});
    document.getElementById("ascend numbers").innerHTML = points;
}

var points = [40, 100, 1, 5, 25, 10];
document.getElementById("descend numbers").innerHTML = points;    

function myFunction2() {
    points.sort(function(a, b){return b-a});
    document.getElementById("descend numbers").innerHTML = points;
}

