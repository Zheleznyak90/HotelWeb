/**
 * 
 */

function langChange(elem) {
	
	var lang = elem.value;
	$.post("/HotelWeb/LangChange", {
		lang : lang
	}, function() {
		location.reload();
	});

};