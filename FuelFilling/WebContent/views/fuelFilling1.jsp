<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Fuel Filling-1</title>
<jsp:include page="head.jsp" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/fuelFilling1.js"></script>
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
						<form:form id="fuelFilling1FormId"
							modelAttribute="fuelFilling1Bean" method="POST"
							action="${pageContext.request.contextPath}/FuelFilling1Controller/fuelFillingAction">
							<td width="85%" valign="top" bgcolor="#80DFE3">
								<table width="100%">
									<tr>
										<td align="center" colspan="3"><label
											class="lblpageheading">Session 01 - Fuel Filling</label></td>
									</tr>
									<tr height="10px"></tr>
									<tr>
										<td align="right"><label class="mandatoryredtext">**No
												of fillings should not exceed 10</label></td>
									</tr>
									<tr height="10px"></tr>
									<tr>
										<td align="center" colspan="2"><label
											class="mandatoryredtext" id="errorMsgId">${fuelFilling1Bean.errorMessage}</label>
										</td>
									</tr>

									<tr height="10px"></tr>
									<tr>
										<td align="right" width="55%"><label
											class="lblunderlinesection">Meter Reading</label></td>
										<td align="right" width="40%"><form:button type="submit"
												name="addNext"
												disabled="${fuelFilling1Bean.addNextBtnDisable}"
												class="${fuelFilling1Bean.addNextBtnStyleClass}">AddNext</form:button>
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
													<td align="left"><label class="labelvalue">${fuelFilling1Bean.previousReading}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Present
															Reading :</label></td>
													<td align="left"><form:input path="presentReading" id="presentReadingId"
															onkeypress="return validateFloat(event,this)"
															maxlength="6" onfocus="this.value=''"
															disabled="${fuelFilling1Bean.presentReadingDisable}"
															class="controlfont"
															onchange="onchangeDistanceTravalled('${pageContext.request.contextPath}/FuelFilling1Controller/onchangeDistanceTravalled');" /></td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Distance
															Travelled :</label></td>
													<td align="left"><label id="distanceTravelledId"
														class="labelvalue">${fuelFilling1Bean.distanceTraveled}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Fuel
															Filled :</label></td>
													<td align="left"><form:input path="fuelFilled" id="fuelFilledId"
															onfocus="this.value=''"
															disabled="${fuelFilling1Bean.fuelFilledDisable}"
															onkeypress="return validateFloat(event,this)"
															maxlength="4" class="controlfont" /></td>
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
															disabled="${fuelFilling1Bean.updateBtnDisable}"
															class="${fuelFilling1Bean.updateBtnStyleClass}">Update</form:button></td>
													<td><form:button type="submit" name="refresh"
															disabled="${fuelFilling1Bean.refreshBtnDisable}"
															class="${fuelFilling1Bean.refreshBtnStyleClass}">Refresh</form:button>
													</td>
													<td><form:button type="submit" name="rollBack"
															disabled="${fuelFilling1Bean.rollBackBtnDisable}"
															class="${fuelFilling1Bean.rollBackBtnStyleClass}">RollBack</form:button>
													</td>
													<td><form:button type="submit" name="clear"
															disabled="${fuelFilling1Bean.clearBtnDisable}"
															class="${fuelFilling1Bean.clearBtnStyleClass}">Clear</form:button>
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
													<td align="left"><label class="labelvalue">${fuelFilling1Bean.totalFillings}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Total
															Fuel Filled :</label></td>
													<td align="left"><label class="labelvalue">${fuelFilling1Bean.totalFuelFilled}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Total
															Distance Travelled :</label></td>
													<td align="left"><label class="labelvalue">${fuelFilling1Bean.totalDistanceTravelled}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Mileage
															:</label></td>
													<td align="left"><label class="labelvalue">${fuelFilling1Bean.mileage}</label>
													</td>
												</tr>
												<tr height="25px"></tr>
												<tr>
													<td align="right"><label class="labelfont">Average
															Mileage :</label></td>
													<td align="left"><label class="labelvalue">${fuelFilling1Bean.avgMileage}</label>
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