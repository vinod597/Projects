$(document).ready(
		function() {
			$("#paymentPopupDialogId").dialog({
				autoOpen : false,
				height : 300,
				width : 400,
				modal : true,
				close : function() {
					$(this).dialog("close");
				}
			});
			$("#discountPopUpId").dialog({
				autoOpen : false,
				height : 550,
				width : 450,
				modal : true,
				close : function() {
					$(this).dialog("close");
				}
			});
			$.ajaxSetup({
				cache : false
			});
			$("#fuelFillingFourId").attr('class', 'clickedButton');
			$('#dateId').datepicker({
				showButtonPanel : true,
				dateFormat : "dd/M/yy",
				beforeShow : function() {
					$(".ui-datepicker").css('font-size', 12)
				}
			});
			var selectedRadioBtn = $(
					"input[type='radio'][name='paymentMode']:checked").val();
			if (selectedRadioBtn == 0) {
				$('#creditPaymentModeDisplayBlockId').hide();
			} else {
				$('#creditPaymentModeDisplayBlockId').show();
			}
		});

function onChangeMaximumFillingsAction(object) {
	document.getElementById('errorMsgId').innerHTML = "";
	if ($('#' + object.id).val() > 10) {
		$("#errorMsgId").html("Maximum Fillings shouldn't exceed 10");
	}
}

function onChangePresentReadingAction(url) {
	document.getElementById('errorMsgId').innerHTML = "";
	document.getElementById('distanceTraveledId').innerHTML = "";
	var form = $("#fuelFilling3FormId").serialize();
	$.ajax({
		url : url,
		type : "POST",
		data : form,
		dataType : "json",
		success : function(data) {
			if (data.errorMessage) {
				$("#errorMsgId").html(data.errorMessage);
			} else {
				$("#distanceTraveledId").html(data.distanceTraveled);
			}
		}
	});

}

function onClickPayBtnAction(url) {
	$('#paymentPopupErrorMsgId').html('');
	$("#errorMsgId").html("");
	$.ajax({
		url : url,
		type : "GET",
		dataType : "json",
		success : function(data) {
			$("#netAmountId").html(data.netAmount);
			$("#paymentCreditAvailedId").html(data.creditAvailed);
			// check the payment mode
			if (data.paymentMode == 0) {
				$('#paymentCreditAvailedBlockId').hide();
				$('#paymentAmountDueBlockId').hide();
				$('#paymentAmountToBeReturnedBlockId').show();
			} else {
				$('#paymentCreditAvailedBlockId').show();
				$('#paymentAmountDueBlockId').show();
				$('#paymentAmountToBeReturnedBlockId').hide();
			}

			$("#paymentPopupDialogId").dialog("open");
		}
	});
	return false;

}
function onClickDiscountBtnAction() {
	$('#discountPopUpErrorId').html("");
	$("#discountPopUpId").dialog("open");
	return false;
}
function onClickPaymentPopupOkAction(url) {
	$('#paymentPopupErrorMsgId').html('');
	var amountReceived = $('#amountReceivedId').val();
	if ($("input[type='radio'][name='paymentMode']:checked").val() == 0) {
		if (amountReceived == 0) {
			$('#paymentPopupErrorMsgId').html(
					'Please Enter the Amount Received');
			return false;
		}
	} else {
		if (amountReceived == "") {
			$('#paymentPopupErrorMsgId').html(
					'Please Enter the Amount Received');
			return false;
		}
	}
	$.ajax({
		url : url + "?amountReceived=" + amountReceived,
		type : "GET",
		dataType : "json",
		success : function(data) {
			if (data.payMentPopupErrMsg) {
				$('#paymentPopupErrorMsgId').html(data.payMentPopupErrMsg);
			} else {
				// $("#rollBackId").attr('class', 'btn_gray');
				// $("#rollBackId").attr('disabled', 'disabled');
				$("#addId").attr('class', 'btn_login');
				$("#addId").removeAttr('disabled');
				$("#payId").attr('class', 'btn_gray');
				$("#payId").attr('disabled', 'disabled');
				$('#paymentPopupDialogId').dialog("close");
				$('#creditAvailableId').html(data.creditAvailable);
			}
		}
	});
}

function onChangePaymentPopupAmtReceivedAction(url) {
	var amountReceived = $('#amountReceivedId').val();
	$('#paymentPopupErrorMsgId').html('');
	$.ajax({
		url : url + "?amountReceived=" + amountReceived,
		type : "GET",
		dataType : "json",
		success : function(data) {
			if (data.payMentPopupErrMsg) {
				$('#paymentPopupErrorMsgId').html(data.payMentPopupErrMsg);
			} else {
				$('#amountToBeReturnedId').html(data.amountToBeReturned);
				$('#amountDueId').html(data.amountDue);
			}
		}
	});
}

function onChangePaymentModeRadioBtnAction(url) {
	var selectedRadioBtn = $("input[type='radio'][name='paymentMode']:checked")
			.val();
	window.location.href = url + "/" + selectedRadioBtn;
}

function onChangeCreditLimitValueAction(url) {
	// Get the entered credit Limit value
	var creditLimitValue = $('#creditLimitId').val();
	$.ajax({
		url : url + "/" + creditLimitValue,
		type : "GET",
		dataType : "json",
		success : function(data) {
			$('#creditAvailableId').html(data.creditAvailable);
		}
	});
}

function isNumberKey(evt) {

	var charCode = (evt.which) ? evt.which : event.keyCode
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		return false;
	}
	return true;

}

