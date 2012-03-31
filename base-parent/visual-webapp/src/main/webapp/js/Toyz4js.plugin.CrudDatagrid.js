/**
 require jquery,easyui
 * import core.js
 * import setting.js
 * import extends.jquery.js
 * import extends.easyui.js
 * import prototype.String.js
 */


var CrudDatagrid=function(opts){
	this._urlAdd=opts["urlAdd"]||"";
	this._urlRemove=opts["urlRemove"]||"";
	this._urlUpdate=opts["urlUpdate"]||"";
	this._urlQuery=opts["urlQuery"]||"";
	this._urlExportExcel=opts["urlExportExcel"]||"";
	this._regexp=opts["regexp"]||"";
    this._id=opts["id"]||"Id";
    this._initRow=opts["initRow"]||function(){return {};};
    this._editors=opts["editors"];
    this._querys=opts["querys"];
    
    //alert("init");
};

CrudDatagrid.prototype.getToolbar = function(opts) {
    opts = opts || {};
    var newRow = new this._initRow();
    var regexp = this._regexp;
    var id = this._id;
    var urlRemove = this._urlRemove;
    var urlAdd = this._urlAdd;
    var urlUpdate = this._urlUpdate;
    var urlExportExcel = this._urlExportExcel;
    var flag=false;
    var formOpts = {};
    formOpts["editors"] = this._editors;
    formOpts["prefix"] = opts["prefix"] || "";
    formOpts["querys"] = this._querys|| [];
    formOpts["urlQuery"] = this._urlQuery|| [];
    var divQuery=null;
    var divCrud=null;
    var handlerBtnQuery=function() {
    	if(flag){return false;}
    	if(divQuery!=null){divQuery.dialog("open");return false;}
    	var regexpContent="#divQueryDialog";
        divQuery = $("<div id='divQueryDialog'></div>");
        //divQuery.addClass("query");
        formOpts["regexpContent"]=regexpContent;
        formOpts["datagridRegexp"] = regexp;
        divQuery.toyzQueryForm(formOpts);
        divQuery.dialog({
            title: "数据查询"
	      , modal: true
          ,onOpen:function(){flag=true;}
          ,onClose:function(){flag=false;}
        });
        return false;
    };
    
    var btnQuery = { iconCls: "icon-search", text: "查询"
        , handler: handlerBtnQuery
};
    
    var handlerBtnAdd=function() {
    	if(flag){return false;}
        formOpts["data"] = newRow;
        formOpts["urlSave"] = urlAdd;
        var regexpContent="#divCrudDialog";
    
        var div = $("<div id='divCrudDialog'></div>");
        //div.addClass("crud");
        formOpts["regexpContent"]=regexpContent;
        div.toyzCrudForm(formOpts);
        div.dialog({
            title: "新建记录"
	      , modal: true
	      ,onOpen:function(){flag=true;}
          , onClose: function() {flag=false; $(this).dialog("destroy", true); }
         , onDestroy: function() { $(regexp).datagrid("reload"); }
         
        });
        return false;
    };
    
    var btnAdd = { iconCls: "icon-add", text: "新建"
	        , handler: handlerBtnAdd
    };
    
    var handlerBtnUpdate=function() {
    	if(flag)return false;
        var selectRow = $(regexp).datagrid("getSelected");
        if (!selectRow) { $.messager.alert("", "没有记录被选中", "error"); return false; }
        var rowIndex = $(regexp).datagrid("getRowIndex", selectRow);
        formOpts["data"] = selectRow;
        formOpts["urlSave"] = urlUpdate;
        var title = "修改记录序号:" + (rowIndex + 1);
        var div = $("<div></div>");
        div.addClass("crud");
        div.toyzCrudForm(formOpts);
        div.dialog({
            title: title
	      , modal: true
            //,onBeforeOpen:function(){$(this).toyzCrudForm(formOpts);}
	     ,onOpen:function() { flag=true; }
         , onClose: function() {flag=false; $(this).dialog("destroy", true); }
         , onDestroy: function() { $(regexp).datagrid("reload"); }
        });
        return false;
    }
    
    var btnUpdate = { iconCls: "icon-edit", text: "修改"
	        , handler: handlerBtnUpdate
    };
    
    var handlerBtnRemove=function() {
    	
        var selectsRows = $(regexp).datagrid("getSelections");
        var deleteCount = selectsRows.length;
        if (deleteCount == 0) { $.messager.alert("", "没有记录被选中", "error"); return; }
        var ids = "";
        ids = selectsRows.getUnionAttrStr(id, ",");
        $.messager.confirm("操作提示", "是否删除" + deleteCount + "条记录", function(ok) {
            if (ok) {
                //var removeRowsAction=basePath+"/common/Datagrid/do/removeRows.action?modelClass="+modelClass;
                $.post(urlRemove, { pks: ids }, function(re) {
                    try {
                        //alert(re.toString());
                        
                        re.toString().messager();
                        $(regexp).datagrid("clearSelections");
                        $(regexp).datagrid("reload");
                    } catch (ex) { alert(ex); }
                });
            } //if(ok){
        });
        return false;
    };
    
    var btnRemove = { iconCls: "icon-remove"
		        , text: "删除"
		       , handler: handlerBtnRemove
    };
    
    var handlerBtnRefresh=function() {
        $(regexp).datagrid("clearSelections");
        $(regexp).datagrid("reload");
        return false;
    };
    
    var btnRefresh = { iconCls: "icon-reload"
	        , text: "刷新"
	        , handler: handlerBtnRefresh
    };
    
    var handlerBtnExportExcel=function() {
    	if(flag)return false;
	    if (urlExportExcel.length < 1) {
	        $.messager.alert("操作错误", "没有配置excel路径", "error");
	        return;
	    }
	    var pager=$(regexp).datagrid("getPager");
	    var total=pager.pagination("options")["total"];
	    var pageNumber=pager.pagination("options")["pageNumber"];
	    var pageSize=pager.pagination("options")["pageSize"];
	    var pageParam=$.param({rows:pageSize,page:pageNumber});
	    var div = $("<div></div>");
	    var table = $("<table></table>");
	    table.css("padding", "10px");
	    var tr;
	    var th;
	    var td;
	    var td2;
	    var a;

	    //导出全部记录
	    tr = $("<tr></tr>");
	    th = $("<th></th>");
	    td = $("<td></td>");
	    td2 = $("<td></td>");
	    a = $("<a></a>");
	    var countAll = $(regexp).datagrid("getData")["total"] || 0;
	    th.html("全部记录数:");
	    td.html(countAll).css("width", "100px");
	    td2.css("width", "120px");
	    a.attr("href", urlExportExcel);
	    td2.append(a);
	    a.linkbutton({
	        text: "导出excel"
	    });
	    tr.append(th).append(td).append(td2);
	    table.append(tr);

	    //导出已选记录
	    tr = $("<tr></tr>");
	    th = $("<th></th>");
	    td = $("<td></td>");
	    td2 = $("<td></td>");
	    a = $("<a></a>");
	    var selectsRows=$(regexp).datagrid("getSelections");
	    var countSelect = selectsRows.length || 0;
        var pks = "";
        pks = selectsRows.getUnionAttrStr(id, ",");
	    th.html("已选记录数:");
	    td.html(countSelect);
	    a.attr("href", urlExportExcel+"?pks="+pks);
	    td2.append(a);
	    a.linkbutton({
	        text: "导出excel"
	    });
	    tr.append(th).append(td).append(td2);
	    table.append(tr);

	    //导出当前页记录
	    tr = $("<tr></tr>");
	    th = $("<th></th>");
	    td = $("<td></td>");
	    td2 = $("<td></td>");
	    a = $("<a></a>");
	    var countPage = $(regexp).datagrid("getRows").length || 0;
	    th.html("当前页记录数:");
	    td.html(countPage);
	    a.attr("href", urlExportExcel+"?"+pageParam);
	    td2.append(a);
	    a.linkbutton({
	        text: "导出excel"
	    });
	    tr.append(th).append(td).append(td2);
	    table.append(tr);

	    div.append(table);

	    div.dialog({
	        title: "导出"
	        ,modal:true
	        ,onOpen:function() { flag=true; }
	    ,onOpen:function() { flag=false; }
	    });
	    return false;
	};
    
    var btnExportExcel = {
        iconCls: "icon-help"
            	, text: "导出"
            	, handler: handlerBtnExportExcel
    };

    var toolbar = [btnQuery,btnAdd, btnUpdate, btnRemove, btnRefresh,btnExportExcel];
    $(document).bind("keypress","Alt+1",handlerBtnQuery);
    $(document).bind("keypress","Alt+2",handlerBtnAdd);
    //$(document).bind("keypress","Alt+3",handlerBtnUpdate);
    //$(document).bind("keypress","Alt+4",handlerBtnRefresh);
    //$(document).bind("keypress","Alt+5",handlerBtnRemove);
    //$(document).bind("keydown","alt+6",function(e){btnQuery.click();});
   return toolbar;
};




