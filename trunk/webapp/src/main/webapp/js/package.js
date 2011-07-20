
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
 
 
 



 
Class.forName("Kia.custom.setting");

Kia.custom.setting={
	dbDateFormat:"yyyy-MM-dd"
    ,precision:2
}
Array.prototype.getUnionStr=function(filed,split){
	//if(!(filed instanceof String))return "";
	try{
	//if(!filed.isString())return "";
	var unionStr=new String();
	if(!split){
		split=",";
	}
	for(var i=0;i<this.length;i++){
		var tempVal=this[i][filed];
		//if(!tempVal.isString())continue;
		unionStr+=tempVal+split;
	}
		unionStr=unionStr.substr(0,unionStr.lastIndexOf(split));
	return unionStr;
	}catch(ex){alert(ex);}
}

String.prototype.toJson=function(){
	try{
		var json=eval("("+this.toString()+")");
		return json;
	}catch(ex){
		return {};
	}
};


String.prototype.messager=function(handler){
    try{
      
       var json=this.toJson();
       var msg=json["msg"]||"";
	   var title=json["title"]||"操作结果";
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
    }catch(ex){
    	alert(ex);
    	$.messager.alert("Format error","The result is not a Messager format");
    }	 
};


//判断字符串是否只包含英文字母
String.prototype.isAlph=function(){
	
	return (/^[A-Za-z]+$/.test(this));
	
};

//判断字符串是否只包含英文字母和数字
String.prototype.isAlphOrNum=function(){
	return (/^[A-Za-z0-9]+$/.test(this));
};

//判断字符串是否不包含任何标点符号
String.prototype.isNotSymbol=function(){
	return !(/[^0-9A-z\u4e00-\u9fa5]/.test(this));

};


//判断字符是否符合身份证格式
String.prototype.isIdNoFormat=function(){
	return (/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(this));
};

//从身份证里提出出日期
String.prototype.getIdNoBornDate=function(){
	var len=this.length;
	if(len==15){
		var year="19"+this.slice(6,8);
		var month=this.slice(8,10);
		var day=this.slice(10,12);
		return new Date(year+"/"+month+"/"+day);
	}
	
	if(len==18){
		var year=this.slice(6,10);
		var month=this.slice(10,12);
		var day=this.slice(12,14);
		return new Date(year+"/"+month+"/"+day);
	}
};
//电话
String.prototype.isPhoneFormat=function(){
	return (/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/).test(this);
};
//手机号码
String.prototype.isMobileFormat=function(){
	return (/^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}|15[89]\d{8}/).test(this);


};
//邮政编码 
String.prototype.isZipCode=function(){
	return (/[1-9]\d{5}(?!\d)/.test(this));
};

//中文
String.prototype.isChinese=function(){
	return (/[\u4e00-\u9fff]+/.test(this));
};
//五位的数字
String.prototype.isFive=function(){
	return (/^\d{5,5}$/.test(this));
};
//车牌号
String.prototype.carNo=function(){
	return (/\d{5}$|[A-Z]{1}\d{4}|\d{1}[A-Z]{1}\d{3}|[A-Z]{2}\d{3}$/.test(this));
};
//IP地址
String.prototype.ip=function(){
	return (/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/.test(this));
}
;/*!
 * "f" is for Format & WHAT THE diff?? v0.5.0
 *
 * Copyright (c) 2009 Joshua Faulkenberry
 * Dual licensed under the MIT and GPL licenses.
 * http://docs.jquery.com/License
 *
 * Date: 2009-03-20 22:15:23 -0700 (Fri, 20 Mar 2009)
 * Revision: 6
 */

window.Date.prototype.format = function(format) //author: meizz 
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



/************** "f" is for Format ***************
 * Outputs a JavaScript Date Object in various
 * customizable formats
 **********************************************
 */
