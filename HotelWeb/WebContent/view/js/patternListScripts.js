/**
 * 
 */

function editPattern(element) {
	var patternId = element.id.slice(-1);

}

function deletePattern(adress, element) {

	var patternId = element.id.slice(-1);
	$.post(adress + "/admin/PatternDelete", {
		id : patternId
	}, function(data) {
		if (data != 301) {
			location.reload();
		}else{
			$("#errorMsg").html("Cannot delete pattern with referencing rooms");
			$("#errorMsg").show();
		}

	});
};