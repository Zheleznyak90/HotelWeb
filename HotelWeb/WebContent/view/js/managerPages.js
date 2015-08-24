/**
 * 
 */

$(document).ready(function() {
	$(".sortable").makeSortable(newTableObject);
});

function selectItem(element,nextPage){
	var id = element.id;
	
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