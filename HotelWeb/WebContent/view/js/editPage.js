$(".changeable").change(function() {
  var editInfo = this.id.split("_");
  var value;
  if(this.type == "checkbox"){
	  if(this.checked){
		  value = 1;
	  }
	  else{
		  value = 0;
	  }
  }
  else{
	  value = this.value;
  }
  $.post("/HotelWeb/admin/FieldEdit", {
  		table : editInfo[0],
  		field : editInfo[1],
		id : editInfo[2],
		value:value
	}, function(data) {
		if (data != 301) {
		} else {
			$("#errorMsg").html(
					"Cannot update");
			$("#errorMsg").show();
		}

	});

});