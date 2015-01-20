function sortbyIncrease(a, b)
{
return a - b;
}
var array = ["13", "-8", "55", "-31", "1995", "331", "405", "301", "451"]	
function sortbyDecrease(a, b)
{
return b - a;
}
var array = ["13", "-8", "55", "-31", "1995", "331", "405", "301", "451"]	
alert("Hello, Our array is : [13, -8, 55, -31, 1995, 331, 405, 301, 451]")
alert("Sorting by alfavit");
alert(array.sort());
alert("Sorting by increase");
alert(array.sort(sortbyIncrease));
alert("Sorting by Decrease");
alert(array.sort(sortbyDecrease));
alert("Thanks !")
