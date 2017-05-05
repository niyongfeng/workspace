package cn.itcast.bos.pojo;
/**
 * 分页实体
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月5日 下午2:44:34
 * @version 1.0
 */
public class PageModel {
	
	/** 当前页码 */
	private int pageIndex;
	/** 每页显示的记录条数 */
	private int pageSize;
	/** 总记录条数 */
	private int recordCount;
	
	/** setter and getter method */
	public int getPageIndex() {
		return pageIndex <= 1 ? 1 : pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize <= 1 ? 1 : pageSize;
	}
	/** mysql: 返回的是limit的第一个问号的值  oracle: 返回的是第二个问号的值 */
	public int getStartRow() {
		/** (当前页码 - 1) * 每页显示的记录条数 */
		return (getPageIndex() - 1) * getPageSize();
	}
}