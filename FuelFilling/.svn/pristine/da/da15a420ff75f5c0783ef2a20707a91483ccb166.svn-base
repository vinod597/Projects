<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Fuel Filling-1</title>
<jsp:include page="../head.jsp" />
<script src="<%=request.getContextPath()%>/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/style/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/popup.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/theme.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/colorbox.css" />

</head>

<script type="text/javascript">
		$(document).ready(function(){
		
			
			// addOrEdit dialog initialization
				addOrEditCountryPopupDialog = $("#addOrEditCountryPopupDivId").dialog(
						{ 
							autoOpen: false,
							modal:true,
							width: 700,
							title:'Edit Country' 
						});
			//jqGrid
			$countryListJqGrid = $("#listCountry");
			$countryListJqGrid.jqGrid({
			   	url:'<%=request.getContextPath()%>/CountryController/getCountriesList',
				datatype: "json",			
			   	colNames:['Edit','Country Code','Country Name','Active', 'Last Updated By' , 'Last Updated On'],
			   	colModel:[				    
				    {name:'countryId',search:false, index:'countryId', width:30,sortable: false, formatter: editLink},				    
			   		{name:'countryCode',index:'countryCode', width:100},
			   		{name:'countryName',index:'countryName',width:250},	
			   		{name:'isActive',index:'isActive',width:80,formatter:'select', stype:'select', edittype:'select',editoptions: { value: "false:False;true:True" },searchoptions: {sopt: ["eq", "ne"],value : "false:False;true:True"}},
			   		{name:'lastUpdatedBy',index:'lastUpdatedBy',width:150,sortable: false,search: false},
			   		{name:'lastUpdatedOn',index:'lastUpdatedOn', width:200},],
			   		rowNum:20,
			      	rowList:[10,20,30,40,50],
			  	    rownumbers: true,  
			        pager: '#pagerDiv', headertitles:true,
			        sortname: 'countryName',  
			        viewrecords: true,  
			        sortorder: "asc",
			        loadComplete: function() {
	                    $("tr.jqgrow:odd").addClass('myAltRowClass');
					},
			});
			$('#gridContainer div:not(.ui-jqgrid-titlebar)').width("100%");
			$('.ui-jqgrid-bdiv').css('height', window.innerHeight * .65);					
			$('#load_listCountry').width("130");	
			$("#listCountry").jqGrid('navGrid','#pagerDiv',{edit:false,add:false,del:false},{},{},{},{closeAfterSearch:true, recreateFilter: true});
			$(".inline").colorbox({inline:true, width:"20%"});
		});
		
		function jqGridEditButtonOnClick(dialogUrl){
       	         $.ajax({
       	                url:dialogUrl,
       	                success: function(data) {
       	                    $("#addOrEditCountryPopupDivId").html(data);
       	                    addOrEditCountryPopupDialog.dialog("open");
 			                return false;
       	                },
       	                error: function(jqXHR){
       	                    alert("jqGridEditButtonOnClick error:"+jqXHR);
       	                }
				});
       	      $("span.ui-dialog-title").html('Edit Country');
       	         return false;
			}
			
			function addCountryButtonOnClick(dialogUrl){
       	         $.ajax({
       	                url:dialogUrl,
       	                success: function(data) {
       	                    $("#addOrEditCountryPopupDivId").html(data);
       	                    addOrEditCountryPopupDialog.dialog("open");
 			                return false;
       	                },
       	                error: function(jqXHR){
       	                	alert("addCountryButtonOnClick error:"+jqXHR);
       	                }
				});
       	      $("span.ui-dialog-title").html('Add Country');
       	         return false;
			}
		
		function editLink(cellValue, options, rowdata, action)
        {
            return "<a href=\"javascript:return false\" onclick=\"jqGridEditButtonOnClick('<%=request.getContextPath()%>/Admin/addCountry/"
				+ rowdata.countryId
				+ "');return false;\" title='Edit' class='ui-icon ui-icon-pencil'></a>";
	}
</script>
<body>

	<table width="60%" align="center" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center" width="100%">
				<table>
					<tr>
						<td><img alt="Logo" src="${pageContext.request.contextPath}/images/logo.png"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="100%" valign="top">
				<table border="0" width="100%">
					<tr height="780px">
						<td width="15%" bgcolor="#006D7A" valign="top"><jsp:include page="../leftMenu.jsp"></jsp:include></td>


						<td>

							<div class="headerbgground">
								<div class="lh45 FL">
									Country List <label class="label" style="width: 500px; padding-left: 20px; font: normal 13px Arial; color: green">${successMsg}</label>
								</div>
								<div class="FR">
									<div class="addbtn">
										<a style="color: #fff;" href="javascript:return false;" onclick="addCountryButtonOnClick('<%=request.getContextPath()%>/CountryController/newCountry');return false;">Add Country</a>
									</div>
								</div>
							</div>
							<div style="clear: both;"></div>
							<div style="padding: 10px;">
								<div id="gridContainer">
									<table id="listCountry"></table>
									<div id="pagerDiv"></div>
								</div>
							</div>
							<div id="addOrEditCountryPopupDivId"></div>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>