window.Date.prototype.f = function(format) {
   if(format == "@") {
      return this.getTime();
   }
   else if(format == "REL") {
   	var diff = (((new Date()).getTime() - this.getTime()) / 1000), day_diff = Math.floor(diff / 86400);
   	return day_diff == 0 && (
 			diff > -60 && "right now" ||
			diff > -120 && "1 minute from now" ||
			diff > -3600 && -(Math.floor(diff / 60)) + " minutes from now" ||
			diff > -7200 && "1 hour ago" ||
			diff > -86400 && -(Math.floor(diff / 3600)) + " hours from now" ||

			diff < 60 && "just now" ||
			diff < 120 && "1 minute ago" ||
			diff < 3600 && Math.floor( diff / 60 ) + " minutes ago" ||
			diff < 7200 && "1 hour ago" ||
			diff < 86400 && Math.floor( diff / 3600 ) + " hours ago") ||

			day_diff == 0 && "Tomorrow" ||
			day_diff > -7 && -(day_diff) + " days from now" ||
			-(Math.ceil( day_diff / 7 )) == 1 && "1 week from now" ||
			day_diff > -78 && -(Math.ceil( day_diff / 7 )) + " weeks from now" ||
			day_diff > -730 && -(Math.ceil( day_diff / 30 )) + " months from now" ||
			day_diff <= -730 && -(Math.ceil( day_diff / 365 )) + " years from now" ||
	
			day_diff == 1 && "Yesterday" ||
			day_diff < 7 && day_diff + " days ago" ||
			(Math.ceil( day_diff / 7 )) == 1 && "1 week ago" ||
			day_diff < 78 && Math.ceil( day_diff / 7 ) + " weeks ago" ||
			day_diff < 730 && Math.ceil( day_diff / 30 ) + " months ago" ||
			Math.ceil( day_diff / 365 ) + " years ago";
   }
   var MONTH_NAMES = ['January','February','March','April','May','June','July','August','September','October','November','December'],
       DAY_NAMES = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'],
       LZ = function(x) {return(x<0||x>9?"":"0")+x},
       date = this,
	    format = format + "",
	    result = "",
	    i_format = 0,
	    c = "",
	    token = "",
	    y = date.getYear() + "",
	    M = date.getMonth() + 1,
	    d = date.getDate(),
	    E = date.getDay(),
	    H = date.getHours(),
	    m = date.getMinutes(),
	    s = date.getSeconds(),   
	    yyyy,yy,MMM,MM,dd,hh,h,mm,ss,ampm,HH,H,KK,K,kk,k,
	    value = new Object();
	// Convert real date parts into formatted versions
	if (y.length < 4) {y=""+(y-0+1900);}
	value["y"]=""+y;
	value["yyyy"]=y;
	value["yy"]=y.substr(2,4);
	value["M"]=M;
	value["MM"]=LZ(M);
	value["MMM"]=MONTH_NAMES[M-1];
	value["NNN"]=MONTH_NAMES[M-1].substr(0,3);
	value["N"]=MONTH_NAMES[M-1].substr(0,1);
	value["d"]=d;
	value["dd"]=LZ(d);
	value["e"]=DAY_NAMES[E].substr(0,1);
	value["ee"]=DAY_NAMES[E].substr(0,2);
	value["E"]=DAY_NAMES[E].substr(0,3);
	value["EE"]=DAY_NAMES[E];
	value["H"]=H;
	value["HH"]=LZ(H);
	if (H==0){value["h"]=12;}
	else if (H>12){value["h"]=H-12;}
	else {value["h"]=H;}
	value["hh"]=LZ(value["h"]);
	if (H>11){value["K"]=H-12;} else {value["K"]=H;}
	value["k"]=H+1;
	value["KK"]=LZ(value["K"]);
	value["kk"]=LZ(value["k"]);
	if (H > 11) { value["a"]="PM"; }
	else { value["a"]="AM"; }
	value["m"]=m;
	value["mm"]=LZ(m);
	value["s"]=s;
	value["ss"]=LZ(s);
	while (i_format < format.length) {
		c=format.charAt(i_format);
		token="";
		while ((format.charAt(i_format)==c) && (i_format < format.length)) {
			token += format.charAt(i_format++);
			}
		if (value[token] != null) { result=result + value[token]; }
		else { result=result + token; }
	}
	return result;
}

/************* WHAT THE diff?? *************
 * Calculates the exact difference between
 * any two dates and outputs the results in
 * a customizable incremental breakdown
 *******************************************
 */
