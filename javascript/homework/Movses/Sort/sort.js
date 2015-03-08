var points = [32, 6, 24, 12, 48, 144];
document.getElementById("demo").innerHTML = points;

function Growth() {
        points.sort(function(a, b){return a-b});
            document.getElementById("demo").innerHTML = points;
}
function Decline() {
        points.sort(function(a, b){return b-a});
            document.getElementById("demo").innerHTML = points;
}
