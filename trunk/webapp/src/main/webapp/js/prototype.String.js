



String.prototype.toJson=function(){
	try{
		var json=eval("("+this.toString()+")");
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
    	$.messager.alert("Format error","The result is not a Messager format");
    }	 
};


String.prototype.isDateTimeFormat=function(){
	
};


String.prototype.isIdNoFormat=function(){
	
};

String.prototype.getIdNoBornDate=function(){
	return new Date();
}