window.Date.prototype.diff = function(date, breakdown) {
   var options = {};
   if( typeof date ==  "string" ) {
      if((new Date(date)) != "Invalid Date" && (new Date(date)) != "NaN") {
         date = new Date(date);
      }
      else {
         breakdown = date;
         date = new Date();
      }
   }
   else if( typeof date ==  "object" && !date.getTime) {
      options = date;
      date = new Date();
   }
   if( typeof breakdown ==  "object") {
      options = breakdown;
      breakdown = options.breakdown || "*";
   }
	options.labels = options.labels || {};
   if(breakdown) {
      function processTime(trg) {
         var result = null;
         if(diff >= tl[trg]) {
            if(trg == "Y" || trg == "D" || trg == "C" || trg == "T") {
               //Catch leap years
               for(var yr = (min);yr.getFullYear() <= max.getFullYear();yr.setYear(yr.getFullYear()+1)) {
                  if(yr.isLeapYear()) {
                     diff -= tl["d"];
                  }
               }
            }
            if(diff >= tl[trg]) {
               result = Math.floor(diff/tl[trg]) + " " + (Math.floor(diff/tl[trg]) == 1 && names[trg][0] || names[trg][1]);
               diff = diff%tl[trg];
            }
         }
         eval('breakdown = breakdown.replace(/'+trg+'/g, "")');
         return result;
      }

      var min   = date <= this && date || date > this && this,
         max    = date > this && date || date <= this && this,
         diff   = (max.getTime() - min.getTime()),
         tl     = {
            T : 1000*60*60*24*365*100*10,
            C : 1000*60*60*24*365*100,
            D : 1000*60*60*24*365*10,
            Y : 1000*60*60*24*365,
            M : 1000*60*60*24*28,
            W : 1000*60*60*24*7,
            d : 1000*60*60*24,
            H : 1000*60*60,
            m : 1000*60,
            S : 1000,
            N : 1
         },
         names = {
            T : options.labels.T || ["Mellinium","Mellinia"],
            C : options.labels.C || ["Century","Centuries"],
            D : options.labels.D || ["Decade","Decades"],
            Y : options.labels.Y || ["Year","Years"],
            M : options.labels.M || ["Month","Months"],
            W : options.labels.W || ["Week","Weeks"],
            d : options.labels.d || ["Day","Days"],
            H : options.labels.H || ["Hour","Hours"],
            m : options.labels.m || ["Minute","Minutes"],
            S : options.labels.S || ["Second","Seconds"],
            N : options.labels.N || ["Millisecond","Milliseconds"]
         };
      if(options.len) {
         for(var x in names) {
            names[x] = names[x].substr(0,options.len);
         }
      }

      //Catch daylight savings year by year
      var testDt = new Date(min.toString());
      if(max.getFullYear() - testDt.getFullYear() > 1) {
         testDt.setYear(max.getFullYear()-1);
      }
      while(testDt < max) {
         if(testDt.isDayLightSavingsDay() && testDt.getMonth() < 5) {
            diff += tl["H"];
         }
         else if(testDt.isDayLightSavingsDay()) {
            diff -= tl["H"];
         }
         testDt.setDate(testDt.getDate()+1);
      }
      //Catch daylight savings for when the max date is before the spring change or after the fall change
      if(((max.getMonth() == max.getDayLightSavingsDays()[0].getMonth() && max.getDate() < max.getDayLightSavingsDays()[0].getDate()) || max.getMonth() < max.getDayLightSavingsDays()[0].getMonth()) && max.getMonth() == min.getMonth() ) {
         diff += tl["H"];
      }
      else if(((min.getMonth() == min.getDayLightSavingsDays()[1].getMonth() && min.getDate() > min.getDayLightSavingsDays()[1].getDate()) || min.getMonth() < min.getDayLightSavingsDays()[1].getMonth()) && min.getMonth() == min.getMonth() ) {
         diff -= tl["H"];
      }
      var result = [], out;
      while(diff>0) {
         if(breakdown == "*") {
           breakdown = "TCDYMWdHmSN";
         }
         else if(breakdown.indexOf("T") > -1) {
           if(out = processTime("T")) {result[result.length] = out};
         }
         else if(breakdown.indexOf("C") > -1) {
           if(out = processTime("C")) {result[result.length] = out};
         }
         else if(breakdown.indexOf("D") > -1) {
           if(out = processTime("D")) {result[result.length] = out};
         }
         else if(breakdown.indexOf("Y") > -1) {
           if(out = processTime("Y")) {result[result.length] = out};
         }
         else if(breakdown.indexOf("M") > -1) {
           if(diff >= tl["M"]) {
              var cur = (new Date(max.getTime() - diff));
              var monthCount = 0;
              var lastVal = 0;
              //Step through each year
              for(var yr = cur.getFullYear();yr<=max.getFullYear();yr++) {
                 //Step through each month
                 while(cur.getFullYear() == yr) {
                    lastVal = cur.getTime();
                    cur.setMonth(cur.getMonth()+1);
                    if( diff - (cur.getTime() - lastVal) >= 0 ) {
                       monthCount++;
                       diff -= (cur.getTime() - lastVal);
                    }
                    if(yr == max.getFullYear() && cur.getMonth() == max.getMonth()) {
                       break;
                    }
                 }
              }
              if(monthCount) {
                 result[result.length] = monthCount + " " + (monthCount == 1 && names["M"][0] || names["M"][1]);
              }
           }
           breakdown = breakdown.replace(/M/g, "");
         }
         else if(breakdown.indexOf("W") > -1) {
           if(out = processTime("W")) {result[result.length] = out};
         }
         else if(breakdown.indexOf("d") > -1) {
           if(out = processTime("d")) {result[result.length] = out};
         }
         else if(breakdown.indexOf("H") > -1) {
           if(out = processTime("H")) {result[result.length] = out};
         }
         else if(breakdown.indexOf("m") > -1) {
           if(out = processTime("m")) {result[result.length] = out};
         }
         else if(breakdown.indexOf("S") > -1) {
           if(out = processTime("S")) {result[result.length] = out};
         }
         else if(breakdown.indexOf("N") > -1) {
           if(out = processTime("N")) {result[result.length] = out};
         }
         else {
           diff = 0;
         }
      }
      options.divider = options.divider || ", ";
      if(options.divider == ", " && result.length > 1 && !options.hideAnd) {
         result[result.length-1] = "and " + result[result.length-1];
      }
      diff = result.join(options.divider);
   }
   if(diff == "") {
      diff = "Same";
   }
   if(options.lc) {
      diff = diff.toLowerCase();
   }
   return diff;
}

