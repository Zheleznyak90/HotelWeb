/**
 * 
 */

function editField(adress, table, field, element, setValue) {
	var patternId = element.id.slice(-1);

}

function deleteRow(adress, table, element) {
	
	var delId = element.id.substr(element.id.lastIndexOf('_')+1);
	$.post(adress + "/admin/RowDelete", {
		id : delId,
		table : table
	}, function(data) {
		if (data != 301) {
			location.reload();
		}else{
			$("#errorMsg").html("Cannot delete this row. Another one reference it.");
			$("#errorMsg").show();
		}

	});
};