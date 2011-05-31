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
                ,message: '只能是中文名'
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