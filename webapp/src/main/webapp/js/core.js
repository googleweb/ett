
//require jquery easyui

Date.prototype.format = function(format) //author: meizz 
{ 
  var o = { 
    "M+" : this.getMonth()+1, //month 
    "d+" : this.getDate(),    //day 
    "h+" : this.getHours(),   //hour 
    "m+" : this.getMinutes(), //minute 
    "s+" : this.getSeconds(), //second 
    "q+" : Math.floor((this.getMonth()+3)/3),  //quarter 
    "S" : this.getMilliseconds() //millisecond 
  } 
  if(/(y+)/.test(format)) 
	  format=format.replace(RegExp.$1, 
		                    (this.getFullYear()+"").substr(4 - RegExp.$1.length)
		                   ); 
      for(var k in o)if(new RegExp("("+ k +")").test(format)) 
      format = format.replace(RegExp.$1, 
                            RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)
                           ); 
    return format; 
} 




// 声明一个全局对象Namespace，用来注册命名空间
Class = new Object();

// 全局对象仅仅存在register函数，参数为名称空间全路径，如"Grandsoft.GEA"
Class.forName = function(fullNS)
{
    // 将命名空间切成N部分, 比如Grandsoft、GEA等
    var nsArray = fullNS.split('.');
    var sEval = "";
    var sNS = "";
    for (var i = 0; i < nsArray.length; i++)
    {
        if (i != 0) sNS += ".";
        sNS += nsArray[i];
        // 依次创建构造命名空间对象（假如不存在的话）的语句
        // 比如先创建Grandsoft，然后创建Grandsoft.GEA，依次下去
        sEval += "if (typeof(" + sNS + ") == 'undefined') " + sNS + " = new Object();"
    }
    if (sEval != "") eval(sEval);
}

Class.forName("Kia.util");

Kia.util={
   isDateFormat:function (pattern,val){
	  if(pattern.length!=val.length)return false;
		  var reg=pattern;
		  reg=reg.replace(/yyyy/,"[0-9]{4}"); 
		  reg=reg.replace(/yy/,"[0-9]{2}"); 
		  reg=reg.replace(/MM/,"((0[1-9])|1[0-2])"); 
		  reg=reg.replace(/M/,"(([1-9])|1[0-2])"); 
		  reg=reg.replace(/dd/,"((0[1-9])|([1-2][0-9])|30|31)"); 
		  reg=reg.replace(/d/,"([1-9]|[1-2][0-9]|30|31))"); 
		  reg=reg.replace(/HH/,"(([0-1][0-9])|20|21|22|23)"); 
		  reg=reg.replace(/H/,"([0-9]|1[0-9]|20|21|22|23)"); 
		  reg=reg.replace(/mm/,"([0-5][0-9])"); 
		  reg=reg.replace(/m/,"([0-9]|([1-5][0-9]))"); 
		  reg=reg.replace(/ss/,"([0-5][0-9])"); 
		  reg=reg.replace(/s/,"([0-9]|([1-5][0-9]))"); 
		  var regexp=new RegExp("^"+reg+"$"); 
		  return regexp.test(val);
}
,
parseDateTime:function (pattern,str){
	if(pattern.length!=str.length)return null;
	var yearIndex=pattern.indexOf("yyyy");
	var monthIndex=pattern.indexOf("MM");
	var dayIndex=pattern.indexOf("dd");
	var hourIndex=pattern.indexOf("HH");
	var minuteIndex=pattern.indexOf("mm");
	var secondIndex=pattern.indexOf("ss");
	var d=new Date();
	try{
	//	alert(pattern+":"+str+":"+yearIndex+":"+monthIndex+":"+dayIndex);
	if(yearIndex==-1||monthIndex==-1||dayIndex==-1)return null;
	var year=parseInt(str.substr(yearIndex,4));
	var month=parseInt(str.substr(monthIndex,2));
	var day=parseInt(str.substr(dayIndex,2));
    d.setFullYear(year,month-1,day);
	if(hourIndex!=-1){var hour=parseInt(str.substr(hourIndex,2));d.setHours(hour);}	
	if(minuteIndex!=-1){var minute=parseInt(str.substr(minute,2));d.setMinutes(minute);}
    if(secondIndex!=-1){var second=parseInt(str.substr(secondIndex,2));d.setSeconds(second);}
	return d;
	}catch(ex){return null;}
}
,	
strToJson:function(jsonStr){	  
	  return eval('('+jsonStr+')');
	}
,
handleJsonResult:function(json,handler){
	   var msg=json["msg"]||"";
	   var title=json["title"]||"操作";
	   var icon=json["icon"]||"info";
	   var action=json["action"]||"show";
	   var result=false;
	   if(action=="show"){
		   $.messager.show({title:title
			                ,msg:msg
			                ,timeout:5000
			                ,showType:"slide"
			                ,showSpeed:500
		   });
	   }else if(action=="alert"){
		   $.messager.alert(title,msg,icon,handler==null?function(){ return true;}:handler);
	   }else if(action=="confirm"){
		   $.messager.confirm(title,msg,handler==null?function(y){ return y;}:handler);
	   }else if(action=="prompt"){
		   $.messager.prompt(title,msg,handler==null?function(val){return val;}:handler);
	   }
	}

,
getIframeContext:function(src){
	return "<iframe frameborder='0' src='"+src+"' style='width:100%;height:100%;overflow:hidden;'></iframe>";
}

}

