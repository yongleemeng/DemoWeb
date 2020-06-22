package com.javaegitimleri.app.common;

public class CommonWebUtils {
	
	
	public static String contructPagination(int pageNo, int pageSize) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("limit ");
		pageNo = pageNo == 0?1:pageNo;
		sb.append((pageNo - 1) * pageSize);
		sb.append(",");
		sb.append(pageSize);
		
		return sb.toString();
	}
	
	public static String contructWildCard(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("%");
		sb.append(field);
		sb.append("%");
		return sb.toString();
	}

}
