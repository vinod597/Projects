package com.pbsi.fuelfilling.grid;

import java.util.List;

public class GridColumnsJson {
	// primary key for the grid
	private String gridIdVar;
	// id for the grid
	private String gridDivId;
	// grid column Name
	private String columnName;
	// field name for the column
	private String fieldName;
	// column width
	private String columnWidth;
	// context of the project
	private String contextPath;
	// controller
	private String controllerName;
	// javascript method for the event handling
	private String scriptOnclickMethod;
	// variable for the subgrid expand or collapse info
	private String subGridExpandCollapseVar;
	// main grid width
	private String gridWidth;
	// name of the grid
	private String gridName;
	// get the field name of the subgrid
	private String subgridListVar;
	// represent the type of the column
	private TypeOfField typeOfField;
	// subgrid information
	private List<GridColumnsJson> subGridColumnJsonList;
	// if search is required to the field
	private Boolean isSearchRequired = Boolean.FALSE;
	// if navigation bar is required to the grid
	private Boolean isNavigationBarRequired = Boolean.FALSE;
	// if search bar is required to the grid
	private Boolean isSearchBarRequired = Boolean.FALSE;
	// if subgrid is required to the grid
	private Boolean isSubGridRequired = Boolean.FALSE;
	// if sorting is required to the field
	private Boolean isSortingRequired = Boolean.FALSE;

	public String getScriptOnclickMethod() {
		return scriptOnclickMethod;
	}

	public void setScriptOnclickMethod(String scriptOnclickMethod) {
		this.scriptOnclickMethod = scriptOnclickMethod;
	}

	public Boolean getIsSubGridRequired() {
		return isSubGridRequired;
	}

	public void setIsSubGridRequired(Boolean isSubGridRequired) {
		this.isSubGridRequired = isSubGridRequired;
	}

	public GridColumnsJson getInstance() {
		return new GridColumnsJson();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public List<GridColumnsJson> getSubGridColumnJsonList() {
		return subGridColumnJsonList;
	}

	public void setSubGridColumnJsonList(List<GridColumnsJson> subGridColumnJsonList) {
		this.subGridColumnJsonList = subGridColumnJsonList;
	}

	public TypeOfField getTypeOfField() {
		return typeOfField;
	}

	public void setTypeOfField(TypeOfField typeOfField) {
		this.typeOfField = typeOfField;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getSubGridExpandCollapseVar() {
		return subGridExpandCollapseVar;
	}

	public void setSubGridExpandCollapseVar(String subGridExpandCollapseVar) {
		this.subGridExpandCollapseVar = subGridExpandCollapseVar;
	}

	public String getGridIdVar() {
		return gridIdVar;
	}

	public void setGridIdVar(String gridIdVar) {
		this.gridIdVar = gridIdVar;
	}

	public String getGridWidth() {
		return gridWidth;
	}

	public void setGridWidth(String gridWidth) {
		this.gridWidth = gridWidth;
	}

	public Boolean getIsSortingRequired() {
		return isSortingRequired;
	}

	public void setIsSortingRequired(Boolean isSortingRequired) {
		this.isSortingRequired = isSortingRequired;
	}

	public String getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(String columnWidth) {
		this.columnWidth = columnWidth;
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName;
	}

	public Boolean getIsNavigationBarRequired() {
		return isNavigationBarRequired;
	}

	public void setIsNavigationBarRequired(Boolean isNavigationBarRequired) {
		this.isNavigationBarRequired = isNavigationBarRequired;
	}

	public String getGridDivId() {
		return gridDivId;
	}

	public void setGridDivId(String gridDivId) {
		this.gridDivId = gridDivId;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	public Boolean getIsSearchRequired() {
		return isSearchRequired;
	}

	public void setIsSearchRequired(Boolean isSearchRequired) {
		this.isSearchRequired = isSearchRequired;
	}

	public Boolean getIsSearchBarRequired() {
		return isSearchBarRequired;
	}

	public void setIsSearchBarRequired(Boolean isSearchBarRequired) {
		this.isSearchBarRequired = isSearchBarRequired;
	}

	public String getSubgridListVar() {
		return subgridListVar;
	}

	public void setSubgridListVar(String subgridListVar) {
		this.subgridListVar = subgridListVar;
	}

}
