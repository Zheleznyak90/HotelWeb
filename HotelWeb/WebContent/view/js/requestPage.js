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
	} else {
		// TODO BLA BLAchange date
	}

});

function validate() {
	
	alert("false");
	return false;
/*	if (event.defaultPrevented) {
		event.defaultPrevented;
	} else {
		event.returnValue = false; // for IE as dont support preventDefault;
	}*/
	var errMsg = "";
	var checkIn = new Date($("#checkin").val());
	var checkOut = new Date($("#checkout").val());
	var midnightNow = new Date().setHours(0, 0, 0, 0);
	var tomorrowDate = new Date(midnightNow.getTime() + 24 * 60 * 60 * 1000);
	if ((checkOut - checkIn) < 1) {
		errMsg += "Check in date must be earlier than checkout";
	}
	alert((checkIn - tomorrowDate) / (24 * 60 * 60 * 1000));
	/* if() */

	if (errMsg != "") {
		alert("err");
	}
	return false;
}