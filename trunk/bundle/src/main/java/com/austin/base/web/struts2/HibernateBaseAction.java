/**
 * 
 */
package com.austin.base.web.struts2;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.austin.base.dao.IBaseDao;
import com.austin.base.dao.Page;


/**
 * @author austin
 *
 */
public class HibernateBaseAction extends AbstractStrut2BaseAction {
	/**
	 * Logger for this class
	 */
	
	private IBaseDao baseBiz;//基本的Biz对象。带有事务
	public IBaseDao getBaseBiz() {
		return baseBiz;
	}

	public void setBaseBiz(IBaseDao baseBiz) {
		this.baseBiz = baseBiz;
	}

	private static final Logger logger = Logger
			.getLogger(HibernateBaseAction.class);

	@Override
	public boolean checkUserRight(String rightId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	private String sort;//easyui排序参数
	private String order;//easyui 排序 asc or desc

	private int page;//easyui 当前页
	private int total;//easyui总记录数
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	private List rows;//easyui 返回数据的lists
	private String modelName;//实例名
	private String condition;//前台easyui组合成的条件语句
	
	private String jsondata;//easyui页面获取的json参数提交到后台使用

	
	
	



	public String getJsondata() {
		return jsondata;
	}

	public void setJsondata(String jsondata) {
		this.jsondata = jsondata;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public String getCondition() {
		if(condition==null)
		{
			return "";
		}
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	private String getOrders()
	{
		if(sort==null||order=="")
		{
			return "";
		}
		return " order by "+this.sort+" "+this.order;
	}
	
	public String list()
	{
		String sql="select count(*) FROM "+modelName+this.getCondition();
		logger.info("查询语句："+sql);
		total=this.getBaseBiz().count(sql);
		logger.info("查询结果记录数："+total);
	    Page pager=new Page(total,this.getRowsPerPage(),page);
	    this.page=pager.getCurrentPageIndex();
		int start=pager.getStartIndex();
		logger.info("分页对象的起始索引："+start);
	    this.rows=this.getBaseBiz().getAllByPage("FROM "+modelName+this.getCondition()+this.getOrders(), pager);
	    logger.info("获取的列表长度为："+rows.size());
		return ListPage;
	}
	public String edit() throws ClassNotFoundException
	{
		JSONObject obj = JSONObject.fromObject(this.jsondata);
		if(logger.isInfoEnabled())
		logger.info("需要编辑对象的jsondata为："+jsondata);
		//Class.forName(modelName);
		Object model=JSONObject.toBean(obj,Class.forName(modelName));
		this.baseBiz.saveOrUpdate(model);
		
		//this.entity = (T) JSONObject.toBean( obj, this.entityClass );
		return AjaxResult;
	}
	public String add() throws ClassNotFoundException
	{
		JSONObject obj = JSONObject.fromObject(this.jsondata);
		if(logger.isInfoEnabled())
		logger.info("需要添加对象的jsondata为："+jsondata);
		//Class.forName(modelName);
		Object model=JSONObject.toBean(obj,Class.forName(modelName));
		this.baseBiz.saveOrUpdate(model);
		
		//this.entity = (T) JSONObject.toBean( obj, this.entityClass );
		return AjaxResult;
	}
	public String delete()
	{
		try
		{
			String[] ids = this.getHtmlAttributeOrParamter("ids").split(",");
			
			if(logger.isInfoEnabled())
			{
				logger.info("请求删除的ids为："+ids);
				if(ids.length>0)
					logger.info("需要删除的记录有："+ids.length+"条");
				for(int i=0;i<ids.length;i++)
				{
					logger.info("id:"+ids[i]);
				}
	
			}
			Object obj=null;
			for(String id :ids){
				//logger.info("请求删除的id为："+id);
				obj=this.getBaseBiz().get(modelName, Long.valueOf(id));
				this.getBaseBiz().delete(obj);
			}
			
		    //this.afterDelete();
		}
		catch(Exception ex)
		{
			this.goFailPage(ex.getMessage());
		}
		return ListPage;
	}

	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRowsPerPage() {
		String rows=this.getParamter("rows");//easyui每页记录数
		if(rows.length()==0)
			return 10;
		return Integer.valueOf(rows);
	}


	
	
	
	

}
