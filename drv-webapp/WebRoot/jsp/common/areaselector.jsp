<%@page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="true"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<link href="<s:url value="/css/styles.css"/>" rel="Stylesheet"
	type="text/css" />
<style>
a,body,select {
	font-size: 12px;
	text-decoration: none;
}

a,pre {
	color: #808080;
}

body {
	background: #efefef;
}
</style>
<script> 
   var xmlHttp; 
   function cerateXMLHttpRequest()
   { 
	    if(window.XMLHttpRequest)
	    { 
	     xmlHttp = new XMLHttpRequest(); 
	    }
	    else if(window.ActiveXObject) 
	    { 
		     try
		     { 
		      xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); 
		     }
		     catch(e)
		     { 
			      try
			      { 
			       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); 
			      }catch(e)
			      { 
			       alert("创建异步对象失败"); 
			      } 
		     } 
	     } 
	    if(!xmlHttp)
	    { 
	     alert("创建异步对象失败"); 
	     return; 
	    } 
   } 
   //ajax+struts2.0三级联动 
   //选择省份 
   function selectShengfen(shengfen)
   { 
  	 //alert("选择的省份代码->"+shengfen);
      if(shengfen=="")
      { 
         document.f.selectchengshi.options.length = 1; 
         document.f.selectqu.options.length = 1; 
         return; 
      } 
       sendselectShengfen("areaselector!second.action?id="+shengfen); 
   } 
   //ajax发送函数,发送省份 
   function sendselectShengfen(url)
   { 
    cerateXMLHttpRequest(); 
    xmlHttp.open("get",url,true); 
    xmlHttp.onreadystatechange=processCountry; 
    xmlHttp.send(null); 
   } 
   //以省份来 返回城市的响应函数 
   function processCountry()
   { 
      if(xmlHttp.readyState==4)
      { 
	     if(xmlHttp.status==200)
	     { 
	        var doc=xmlHttp.responseXML; 
	       // alert("返回结果->"+doc);
	        var pro=doc.getElementsByTagName("provs"); 
	        document.f.selectchengshi.options.length = 1; 
	        document.f.selectqu.options.length = 1; 
	        for(var i=0;i<pro.length;i++)
	        { 
	           var p=pro[i]; 
	           document.f.selectchengshi.add(new Option(p.childNodes[1].firstChild.data,p.childNodes[0].firstChild.data)); 
	        } 
	     }
	     else
	     { 
	      alert("请求页面返回城市异常"); 
	     } 
    	} 
   } 
   //选择城市 
   function selectChengshi(chengshi)
   { 
  	// alert("选择的城市代码->"+chengshi);
      if(chengshi=="")
      { 
         document.f.selectqu.options.length = 1; 
         return; 
      } 
      sendSelectChengshi("areaselector!third.action?id="+chengshi); 
   } 
   //ajaxa发送函数,发送城市 
   function sendSelectChengshi(url) 
   { 
    cerateXMLHttpRequest(); 
    xmlHttp.open("get",url,true); 
    xmlHttp.onreadystatechange=processProvince; 
    xmlHttp.send(null); 
   } 
   //以城市来 返回区域的响应函数 
   function processProvince()
   { 
      if(xmlHttp.readyState==4)
      { 
	     if(xmlHttp.status==200)
	     { 
	        var doc=xmlHttp.responseXML; 
	        var pro=doc.getElementsByTagName("provs"); 
	        document.f.selectqu.options.length = 1; 
	        for(var i=0;i<pro.length;i++)
	        { 
	           var p=pro[i]; 
	           document.f.selectqu.add(new Option(p.childNodes[1].firstChild.data,p.childNodes[0].firstChild.data)); 
	        } 
     	}
     	else
     	{ 
      		alert("请求返回区域页面异常"); 
     	} 
      }
    }</script>
<script type="text/javascript">
   function returnParent(obj)
   {
    if (obj==0)
    {
     window.returnValue=false;
   	} 
   	else
   	{
   		var p=document.f.province;
   		var c=document.f.selectchengshi;
   		var a=document.f.selectqu;
     	window.returnValue =p.options[p.selectedIndex].value+";"+p.options[p.selectedIndex].text+";"+c.options[c.selectedIndex].value+";"+c.options[c.selectedIndex].text+a.options[a.selectedIndex].text+";"+a.options[a.selectedIndex].value+";"+a.options[a.selectedIndex].text;
   	}
   	window.close();
   }
  </script>
<body>
<form name="f">
<div>省份<s:select list="#listCountry" name="province"
	listKey="value" listValue="text" onchange="selectShengfen(this.value)" />
<br />
城市<select name="selectchengshi" onchange="selectChengshi(this.value)">
	<option value="">--请选择--</option>
</select> <br />
地区<select name="selectqu">
	<option value="">--请选择--</option>
</select>
<div><a href="#" onclick="returnParent(1)">确定</a>&nbsp;<a href="#"
	onclick="returnParent(0)">取消</a></div>
</div>

</form>
</body>
</html>
