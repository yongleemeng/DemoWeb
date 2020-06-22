package com.javaegitimleri.app.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

public abstract class CommonAbstractModel {

    @Transient
    private int pageNo;

    @Transient
    private List<CommonSortingModel> sortingList = new ArrayList<CommonSortingModel>();


	public abstract String contructSorting();
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<CommonSortingModel> getSortingList() {
		return sortingList;
	}

	public void setSortingList(List<CommonSortingModel> sortingList) {
		this.sortingList = sortingList;
	}
    
    
}
