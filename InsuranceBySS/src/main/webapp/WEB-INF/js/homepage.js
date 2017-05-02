$(document).ready(function() {

	$('#errorMsgId').hide();
	$("#contextpath").hide();

});
function checkNumber() {
	var ziplength = $('#zipCode').val();

	if (ziplength == null || ziplength == 0) {
		$('#errorMsgId').show();
		return false;
	} else
		$('#errorMsgId').hide();

	return true;
}

function isNumberKey(evt) {

	var charCode = (evt.which) ? evt.which : event.keyCode
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		return false;
	} else {
		return true;

	}

}

$(document).ready(function() {

	$(function() {

		var url = $("#contextpath").val() + "/HomeAjax/getZips";

		$("#zipCode").autocomplete({

			source : function(request, response) {

				$.ajax({
					url : url,
					type : "GET",
					data : {

						/*term:zipCode*/
						term : request.term
					},
					dataType : "json",
					success : function(data) {

						response($.map(data, function(v, i) {
							return {
								label : v
							};
						}));

					}
				});
			}
		});
	});
});

function getZipValues(url) {

	var zipCode = $("#zipCode").val();
	$.ajax({
		url : url,
		type : "GET",
		data : {
			term : zipCode
		},
		dataType : "json",
		/*headers: { Accept : "text/plain; charset=utf-8","Content-Type": "text/plain; charset=utf-8"},*/
		success : function(data) {

			if (data.status == "SUCCESS") {

				$('#cityName').val(data.resultObject.cityName);
				$('#stateName').val(data.resultObject.stateName);
			}
		},

	/*error : function(e) {

		alert('Error: ' + e);

	}*/

	});

}
