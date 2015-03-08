//get random element between min and max.
function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}
function getArrayByRandom(){
    var numbers = new Array();
    var count   = parseInt(document.getElementById("count").value);
    var rangMin = parseInt(document.getElementById("min").value);
    var rangMax = parseInt(document.getElementById("max").value);
   
    for(i = 0; i < count; i++){
        numbers[i] = getRandomInt(rangMin, rangMax);
    }
    return numbers;
}
function sortDesc(arrayForSorting){
    return arrayForSorting.sort(function (a, b) { 
        return b-a;
    });
}
function sortAsc(arrayForSorting){
    return arrayForSorting.sort(function (a, b) { 
        return a-b;
    });
}
function view(){
    numbers = getArrayByRandom();
    document.getElementById("demoRandom").innerHTML=numbers;
    document.getElementById("demoSortDesc").innerHTML=sortDesc(numbers);
    document.getElementById("demoSortAsc").innerHTML=sortAsc(numbers);
}
