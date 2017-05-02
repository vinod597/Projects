$(document).ready(function() {
	$.ajaxSetup({
		cache : false
	});
	$("#fuelFillingTwoId").attr('class', 'clickedButton');
});

function onchangeMaximumFillings(id) {
	$("#errorMsgId").html("");
	if (id.value > 10) {
		$("#errorMsgId").html("Maximum Fillings greater than 10 not allowed");
	}
}
function onchangecreditLimit(id) {
	$("#creditAvailableId").html(id.value);
}

function onchangeDistanceTravalled(url) {
	document.getElementById('errorMsgId').innerHTML = "";
	document.getElementById('distanceTravelledId').innerHTML = "";
	var form = $("#fuelFilling2FormId").serialize();
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

// This function is used to enter only Numbers in the PresentReading and
// FuelFilled text fields.
function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode
	if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
		return false;

	return true;
}

function onchangeValidation() {
	$("#errorMsgId").html("");
	var maximumFillings = $('#maximumFillingsId').val();
	var creditLimit = $('#creditLimitId').val();
	var presentReading = $('#presentReadingId').val();
	var fuelCost = $('#fuelCostId').val();
	var fuelFilled = $('#fuelFilledId').val();
	var totalFillings = document.getElementById('totalFillingsId').innerHTML;
	var creditAvailable = document.getElementById('creditAvailableId').innerHTML;
	if (maximumFillings == null || maximumFillings == 0) {
		$("#errorMsgId").html("Please Enter Maximum Fillings");
		return false;
	}
	if (creditLimit == null || creditLimit == 0) {
		$("#errorMsgId").html("Please Enter Credit Limit");
		return false;
	}
	if (presentReading == null || presentReading == 0) {
		$("#errorMsgId").html("Please Enter Present Reading");
		return false;
	}
	if (fuelCost == null || fuelCost == 0) {
		$("#errorMsgId").html("Please Enter Fuel Cost");
		return false;
	}
	if (fuelFilled == null || fuelFilled == 0) {
		$("#errorMsgId").html("Please Enter Fuel Filled");
		return false;
	}
	if (totalFillings >= maximumFillings) {
		$("#errorMsgId").html("Maximum Fillings is Reached");
		return false;
	}
	var billAmount = fuelCost * fuelFilled;

	if (creditAvailable < billAmount) {
		$("#errorMsgId").html("Credit Limit is Reached");
		return false;
	}
	return true;
}
