Class.forName("Kia.easyui.datebox");

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

 $.fn.form.defaults.success=function(str){str.messager(null);}
 $.fn.form.defaults.onSubmit=function(){ return $(this).form("validate"); }
 $.fn.form.defaults.onLoadError=function(){
	 $.messager.alert("Error","Can't access to the remote site.","error");
 }
 
  $.fn.datagrid.defaults.fit=true;
 $.fn.datagrid.defaults.pagination=true;
 $.fn.datagrid.defaults.nowrap=false;
 $.fn.datagrid.defaults.idField="Id";
 $.fn.datagrid.defaults.rownumbers=true;
 $.fn.datagrid.defaults.pageSize=20;
 $.fn.datagrid.defaults.groupFormatter=function(value,rows){return value + ' - 共' + rows.length + ' 条';};