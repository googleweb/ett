Class.forName("Toyz4js.cfg");

Toyz4js.cfg = {
	datePattern:"yyyy-MM-dd"
	,dateTimePattern:"yyyy-MM-dd HH:mm:ss"
	,array_separator:","
    ,precision:2
    ,value_true:"Y"
    ,value_false:"N"
    ,text_true:"是"
    ,text_false:"否"
    ,combobox_textField:"text"
    ,combobox_valueField:"value"
    ,queryTypes:{
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
	}
    ,jsonDateHandler:function(value){return Date.parse(value);}
}