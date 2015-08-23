/**
 * 
 */

$(document).ready(function() {
	$(".sortable").makeSortable(newTableObject);
});

function selectOrder(element){
	var id = element.id;
	
	var nextPage = "OrderEdit";

	var form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", nextPage);

	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "id");
	hiddenField.setAttribute("value", id);

	form.appendChild(hiddenField);

	document.body.appendChild(form);
	form.submit();
}