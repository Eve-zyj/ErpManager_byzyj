package tools;

import java.util.List;

/**
 * 分页
 * @author Eve-赵雅娟
 *
 */
public class PageUtils {

	private Integer pageIndex;//第几页
	private Integer firstData;//第一条数据（当前页）
	private Integer totalCount;//总记录数
	private Integer pageCount;//总页数
	private Integer pageSize;//页面容量
	private List list;//列表
	private String warehouseNo;

	public void count(){
		if(totalCount==null){
			totalCount=0;
		}
		if(pageIndex==null || pageIndex<=0){
			pageIndex=1;
		}
		pageCount=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		if(pageIndex>pageCount&&pageCount!=0){
			pageIndex=pageCount;
		}else if(pageCount==0){
			pageSize=0;
		}
		firstData=(pageIndex-1)*pageSize;
	}
	public PageUtils(){}
	public PageUtils(Integer pageIndex, Integer firstData, Integer totalCount, Integer pageCount, Integer pageSize, List list, String id) {
		this.pageIndex = pageIndex;
		this.firstData = firstData;
		this.totalCount = totalCount;
		this.pageCount = pageCount;
		this.pageSize = pageSize;
		this.list = list;
		this.warehouseNo = warehouseNo;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getFirstData() {
		return firstData;
	}

	public void setFirstData(Integer firstData) {
		this.firstData = firstData;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getWarehouseNo() {
		return warehouseNo;
	}

	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}
}
