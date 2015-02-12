$("#button").click( function() {
$.ajax({
	src: 'xml/data.xml',
	dataType: 'xml',
	success: function() {
		var val = document.getElementById("input").value;
		$(data).find('val').each(function() {
			var res = $(this).find('val').title();
			
			$('.timeline').append(
				$('<li />', {
					text: res
				})
			);
		});
	},
	error: function(){
		$('.timeline').text('Failed to get field');
	}
});
})