CrudDatagrid.prototype.getOperaFormatter=function(){
	try{
	var newRow=new this._initRow();
	var regexp=this._regexp;
	var id=this._id;
	var urlRemove=this._urlRemove;
	var urlAdd=this._urlAdd;
	var urlUpdate=this._urlUpdate;
    var formOpts={};
   formOpts["editors"]=this._editors;
	var o= function(value,row,index){
   var span=$("<span></span>");
   var aEdit=$("<a id='aEdit'></a>");
   var aRemove=$("<a></a>");
   var eidtOnclickContext="$('<div></div>').dialog({width:600,height:400});"
   span.append(aEdit);
   span.find("#aEdit")
	   .attr("title","编辑")
	   .attr("href","javascript:void(0)")
	   .addClass("toyz-icon")
	   .addClass("edit")
	   .attr("onclick",eidtOnclickContext)
	;
	
	   
	   alert(span.html());
     return span.html();
   
   }
	 return o;
	 
	 }catch(ex){alert(ex);}
}

CrudDatagrid.prototype.getEditRowHandler = function(opts) {
    opts = opts || {};
    var regexp = this._regexp;
    var id = this._id;
    var urlRemove = this._urlRemove;
    var urlAdd = this._urlAdd;
    var urlUpdate = this._urlUpdate;
    var formOpts = {};
    formOpts["editors"] = this._editors;
    formOpts["prefix"] = opts["prefix"] || "";
    var fun = function(rowIndex, rowData) {

        formOpts["data"] = rowData;
        formOpts["urlSave"] = urlUpdate;
        var i = parseInt(rowIndex);
        var title = "修改记录序号:" + (i + 1);
        var div = $("<div></div>");
        div.addClass("crud");
        div.toyzCrudForm(formOpts);
        div.dialog({
            title: title
    		      , modal: true
            //,onBeforeOpen:function(){$(this).toyzCrudForm(formOpts);}
	             , onClose: function() { $(this).dialog("destroy", true); }
	             , onDestroy: function() { $(regexp).datagrid("reload"); }
        });

    }
    return fun;

}
	


function dateboxFormatter(value,row,index){

    
	if(value==null||value=='')return '';
	var strFormat="";
	if(typeof(value)=="number"){
		var date=new Date();date.setTime(value);
		return date.toString('yyyy-MM-dd');
	}else{
		return value;
	}

	//alert('value:'+value+" date:"+date.toString('yyyy-MM-dd'));
	
}

function dateTimeboxFormatter(value,row,index){

	if(value==null||value=='')return '';
	var date=new Date();
	date.setTime(value);
	if(date==null){
		return value;
	}
	//alert('value:'+value+" date:"+date.toString('yyyy-MM-dd'));
	return date.toString('yyyy-MM-dd HH:mm:ss');
}





