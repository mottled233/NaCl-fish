package util;

import java.util.List;

import exception.BadInputException;
public class DataPage <T>{

	private List<T> list;
	private int totalRecord;
	private int currentPage;
	private int recordPerPage;
	
	public DataPage() {
		super();
		
	}
	
	
	public DataPage(int totalRecord, int recordPerPage, int currentPage) throws BadInputException {
		this.totalRecord = totalRecord;
		
		if(recordPerPage<=0)
			throw new BadInputException();
		this.recordPerPage = recordPerPage;
		
		if(currentPage<0||currentPage>getTotalPage())
			throw new BadInputException();
		
		this.currentPage = currentPage;
		
	}

	
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	public int getTotalPage() {
		if(totalRecord==0)
			return 1;
		return (totalRecord%recordPerPage==0)?(totalRecord/recordPerPage):(totalRecord/recordPerPage+1);
	}

	public int getRecordPerPage() {
		
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRecordOfThisPage() {
		if(currentPage<getTotalPage()){
			return recordPerPage;
		}else{
			return totalRecord%recordPerPage;
		}
	}

	
	
	
}
