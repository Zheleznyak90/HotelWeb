/**
 * 
 */
$(".unique").change(function() {
	$("#errorMsg.errorMsg").remove();
	var table = $(this).closest("div").attr("title");
	var field = $(this).attr("name");
	var value = $(this).val();
	var thisObj = $(this);

	$.post("/HotelWeb/admin/UniqueCheck", {
		table : table,
		field : field,
		value : value
	}, function(data) {
		switch (data) {
		case "301":
			$("#errorMsg").html("Cannot update");
			$("#errorMsg").show();
			break;
		case "300":
			var row = thisObj.closest("tr");
			var newElem = $("<td></td>").text("Field is not unique");
			$(newElem).attr("id", "errorMsg");
			$(newElem).attr("class", "errorMsg");
			$(newElem).show();
			$(row).append(newElem);
			break;
		default:
			break;
		}
	});

});