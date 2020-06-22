package com.javaegitimleri.app.common;

public class CommonSortingModel {
	public static final String SORT_ASC = " ASC";
	public static final String SORT_DESC = " DESC";
	
	private String field;
	
	private String sortingType;
	
	public String contructSorting(String alias) {
		StringBuilder sb = new StringBuilder();
		sb.append(alias==null?"":alias);
		sb.append(field);
		sb.append(sortingType);
		return sb.toString();
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	
	public String getSortingType() {
		return sortingType;
	}
	
	public void setSortingType(String sortingType) {
		this.sortingType = sortingType;
	}
}
