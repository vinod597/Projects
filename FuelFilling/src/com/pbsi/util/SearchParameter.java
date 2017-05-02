package com.pbsi.util;
public class SearchParameter {
	private Integer currentPage;
	private Integer recordsPerPage;;
	private String searchField;
	private String searchOperator;
	private String searchString;
	private String sortColumn;
	private String sortType;
	private String queryString;
	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the recordsPerPage
	 */
	public Integer getRecordsPerPage() {
		return recordsPerPage;
	}
	/**
	 * @param recordsPerPage the recordsPerPage to set
	 */
	public void setRecordsPerPage(Integer recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	/**
	 * @return the searchField
	 */
	public String getSearchField() {
		return searchField;
	}
	/**
	 * @param searchField the searchField to set
	 */
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	/**
	 * @return the searchOperator
	 */
	public String getSearchOperator() {
		return searchOperator;
	}
	/**
	 * @param searchOperator the searchOperator to set
	 */
	public void setSearchOperator(String searchOperator) {
		this.searchOperator = searchOperator;
	}
	/**
	 * @return the searchString
	 */
	public String getSearchString() {
		return searchString;
	}
	/**
	 * @param searchString the searchString to set
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	/**
	 * @return the sortColumn
	 */
	public String getSortColumn() {
		return sortColumn;
	}
	/**
	 * @param sortColumn the sortColumn to set
	 */
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	/**
	 * @return the sortType
	 */
	public String getSortType() {
		return sortType;
	}
	/**
	 * @param sortType the sortType to set
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	/**
	 * @return the queryString
	 */
	public String getQueryString() {
		return queryString;
	}
	/**
	 * @param queryString the queryString to set
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
}
