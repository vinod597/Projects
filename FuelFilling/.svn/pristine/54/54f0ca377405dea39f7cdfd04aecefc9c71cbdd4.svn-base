<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Fuel Filling-3</title>
<jsp:include page="head.jsp" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/fuelFilling3.js"></script>
</head>
<body>
	<table width="60%" align="center" border="0">
		<tr>

			<td><img alt="Logo"
				src="${pageContext.request.contextPath}/images/logo.png"></td>
		</tr>
		<tr>
			<td width="100%" valign="top">
				<table border="0" width="100%">
					<tr height="780px">
						<td width="15%" bgcolor="#006D7A" valign="top"><jsp:include
								page="leftMenu.jsp"></jsp:include></td>
						<td width="85%" valign="top" bgcolor="#80DFE3"><form:form
								commandName="fuelFilling3Bean" method="POST"
								id="fuelFilling3FormId"
								action="${pageContext.request.contextPath}/FuelFilling3Controller/submitAction">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
										<td align="center" colspan="3"><label
											class="lblpageheading" style="text-decoration: underline;">Session
												03- Fuel Filling with Payment</label></td>
									</tr>
									<tr height="10px"></tr>
									<tr>
										<td colspan="3">
											<table width="100%">
												<tr>
													<td width="30%"></td>
													<td><label class="mandatoryredtext">**No of
															fillings should not exceed 10</label></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr height="10px"></tr>
									<tr>
										<td colspan="3" align="center"><label id="errorMsgId"
											class="mandatoryredtext">${fuelFilling3Bean.errorMessage}</label></td>
									</tr>
									<tr height="10px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Maximum
												Fillings </label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><form:input
												id="maximumFillingsId" maxlength="6"
												onkeypress="return isNumberKey(event)"
												disabled="${fuelFilling3Bean.maximumFillingsDisable}"
												onchange="onChangeMaximumFillingsAction(this);"
												onfocus="this.value=''" cssClass="controlfont"
												path="maximumFillings" /></td>
									</tr>


									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Payment
												Mode </label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%">
											<table width="100%" cellpadding="0" cellspacing="0"
												border="0">
												<tr>
													<td width="40%" class="labelfont"><form:radiobuttons
															path="paymentMode"
															items="${fuelFilling3Bean.paymentModeList}"
															itemLabel="label" itemValue="value"
															onchange="onChangePaymentModeRadioBtnAction('${pageContext.request.contextPath}/FuelFilling3Controller/onChangePaymentModeRadioBtnAction');" />

													</td>
													<td width="10%"></td>
													<td><form:button value="Pay" title="Pay" id="payId"
															disabled="${fuelFilling3Bean.payBtnDisable}"
															onclick="return onClickPayBtnAction('${pageContext.request.contextPath}/FuelFilling3Controller/payBtnAction');"
															class="${fuelFilling3Bean.payBtnStyleClass}">Pay</form:button>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr height="5px" />
									<tr id="creditPaymentModeDisplayBlockId" style="display: none;">
										<td align="right" width="49%"><label class="labelfont">Credit
												Limit</label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%">
											<table width="100%" cellpadding="0" cellspacing="0"
												border="0">
												<tr>
													<td width="18%"><form:input path="creditLimit"
															maxlength="6" onfocus="this.value=''"
															onkeypress="return validateFloat(event,this)"
															disabled="${fuelFilling3Bean.creditLimitDisable}"
															cssStyle="width:75px;" cssClass="controlfont"
															id="creditLimitId"
															onchange="onChangeCreditLimitValueAction('${pageContext.request.contextPath}/FuelFilling3Controller/onChangeCreditLimitValueAction');" /></td>
													<td width="20%"><label class="labelfont">Credit
															Availed </label></td>
													<td width="2%"><label class="labelfont">:</label></td>
													<td width="15%"><form:label path="creditAvailed" id="creditAvailedId"
															cssClass="labelvalue">${fuelFilling3Bean.creditAvailed}</form:label></td>
													<td width="20%"><label class="labelfont">Credit
															Available </label></td>
													<td width="2%"><label class="labelfont">:</label></td>
													<td width="23%"><form:label path="creditAvailable"
															id="creditAvailableId" cssClass="labelvalue">${fuelFilling3Bean.creditAvailable}</form:label></td>
												</tr>
											</table>
										</td>
									</tr>

									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelheading">Meter
												Reading </label></td>
										<td align="center" width="4%"><label></label></td>
										<td align="left" width="49%"><form:button id="addNextId"
												value="Add Next" title="Add Next"
												disabled="${fuelFilling3Bean.addNextBtnDisable}"
												name="addNext"
												class="${fuelFilling3Bean.addNextBtnStyleClass}">Add Next</form:button>
										</td>
									</tr>

									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Date
										</label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><form:input path="date"
												disabled="${fuelFilling3Bean.dateDisable}" readonly="true"
												cssClass="controlfont" id="dateId" /></td>
									</tr>
									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Previous
												Reading </label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><form:label
												id="previousReadingId" cssClass="labelvalue"
												path="previousReading">${fuelFilling3Bean.previousReading}</form:label></td>
									</tr>
									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Present
												Reading</label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><form:input maxlength="6"
												onkeypress="return validateFloat(event,this)"
												id="presentReadingId"
												disabled="${fuelFilling3Bean.presentReadingDisable}"
												onchange="onChangePresentReadingAction('${pageContext.request.contextPath}/FuelFilling3Controller/onChangePresentReadingAction');"
												cssClass="controlfont" onfocus="this.value=''"
												path="presentReading" /></td>
									</tr>
									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Distance
												Traveled</label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><form:label
												class="labelvalue" path="distanceTraveled"
												id="distanceTraveledId">${fuelFilling3Bean.distanceTraveled}</form:label></td>
									</tr>
									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Fuel
												Cost</label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><form:input path="fuelCost"
												id="fuelCostId" maxlength="6"
												onkeypress="return validateFloat(event,this)"
												disabled="${fuelFilling3Bean.fuelCostDisable}"
												onfocus="this.value=''" cssClass="controlfont" /></td>
									</tr>
									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Fuel
												Filled</label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><form:input maxlength="6"
												id="fuelFilledId"
												onkeypress="return validateFloat(event,this)"
												disabled="${fuelFilling3Bean.fuelFilledDisable}"
												onfocus="this.value=''" cssClass="controlfont"
												path="fuelFilled" /></td>
									</tr>

									<tr height="5px" />
									<tr>
										<td colspan="3">
											<table cellpadding="0" cellspacing="10" border="0"
												align="center">
												<tr>
													<td><form:button value="Update" title="Update"
															disabled="${fuelFilling3Bean.updateBtnDisable}"
															name="update"
															onclick="return onclickUpdateBtnValidationAction();"
															class="${fuelFilling3Bean.updateBtnStyleClass}">Update</form:button></td>
													<td><form:button value="Refresh" title="Refresh"
															disabled="${fuelFilling3Bean.refreshBtnDisable}"
															name="refresh"
															class="${fuelFilling3Bean.refreshBtnStyleClass}">Refresh</form:button></td>
													<td><form:button value="Roll Back" title="Roll Back"
															id="rollBackId"
															disabled="${fuelFilling3Bean.rollBackBtnDisable}"
															name="rollBack"
															class="${fuelFilling3Bean.rollBackBtnStyleClass}">Roll Back</form:button></td>
													<td><form:button value="Clear" title="Clear"
															disabled="${fuelFilling3Bean.clearBtnDisable}"
															name="clear"
															class="${fuelFilling3Bean.clearBtnStyleClass}">Clear</form:button></td>
													<td><form:button value="Cancel" title="Cancel"
															disabled="${fuelFilling3Bean.cancelBtnDisable}"
															name="cancel"
															class="${fuelFilling3Bean.cancelBtnStyleClass}">Cancel</form:button></td>
												</tr>
											</table>
										</td>
									</tr>

									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Total
												Fillings </label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><label class="labelvalue"
											id="totalFillingsId">${fuelFilling3Bean.totalFillings}</label>
										</td>
									</tr>
									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Total
												Fuel Filled </label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><label class="labelvalue">${fuelFilling3Bean.totalFuelFilled}</label>
									</tr>
									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Total
												Distance Traveled </label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><label class="labelvalue">${fuelFilling3Bean.totalDistanceTravelled}</label>
									</tr>
									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Mileage</label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><label class="labelvalue">${fuelFilling3Bean.mileage}</label>
									</tr>
									<tr height="5px" />
									<tr>
										<td align="right" width="49%"><label class="labelfont">Average
												Mileage </label></td>
										<td align="center" width="2%"><label>: </label></td>
										<td align="left" width="49%"><label class="labelvalue">${fuelFilling3Bean.avgMileage}</label>
									</tr>
									<tr height="5px" />
									<tr>
										<td colspan="3">
											<table cellpadding="0" cellspacing="0" border="0"
												align="center">
												<tr>
													<td><form:button value="Add" title="Add" id="addId"
															onclick="return onClickAddBtnValidationAction('${pageContext.request.contextPath}/FuelFilling3Controller/addAction');"
															disabled="${fuelFilling3Bean.addBtnDisable}" name="add"
															class="${fuelFilling3Bean.addBtnStyleClass}">Add</form:button></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr height="10px" />
									<tr>
										<td colspan="3" id="fuelFilling3GridId">${fuelFilling3Bean.gridDiv}</td>
									</tr>
								</table>
							</form:form></td>
					</tr>

				</table>
			</td>
		</tr>
	</table>
	<div id="paymentPopupDialogId" title="Payment" style="display: none;">
		<table border="0" width="100%">
			<tr>
				<td colspan="3" align="center"><label class="labelheading">Payment</label></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><label class="mandatoryredtext"
					id="paymentPopupErrorMsgId"></label></td>
			</tr>
			<tr height="5px" />
			<tr>
				<td align="right" width="49%"><label class="labelfont">Net
						Amount</label></td>
				<td align="center" width="2%"><label class="labelfont">:
				</label></td>
				<td align="left" width="49%"><label class="labelvalue"
					id="netAmountId"></label></td>
			</tr>


			<tr height="5px" />
			<tr id="paymentCreditAvailedBlockId">
				<td align="right" width="49%"><label class="labelfont">Credit
						Availed</label></td>
				<td align="center" width="2%"><label class="labelfont">:
				</label></td>
				<td align="left" width="49%"><label class="labelvalue"
					id="paymentCreditAvailedId"></label></td>
			</tr>


			<tr height="5px" />
			<tr>
				<td align="right" width="49%"><label class="labelfont">Amount
						Received</label></td>
				<td align="center" width="2%"><label class="labelfont">:
				</label></td>
				<td align="left" width="49%"><input type="text"
					onfocus="this.value=''"
					onchange="onChangePaymentPopupAmtReceivedAction('${pageContext.request.contextPath}/FuelFilling3Controller/onChangePaymentPopupAmtReceivedAction');"
					id="amountReceivedId"></td>
			</tr>
			<tr height="5px" />
			<tr id="paymentAmountToBeReturnedBlockId">
				<td align="right" width="49%"><label class="labelfont">Amount
						to be Returned</label></td>
				<td align="center" width="2%"><label class="labelfont">:
				</label></td>
				<td align="left" width="49%"><label class="labelvalue"
					id="amountToBeReturnedId"></label></td>
			</tr>
			<tr id="paymentAmountDueBlockId">
				<td align="right" width="49%"><label class="labelfont">Amount
						Due</label></td>
				<td align="center" width="2%"><label class="labelfont">:
				</label></td>
				<td align="left" width="49%"><label class="labelvalue"
					id="amountDueId"></label></td>
			</tr>
			<tr height="15px" />
			<tr>
				<td align="right" width="49%"><input type="button" value="Ok"
					class="btn_login"
					onclick="onClickPaymentPopupOkAction('${pageContext.request.contextPath}/FuelFilling3Controller/paymentPopupOkAction');"
					id="okId"></td>
				<td align="center" width="2%"></td>
				<td align="left" width="49%"><input type="button"
					class="btn_login" value="Cancel" id="cancelId"
					onclick="onclickPayPopupCancelAction();"></td>
			</tr>
		</table>
	</div>
</body>
</html>