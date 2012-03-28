
jQuery.fn.extend({

    toyzLoadFields: function() {
        $(this).find("input:enabled").each(function() {

            if ($(this).hasClass("easyui-combobox")) {
                $(this).combobox();
            } else if ($(this).hasClass("toyz-intbox")) {
                $(this).toyzIntbox();
            } else if ($(this).hasClass("toyz-doublebox")) {
                $(this).toyzDoublebox();
            } else if ($(this).hasClass("toyz-combogrid")) {
                $(this).toyzCombogrid();
            } else if ($(this).hasClass("toyz-datebox")) {
                $(this).toyzDatebox();
            }
        });
        return true;

    }

 , toyzIframe: function(url) {
     $(this).html("<iframe scrolling='no' frameborder='0' src='" + url + "' style='width:99%;height:99%;overflow:hidden;'></iframe>");
 }

 , toyzAuthFields: function(authJson) {
     var authObject = $(this);
     //var authUrl=url||authObject.attr("authUrl")||null;
     if (!authJson) return false;
     authObject.find("input").each(function() {
         var fieldName = $(this).attr("name") || null;
         if (fieldName) {
             var authValue = authJson[fieldName];
             switch (authValue) {
                 case 0: $(this).addClass('invisible').attr("disabled", "disabled"); break;
                 case 1: $(this).addClass('readonly').attr("readonly", "true"); break;
                 default: $(this).addClass('editable');
             }
         }
     });
     return true;
 }



 , toyzCombogrid: function(opts) {

     var thisObj = $(this);
     var thisName = thisObj.attr('name') || "";

     var thisValueField = thisObj.attr("valueField") || "value";
     var thisTextField = thisObj.attr("textField") || "text";
     var thisUrl = thisObj.attr("url") || "";
     var thisRequired = thisObj.attr("required") || true;
     var selecterWidth = thisObj.attr("selecterWidth") || 80;
     var thisDisabled = thisObj.attr("disabled");
     var thisDataEval = thisObj.attr("dataEval") || "";


     if (opts) {
         thisValueField = opts["valueField"] || "value";
         thisTextField = opts["textField"] || "text";
         thisUrl = opts["url"] || "";
         thisRequired = opts["required"] || true;
         selecterWidth = opts["selecterWidth"] || 80;
         thisDisabled = opts["disabled"];
         thisDataEval = opts["dataEval"] || "";
     }


     var thisWidth = thisObj.width();
     var thisHeight = thisObj.height();
     thisObj.width(thisWidth - selecterWidth);
     var thisValue = thisObj.val() || "";

     //var selecterId="selecter-"+thisName;
     //alert(_comboData);
     var selecterObj = $("<input>").width(selecterWidth); //.attr('id',selecterId);
     thisObj.before(selecterObj);
     //var selecterObj=$("#"+selecterId);
     thisObj.combobox({
         hasDownArrow: false
				    	   , editable: false
				    	   , required: thisRequired
				    	   , textField: thisTextField
				    	   , valueField: thisValueField
     });
     selecterObj.combogrid({
         panelWidth: thisWidth
				    	   , disabled: thisDisabled
				    	   , idField: thisValueField
				    	   , textField: thisValueField
				    	   , value: thisValue
				    	   , columns: [[{ field: thisValueField, width: selecterWidth },
                                      { field: thisTextField, width: thisWidth}]]
                           , onChange: function(nv, ov) {
                               if (!nv || !ov || nv == ov) return;
                               thisObj.combobox("select", nv);
                           }
				    	  , onSelect: function(index, r) {
				    	      thisObj.combobox("select", r[thisValueField]);
				    	  }
     });


     var grid = selecterObj.combogrid('grid');
     if (thisDataEval != "") {
         var gridData = eval(thisDataEval);
         if (gridData) {
             grid.datagrid("loadData", gridData);
             thisObj.combobox('loadData', gridData["rows"]);
         }
     } else if (thisUrl != "") {
         $.getJSON(thisUrl, function(gridData) {
             grid.datagrid("loadData", gridData);
             thisObj.combobox('loadData', gridData["rows"]);
         });
     }


     //});  //$.getJSON(thisUrl,function(grid){
 }  // toyzComboBox:function(){

 , toyzDatebox2: function() {
     try {
         var thisObject = $(this);
         var thisValue = thisObject.attr("value") || "";
         var formatValue = "";
         if (thisValue != "") {
             //var d=new Date(thisValue);
             //formatValue=d.format(Toyz4js.custom.setting.dbDateFormat);
             var d = Date.parse(thisValue);
             formatValue = d.toString(Toyz4js.custom.setting.dbDateFormat);
             thisObject.val(formatValue);
             //alert(formatValue);
         }
         thisObject.datebox({
             onChange: Toyz4js.easyui.datebox.onChangeHandler
		 , onSelect: function(date) {
		     thisObject.datebox("setValue", date.format(Toyz4js.custom.setting.dbDateFormat));
		 }
         });
         var dateCombotext = thisObject.next().find("input:first");
         dateCombotext.blur(function() {
             if ($(this).val() == null || $(this).val() == "") return;
             //alert($(this).val());
             var re = Toyz4js.util.isDateFormat(Toyz4js.custom.setting.dbDateFormat, $(this).val());
             if (re) {
                 var cal = dateboxObj.datebox("calendar");
                 var opts = cal.calendar("options");
                 var d = opts["current"];
                 //thisObject.val(d.format(Toyz4js.custom.dbDateFormat));
                 thisObject.datebox("setValue", d.format(Toyz4js.custom.setting.dbDateFormat));
             } else {
                 $.messager.show({ title: "输入错误",
                     msg: "日期格式必须符合" + Toyz4js.custom.setting.dbDateFormat
                 }
    		  );
                 //dateboxObj.datebox("setValue",thisDateboxValue);
                 //thisObject.val(formatValue);
                 thisObject.datebox("setValue", formatValue);
             }
             //if(!isDbDateFormat(thisObject.val())){
             //  $("#"+dateboxId).datebox("setValue","");
             //$.messager.alert("输入错误","日期格式");
             //}
         });
     } catch (ex) {
         //alert(ex); 
     }
 }
 , toyzDatebox: function() {

     var thisObject = $(this);
     var thisValue = thisObject.attr("value") || "";
     var formatValue = "";
     if (thisValue != "") {
         try {
             //var d=Date.parse(thisValue,"%a %h %d %T %z %G");
             var d = new Date(thisValue);
             formatValue = d.toString(Toyz4js.custom.setting.dbDateFormat);
             thisObject.val(formatValue);
         } catch (ex) {
             //alert(ex); 
         }
     } else {
         thisObject.val("");
     }
     thisObject.datebox({
         validType: "date['yyyy-MM-dd']"
     });
 }
 , toyzDoublebox: function() {
     $(this).numberbox({
         increment: 10
            , precision: Toyz4js["cfg"]["precision"]
     });
 }

  , toyzIntbox: function() {
      $(this).numberbox({
          increment: 10
            , precision: 0
      });
  }

 , toyzCrudForm: function(opts) {
	     var regexpContent=opts["regexpContent"]||"";
         var prefix = opts["prefix"] || "";
         var colNum = opts["colNum"] || 2;
         var editors = opts["editors"] || [];
         var urlSave = opts["urlSave"] || "";
         var urlRemove = opts["urlRemove"] || "";
         var data = opts["data"] || {};
         var objDiv = $("<div></div>");
         objDiv
         //.css("width","100%")
         //.css("height","100%")
	.css("overflow", "hidden")
	;
         var objForm = $("<form method='post'></form>");
         var objTable = $("<table cellspacing='0' ></table>");
         objTable.addClass("tableSimple");
         objTable.css("table-layout", "auto");

         $.each(data, function(dataName, dataValue) {
             var hidden = $("<input type=\"hidden\" />")
             hidden.attr("name", prefix + dataName).attr("value", dataValue);
             objForm.append(hidden);

         });

         var tr;
         $.each(editors, function(index, editor) {

             if (index % colNum == 0) {
                 tr = $("<tr></tr>");
             }

             var inputName = editor["field"] || "";
             var inputTitle = editor["title"] || "";
             var pattern = "input[name='" + prefix + inputName + "']";
             objForm.find("input").remove(pattern);
             var td = $("<td>&nbsp;</td>");
             var th = $("<th>&nbsp;</th>");
             var inputEditor = editor["editor"] || { type: "text" };
             var editorType = inputEditor["type"];
             var editorOpts = inputEditor["options"] || {};
             var inputObj;
             if (editorType == "textarea") {
                 inputObj = $("<textarea rows='5' cols='50'></textarea>");
                 inputObj.html(data[inputName]);
             } else if (editorType == "checkbox") {
                 inputObj = $("<input type='checkbox' value='Y' />");
             } else {
                 inputObj = $("<input type='text' />");
                 inputObj.val(data[inputName]);
             }

             inputObj.attr("name", prefix + inputName);
             var span = $("<span></span>");
             span.html(inputTitle);
             //td.html(data[inputName]);
             td.append(inputObj);
             th.append(span).append(":");
             tr.append(th);
             tr.append(td);
             if (index % colNum == colNum - 1 || index == editors.length - 1) {
                 objTable.append(tr);
             }

             switch (editorType) {

                 case "validatebox": { inputObj.validatebox(editorOpts); break; }

                 case "numberbox": { inputObj.numberbox(editorOpts); break; }
                 case "numberspinner": { inputObj.numberspinner(editorOpts); break; }
                 case "combobox": { inputObj.combobox(editorOpts); break; }
                 case "combotree": { inputObj.combotree(editorOpts); break; }
                 case "combogrid": { inputObj.combogrid(editorOpts); break; }
                 case "toyzCombogrid": { inputObj.toyzCombogrid(editorOpts); break; }
                 case "datebox":
                     {
                         var val = inputObj.val();
                         val = DateFormatter(val);
                         inputObj.val(val);
                         inputObj.datebox(editorOpts);
                         break;
                     }
                 case "datetimebox":
                     {
                         var val = inputObj.val();
                         val = DatetimeFormatter(val);
                         inputObj.val(val);
                         inputObj.datetimebox(editorOpts);
                         break;
                     }
                 default: inputObj.validatebox(editorOpts); break;
             }

         });  //each

         var trOpera = $("<tr></tr>");
         var tdOpera = $("<th></th>");
         tdOpera.css("padding-right", "3%");
         trOpera.append(tdOpera);
         tdOpera.attr("colspan", colNum * 2);
         var aSave = $("<a></a>");
         var aClear = $("<a></a>");
         tdOpera.append(aSave);
         tdOpera.append(aClear);
         aSave.linkbutton({
             text: "保存"
    	, iconCls: "icon-save"
         });
         aClear.linkbutton({
             text: "清空"
    	, iconCls: "icon-cancel"
         });
         aSave.click(function() {
             //  $.messager.confirm("操作提示", "确认保存数据？", function(yes) {
             //      if (yes) {

             objForm.form("submit", {
                 url: urlSave
    		   , onSubmit: function() { return $(this).form("validate"); }
    	       , success: function(str) { str.messager(); $(regexpContent).dialog("close"); }
             });
             //      }
             //  });  //$.messager.alert

         });
         aClear.click(function() { objForm.form("clear"); });
         objTable.append(trOpera);
         objForm.append(objTable);
         objDiv.append(objForm);
         $(this).html(objDiv);

     
 }  //toyzCrudForm: function(opts)




 , toyzUploadForm: function(opts) {
     if (!opts) {
         opts = {};
     }
     var uploadUrl = opts["uploadUrl"] || "#";
     var inputName = opts["inputName"] || "file";
     var muti = opts["muti"] || false;
     var div = $("<div></div>");
     var table = $("<table></table>");
     var ol = $("<ol type='1'></ol>");
     var span = $("<span></span>");
     var form = $("<form method='post' enctype='multipart/form-data'></form>");
     form.attr("action", uploadUrl);
     var aNew = $("<a></a>");
     var aSubmit = $("<a></a>");
     aNew.linkbutton({
         text: "新增"
    		  , iconCls: "icon-add"
     });
     aSubmit.linkbutton({
         text: "提交"
    		  , iconCls: "icon-save"
     });
     aNew.click(function() {
         var li = $("<li></li>");
         var inputFile = $("<input type='file' />");
         inputFile.attr("name", inputName);
         var btnRemove = $("<button type='button'>删除</button>");
         btnRemove.click(function() {
             li.remove();
         });
         li.append(inputFile).append("&nbsp;&nbsp;").append(btnRemove);
         ol.append(li);
     });

     aSubmit.click(function() {
         form.form("submit");
     });

     //var btns=[];

     if (muti) {
         //btns=[btnNew,btnUpload];
         span.append(aNew);
     }
     span.append(aSubmit);
     var li = $("<li></li>");
     var inputFile = $("<input type='file' />");
     inputFile.attr("name", inputName);
     li.append(inputFile);
     ol.append(li);
     div.css("padding", "1%");
     span.css("width", "100%").css("text-align", "right").css("padding-right", "5%");
     form.append(ol);
     form.append(span);
     div.append(form);
     $(this).html(div);
 }  //toyzUploadForm: function(opts) 
 
 ,toyzQueryForm:function(opts){
	 
     opts=opts||{};
	 var divLayout=$("<div class='easyui-layout'></div>");
	 var divCenter=$("<div region='center'></div>");
	 var divNorth=$("<div region='north'></div>");
	 var divSouth=$("<div region='south'></div>");
	 var tableQueryDatagrid=$("<table></table>");
	 var regexpContent=opts["regexpContent"]||"";
	 var aAddQuery=$("<a class='easyui-linkbutton' iconCls='icon-add'>添加</a>");
	 var aSearch=$("<a class='easyui-linkbutton' iconCls='icon-search'>查询</a>");
	 var aCancel=$("<a class='easyui-linkbutton' iconCls='icon-cancel'>取消</a>");
	 var datagridRegexp=opts["datagridRegexp"]||"";
	 var querys=opts["querys"]||[];
	 var queryUrl=opts["urlQuery"]||"";
	 var selectQueryPro=$("<select></select>");
	 var selectQueryType=$("<select></select>");
	 var spanQueryVaule=$("<span></span>");
	 var inputQueryVaule;
	 var dataSelectQueryPro=[];
	 var dataQueryGrid={rows:[],total:0};
	 var mapQueryData={};
	 var queryOpts={};
	 var mapQueryTypeName={
		eq:"等于"
		,neq:"非等于"
		,max:"最大"
		,min:"最小"
		,like:"匹配"
		,notlike:"非匹配"
		,isnull:"为空"
		,isnotnull:"非空"
		,isin:"包含"
		,isnotin:"不包含"
	 };
	 $(this).append(divLayout);
	 divLayout.append(divNorth).append(divCenter).append(divSouth);
	 divNorth.append("属性:").append(selectQueryPro).append(selectQueryType).append("值:").append(spanQueryVaule).append(aAddQuery);
	 divCenter.append(tableQueryDatagrid);
	 divSouth.append(aSearch).append(aCancel).css("text-align","right");
	 $.parser.parse(divLayout);
	 $.each(querys,function(index,query){
		 var text=query["column"]["title"];
		 //alert(text);
		 var value=query["column"]["field"];
		 if(!value)return true;
		 var prefix=query["prefix"]||"";
		 var fourceFieldName=query["fourceFieldName"]||"";
		 if(fourceFieldName!=""){
			 value=fourceFieldName;
		 }
		 var v=prefix+value;
		 dataSelectQueryPro.push({text:text,value:v});
		 queryOpts[v]=query;
	 });
	 selectQueryType.combobox({
		 textField:"text"
	     ,valueField:"value"
		 ,editable:false
		 ,onChange:function(ov,nv){
			 //inputQueryVaule.val("");	
			 var proName=selectQueryPro.combobox("getValue");
			 var column=queryOpts[proName]["column"];
			 var editorType=column["editor"]["type"]||"validatebox";
			 var editorOpts=column["editor"]["options"]||{};
			 spanQueryVaule.empty();
			 inputQueryVaule=$("<input name='queryValue' />");
			 if(editorType=="validatebox"){

				 spanQueryVaule.append(inputQueryVaule);
				 inputQueryVaule.validatebox(editorOpts);
			 }
			 else if(editorType=="combobox"){
				 spanQueryVaule.append(inputQueryVaule);
				 inputQueryVaule.combobox(editorOpts);
			 }else if(editorType=="datebox"){
				 spanQueryVaule.append(inputQueryVaule);
				 inputQueryVaule.datebox(editorOpts);
			 }else if(editorType=="numberspinner"){
				 spanQueryVaule.append(inputQueryVaule);
				 inputQueryVaule.numberspinner(editorOpts);
			 }
		 }
	 });
	 selectQueryPro.combobox({
		 textField:"text"
	    ,valueField:"value"
		,data:dataSelectQueryPro
		,editable:false
		,onChange:function(ov,nv){
			//inputQueryVaule.val("");	
			//alert(ov+":"+nv);
			var queryTypes=queryOpts[ov]["queryTypes"]||[];
			var dataQueryTypes=[];
			$.each(queryTypes,function(index,queryType){
				var typeName=Toyz4js["cfg"]["queryTypes"][queryType];
				dataQueryTypes.push({text:typeName,value:queryType});
			});
			selectQueryType.combobox("clear");
			selectQueryType.combobox("loadData",dataQueryTypes);
			selectQueryType.combobox("setValue",dataQueryTypes[0]["value"]);
		}
	 });
	 selectQueryPro.combobox("setValue",dataSelectQueryPro[0]["value"]);
	 inputQueryVaule.validatebox({
		 required:true,
		 missingMessage:"查询值不能为空"
	 });
	 var colOper={title:"操作",field:"op"};
	 var colQueryKey={title:"",checkbox:true,field:"queryKey"};
	 var colProText={title:"属性",field:"proText",align:"right",width:80};
	 var colTypeText={title:"类型",field:"typeText",align:"left",width:50};
	 var colQueryValue={title:"值",field:"queryValue",align:"left",width:200};
	 var btnRemove={iconCls:"icon-remove",text:"删除选中条件",handler:function(){
		 
		 var rows=tableQueryDatagrid.datagrid("getSelections");
		 $.each(rows,function(i,row){
			 mapQueryData[row["queryKey"]]=null;
		 });
		 var listQuery=[];
		 $.each(mapQueryData,function(key){
			 if(!mapQueryData[key])return true;
			 listQuery.push(mapQueryData[key]);
		 });
		 dataQueryGrid["rows"]=listQuery;
		 dataQueryGrid["total"]=listQuery.length;
		 tableQueryDatagrid.datagrid("loadData",dataQueryGrid);
		 tableQueryDatagrid.datagrid("clearSelections");
	 }};
	 tableQueryDatagrid.datagrid({
		 id:"queryKey"
		 ,columns:[[colQueryKey,colProText,colTypeText,colQueryValue]]
	     ,fit:true
         ,data:dataQueryGrid
         
         ,toolbar:[btnRemove]
	 });
	 
	 aAddQuery.click(function(){
		 
		
		 var proText=selectQueryPro.combobox("getText");
		 var proName=selectQueryPro.combobox("getValue");
		 var typeText=selectQueryType.combobox("getText");
		 var typeName=selectQueryType.combobox("getValue");
		 var queryValue=$("input[name=queryValue]").val();
		 //inputQueryVaule.val("");
		 var queryKey=typeName+proName;
		 mapQueryData[queryKey]={queryKey:queryKey,proText:proText,proName:proName,typeText:typeText,typeName:typeName,queryValue:queryValue};
		 
		 var listQuery=[];
		 $.each(mapQueryData,function(key,item){
			 if(item==null)return true;
			 listQuery.push(item);
		 });
		 dataQueryGrid["rows"]=listQuery;
		 dataQueryGrid["total"]=listQuery.length;
		 tableQueryDatagrid.datagrid("loadData",dataQueryGrid);
		 
	 });
	 aSearch.click(function(){
		 var parma={};
		 $.each(mapQueryData,function(key,item){
			 if(mapQueryData[key]==null) return false;
			 parma[key]=mapQueryData[key]["queryValue"];
		 });
		 var d={total:0,rows:[]};
		 $.messager.progress({msg:"数据查询中，请稍候",text:""});
		 $.post(queryUrl,parma,function(str){
			 $.messager.progress("close");
			 d=str.toJson();
			 try{
			 var total=d["total"];
			 $.messager.confirm("搜索结果","本次查询共查到"+total+"条数据，确认加载？",function(yes){
				 if(yes){
				  $(datagridRegexp).datagrid("loadData",d["rows"]);
				  $(regexpContent).dialog("close");
				 }
			 });
			 }catch(ex){
				 str.messager();
			 }
		 });
		 
	 });
	 aCancel.click(function(){
		 $(regexpContent).dialog("close");
	 });
	 
 }   //toyzQueryForm:function(opts){

});                 //jQuery.fn.entends({