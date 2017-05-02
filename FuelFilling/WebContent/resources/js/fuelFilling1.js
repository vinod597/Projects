$(document).ready(function() {
	$.ajaxSetup({
		cache : false
	});
	$("#fuelFillingOneId").attr('class', 'clickedButton');
});

// This function is used to calculate distanceTravalled by using presentReading
// and PreviousReading fields.

function onchangeDistanceTravalled(url) {
	document.getElementById('errorMsgId').innerHTML = "";
	document.getElementById('distanceTravelledId').innerHTML = "";
	var form = $("#fuelFilling1FormId").serialize();
	$.ajax({
		url : url,
		type : "POST",
		data : form,
		success : function(data) {
			if (data.errorMessage) {
				$("#errorMsgId").html(data.errorMessage);
			} else {
				$("#distanceTravelledId").html(data.distanceTraveled);
			}
		}
	});

}

// This function is used to enter only Float values in the text box.
function validateFloat(evt, txtObject) {
	var charCode = (evt.which) ? evt.which : evt.keyCode
	if (txtObject.value.indexOf(".") == -1 || charCode != 46) {
		if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
			return false;
		}
		return true;
	}
	return false;
}

function onchangeValidation(){
	var presentReading = $('#presentReadingId').val();
	var fuelFilled = $('#fuelFilledId').val();
	if(presentReading== null || presentReading == 0){
		$("#errorMsgId").html("Please Enter Present Reading");
		return false;
	}
	if(fuelFilled== null || fuelFilled == 0){
		$("#errorMsgId").html("Please Enter Fuel Filled");
		return false;
	}
	
	return true;
}