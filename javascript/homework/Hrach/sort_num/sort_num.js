var array=[25, 8, 7, 41];

function minMax() {
	array.sort(function(a,b){return a - b});
	document.write(array);
}

function maxMin() {
	array.sort(function(a,b){return b - a});
	document.write(array);
}
