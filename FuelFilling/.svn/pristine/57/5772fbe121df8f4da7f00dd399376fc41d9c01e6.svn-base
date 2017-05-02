<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Fuel Filling-2</title>
<jsp:include page="head.jsp" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/fuelFilling2.js"></script>
</head>
<body>

	<table width="60%" align="center" border="0" cellspacing="0"
		cellpadding="0">
		<tr>
			<td align="center" width="100%">
				<table>
					<tr>
						<td><img alt="Logo"
							src="${pageContext.request.contextPath}/images/logo.png"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="100%" valign="top">
				<table border="0" width="100%">
					<tr height="780px">
						<td width="15%" bgcolor="#006D7A" valign="top"><jsp:include
								page="leftMenu.jsp"></jsp:include></td>
						<form:form id="fuelFilling2FormId"
							modelAttribute="fuelFilling2Bean" method="POST"
							action="${pageContext.request.contextPath}/FuelFilling2Controller/fuelFillingAction">
							<td width="85%" valign="top" bgcolor="#80DFE3">
								<table width="100%">
									<tr>
										<td align="center" colspan="3"><label
											class="lblpageheading">Session 02 - Fuel Filling With
												Credit Limit</label></td>
									</tr>
									<tr height="10px"></tr>
									<tr>
										<td align="right"><label class="mandatoryredtext">**No
												of fillings should not exceed 10</label></td>
									</tr>
									<tr height="10px"></tr>
									<tr>
										<td align="center" colspan="2"><label
											class="mandatoryredtext" id="errorMsgId">${fuelFilling2Bean.errorMessage}</label>
										</td>
									</tr>
									<tr height="10px"></tr>
									<tr>
										<td width="100%" colspan="3">
											<table align="center" border="0" width="100%">
												<tr>
													<td align="right" width="50%"><label class="labelfont">Maximum
															Fillings :</label></td>
													<td align="left" width="10%"><form:input id="maximumFillingsId" onkeypress="return isNumberKey(event)" maxlength="2"
															disabled="${fuelFilling2Bean.maximumFillingsDisable}"
															onchange="onchangeMaximumFillings(this);"
															onfocus="this.value=''" path="maximumFillings"
															class="controlfont" /></td>
												</tr>
												<tr height="10px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Credit
															Limit :</label></td>
													<td align="left"><form:input id="creditLimitId" path="creditLimit" onkeypress="return isNumberKey(event)" maxlength="8"
															disabled="${fuelFilling2Bean.creditLimitDisable}"
															onchange="onchangecreditLimit(this);"
															onfocus="this.value=''" class="controlfont" /></td>
												</tr>
												<tr height="10px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Credit
															Availed : </label></td>
													<td align="left"><label class="labelvalue">${fuelFilling2Bean.creditAvailed}</label>
													</td>
													<td align="right" width="15%"><label class="labelfont">Credit
															Available : </label></td>
													<td align="left"><label class="labelvalue" id="creditAvailableId">${fuelFilling2Bean.creditAvailable}</label>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr height="10px"></tr>
									<tr>
										<td align="right" width="55%"><label
											class="lblunderlinesection">Meter Reading</label></td>
										<td align="right" width="40%"><form:button type="submit"
												name="addNext"
												disabled="${fuelFilling2Bean.addNextBtnDisable}"
												class="${fuelFilling2Bean.addNextBtnStyleClass}">AddNext</form:button>
										</td>
										<td></td>
									</tr>
									<tr height="25px"></tr>
									<tr>
										<td width="100%" colspan="3">
											<table align="center" width="100%">
												<tr>
													<td align="right" width="50%"><label class="labelfont">Previous
															Reading :</label></td>
													<td align="left"><label class="labelvalue" id="previousReadingId">${fuelFilling2Bean.previousReading}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Present
															Reading :</label></td>
													<td align="left"><form:input path="presentReading" id="presentReadingId"
															onkeypress="return validateFloat(event,this)" maxlength="6"
															onfocus="this.value=''"
															disabled="${fuelFilling2Bean.presentReadingDisable}"
															class="controlfont"
															onchange="onchangeDistanceTravalled('${pageContext.request.contextPath}/FuelFilling2Controller/onchangeDistanceTravalled');" /></td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Distance
															Travelled :</label></td>
													<td align="left"><label id="distanceTravelledId"
														class="labelvalue">${fuelFilling2Bean.distanceTraveled}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Fuel
															Cost :</label></td>
													<td align="left"><form:input path="fuelCost" id="fuelCostId"
															onfocus="this.value=''"
															disabled="${fuelFilling2Bean.fuelCostDisable}"
															onkeypress="return validateFloat(event,this)" maxlength="6"
															class="controlfont" /></td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Fuel
															Filled :</label></td>
													<td align="left"><form:input path="fuelFilled" id="fuelFilledId"
															onfocus="this.value=''"
															disabled="${fuelFilling2Bean.fuelFilledDisable}"
															onkeypress="return validateFloat(event,this)" maxlength="6"
															class="controlfont" /></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr height="25px"></tr>
									<tr>
										<td colspan="3">
											<table align="center">
												<tr>
													<td><form:button type="submit" name="update" onclick="return onchangeValidation();"
															disabled="${fuelFilling2Bean.updateBtnDisable}"
															class="${fuelFilling2Bean.updateBtnStyleClass}">Update</form:button></td>
													<td><form:button type="submit" name="refresh"
															disabled="${fuelFilling2Bean.refreshBtnDisable}"
															class="${fuelFilling2Bean.refreshBtnStyleClass}">Refresh</form:button>
													</td>
													<td><form:button type="submit" name="rollBack"
															disabled="${fuelFilling2Bean.rollBackBtnDisable}"
															class="${fuelFilling2Bean.rollBackBtnStyleClass}">RollBack</form:button>
													</td>
													<td><form:button type="submit" name="clear"
															disabled="${fuelFilling2Bean.clearBtnDisable}"
															class="${fuelFilling2Bean.clearBtnStyleClass}">Clear</form:button>
													</td>
													<td><form:button type="submit" name="cancel"
															class="btn_login">Cancel</form:button></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr height="25px"></tr>
									<tr>
										<td width="100%" colspan="3">
											<table align="center" border="0" width="100%">
												<tr>
													<td align="right" width="50%"><label class="labelfont">Total
															Fillings :</label></td>
													<td align="left"><label id="totalFillingsId" class="labelvalue">${fuelFilling2Bean.totalFillings}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Total
															Fuel Filled :</label></td>
													<td align="left"><label class="labelvalue">${fuelFilling2Bean.totalFuelFilled}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Total
															Distance Travelled :</label></td>
													<td align="left"><label class="labelvalue">${fuelFilling2Bean.totalDistanceTravelled}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Mileage
															:</label></td>
													<td align="left"><label class="labelvalue">${fuelFilling2Bean.mileage}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Average
															Mileage :</label></td>
													<td align="left"><label class="labelvalue">${fuelFilling2Bean.avgMileage}</label>
													</td>
												</tr>
											</table>
										</td>
									</tr>

								</table>

							</td>
						</form:form>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>