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
function sortArray(arrayForSorting){
    return arrayForSorting.sort(function (a, b) { 
        if (a > b)
        return 1;
        else if (a < b)
        return -1;
        else
        return 0;
    });
}
function view(){
    numbers = getArrayByRandom();
    document.getElementById("demoRandom").innerHTML=numbers;
    document.getElementById("demoSort").innerHTML=sortArray(numbers);
}