var SimpleDateFormat= function(formatString){
 this.formatString = formatString;
 this.monthNames = ["January","February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
 this.dayNames =   ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];

 this.format = function(aDate){
 var localFormatString = formatString;
 // The order is significant
 /* YYYY */  localFormatString = localFormatString.replace(/Y{3,}/g,     "\" + (aDate.getFullYear()) + \"");
 /* YY   */  localFormatString = localFormatString.replace(/Y{2}/g,      "\" + ((aDate.getFullYear()).toString().substring(2)) + \"");
 /* MMMM */  localFormatString = localFormatString.replace(/M{4,}/g,     "\" + (this.monthNames[aDate.getMonth()]) + \"");
 /* MMM  */  localFormatString = localFormatString.replace(/M{3}/g,      "\" + ((this.monthNames[aDate.getMonth()]).substring(0,3)) + \"");
 /* MM   */  localFormatString = localFormatString.replace(/M{2}/g,      "\" + (aDate.getMonth()+101).toString().substring(1) + \"");
 /* ww   */  /* don't have time to implement this today */
 /* WW   */  /* don't have time to implement this today */
 /* DD   */  /* don't have time to implement this today */
 /* dd   */  localFormatString = localFormatString.replace(/d{2}/g,      "\" + (aDate.getDate()+100).toString().substring(1) + \"");
 /* FF   */  localFormatString = localFormatString.replace(/F{2}/g,      "\" + (aDate.getDay()+100).toString().substring(1) + \"");
 /* EEEE */  localFormatString = localFormatString.replace(/E{4,}/g,     "\" + (this.dayNames[aDate.getDay()]) + \"");
 /* EEE  */  localFormatString = localFormatString.replace(/E{3}/g,      "\" + ((this.dayNames[aDate.getDay()]).substring(0,3)) + \"");
 /* EE   */  localFormatString = localFormatString.replace(/E{2}/g,      "\" + (aDate.getDay()+100).toString().substring(1) + \"");
 /* a    */  /* don't have time to implement this today */
 /* HH   */  localFormatString = localFormatString.replace(/H{2}/g,      "\" + (aDate.getHours()+100).toString().substring(1) + \"");
 /* kk   */  localFormatString = localFormatString.replace(/k{2}/g,      "\" + (aDate.getHours()+101).toString().substring(1) + \"");
 /* KK   */  /* don't have time to implement this today */
 /* hh   */  /* don't have time to implement this today */
 /* mm   */  localFormatString = localFormatString.replace(/m{2}/g,      "\" + (aDate.getMinutes()+100).toString().substring(1) + \"");
 /* ss   */  localFormatString = localFormatString.replace(/s{2}/g,      "\" + (aDate.getSeconds()+100).toString().substring(1) + \"");
 /* SS   */  localFormatString = localFormatString.replace(/S{2}/g,      "\" + (aDate.getMilliSeconds()+1000).toString().substring(1) + \"");
 /* z   */   /* don't have time to implement this today */

 localFormatString = "\"" + localFormatString + "\"";
 //prompt("localFormatString", localFormatString);
 var formatedDate = eval(localFormatString);
 return(formatedDate);
 }
}


  

 jQuery.fn.extend({

kiaLoadFields:function(){
	  $(this).find("input:enabled").each(function(){
		  if($(this).hasClass("easyui-combobox")){
			  $(this).combobox();
		  }else if($(this).hasClass("easyui-datebox")){
			  $(this).datebox();
		  }else if($(this).hasClass("easyui-numberspinner")){
			  $(this).datebox();
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

	 var thisObject=$(this);
	 //alert("kia-datebox");
	 //
	 var dbDateFomat="yyyy-MM-dd";
	 var thisDateFormat=thisObject.attr("dateFormat")||"dd/MM/yyyy";
	 var thisValue=thisObject.attr("value")||"";
	 var thisDateboxValue;
	 if(thisValue==""){
		 thisDateboxValue="";
	 }else{
		 var d=new Date(thisValue);
		 thisDateboxValue=d.format(thisDateFormat);
		 thisValue=d.format(dbDateFomat);
		 thisObject.val(d.format(thisValue));
	 }
     
	 var thisName=thisObject.attr("name")||"";
	 //alert(thisName);
	 //var dateboxId="datebox-"+thisName;
	 var thisWidth=$(this).width();
	 var dateboxObj=$("<input>").width(thisWidth); //.attr("id",dateboxId);
	 thisObject.after(dateboxObj);
	  dateboxObj.datebox({
		 value:thisDateboxValue
		 ,parser:function(str){
		    //alert("parse:"+str);
		    var d=Kia.util.parseDateTime(thisDateFormat,str);
		    return d==null?new Date():d;
		 }
		 ,formatter:function(date){
		    return date.format(thisDateFormat);
		 }
	     ,onSelect:function(date){
	    	 thisObject.val(date.format(dbDateFomat));
	     }
	 });
	 var dateCombotext= dateboxObj.next().find("input:first");
      dateCombotext.blur(function(){
    	  if($(this).val()==null||$(this).val()=="")return;
    	  //alert($(this).val());
    	  var re= Kia.util.isDateFormat(thisDateFormat,$(this).val());
    	  if(re){
    		 var cal=dateboxObj.datebox("calendar");
    		 var opts=cal.calendar("options");
    		 var d=opts["current"];
    		 thisObject.val(d.format(dbDateFomat));
    	  }else{
    		  $.messager.show({title:"输入错误",
    			               msg:"日期格式必须符合"+thisDateFormat}
    		  );
    		  dateboxObj.datebox("setValue",thisDateboxValue);
    		  thisObject.val(thisValue);
    	  }
    	  //if(!isDbDateFormat(thisObject.val())){
    		//  $("#"+dateboxId).datebox("setValue","");
    		  //$.messager.alert("输入错误","日期格式");
    	  //}
      });
 }   //kiaDateBox:function(){
 
 }); //jQuery.fn.entends({
 


 

 $.extend($.fn.validatebox.defaults.rules, {

    minLength: {
                validator: function(value, param){
                              return value.length >= param[0];},
                message: 'Please enter at least {0} characters.'
    }  //minLength: {
   ,datetime:{
	            validator:function(value,param){
	                      var pattern=param[0]||"yyyy/MM/dd";
	                      return Kia.util.isDateFormat(pattern,value);
	            }
                ,message: '日期格式必须符合 {0}'
   }

});   //$.extend($.fn.validatebox.defaults.rules, {
 
 $.fn.datebox.defaults.formatter = function(date) {
	 if(date)
	 {return date.format("yyyy-MM-dd");}
	 else{
		 return "";
	 }
 }
 
 $.fn.datebox.defaults.parser = function(s) { 
	 if(s){
		 //alert(s);
		 var a = s.split('-');
		 try{
		 var d = new Date(parseInt(a[0]), parseInt(a[1]) - 1, parseInt(a[2]));
		 return d;
		 }catch(ex){
             return new Date(s);		
		 }

	 }else {
		 return new Date();
	 }
 }
 
 
 



 
