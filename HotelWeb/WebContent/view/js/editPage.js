$(".changeable").change(function() {
	var parent = $(".currItem");
	var table = $(parent).attr("title");
	var id = $(parent).attr("id");
	
	var field = $(this).attr("id");
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
	$.post("/HotelWeb/manager/FieldEdit", {
  		table : table,
  		field : field,
		id : id,
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