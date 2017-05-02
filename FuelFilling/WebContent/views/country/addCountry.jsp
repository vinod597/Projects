<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/theme.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/colorbox.css" />
<title></title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	
		// save/update confirmation dialog initialization
		saveOrUpdateConfirmationPopUpDialog = $("#saveOrUpdateConfirmationPopUp").dialog(
				{ 
					autoOpen: false,
					modal:true,
					width: 400,
					height: 130,
					title:'Country Confirmation',
					dialogClass: 'confirmdialogStyle'
				});
	});
	function validateForm() {
		$("#errorMessage").html("");
		var result = true;
		var countryCode = $("#countryCode").val();
		var countryName = $("#countryName").val();
		if (countryCode == "") {
			$("#errorMessage").html("Please enter Country Code");
			result = false;
			return false;
		}
		if (countryName == "") {
			$("#errorMessage").html("Please enter Country Name.");
			result = false;
		} 
		
		return result;
	}
	/* to insert data, first validate form and then only show confirm popup */	
	function validateFormBeforeConfirmation() {
		if (validateForm()) {
			alert();
			saveOrUpdateConfirmationPopUpDialog.dialog("open");
			return;
		}
	}
	
	function saveOrUpdateConfirmationPopUpCancel() {
		saveOrUpdateConfirmationPopUpDialog.dialog('close'); 
		return false;
	}

	function addOrEditCountryPopupCancel() {
		addOrEditCountryPopupDialog.dialog('close');
		return false;
	}
	function submitData() {
		alert();
		var addOrEditFormData = $("#countryForm").serialize();
		$.ajax({
			url:"<%=request.getContextPath()%>/Admin/saveOrUpdateCountry",
			type:'POST',
			data:addOrEditFormData,
			success: function(data) {
				saveOrUpdateConfirmationPopUpDialog.dialog('close');
				addOrEditCountryPopupDialog.dialog('close');
				$countryListJqGrid.trigger('reloadGrid', [{current:true}]);
				return false;
			},
			error: function(jqXHR){
				alert("submitData error:"+jqXHR);
			}
		});
		return false;
		}
</script>
</head>
<body>
	<div >
		<div class="ContentHolder">
				<div class="formElements">
					<form
						action="<%=request.getContextPath()%>/CountryController/saveOrUpdateCountry"
						method="post" name="countryForm" id="countryForm">
						<div>
							<p style="height: 20px;">
							<label
							id="errorMessage" style="padding-left:1px;" class="errorMessage">${errorMessage}</label>
							<label class="successMessage" id="statusMessage"></label> 
							</p>
							<p>
								<input type="text" value="${countryBean.countryId }"
									id="countryId" name="countryId" style="display:none;"
									maxlength="20" />
							</p>
							<p>
								<label class="label" style="width:175px;">Country Code :<font
									color="red">*</font> </label> <input type="text"
									value="${countryBean.countryCode}" name="countryCode"
									class="txtcontrolwidth" id="countryCode" maxlength="8" />
							</p>

							<p>
								<label class="label" style="width:175px;">Country Name :<font
									color="red">*</font>
								</label> <input type="text" value="${countryBean.countryName}"
									class="txtcontrolwidth" name="countryName" id="countryName"
									maxlength="95" />
							</p>
							<p>
								<label class="label" style="width:175px;">Is Active :<font
									color="red"></font> </label> <input type="checkbox" id="isActive" class="checkbox" name="isActive" <c:if test="${countryBean.isActive}"> checked="checked" </c:if> />
							</p>
							<p style="height: 10px;"></p>
							<p>
								<label class="label" style="width:175px;">Last Updated By : </label> 
								<label id="lastUpdatedBy" > ${countryBean.lastUpdatedBy}</label>
							</p>
							<p style="height: 10px;"></p>
							<p>
								<label class="label" style="width:175px;">Last Updated On : </label> 
								<label  id="lastUpdatedOn" >${countryBean.lastUpdatedOn}</label>
							</p>
						</div>
					</form>
				</div>
				<div>
					<div class="btnsHolder btnpadding">
						<div >
							<table border="0" cellpadding="0" cellspacing="0" align="center">
								<tr>
									<td>
										<a class=" btn btnDark" onclick="validateFormBeforeConfirmation()">${empty countryBean.countryId ? "Save" :"Update" }</a>
								 	</td>
								 	<td>
										<a class="btn btnDark" onclick="addOrEditCountryPopupCancel()">Cancel</a>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div style='display: none' id="saveOrUpdateConfirmationPopUp">
					<div>
						<div class="label1">${empty countryBean.countryId ? "Are you sure you want to add country?" :"Are you sure you want to update country?" }</div>
							<table border="0" cellpadding="0" cellspacing="0" align="center">
								<tr>
									<td colspan="3"  align="right">
										<button class="btn btnDark" onclick="submitData()" style="min-width:65px;outline:none;box-shadow:none;">Yes</button>
										<button class="btn btnDark btnNo" onclick="saveOrUpdateConfirmationPopUpCancel()" style="min-width:65px;">No</button>
									</td>
								</tr>
							</table>
					</div>
				</div>
			</div>
		</div>
</body>
</html>