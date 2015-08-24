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