/********* Date.getDaysInMonth() *************
 * Returns the number of days in the selected
 * month
 *********************************************
 */
window.Date.prototype.getDaysInMonth = function() {
   return [31,28,31,30,31,30,31,31,30,31,30,31][this.getMonth()];
};

/************* Date.isLeapYear() ***************
 * Returns true if the selected year is a leap
 * year
 ***********************************************
 */
window.Date.prototype.isLeapYear = function() {
   return (new Date(this.getFullYear(),2-1,29)).getDate() == 29;
};

/******* Date.getDayLightSavingsDays() *********
 * Returns an array containing date objects for
 * the two daylight savings change days within
 * the selected year
 ***********************************************
 */
window.Date.prototype.getDayLightSavingsDays = function() {
   var result = [];
   var day1 = new Date("03/07/"+this.getFullYear());
   var day2 = new Date("03/06/"+this.getFullYear());
   while(day1.getMonth() < 3 || (day1.getMonth() == 3  && day1.getDate() < 16)) {
      if((day1.getTime() - day2.getTime())/1000/60/60 != 24) {
         result[result.length] = new Date(day2.getTime());
      }
      day1.setDate(day1.getDate()+1);
      day2.setDate(day2.getDate()+1);
   }
   var day1 = new Date("10/31/"+this.getFullYear());
   var day2 = new Date("10/30/"+this.getFullYear());
   while(day1.getMonth() < 11 || (day1.getMonth() == 10 && day1.getDate() < 9)) {
      if((day1.getTime() - day2.getTime())/1000/60/60 != 24) {
         result[result.length] = new Date(day2.getTime());
      }
      day1.setDate(day1.getDate()+1);
      day2.setDate(day2.getDate()+1);
   }
   return result;
};

/******** Date.isDayLightSavingsDay() **********
 * Returns true if the selected day is a
 * daylight savings change day
 ***********************************************
 */
