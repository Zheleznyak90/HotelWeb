$(document).ready(function($) {

	var options = {
		$DragOrientation : 3,
		$SlideDuration : 500,

		$ArrowNavigatorOptions : {
			$Class : $JssorArrowNavigator$,
			$ChanceToShow : 2,
			$AutoCenter : 2,
			$Steps : 1
		}
	};
	var jssor_slider1 = new $JssorSlider$('slider1_container', options);

});

function OfferRoom() {

	var id = document.getElementsByClassName('room')[0].id;
	var nextPage = "client/OrderInit";

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