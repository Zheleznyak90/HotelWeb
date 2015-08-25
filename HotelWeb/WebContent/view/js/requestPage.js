$(document).ready(function() {
	$(".date").datepicker();

});

$(".recalc").change(function() {
	var checkIn = new Date($("#checkin").val());
	var checkOut = new Date($("#checkout").val());
	var days = (checkOut - checkIn) / 86400000;
	if (days > 0) {
		var roomPrice = parseFloat($("#roomPrice").html().slice(0, -1));
		var mealPriceString = $("#mealSelect option:selected").text();
		var mealPriceWithScrap = /\s[0-9\.,]+\$/.exec(mealPriceString);
		var mealPrice = parseFloat(mealPriceWithScrap[0]);
		var total = days * (roomPrice + mealPrice);
		$("#total").html(total);
	}
	else{
		//TODO BLA BLAchange date
	}

});