window.Date.prototype.isDayLightSavingsDay = function() {
   var comp = new Date(this.getTime());
   comp.setDate(comp.getDate()+1);
   return (comp.getTime() - this.getTime())/1000/60/60 != 24;
};  
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
	  $(this).html("<iframe scrolling='no' frameborder='0' src='"+url+"' style='width:99%;height:99%;overflow:hidden;'></iframe>");
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
 

 
 ,kiaCombogrid:function(opts){
	   
		              var thisObj=$(this);
		              var thisName=thisObj.attr('name');
		              var thisValueField=thisObj.attr("valueField")||"Id";
		              var thisTextField=thisObj.attr("textField")||"Name";
		              var thisUrl=thisObj.attr("url")||"";
		              var thisRequired=thisObj.attr("required")||true; 
		              var selecterWidth=thisObj.attr("selecterWidth")||80; 
		              var thisDisabled=thisObj.attr("disabled");
		              var thisDataEval=thisObj.attr("dataEval")||"";
		              
		              if(opts){
		                  thisValueField=opts["valueField"]||"Id";
		                  thisTextField=opts["textField"]||"Name";
		                  thisUrl=opts["url"]||"";
		                  thisRequired=opts["required"]||true; 
		                  selecterWidth=opts["selecterWidth"]||80; 
		                  thisDisabled=opts["disabled"];
		                  thisDataEval=opts["dataEval"]||"";
		              }
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
				    	  }); 
				       
				       var gridData=eval(thisDataEval);
			
				       if(gridData){
					          // alert(gridData["total"]);
					           var grid=selecterObj.combogrid('grid');
					    	   grid.datagrid("loadData",gridData);
					    	   thisObj.combobox('loadData',gridData["rows"]);
				       }else if(thisUrl!=""){
				    	   $.getJSON(thisUrl,function(gridData){
				    		   grid.datagrid("loadData",gridData);
					    	   thisObj.combobox('loadData',gridData["rows"]);
				    	   });
				       }

				      //});  //$.getJSON(thisUrl,function(grid){
	 }  // kiaComboBox:function(){
 
 ,kiaDatebox2:function(){
	 try{
	 var thisObject=$(this);
	 var thisValue=thisObject.attr("value")||"";
	 var formatValue="";
	 if(thisValue!=""){
		 //var d=new Date(thisValue);
		 //formatValue=d.format(Kia.custom.setting.dbDateFormat);
		 var d=Date.parse(thisValue);
		 formatValue=d.toString(Kia.custom.setting.dbDateFormat);
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
 ,kiaDatebox:function(){
	
	 var thisObject=$(this);
	 var thisValue=thisObject.attr("value")||"";
	 var formatValue="";
	 if(thisValue!=""){
		 try{
		 //var d=Date.parse(thisValue,"%a %h %d %T %z %G");
		 var d=new Date(thisValue);
		 formatValue=d.toString(Kia.custom.setting.dbDateFormat);
		 thisObject.val(formatValue);
		 }catch(ex){alert(ex);}
	 }else{
		 thisObject.val("");
	 }
	 thisObject.datebox({
		 validType:"date['yyyy-MM-dd']"
	 });
 }
 ,kiaDoublebox:function(){
	 $(this).numberbox({
		     increment:10
            ,precision:Kia.setting.precision
	 });
 }
 
  ,kiaIntbox:function(){
	 $(this).numberbox({
		     increment:10
            ,precision:0
	 });
 }
 
 ,kiaCrudForm:function(opts){
	try{
	var prefix=opts["prefix"]||"";
	var colNum=opts["colNum"]||2;
	var editors=opts["editors"]||[];
	var urlSave=opts["urlSave"]||"";
	var urlRemove=opts["urlRemove"]||"";
	var data=opts["data"]||{};
	var objDiv=$("<div></div>");
	objDiv
	//.css("width","100%")
	//.css("height","100%")
	.css("overflow","hidden")
	;
	var objForm=$("<form method='post'></form>");
	var objTable=$("<table cellspacing='0' ></table>");
	objTable.addClass("editTable");
	objTable.css("table-layout","auto");
	
	$.each(data,function(dataName,dataValue){
		var hidden=$("<input type=\"hidden\" />")
		hidden.attr("name",prefix+dataName).attr("value",dataValue);
		objForm.append(hidden);
		
	});
	
	var tr;
	$.each(editors,function(index,editor){
		
		if(index%colNum==0){
			tr=$("<tr></tr>");
		}
		
		var inputName=editor["field"]||"";
		var inputTitle=editor["title"]||"";
		var pattern="input[name='"+prefix+inputName+"']";
		objForm.find("input").remove(pattern);
		var td=$("<td>&nbsp;</td>");
		var th=$("<th>&nbsp;</th>");
		var inputEditor=editor["editor"]||{type:"text"};
		var editorType=inputEditor["type"];
        var editorOpts=inputEditor["options"]||{};
		var inputObj;
		if(editorType=="textarea"){
			inputObj=$("<textarea rows='3'></textarea>");
			inputObj.html(data[inputName]);
		}else if(editorType=="checkbox"){
			inputObj=$("<input type='checkbox' value='Y' />");
		}else{
			inputObj=$("<input type='text' />");
			inputObj.val(data[inputName]);
		}
	    
	    inputObj.css("width","90%").attr("name",prefix+inputName);
		var span=$("<span></span>");
		span.html(inputTitle);
		//td.html(data[inputName]);
		td.append(inputObj);
		th.append(span).append(":");
		tr.append(th);
		tr.append(td);
		if(index%colNum==colNum-1||index==editors.length-1){
		    objTable.append(tr);
		}
        
		switch(editorType){

		  case "validatebox":inputObj.validatebox(editorOpts);break;
		  case "datebox":inputObj.datebox(editorOpts);break;
		  case "numberbox":inputObj.numberspinner(editorOpts);break;
		  case "combobox":inputObj.combobox(editorOpts);break;
		  case "combotree":inputObj.combotree(editorOpts);break;
		  default:inputObj.validatebox(editorOpts);break;
		}
		
	});
 
	var trOpera=$("<tr></tr>");
	var tdOpera=$("<th></th>");
	tdOpera.css("padding-right","3%");
	trOpera.append(tdOpera);
	tdOpera.attr("colspan",colNum*2);
	var aSave=$("<a></a>");
	var aClear=$("<a></a>");
	tdOpera.append(aSave);
	tdOpera.append(aClear);
    aSave.linkbutton({
    	text:"保存"
    	,iconCls:"icon-save"
    });
    aClear.linkbutton({
    	text:"清空"
    	,iconCls:"icon-cancel"
    });
    aSave.click(function(){
    	$.messager.confirm("操作提示","确认保存数据？",function(yes){if(yes){
    		
    	   objForm.form("submit",{
    		   url:urlSave
    		   ,onSubmit:function(){return $(this).form("validate");}
    	       ,success:function(str){ str.messager(); }
    	   });
    	  }
    	});  //$.messager.alert
    	
    });
    aClear.click(function(){objForm.form("clear");});
	objTable.append(trOpera);
    objForm.append(objTable);
	objDiv.append(objForm);
	$(this).html(objDiv);
	
	}catch(ex){alert(ex);}
 } 
	
 
 ,kiaUploadForm:function(opts){
	     if(!opts){
	    	 opts={};
	     }
    	 var uploadUrl=opts["uploadUrl"]||"#";
    	 var inputName=opts["inputName"]||"file";
    	 var muti=opts["muti"]||false;
    	 var div=$("<div></div>");
    	 var table=$("<table></table>");
    	 var ol=$("<ol type='1'></ol>");
    	 var span=$("<span></span>");
    	 var form=$("<form method='post' enctype='multipart/form-data'></form>");
    	 form.attr("action",uploadUrl);
    	 var aNew=$("<a></a>");
    	 var aSubmit=$("<a></a>");
    	 aNew.linkbutton({
    		  text:"新增"
    		  ,iconCls:"icon-add"
    	 });
    	 aSubmit.linkbutton({
    		  text:"提交"
    		  ,iconCls:"icon-save"
    	 });
    	 aNew.click(function(){
    		    var li=$("<li></li>");
    		    var inputFile=$("<input type='file' />");
    		    inputFile.attr("name",inputName);
    		    var btnRemove=$("<button type='button'>删除</button>");
    		    btnRemove.click(function(){
    		    	li.remove();
    		    });
    		    li.append(inputFile).append("&nbsp;&nbsp;").append(btnRemove);
    		    ol.append(li);
    	 });
    	 
    	 aSubmit.click(function(){
    		 form.form("submit");
    	 });
    	 
    	 //var btns=[];
    	 
    	 if(muti){
    		 //btns=[btnNew,btnUpload];
    		 span.append(aNew);
    	 }
    	 span.append(aSubmit);
    	 var li=$("<li></li>");
    	 var inputFile=$("<input type='file' />");
    	 inputFile.attr("name",inputName);
    	 li.append(inputFile);
    	 ol.append(li);
    	 div.css("padding","1%");
    	 span.css("width","100%").css("text-align","right").css("padding-right","5%");
    	 form.append(ol);
    	 form.append(span);
    	 div.append(form);
         $(this).html(div);
}
  
 }); //jQuery.fn.entends({Class.forName("Kia.easyui.datebox");

Kia.easyui.datebox={
	onChangeHandler:function(nv,ov){
	  if(ov.length>nv.length)return;
	  var newValue="";
	  var checkpoints=[0,4,7,10];
      for(var i=1;i<checkpoints.length;i++){
    	  var cp=checkpoints[i];
    	  if(nv.length!=cp)continue;
    	  var pattern=Kia.custom.setting.dbDateFormat.substr(0,cp);
    	  if(Kia.util.isDateFormat(pattern,nv)){
    		  if(cp!=10){newValue=nv+"-";} 
    	  }else{
    		  var precp=checkpoints[i-1];
    		  newValue=nv.substr(0,precp+1);
    	  }
    	  $(this).datebox("setValue",newValue);
    	  break;
      } //alert(newValue);

	}
}

$.extend($.fn.validatebox.defaults.rules, {

    minLength: {
                validator: function(value, param){
                              return value.length >= param[0];},
                message: 'Please enter at least {0} characters.'
    }  //minLength: {
   ,datetime:{
	            validator:function(value,param){
	                      var pattern=param[0]||Kia.custom.setting.dbDateFormat;
	                      return Kia.util.isDateFormat(pattern,value);
	            }
                ,message: '日期格式必须符合 {0}'
   }
   ,idCard:{
	   	        validator:function(value,param){
	                   return value.isIdNoFormat(); 
	            }
                ,message: '身份证格式错误'
   }
   ,zip:{
	   	        validator:function(value,param){
	                   return value.isZipCode(); 
	            }
                ,message: '邮政编码格式错误'
   }
   ,phone:{
	   	        validator:function(value,param){
	                   return value.isPhoneFormat(); 
	            }
                ,message: '电话号码格式错误'
   }
    ,mobile:{
	   	        validator:function(value,param){
	                   return value.isMobileFormat(); 
	            }
                ,message: '手机号码格式错误'
   }
      ,Chinese:{
	   	        validator:function(value,param){
	                   return value.isChinese(); 
	            }
                ,message: '只能是中文'
   }
    ,five:{
	   	      validator:function(value,param){
	                   return value.isFive(); 
	            }
                ,message: '输入格式错误'
   }
     ,carno:{
	   	      validator:function(value,param){
	                   return value.carNo(); 
	            }
                ,message: '车牌输入格式错误'
   }
     ,ip:{
	   	      validator:function(value,param){
	                   return value.ip(); 
	            }
                ,message: 'IP输入格式错误'
   }

});   //$.extend($.fn.validatebox.defaults.rules, {
 
 $.fn.datebox.defaults.formatter = function(fdate) {
	 //alert("fdate:"+fdate);
	 if(fdate)
	 {return fdate.format(Kia.custom.setting.dbDateFormat);}
	 else{
		 return "";
	 }
 }
 
 $.fn.datebox.defaults.parser = function(s) { 
	 if(s&&Kia.util.isDateFormat(Kia.custom.setting.dbDateFormat,s)){
         return Kia.util.parseDateTime(Kia.custom.setting.dbDateFormat,s);
	 }else {
		 return new Date();
	 }
 }
 
 
  $.fn.panel.defaults.onMove=function(left,top){
 	     if(left<0){
            $(this).panel("move",{left:10});
    	 }
    	 if(top<0){
    		$(this).panel("move",{top:10});
    	 }
    	 var right=left+$(this).width();
    	 var buttom=top+$(this).height();
    	 var wiw=parseInt(window.innerWidth);
    	 var wih=parseInt(window.innerHeight);
    	 if(right>wiw){  
    		 var r=wiw-$(this).width()-30;
    		 $(this).panel("move",{left:r});
    	 }
    	 if(buttom>wih){  
    		  var b=wih-$(this).height()-50;
    		 $(this).panel("move",{top:b});
    	 }
 }
  
 $.fn.window.defaults.onMove= $.fn.panel.defaults.onMove;
 $.fn.dialog.defaults.onMove= $.fn.panel.defaults.onMove;
 
 $.fn.window.defaults.shadow=false;

 $.fn.form.defaults.success=function(str){str.messager(null);};
 $.fn.form.defaults.onSubmit=function(){ return $(this).form("validate"); };
 $.fn.form.defaults.onLoadError=function(){
	 $.messager.alert("Error","Can't access to the remote site.","error");
 };
 
 
  $.fn.datagrid.defaults.fit=true;
 $.fn.datagrid.defaults.pagination=true;
 $.fn.datagrid.defaults.nowrap=false;
 $.fn.datagrid.defaults.idField="Id";
 $.fn.datagrid.defaults.rownumbers=true;
 $.fn.datagrid.defaults.pageSize=20;
 $.fn.datagrid.defaults.groupFormatter=function(value,rows){return value + ' - 共' + rows.length + ' 条';};/**
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
	this._urlExportExcel=opts["urlExportExcel"]||"";
	this._regexp=opts["regexp"]||"";
    this._id=opts["id"]||"Id";
    this._initRow=opts["initRow"]||function(){return {};};
    this._editors=opts["editors"];
    //alert("init");
};

CrudDatagrid.prototype.getToolbar=function(opts){
	        opts=opts||{};
	        var textBtnAdd=opts["textBtnAdd"]||"新建";
		    var newRow=new this._initRow();
	        var regexp=this._regexp;
	        var id=this._id;
	        var urlRemove=this._urlRemove;
	        var urlAdd=this._urlAdd;
	        var urlUpdate=this._urlUpdate;
	        var urlExportExcel=this._urlExportExcel;
	        var formOpts={};
    	    formOpts["editors"]=this._editors;
    	    formOpts["prefix"]=opts["prefix"]||"";
	    	var btnAdd={iconCls:"icon-add",text:textBtnAdd
	        ,handler:function(){
	    		formOpts["data"]=newRow;
	    		formOpts["urlSave"]=urlAdd;
	    	    var div=$("<div></div>");
	    		div.kiaCrudForm(formOpts);
	            div.dialog({
	              title:"新建记录"
    		      ,modal:true
	              ,onClose:function(){$(this).dialog("destroy",true);}
	             ,onDestroy:function(){$(regexp).datagrid("reload");}

    	        });
	         }
            };
	        var btnUpdate={iconCls:"icon-edit",text:"修改"
	        ,handler:function(){ 	
	        	var selectRow=$(regexp).datagrid("getSelected");
	        	if(!selectRow){$.messager.alert("","没有记录被选中","error");return;}
	        	var rowIndex=$(regexp).datagrid("getRowIndex",selectRow);
	            formOpts["data"]=selectRow;
	    		formOpts["urlSave"]=urlUpdate;
	    		var title="修改记录序号:"+(rowIndex+1);
	    		var div=$("<div></div>");
	    		
	    		div.kiaCrudForm(formOpts);
	            div.dialog({
	              title:title
    		      ,modal:true
    		     //,onBeforeOpen:function(){$(this).kiaCrudForm(formOpts);}
	             ,onClose:function(){$(this).dialog("destroy",true);}
	             ,onDestroy:function(){$(regexp).datagrid("reload");}
    	        });
	       
	        	}
            };
            var btnRemove={iconCls:"icon-remove"
		        ,text:"删除"
		       ,handler:function(){
	            			var selectsRows=$(regexp).datagrid("getSelections");
	            			var deleteCount=selectsRows.length;
	            			if(deleteCount==0){$.messager.alert("","没有记录被选中","error");return;}
							var ids="";
							ids=selectsRows.getUnionStr(id,",");
							$.messager.confirm("操作提示","是否删除"+deleteCount+"条记录",function(ok){
								if(ok){
							    //var removeRowsAction=basePath+"/common/Datagrid/do/removeRows.action?modelClass="+modelClass;
						        $.post(urlRemove,{ids:ids},function(str){
					              try{
					               var re=new String(str);
                                   re.messager();
                                  $(regexp).datagrid("clearSelections");
						          $(regexp).datagrid("reload");
						         }catch(ex){alert(ex);}
							    });
					          }//if(ok){
					    });
		       }
            };
            var btnRefresh={iconCls:"icon-reload"
	        ,text:"刷新"
	        ,handler:function(){
            	$(regexp).datagrid("reload");
	        }
           };
            var btnExportExcel={
            	iconCls:"icon-help"
            	,text:"导出excel"
            	,handler:function(){
            	   if(urlExportExcel.length<1){
            		   $.messager.alert("操作错误","没有配置excel路径","error");
            		   return;
            	   }
            	   var div=$("<div></div>");
            	   var table=$("<table></table>");
            	   table.css("padding","10px");
            	   var tr;
            	   var th;
            	   var td;
                   var td2;
            	   var a;
            	   
            	   //导出全部记录
            	   tr=$("<tr></tr>");
            	   th=$("<th></th>");
            	   td=$("<td></td>");
            	   td2=$("<td></td>");
            	   a=$("<a></a>");
            	   var countAll=$(regexp).datagrid("getData")["total"]||0;
            	   th.html("全部记录数:");
            	   td.html(countAll).css("width","100px");
            	   td2.css("width","120px");
            	   a.attr("href",urlExportExcel);
            	   td2.append(a);
            	   a.linkbutton({
            		   text:"导出"
            	   });
            	   tr.append(th).append(td).append(td2);
            	   table.append(tr);
            	   
            	   //导出已选记录
            	   tr=$("<tr></tr>");
            	   th=$("<th></th>");
            	   td=$("<td></td>");
            	   td2=$("<td></td>");
            	   a=$("<a></a>");
            	   var countSelect=$(regexp).datagrid("getSelections").length||0;
            	   th.html("已选记录数:");
            	   td.html(countSelect);
            	   a.attr("href",urlExportExcel);
            	   td2.append(a);
            	   a.linkbutton({
            		   text:"导出"
            	   });
            	   tr.append(th).append(td).append(td2);
            	   table.append(tr);
            	   
            	   //导出当前页记录
            	   tr=$("<tr></tr>");
            	   th=$("<th></th>");
            	   td=$("<td></td>");
            	   td2=$("<td></td>");
            	   a=$("<a></a>");
            	   var countPage=$(regexp).datagrid("getRows").length||0;
            	   th.html("当前页记录数:");
            	   td.html(countPage);
            	   a.attr("href",urlExportExcel);
            	   td2.append(a);
            	   a.linkbutton({
            		   text:"导出"
            	   });
            	   tr.append(th).append(td).append(td2);
            	   table.append(tr);
            	   
            	   div.append(table);
            	   
            	   div.dialog({
            		   title:"导出excel"
            	   });
            	}
            };

            var toolbar=[btnAdd,btnUpdate,btnRemove,btnRefresh,btnExportExcel];
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
	   .addClass("kia-icon")
	   .addClass("edit")
	   .attr("onclick",eidtOnclickContext)
	;
	
	   
	   alert(span.html());
     return span.html();
   
   }
	 return o;
	 
	 }catch(ex){alert(ex);}
}

CrudDatagrid.prototype.getEditRowHandler=function(opts){
	  opts=opts||{};
	  var regexp=this._regexp;
	  var id=this._id;
	  var urlRemove=this._urlRemove;
	  var urlAdd=this._urlAdd;
	  var urlUpdate=this._urlUpdate;
	  var formOpts={};
      formOpts["editors"]=this._editors;
      formOpts["prefix"]=opts["prefix"]||"";
	  var fun=function(rowIndex,rowData){

	            formOpts["data"]=rowData;
	    		formOpts["urlSave"]=urlUpdate;
	    		var i=parseInt(rowIndex);
	    		var title="修改记录序号:"+(i+1);
	    		var div=$("<div></div>");	    		
	    		div.kiaCrudForm(formOpts);
	            div.dialog({
	              title:title
    		      ,modal:true
    		     //,onBeforeOpen:function(){$(this).kiaCrudForm(formOpts);}
	             ,onClose:function(){$(this).dialog("destroy",true);}
	             ,onDestroy:function(){$(regexp).datagrid("reload");}
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







