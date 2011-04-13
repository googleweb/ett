/**
 * 
 */
package com.ett.dao;

/**
 * @author chen
 * 分页对象，待完成
 */
public class Page {
	
	public static final int Default_Page_Size = 20;

	private int pageSize = Default_Page_Size; // 每页的记录数
	private int pageIndex=1;
	private int totalCount; // 总记录数
	
	private int pageCount=1;
	
	private int startIndex=0;//起始记录

	/**
	 * 构造函数，默认页数为20.
	 */
	public Page() {
		this(0, Default_Page_Size,1);
	}
	
	/**
	 * 构造函数，默认页数为20.
	 */
	public Page(int totalSize,int pageIndex) {
		this(totalSize, Default_Page_Size,pageIndex);
	}

	/**
	 * @param totalSize 总记录数
	 * @param pageSize 分页大小
	 * @param startIndex 页索引，如果超出总页数，会被重置为�1�7�页敄1�7
	 */
	public Page(int totalSize, int pageSize,int startIndex) {
		this.pageSize = pageSize;
		this.totalCount = totalSize;
		int now=startIndex/this.pageSize+1;
		this.pageIndex=now>0?now:1;
		this.init();
	}
	
	/**
	 * 初始化，进行总页数计算，如果当前页超出索引，并重置当前页
	 */
	private void init()
	{
		if (totalCount!=0&&totalCount % pageSize == 0)
			this.pageCount=totalCount / pageSize;
		else
			this.pageCount=totalCount / pageSize + 1;
		if(this.pageIndex>this.pageCount)
			this.pageIndex=this.pageCount;
		this.startIndex=(pageIndex-1)*pageSize;
	}
	/**
	 * @return 总记录数
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/**
	 * @return 获取总页数
	 */
	public int getTotalPageCount() {
		return this.pageCount;
	}

	/**
	 * @return 取分页大小
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @return 获取当前页索引
	 */
	public int getCurrentPageIndex() {
		return this.pageIndex;
	}
	
	/**
	 * @return 是否有下页
	 */
	public boolean hasNextPage() {
		return this.pageIndex < this.pageCount;
	}
	
	/**
	 * @return 是否是尾页，如果是返回true
	 */
	public boolean isLast()
	{
		return this.pageCount==this.pageIndex;
	}
	
	/**
	 * @return 是否是首页,如果是返回true
	 */
	public boolean isFirst()
	{
		return this.pageIndex==1;
	}

	/**
	 * @return 是否有上一页
	 */
	public boolean hasPreviousPage() {
		return this.pageIndex > 1;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

}
