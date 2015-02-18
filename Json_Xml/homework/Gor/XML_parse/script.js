$("#button").click( function() {
$(document).ready(function () {
	$.ajax({
		type: "GET",
		url: "data.xml",
		dataType: "xml",
		success: function(xml) {
			var val = document.getElementById("input").value;
			$(xml).find(val).each(function(){
				var out = $(this).find(val).text();
				document.getElementById("res").innerHTML=out;
			});
		}
	});
});
});