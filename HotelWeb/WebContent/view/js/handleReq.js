/**
 * 
 */

$(document).ready(function() {
	$(".date").datepicker();

});

$(".refresh").change(function() {
	var form = $("#handleReqForm");
	form.submit();

});

function createOrder(){
	var nextPage = "OfferRoom";
	$('#handleReqForm').attr('action', nextPage);
	$('#handleReqForm').submit();

}