function onclickUpdateBtnValidationAction() {
	var maximumFillings = $('#maximumFillingsId').val();
	var date = $('#dateId').val();
	var presentReading = $('#presentReadingId').val();
	var fuelCost = $('#fuelCostId').val();
	var fuelFilled = $('#fuelFilledId').val();
	var totalFillings = $('#totalFillingsId').html();
	var previousReading = $('#previousReadingId').html();
	var discountBtnStyleClass = $("#discountBtnId").attr("class");
	$('#errorMsgId').html("");
	var selectedRadioBtn = $("input[type='radio'][name='paymentMode']:checked")
			.val();
	var creditLimit = $('#creditLimitId').val();
	if (discountBtnStyleClass == "btn_login") {
		$('#errorMsgId').html("Please provide the discounts");
		return false;
	}
	if (maximumFillings == 0) {
		$('#errorMsgId').html("Please enter Maximum Fillings");
		return false;
	} else if (maximumFillings > 10) {
		$('#errorMsgId').html("Maximum Fillings shouldn't exceed 10");
		return false;
	}
	if (totalFillings == maximumFillings) {
		$('#errorMsgId').html("Maximum Fillings Reached");
		return false;
	}
	if (presentReading < Number(previousReading)) {
		$('#errorMsgId').html(
				"Present Reading must be greater than Previous Reading");
		return false;
	}
	if (date == '') {
		$('#errorMsgId').html("Please select Date");
		return false;
	}
	if (presentReading == 0) {
		$('#errorMsgId').html("Please enter Present Reading");
		return false;
	}
	if (fuelCost == 0) {
		$('#errorMsgId').html("Please enter Fuel Cost");
		return false;
	}
	if (fuelFilled == 0) {
		$('#errorMsgId').html("Please enter Fuel Filled");
		return false;
	}
	if (selectedRadioBtn == 1) {
		if (creditLimit == 0) {
			$('#errorMsgId').html("Please enter Credit Limit");
			return false;
		}
	}
	return true;
}

function onClickAddBtnValidationAction(url) {
	var selectedRadioBtn = $("input[type='radio'][name='paymentMode']:checked")
			.val();
	var fuelCost = $('#fuelCostId').val();
	var fuelFilled = $('#fuelFilledId').val();
	var creditAvailable = Number($('#creditAvailableId').html());
	var netAmount = fuelCost * fuelFilled;
	$('#errorMsgId').html("");

	if (selectedRadioBtn == 1) {
		if (netAmount > creditAvailable) {
			$('#errorMsgId').html(
					"Insufficient Credit Availble please Pay the bill");
			return false;
		}
	}
	$.ajax({
		url : url,
		type : "GET",
		dataType : "json",
		success : function(data) {
			$("#addId").attr('class', 'btn_gray');
			$("#addId").attr('disabled', 'disabled');
			$("#addNextId").attr('class', 'btn_login');
			$("#addNextId").removeAttr('disabled');
			$("#payId").attr('class', 'btn_gray');
			$("#payId").attr('disabled', 'disabled');
			$("#rollBackId").attr('class', 'btn_gray');
			$("#rollBackId").attr('disabled', 'disabled');
			$('#fuelFilling4GridId').html(data.gridDiv);
			$('#creditAvailableId').html(data.creditAvailable);
			$('#creditAvailedId').html(data.creditAvailed);
		}
	});
	return false;
}

function onclickPayPopupCancelAction() {
	$('#paymentPopupDialogId').dialog("close");
}

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
function onClickDiscountPopupOkAction(url) {
	$('#discountPopUpErrorId').html("");
	var maxDiscount = $("#maxDiscountAllowedId").val();
	var billAmount = $("#byBillAmtId").val();
	var billDiscount = $('#byBillDiscountId').val();
	var monthlyAmount = $('#byMonthAmtId').val();
	var monthlyDiscount = $("#byMonthDiscountId").val();
	var yearlyAmount = $("#byYearAmtId").val();
	var yearlyDiscount = $("#byYearDiscountId").val();
	if (maxDiscount == 0) {
		$('#discountPopUpErrorId').html("Please enter Max Discount Allowed");
		return false;
	}
	if (billAmount == 0) {
		$('#discountPopUpErrorId').html("Please enter Bill Amount Exceeds");
		return false;
	}
	if (billDiscount == 0) {
		$('#discountPopUpErrorId').html("Please enter By Bill Discount of");
		return false;
	}
	if (monthlyAmount == 0) {
		$('#discountPopUpErrorId').html("Please enter Monthly Bill Exceeds");
		return false;
	}
	if (monthlyDiscount == 0) {
		$('#discountPopUpErrorId').html("Please enter By Month Discount of");
		return false;
	}
	if (yearlyAmount == 0) {
		$('#discountPopUpErrorId').html("Please enter Yearly Bill Exceeds");
		return false;
	}
	if (yearlyDiscount == 0) {
		$('#discountPopUpErrorId').html("Please enter By Year Discount of");
		return false;
	}
	var form = $("#discountPopUpFormId").serialize();
	$.ajax({
		url : url,
		type : "POST",
		data : form,
		dataType : "json",
		success : function(data) {
			$("#discountBtnId").attr('class', 'btn_gray');
			$("#discountBtnId").attr('disabled', 'disabled');
			$("#discountPopUpId").dialog("close");
		}
	});
}
function onClickDiscountPopupClearAction() {
	$('#discountPopUpErrorId').html("");
	var maxDiscount = $("#maxDiscountAllowedId").val(0.0);
	var billAmount = $("#byBillAmtId").val(0.0);
	var billDiscount = $('#byBillDiscountId').val(0.0);
	var monthlyAmount = $('#byMonthAmtId').val(0.0);
	var monthlyDiscount = $("#byMonthDiscountId").val(0.0);
	var yearlyAmount = $("#byYearAmtId").val(0.0);
	var yearlyDiscount = $("#byYearDiscountId").val(0.0);
}
function onclickDiscountPopupCancelAction() {
	$("#discountPopUpId").dialog("close");
}