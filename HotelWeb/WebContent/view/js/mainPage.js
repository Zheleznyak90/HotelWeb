/**
 * 
 */

$(document).ready(function($) {
	google.maps.event.addDomListener(window, 'load', initialize);

});

function initialize() {
	var myLatlng = new google.maps.LatLng(50.0827754,36.236216,21);

	var mapCanvas = document.getElementById('map');
	var mapOptions = {
		center : myLatlng,
		zoom : 13,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(mapCanvas, mapOptions);
	

	var marker = new google.maps.Marker({
	    position: myLatlng,
	    title:"HotelWeb"
	});

	// To add the marker to the map, call setMap();
	marker.setMap(map);
}

function OfferRoom(element) {

	var id = element.id;
	var nextPage = "RoomPage"
	/* var nextPage = "client/OrderInit"; */

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
function sort(type, order) {
	var toSort = document.getElementById('patternList').children;
	toSort = Array.prototype.slice.call(toSort, 0);
	switch (type) {
	case 'capacity':
		if (order == "direct") {
			toSort.sort(capacitySort);
		} else {
			toSort.sort(capacitySortDesc);
		}
		break;
	case 'aClass':
		if (order == "direct") {
			toSort.sort(classSort);
		} else {
			toSort.sort(classSortDesc);
		}
		break;
	case 'price':
		if (order == "direct") {
			toSort.sort(priceSort);
		} else {
			toSort.sort(priceSortDesc);
		}
		break;
	}

	var parent = document.getElementById('patternList');
	parent.innerHTML = "";

	for ( var i = 0, l = toSort.length; i < l; i++) {
		parent.appendChild(toSort[i]);
	}
}
function capacitySort(ele1, ele2) {
	var ele1Comp = ele1.getElementsByClassName('roomCapacitySort')[0].innerHTML;
	var ele2Comp = ele2.getElementsByClassName('roomCapacitySort')[0].innerHTML;
	return ele1Comp - ele2Comp;
}

function capacitySortDesc(ele1, ele2) {
	var ele1Comp = ele1.getElementsByClassName('roomCapacitySort')[0].innerHTML;
	var ele2Comp = ele2.getElementsByClassName('roomCapacitySort')[0].innerHTML;
	return ele2Comp - ele1Comp;
}

function classSort(ele1, ele2) {
	var ele1Comp = ele1.getElementsByClassName('roomClassSort')[0].id;
	var ele2Comp = ele2.getElementsByClassName('roomClassSort')[0].id;
	return ele1Comp.localeCompare(ele2Comp);

}
function classSortDesc(ele1, ele2) {
	var ele1Comp = ele1.getElementsByClassName('roomClassSort')[0].id;
	var ele2Comp = ele2.getElementsByClassName('roomClassSort')[0].id;
	return ele2Comp.localeCompare(ele1Comp);

}
function priceSort(ele1, ele2) {
	var ele1Comp = ele1.getElementsByClassName('roomRateSort')[0].innerHTML;
	var ele2Comp = ele2.getElementsByClassName('roomRateSort')[0].innerHTML;
	return ele1Comp - ele2Comp;

}
function priceSortDesc(ele1, ele2) {
	var ele1Comp = ele1.getElementsByClassName('roomRateSort')[0].innerHTML;
	var ele2Comp = ele2.getElementsByClassName('roomRateSort')[0].innerHTML;
	return ele2Comp - ele1Comp;

}