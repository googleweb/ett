function getParameter(paraStr, url) {
	var result = "";
	//获取URL中全部参数列表数据   
	var str = "&" + url.split("?")[1];
	var paraName = paraStr + "=";
	//判断要获取的参数是否存在   
	if (str.indexOf("&" + paraName) != -1) {
		//如果要获取的参数到结尾是否还包含“&”   
		if (str.substring(str.indexOf(paraName), str.length).indexOf("&") != -1) {
			//得到要获取的参数到结尾的字符串   
			var TmpStr = str.substring(str.indexOf(paraName), str.length);
			//截取从参数开始到最近的“&”出现位置间的字符   
			result = TmpStr.substr(TmpStr.indexOf(paraName), TmpStr
					.indexOf("&")
					- TmpStr.indexOf(paraName));
		} else {
			result = str.substring(str.indexOf(paraName), str.length);
		}
	} else {
		result = "无此参数";
	}
	return (result.replace("&", ""));
}

function fullScreen() {

	if (this.name != 'fullscreen') {
		var win=window.open(location.href,'fullscreen', 'fullscreen=yes;top=0,left=0,toolbar=no,menubar=no,status=no,scrollbars=yes,resizeable=yes');
		win.resizeTo(window.screen.availWidth,window.screen.availHeight);
		//win.parent=null;
		parent.opener = null; //最关键的一句，注意最后的参数
		//win.parent=null;
		//win.opener=null;
		window.close(parent);
	}
	//禁用鼠标右键
	//document.oncontextmenu = new Function('event.returnValue=false;');
	//禁用拖动选取
	//document.onselectstart = new Function('event.returnValue=false;');
}
function goPre(param) {
	var r = getParameter("returnurl", location.href);

	//测试输出，结果是：site=popasp  
	//alert(r);   
	//根据得到的结果可以使用   
	var url = r.split("=")[1]; //获取参数名  
	if (param) {
		url = url + param;
	}
	document.location.href = url;
}
function nextStep(param) {
	var r = getParameter("gourl", location.href);

	//测试输出，结果是：site=popasp  
	//alert(r);   
	//根据得到的结果可以使用   
	var url = r.split("=")[1]; //获取参数名  
	if (param) {
		url = url + param;
	}
	document.location.href = url;
}

function goFirst() {
	document.location.href = "/webapp/index!logout.action";
}

function goNext(url) {
	document.location.href = url+">returnurl="+document.location.href;
}

function writeNowDate()
{
	var now= new Date();
	var year=now.getYear();  
	var month=now.getMonth()+1;  
	var day=now.getDate(); 
	document.write(year+"-"+month+"-"+day);
	
}

//格式化日期的表示
function   formatDate(date,str) 
{ 
	//alert("格式化时间"+date);
	//alert("格式化字符串"+str);
	str=str.replace("yyyy",date.getFullYear()); 
	str=str.replace("MM",date.getMonth()); 
	str=str.replace("dd",date.getDate()); 
	return   str; 
} 

//增加天 
function   addDays(date,value) 
{ 
date.setDate(date.getDate()+value); 
} 



