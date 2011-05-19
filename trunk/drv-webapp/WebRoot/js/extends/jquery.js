jQuery.fn.extend({

kiaLoadFields:function(){
	  $(this).find("input:enabled").each(function(){
		  if($(this).hasClass("easyui-combobox")){
			  $(this).combobox();
		  }else if($(this).hasClass("kia-intbox")){
			  $(this).kiaIntbox();
		  }else if($(this).hasClass("kia-doublebox")){
			  $(this).kiaDoublebox();
		  }else if($(this).hasClass("kia-combogrid")){
	  	      $(this).kiaCombogrid();
		  }else if($(this).hasClass("kia-datebox")){
			  $(this).kiaDatebox();
		  }
	  });
	  return true;
	  
 }
 
 ,kiaIframe:function(url){
	  $(this).html("<iframe scrolling='no' frameborder='0' src='"+url+"' style='width:100%;height:100%;overflow:hidden;'></iframe>");
 }
 
 ,kiaAuthFields:function(authJson){
	     var authObject=$(this);
	     //var authUrl=url||authObject.attr("authUrl")||null;
         if(!authJson) return false;	     
	    	 authObject.find("input").each(function(){
		    	    var fieldName=$(this).attr("name")||null;
			    	    if(fieldName){
			    	    var authValue=authJson[fieldName];
			    	    switch(authValue){
			    	      case 0:$(this).addClass('invisible').attr("disabled","disabled");break;
			    	      case 1:$(this).addClass('readonly').attr("readonly","true");break;
			    	      default:$(this).addClass('editable');
			    	    }
		    	    }
	    	 });
	       return true;
 }
 

 
 ,kiaCombogrid:function(){
	   
		              var thisObj=$(this);
		              var thisName=thisObj.attr('name');
		              var thisValueField=thisObj.attr("valueField")||"id";
		              var thisTextField=thisObj.attr("textField")||"name";
		              var thisUrl=thisObj.attr("url")||"";
		              var thisRequired=thisObj.attr("required")||true; 
		              var selecterWidth=thisObj.attr("selecterWidth")||60; 
		              var thisDisabled=thisObj.attr("disabled");
		              var thisDataClass=thisObj.attr("dataClass")||"";
		              var thisWidth=thisObj.width();
		              var thisHeight=thisObj.height();
		              thisObj.width(thisWidth-selecterWidth);
		              var thisValue=thisObj.val()||"";

		              //var selecterId="selecter-"+thisName;
		              //alert(_comboData);
		              var selecterObj=$("<input>").width(selecterWidth); //.attr('id',selecterId);
				      thisObj.before(selecterObj);
				      //var selecterObj=$("#"+selecterId);
				       thisObj.combobox({
				    	   hasDownArrow:false
				    	   ,editable:false
				    	   ,required:thisRequired
				    	   ,textField:thisTextField
				    	   ,valueField:thisValueField
		                  });
				       selecterObj.combogrid({
				    	    panelWidth:thisWidth
				    	   ,disabled:thisDisabled
				    	   ,idField:thisValueField
				    	   ,textField:thisValueField
				    	   ,value:thisValue
				    	   ,columns:[[{field:thisValueField,width:selecterWidth},
                                      {field:thisTextField,width:thisWidth}]]
                           ,onChange:function(nv,ov){
				    	                if(!nv||!ov||nv==ov)return;
                                        thisObj.combobox("select",nv);
                                       	}
				    	  ,onSelect:function(index,r){
				        	             thisObj.combobox("select",r[thisValueField]);
				                    }
				    	  }); //$("#"+selecterId).combogrid({
				      //$.getJSON(thisUrl,function(gridData){
				       
				          var gridData=_comboData[thisDataClass];
				         if(gridData){
				           var grid=selecterObj.combogrid('grid');
				    	   grid.datagrid("loadData",gridData);
				    	   thisObj.combobox('loadData',gridData["rows"]);
				         }

				      //});  //$.getJSON(thisUrl,function(grid){
	 }  // kiaComboBox:function(){
 
 ,kiaDatebox:function(){
	 try{
	 var thisObject=$(this);
	 var thisValue=thisObject.attr("value")||"";
	 var formatValue="";
	 if(thisValue!=""){
		 var d=new Date(thisValue);
		 formatValue=d.format(Kia.custom.setting.dbDateFormat);
		 thisObject.val(formatValue);
		 //alert(formatValue);
	 }
	 thisObject.datebox({
		 onChange:Kia.easyui.datebox.onChangeHandler
		 ,onSelect:function(date){
	    	 thisObject.datebox("setValue",date.format(Kia.custom.setting.dbDateFormat));  
	 }
	 });
	 var dateCombotext= thisObject.next().find("input:first");
      dateCombotext.blur(function(){
    	  if($(this).val()==null||$(this).val()=="")return;
    	  //alert($(this).val());
    	  var re= Kia.util.isDateFormat(Kia.custom.setting.dbDateFormat,$(this).val());
    	  if(re){
    		 var cal=dateboxObj.datebox("calendar");
    		 var opts=cal.calendar("options");
    		 var d=opts["current"];
    		 //thisObject.val(d.format(Kia.custom.dbDateFormat));
    		 thisObject.datebox("setValue",d.format(Kia.custom.setting.dbDateFormat));
    	  }else{
    		  $.messager.show({title:"输入错误",
    			               msg:"日期格式必须符合"+Kia.custom.setting.dbDateFormat}
    		  );
    		  //dateboxObj.datebox("setValue",thisDateboxValue);
    		  //thisObject.val(formatValue);
    		  thisObject.datebox("setValue",formatValue);
    	  }
    	  //if(!isDbDateFormat(thisObject.val())){
    		//  $("#"+dateboxId).datebox("setValue","");
    		  //$.messager.alert("输入错误","日期格式");
    	  //}
      });
      }catch (ex){alert(ex);}
 }
 
 ,kiaDoublebox:function(){
	 $(this).numberbox({
		     increment:10
            ,precision:Kia.custom.setting.precision
	 });
 }
 
  ,kiaIntbox:function(){
	 $(this).numberbox({
		     increment:10
            ,precision:0
	 });
 }
 
 }); //jQuery.fn.entends({