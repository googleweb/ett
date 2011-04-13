/**
 * 
 */
package com.ett.web.framework;
/**
 * @author chen
 * 基本的Crud的Action，供webwork，struts1，struts2扩展
 */
public interface IBaseEntityAction extends IBaseAction {
	
	/**
	 * @return 获取请求的查询条件
	 */
	public String getCondition();
	
	/**
	 * @return 获取请求的排序条件
	 */
	public String getOrders();
	
	/**
	 * @return 根据条件来查询结果列表集合
	 * @throws Exception 异常信息
	 */
	public String list() throws Exception;
	
	/**
	 * @return 删除数据
	 * @throws Exception 删除的异常信息
	 */
	public String delete() throws Exception;
	
	/**
	 * @return 初始化添加页面信息
	 * @throws Exception 初始化过程中的异常
	 */
	public String prepareAdd() throws Exception;
	
	/**
	 * @return  添加一个未存在的对象
	 * @throws Exception 初始化一个对象的异常信息
	 */
	public String add() throws Exception;
	
	/**
	 * @return 编辑一个现存在的对象
	 * @throws Exception 编辑对象时发声的异常
	 */
	public String edit() throws Exception;
	
	
	/**
	 * @return 导出全部
	 * @throws Exception 结果
	 */
	public String exportAll() throws Exception;
	
	/**
	 * @return 导出当前页
	 * @throws Exception 结果
	 */
	public String exportPage() throws Exception;
	
	
	
	/**
	 * 处理ajax命令请求
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception;
	
	
	/**
	 * 输出ajax结果
	 */
	public void renderAjax();
	
	
	
	
	//TODO 增加获取上传文件流的方法，供子action保存使用
	//TODO 增加web处理所有异常的方法
	//TODO 增加国际化支持
	
	
}
