package com.derhede.taoke.dto;

/**
 * 
 * @author chenziyi01
 *
 */
public class QueryParameterDTO {
		
	private String querytime; //查询时间
	
	int  startNo =0;//分页页数
	
	int  endNo =5000;//分页页数
	
	int  pageNo =0;//总页数
	
	int  currentPage =1;//当前页
	
	int  pageSize=5000;//每页条数
	
	int totalcount;//总条数

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {		
		this.totalcount = totalcount;
		if(totalcount<pageSize){
			this.pageNo=1;
		}else{
			this.pageNo=totalcount/pageSize;
			if(totalcount%pageSize!=0){
				this.pageNo=pageNo+1;
			}
		}		
	}	
	
	public void setCurrentPageNo(int  currentPage){
		if(currentPage>pageNo){
		   this.currentPage=pageNo;
		}
		this.startNo=(currentPage-1)*pageSize;
		this.endNo=currentPage*pageSize;
	}
	
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public String getQuerytime() {
		return querytime;
	}
	public void setQuerytime(String querytime) {
		this.querytime = querytime;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setTotalcount(this.totalcount);
	}
}