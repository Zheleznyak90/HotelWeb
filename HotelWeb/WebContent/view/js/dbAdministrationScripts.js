/**
 * 
 */
function editRow(adress, editPageAdr, element) {
	var editId = element.id.substr(element.id.lastIndexOf('_') + 1);
	var nextPage = adress + "/admin/" + editPageAdr;

	var form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", nextPage);

	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "id");
	hiddenField.setAttribute("value", editId);

	form.appendChild(hiddenField);

	document.body.appendChild(form);
	form.submit();

}

function deleteRow(adress, table, element) {

	var delId = element.id.substr(element.id.lastIndexOf('_') + 1);
	$.post(adress + "/admin/RowDelete", {
		id : delId,
		table : table
	}, function(data) {
		if (data != 301) {
			location.reload();
		} else {
			$("#errorMsg").html(
					"Cannot delete this row. Another one reference it.");
			$("#errorMsg").show();
		}

	});
};