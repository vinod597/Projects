package com.pbsi.fuelfilling.grid;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

public class GridBuilder {
	/**
	 * This method returns a <code>String</code> representation of the Grid, by
	 * taking <code>Object</code> as an argument to generate a grid with
	 * corresponding <code>List<GridColumnsJson></code> as an argument to show
	 * the list of columns in the Grid and <code>availableRecords</code> as an
	 * argument to display the available records in the grid.
	 * 
	 * @param object
	 *            it is a source for the grid
	 * @param gridColumnsJsonList
	 *            represent the list of columns has to shown in the Grid
	 * @param noOfRecords
	 *            represent the available records in the Grid
	 * @return <code>String</code> representation of the Grid.
	 */
	public static String developGridAction(Object object, List<GridColumnsJson> gridColumnsJsonList, Integer availableRecords, String currentPage, Map<String, Integer> sortColumn) {
		String strGrid = "";
		try {
			if (gridColumnsJsonList != null && gridColumnsJsonList.size() > 0) {
				StringBuilder stringBuilder = new StringBuilder();
				// checking for navigation bar
				if (gridColumnsJsonList.get(0).getIsNavigationBarRequired()) {
					stringBuilder.append("<table align=\"center\" cellpadding=\"2\" cellspacing=\"1\" width=\"" + gridColumnsJsonList.get(0).getGridWidth() + "\"><tr style=\"background-color: #325c69;\" height=\"10px;\"><td align=\"center\" colspan=\""
							+ (gridColumnsJsonList.size()) + "\">");
					stringBuilder.append("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">");
					stringBuilder.append("<tr>");
					stringBuilder.append("<td width=\"45%\" align=\"left\">");
					// checking for search Bar
					if (gridColumnsJsonList.get(0).getIsSearchBarRequired()) {
						stringBuilder.append("<table><tr><td><select id=\"" + gridColumnsJsonList.get(0).getGridName() + "SearchFieldId\" onchange=\"onChangeSearchField" + gridColumnsJsonList.get(0).getGridName() + "ComboAction(this);\">");
						for (GridColumnsJson json : gridColumnsJsonList) {
							if (json.getIsSearchRequired()) {
								stringBuilder.append("<option value=\"" + json.getTypeOfField() + "\">" + json.getColumnName() + "</option>");
							}
						}
						stringBuilder.append("</select></td>");
						stringBuilder.append("<td id=\"searchOperator" + gridColumnsJsonList.get(0).getGridName() + "Id\"></td></tr></table>");
					}
					stringBuilder.append("</td>");
					stringBuilder.append("<td width=\"35%\" align=\"left\"><table><tr>");
					stringBuilder.append("<td><img src=\"" + gridColumnsJsonList.get(0).getContextPath() + "/images/grid/first.gif\" title=\"First\" alt=\"first\" id=\"first" + gridColumnsJsonList.get(0).getGridName()
							+ "Id\" style=\"cursor: pointer;\" onclick=\"onClick" + gridColumnsJsonList.get(0).getGridName() + "NavigationAction(this);\"/></td>");
					stringBuilder.append("<td><img src=\"" + gridColumnsJsonList.get(0).getContextPath() + "/images/grid/prev.gif\" title=\"Previous\" alt=\"previous\" id=\"previous" + gridColumnsJsonList.get(0).getGridName()
							+ "Id\" style=\"cursor: pointer;\" onclick=\"onClick" + gridColumnsJsonList.get(0).getGridName() + "NavigationAction(this);\"/></td>");
					stringBuilder.append("<td><img src=\"" + gridColumnsJsonList.get(0).getContextPath() + "/images/grid/next.gif\" title=\"Next\" alt=\"next\" id=\"next" + gridColumnsJsonList.get(0).getGridName()
							+ "Id\" style=\"cursor: pointer;\" onclick=\"onClick" + gridColumnsJsonList.get(0).getGridName() + "NavigationAction(this);\"/></td>");
					stringBuilder.append("<td><img src=\"" + gridColumnsJsonList.get(0).getContextPath() + "/images/grid/last.gif\" title=\"Last\" alt=\"last\" id=\"last" + gridColumnsJsonList.get(0).getGridName()
							+ "Id\" style=\"cursor: pointer;\" onclick=\"onClick" + gridColumnsJsonList.get(0).getGridName() + "NavigationAction(this);\"/></td>");
					stringBuilder.append("</tr></table>");
					stringBuilder.append("</td>");
					stringBuilder.append("<td width=\"20%\" align=\"right\"><label class=\"currentRecordsWhite14px\">" + currentPage + "</label></td>");
					stringBuilder.append("</tr>");
					stringBuilder.append("</table>");
					stringBuilder.append("</td></tr>");
					stringBuilder.append("</table>");
				}
				stringBuilder.append("<table align=\"center\" width=\"" + gridColumnsJsonList.get(0).getGridWidth() + "\" cellpadding=\"2\" cellspacing=\"1\">");
				stringBuilder.append("<tr border=\"1\" style=\"background-color: #325c69;\" height=\"20px;\"><td colspan=\"" + (gridColumnsJsonList.size()) + "\"><label class=\"avlRecordsWhite12px\">Available Records:" + availableRecords
						+ "</label></td></tr>");
				stringBuilder.append("<tr border=\"1\" style=\"background-color: #325c69;\">");
				for (GridColumnsJson json : gridColumnsJsonList) {
					if (json.getIsSortingRequired()) {
						stringBuilder.append("<td valign=\"top\" width=\"" + json.getColumnWidth() + "\" align=\"center\"><label class='grdHeaderValue14px' onclick=\"onClick" + json.getGridName() + "SortingAction('" + json.getFieldName()
								+ "');\" style=\"cursor:pointer;\" title=\"" + json.getColumnName() + "\">" + json.getColumnName() + "</label>");
						if (sortColumn != null && sortColumn.size() > 0) {
							for (String key : sortColumn.keySet()) {
								if (key.equals(json.getFieldName())) {
									if (sortColumn.get(key) % 2 == 0) {
										stringBuilder.append("<img src=\"" + gridColumnsJsonList.get(0).getContextPath() + "/images/grid/imgasc.gif\" title=\"First\" alt=\"first\"/>");
									} else {
										stringBuilder.append("<img src=\"" + gridColumnsJsonList.get(0).getContextPath() + "/images/grid/imgdesc.gif\" title=\"First\" alt=\"first\"/>");
									}
								}
							}
						}
						stringBuilder.append("</td>");
					} else {
						stringBuilder.append("<td width=\"" + json.getColumnWidth() + "\" align=\"center\">" + "<label class='grdHeaderValue14px' title=\"" + json.getColumnName() + "\">" + json.getColumnName() + "</label></td>");
					}
				}
				stringBuilder.append("</tr>");
				// Check whether the argument <code>Object</code> is an instance
				// of
				// the list or not.
				if (object != null && object instanceof List) {
					List<?> list = (List<?>) object;
					if (list.size() > 0) {
						int mainGridRecordCount = 0;
						for (Object obj : list) {
							if (mainGridRecordCount++ % 2 == 0) {
								stringBuilder.append("<tr  style=\"background-color: #dceced;\">");
							} else {
								stringBuilder.append("<tr  style=\"background-color: #488495;\">");
							}
							GridColumnsJson subGridjson = null;
							for (GridColumnsJson json : gridColumnsJsonList) {
								setTheValuesToTheGridColumnAction(stringBuilder, json, obj);
								// Check whether the given <code>Object</code>
								// has a
								// sub-grid or not.
								if (json.getIsSubGridRequired()) {
									if ((boolean) (PropertyUtils.getProperty(obj, json.getSubGridExpandCollapseVar()))) {
										subGridjson = json;
									}
								}

							}
							// This code is for subgrid.
							if (subGridjson != null) {
								int subGridRecordCount = 0;
								List<?> subGridList = (List<?>) PropertyUtils.getProperty(obj, subGridjson.getSubgridListVar());
								stringBuilder.append("</tr>");
								stringBuilder.append("<tr>");
								stringBuilder.append("<td width=\"36px\"></td>");
								stringBuilder.append("<td colspan=\"" + (gridColumnsJsonList.size() - 1) + "\"><table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\">");
								stringBuilder.append("<tr style=\"background-color: #105681;\">");
								for (GridColumnsJson subJson : subGridjson.getSubGridColumnJsonList()) {
									stringBuilder.append("<td width=\"" + subJson.getColumnWidth() + "\" align=\"center\">" + "<label class='grdHeaderValue14px' title=\"" + subJson.getColumnName() + "\">" + subJson.getColumnName() + "</label></td>");
								}
								stringBuilder.append("</tr>");
								stringBuilder.append("</table></td>");
								stringBuilder.append("</tr>");

								for (Object subObj : subGridList) {
									stringBuilder.append("<tr>");
									stringBuilder.append("<td width=\"36px\"></td>");
									stringBuilder.append("<td colspan=\"" + (gridColumnsJsonList.size() - 1) + "\"><table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\">");

									if (subGridRecordCount++ % 2 == 0) {
										stringBuilder.append("<tr style=\"background-color: #d3e6ef;\">");
									} else {
										stringBuilder.append("<tr style=\"background-color:	#64a5c8;\">");
									}
									List<GridColumnsJson> subColumnsList = subGridjson.getSubGridColumnJsonList();
									for (GridColumnsJson subJson : subColumnsList) {
										setTheValuesToTheGridColumnAction(stringBuilder, subJson, subObj);
									}
									stringBuilder.append("</tr>");
									stringBuilder.append("</table></td>");
									stringBuilder.append("</tr>");
								}
							} else {
								stringBuilder.append("</tr>");
							}
						}
					} else {
						stringBuilder.append("<tr border=\"1\" style=\"background-color: white;\"><td colspan='" + gridColumnsJsonList.size() + "'><label class='grdValue14px'>No Records Found.</label></td></tr>");
					}
				} else {
					stringBuilder.append("<tr border=\"1\" style=\"background-color: white;\"><td colspan='" + gridColumnsJsonList.size() + "'><label class='grdValue14px'>No Records Found.</label></td></tr>");
				}
				javaScriptActions(stringBuilder, gridColumnsJsonList);
				if (gridColumnsJsonList.get(0).getIsSearchBarRequired()) {
					stringBuilder.append("<script>onChangeSearchField" + gridColumnsJsonList.get(0).getGridName() + "ComboAction();</script>");
				}
				stringBuilder.append("</table>");
				strGrid = stringBuilder.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strGrid;
	}

	/**
	 * Returns the StringBuilder representation of the each row of an object
	 * with taking the existing <code>StringBuilder</code> value as an argument,
	 * with required columnNames and fieldNames of the grid, with the
	 * <code>Object</code> as an argument to get the current row of the grid
	 * 
	 * @param stringBuilder
	 * @param json
	 *            represent the list of column names with corresponding field
	 *            names
	 * @param obj
	 *            an object to show the values in the grid
	 * @return StringBuilder representation of the each grid row
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static StringBuilder setTheValuesToTheGridColumnAction(StringBuilder stringBuilder, GridColumnsJson json, Object obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if ((json.getTypeOfField()).equals(TypeOfField.IMAGE)) {
			stringBuilder.append("<td  align=\"center\" width=\"" + json.getColumnWidth() + "\">" + "<img style=\"cursor:pointer;\" src=\"" + json.getContextPath() + "/" + PropertyUtils.getProperty(obj, json.getFieldName()) + "\" onclick=\"onClick"
					+ json.getGridName() + json.getScriptOnclickMethod() + "Action(" + PropertyUtils.getProperty(obj, json.getGridIdVar()) + ");\"  alt=\"\"/></td>");
		} else {
			if ((json.getTypeOfField()).equals(TypeOfField.LABEL))
				stringBuilder.append("<td width=\"" + json.getColumnWidth() + "\" align=\"left\">" + "<label title=\"" + PropertyUtils.getProperty(obj, json.getFieldName()) + "\" class='grdValue14px'>" + PropertyUtils.getProperty(obj, json.getFieldName())
						+ "</label></td>");
			else if ((json.getTypeOfField()).equals(TypeOfField.DATE))
				stringBuilder.append("<td width=\"" + json.getColumnWidth() + "\" align=\"center\"><label title=\"" + PropertyUtils.getProperty(obj, json.getFieldName()) + "\" class='grdValue14px'>" + PropertyUtils.getProperty(obj, json.getFieldName())
						+ "</label></td>");
			else
				stringBuilder.append("<td width=\"" + json.getColumnWidth() + "\" align=\"right\"><label title=\"" + PropertyUtils.getProperty(obj, json.getFieldName()) + "\" class='grdValue14px'>" + PropertyUtils.getProperty(obj, json.getFieldName())
						+ "</label></td>");
		}
		return stringBuilder;
	}

	/**
	 * This method is to develop the javascript functions through java code.
	 * 
	 * @param stringBuilder
	 * @param gridColumnsJsonList
	 * @return
	 */
	public static StringBuilder javaScriptActions(StringBuilder stringBuilder, List<GridColumnsJson> gridColumnsJsonList) {

		stringBuilder.append("	<script type=\"text/javascript\">	");
		// This function is for sorting action
		stringBuilder.append("	function onClick" + gridColumnsJsonList.get(0).getGridName() + "SortingAction(fieldValue){	");
		stringBuilder.append("		$.ajax({	");
		stringBuilder.append("	url:\"" + gridColumnsJsonList.get(0).getContextPath() + "/" + gridColumnsJsonList.get(0).getControllerName() + "/onClick" + gridColumnsJsonList.get(0).getGridName() + "SortingAction/\"+fieldValue,	");
		stringBuilder.append("	type:\"GET\",	");
		stringBuilder.append("	data:null,	");
		stringBuilder.append("	dataType:\"text\",	");
		stringBuilder.append("	success:function(data){	");
		stringBuilder.append("	document.getElementById(\"" + gridColumnsJsonList.get(0).getGridDivId() + "\").innerHTML=data; ");
		stringBuilder.append("	}	");
		stringBuilder.append("	});	");
		stringBuilder.append("	}	");

		// This function is for subGrid action, this function is like
		// onclick+"ProjectInfoGrid"+SubgridAction
		stringBuilder.append("	function onClick" + gridColumnsJsonList.get(0).getGridName() + "SubGridAction(id){	");
		stringBuilder.append("	var comboBoxValue=$('#select" + gridColumnsJsonList.get(0).getGridName() + "Id').val();	");
		stringBuilder.append("	$.ajax({	");
		stringBuilder.append("	url:\"" + gridColumnsJsonList.get(0).getContextPath() + "/" + gridColumnsJsonList.get(0).getControllerName() + "/onClick" + gridColumnsJsonList.get(0).getGridName() + "SubgridAction/\"+id,	");
		stringBuilder.append("	type:\"GET\",	");
		stringBuilder.append("	data:null,	");
		stringBuilder.append("	dataType:\"text\",	");
		stringBuilder.append("	success:function(data){	");
		stringBuilder.append("	document.getElementById(\"" + gridColumnsJsonList.get(0).getGridDivId() + "\").innerHTML=data; ");
		stringBuilder.append("	 } }); }");

		// This function is for perform Edit Action
		stringBuilder.append("	function onClick" + gridColumnsJsonList.get(0).getGridName() + "EditAction(id){	");
		stringBuilder.append("	window.location = \"" + gridColumnsJsonList.get(0).getContextPath() + "/" + gridColumnsJsonList.get(0).getControllerName() + "/onClick" + gridColumnsJsonList.get(0).getGridName() + "EditAction/\"+id;	");
		stringBuilder.append("	}	");

		// If navigation Bar is required
		if (gridColumnsJsonList.get(0).getIsNavigationBarRequired()) {
			// This function is for navigation purpose, this function is like
			// onclick+"ProjectInfoGrid"+NavigationAction
			stringBuilder.append("	function onClick" + gridColumnsJsonList.get(0).getGridName() + "NavigationAction(obj){	");
			stringBuilder.append("	var comboBoxValue=$('#select" + gridColumnsJsonList.get(0).getGridName() + "Id').val();	");
			stringBuilder.append("	$.ajax({	");
			stringBuilder.append("	url:\"" + gridColumnsJsonList.get(0).getContextPath() + "/" + gridColumnsJsonList.get(0).getControllerName() + "/onClick" + gridColumnsJsonList.get(0).getGridName() + "NavigationAction/\"+obj.id,	");
			stringBuilder.append("	type:\"GET\",	");
			stringBuilder.append("	data:null,	");
			stringBuilder.append("	dataType:\"text\",	");
			stringBuilder.append("	success:function(data){	");
			stringBuilder.append("	document.getElementById(\"" + gridColumnsJsonList.get(0).getGridDivId() + "\").innerHTML=data; ");
			stringBuilder.append("	 ");
			stringBuilder.append("	 } }); }");

		}

		// if Search Bar is required
		if (gridColumnsJsonList.get(0).getIsSearchBarRequired()) {
			// This function is for search field action, this function is like
			// onChangeSearchField+"ProjectInfoGrid"+ComboAction
			stringBuilder.append("	function onChangeSearchField" + gridColumnsJsonList.get(0).getGridName() + "ComboAction(){	");
			stringBuilder.append("   var searchValue = $('#" + gridColumnsJsonList.get(0).getGridName() + "SearchFieldId').val(); ");
			stringBuilder.append("   document.getElementById('searchOperator" + gridColumnsJsonList.get(0).getGridName() + "Id').innerHTML=\"\"; ");
			stringBuilder.append("  var parentDiv = document.getElementById('searchOperator" + gridColumnsJsonList.get(0).getGridName() + "Id'); ");
			stringBuilder.append("  var selectElement  =  document.createElement('select'); ");
			stringBuilder.append("  selectElement.setAttribute(\"id\", \"" + gridColumnsJsonList.get(0).getGridName() + "operatorId\"); ");
			Map<String, Map<String, String>> operatorsMap = getOperatorByFieldValue();
			for (String key : operatorsMap.keySet()) {
				for (String operator : operatorsMap.get(key).keySet()) {
					stringBuilder.append("  if('" + key + "'.indexOf(searchValue) !=-1){ ");
					stringBuilder.append(" var option = new Option ('" + operatorsMap.get(key).get(operator) + "','" + operator + "'); ");
					stringBuilder.append("   selectElement.options[selectElement.options.length] = option;");
					stringBuilder.append("}");
				}
			}
			stringBuilder.append("   parentDiv.appendChild (selectElement); ");
			stringBuilder.append("   var inputText = document.createElement(\"input\"); ");
			stringBuilder.append("   var label1 = document.createElement(\"label\"); ");
			stringBuilder.append("   label1.innerHTML = \"&nbsp;\";  ");
			stringBuilder.append("   inputText.setAttribute(\"type\", \"text\"); ");
			stringBuilder.append("   inputText.setAttribute(\"id\", \"" + gridColumnsJsonList.get(0).getGridName() + "inputId\"); ");
			stringBuilder.append("   inputText.setAttribute(\"style\", \"width:120px;\"); ");
			stringBuilder.append("   var button = document.createElement(\"input\"); ");
			stringBuilder.append("   button.type = \"button\"; ");
			stringBuilder.append("   button.value = \"Go\"; ");
			stringBuilder.append("   button.setAttribute(\"onclick\", \"onClick" + gridColumnsJsonList.get(0).getGridName() + "GoAction();\"); ");
			stringBuilder.append("   var label2 = document.createElement(\"label\"); ");
			stringBuilder.append("   label2.innerHTML = \"&nbsp;\";  ");

			stringBuilder.append("   parentDiv.appendChild (label1); ");
			stringBuilder.append("   parentDiv.appendChild (inputText); ");
			stringBuilder.append("   parentDiv.appendChild (label2); ");
			stringBuilder.append("   parentDiv.appendChild (button); ");
			stringBuilder.append("   if(searchValue=='date') ");
			stringBuilder.append("   { ");
			stringBuilder.append("   inputText.setAttribute(\"readonly\", \"readonly\"); ");
			stringBuilder.append("   $('#" + gridColumnsJsonList.get(0).getGridName() + "inputId').datepicker({ ");
			stringBuilder.append("   showButtonPanel : true, ");
			stringBuilder.append("  dateFormat : \"dd/MM/yy\", ");
			stringBuilder.append("  beforeShow : function() { ");
			stringBuilder.append("  $(\".ui-datepicker\").css('font-size', 12) ");
			stringBuilder.append("  } ");
			stringBuilder.append("  }); ");
			stringBuilder.append("   } ");
			stringBuilder.append("}");

			// This function is called when we click on Go button for the
			// search,
			// this function is like onClick+"ProjectInfoGrid"+GoAction
			stringBuilder.append("	function onClick" + gridColumnsJsonList.get(0).getGridName() + "GoAction(){");
			stringBuilder.append("	var comboBoxValue=$('#select" + gridColumnsJsonList.get(0).getGridName() + "Id').val();	");
			stringBuilder.append("	var operatorValue = $('#" + gridColumnsJsonList.get(0).getGridName() + "operatorId').val();	");
			stringBuilder.append("	var inputValue = $('#" + gridColumnsJsonList.get(0).getGridName() + "inputId').val();	");
			stringBuilder.append("   var searchValue = $('#" + gridColumnsJsonList.get(0).getGridName() + "SearchFieldId').val(); ");
			stringBuilder.append("  var el = document.getElementById('" + gridColumnsJsonList.get(0).getGridName() + "SearchFieldId'); ");
			stringBuilder.append("  var searchField=el.options[el.selectedIndex].innerHTML; ");
			stringBuilder.append("  var fieldName; ");
			Map<String, String> fieldWithColumnNameMap = getFieldName(gridColumnsJsonList);
			for (String key : fieldWithColumnNameMap.keySet()) {
				stringBuilder.append("  if(searchField=='" + key + "'){ ");
				stringBuilder.append("  fieldName='" + fieldWithColumnNameMap.get(key) + "'; ");
				stringBuilder.append("  } ");
			}
			stringBuilder.append("	$.ajax({	");
			stringBuilder.append("	url:\"" + gridColumnsJsonList.get(0).getContextPath() + "/" + gridColumnsJsonList.get(0).getControllerName() + "/onClick" + gridColumnsJsonList.get(0).getGridName() + "SearchAction\",	");
			stringBuilder.append("	type:\"GET\",	");
			stringBuilder.append("	data:{searchField:fieldName,operator:operatorValue,input:inputValue,searchFieldValue:searchValue},	");
			stringBuilder.append("	dataType:\"text\",	");
			stringBuilder.append("	success:function(data){	");
			stringBuilder.append("   var operatorValue = $('#" + gridColumnsJsonList.get(0).getGridName() + "operatorId').val(); ");
			stringBuilder.append("   var inputValue = $('#" + gridColumnsJsonList.get(0).getGridName() + "inputId').val(); ");
			stringBuilder.append("	document.getElementById(\"" + gridColumnsJsonList.get(0).getGridDivId() + "\").innerHTML=data;	");
			stringBuilder.append("	onChangeSearchField" + gridColumnsJsonList.get(0).getGridName() + "ComboAction(); ");

			stringBuilder.append(" var selectElement = document.getElementById('" + gridColumnsJsonList.get(0).getGridName() + "operatorId');  ");

			stringBuilder.append("   $('#" + gridColumnsJsonList.get(0).getGridName() + "operatorId').empty(); ");

			for (String key : operatorsMap.keySet()) {
				for (String operator : operatorsMap.get(key).keySet()) {
					stringBuilder.append("  if('" + key + "'.indexOf(searchValue) !=-1){ ");
					stringBuilder.append(" var option = new Option ('" + operatorsMap.get(key).get(operator) + "','" + operator + "'); ");
					stringBuilder.append("   selectElement.options[selectElement.options.length] = option;");
					stringBuilder.append("}");
				}
			}
			stringBuilder.append(" $('#" + gridColumnsJsonList.get(0).getGridName() + "SearchFieldId').val(searchValue);  ");
			stringBuilder.append(" $('#" + gridColumnsJsonList.get(0).getGridName() + "operatorId').val(operatorValue);  ");
			stringBuilder.append(" $('#" + gridColumnsJsonList.get(0).getGridName() + "inputId').val(inputValue);  ");
			stringBuilder.append("	$('#select" + gridColumnsJsonList.get(0).getGridName() + "Id').val(comboBoxValue);");
			stringBuilder.append("	 } }); ");
			stringBuilder.append("  } ");
		}
		stringBuilder.append("</script>");
		return stringBuilder;
	}

	/**
	 * This method is to get the operators for the corresponding field types
	 * 
	 * @return Map representation of the field with operators
	 */
	private static Map<String, Map<String, String>> getOperatorByFieldValue() {
		Map<String, Map<String, String>> opearatorMap = new HashMap<String, Map<String, String>>();
		Map<String, String> stringOperators = new LinkedHashMap<String, String>();
		stringOperators.put("begins", "Begins");
		stringOperators.put("contains", "Contains");
		stringOperators.put("equals", "Equals");
		Map<String, String> numDateOperators = new LinkedHashMap<String, String>();
		numDateOperators.put("eq", "=");
		numDateOperators.put("gt", ">");
		numDateOperators.put("gte", ">=");
		numDateOperators.put("lt", "<");
		numDateOperators.put("lte", "<=");
		opearatorMap.put("label", stringOperators);
		opearatorMap.put("datenumber", numDateOperators);
		return opearatorMap;
	}

	/**
	 * This method is to get the selected field name from the search Field
	 * comboBox.
	 * 
	 * @param gridColumnsJsonList
	 * @return
	 */
	private static Map<String, String> getFieldName(List<GridColumnsJson> gridColumnsJsonList) {
		Map<String, String> fieldWithColumnNameMap = new LinkedHashMap<String, String>();
		for (GridColumnsJson json : gridColumnsJsonList) {
			fieldWithColumnNameMap.put(json.getColumnName(), json.getFieldName());
		}
		return fieldWithColumnNameMap;
	}
}
