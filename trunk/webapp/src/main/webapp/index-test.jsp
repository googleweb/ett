<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>
主页 
</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<s:url value="/js/jquery-1.5.2.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/jquery.popup.js"/>"></script>
    
</head>
<body>
<h2>Hello World!</h2>
<input type="button" value="测试弹出pop" onclick="Pop('popWin','/images/jsptag.gif','测试标题')"/>
<input type="button" value="测试弹出" onclick="popHint('popWin','/images/jsptag.gif','测试标题')"/>
<div  id="popWin" style="display:none">
	<div id="popWinTitle"></div>
	<div><img src="" width=500 height=500 id="popWinImg"/></div>
	<div><input type="button" value="确定"/></div>

</div>



</body>


<script type="text/javascript">

function Pop()
{
	$.popup.open('/images/hint.png','请确认您的身份证信息！','');
}

function popHint(id,imgSrc,title)
{
	

	
var titleObj=$("#"+id+"Title");
if(titleObj)
	{
		//titleObj.InnerHTML=title;
		titleObj.html(title);
	}
	var imgObj=$("#"+id+"Img");
	if(imgObj)
		{
		  imgObj.src=imgSrc;
		}
	$("#"+id).css('display','block');
	//$("#"+id).show();
	$("body").append("<div class='DivMask'><iframe border='0' width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no'></iframe></div>");
	  function SetCss(){
          $('.DivMask').css(
              {
                  height:document.body.clientHeight,
                  width:document.body.clientWidth,
                  "background-color": "#CCCCFF",
                  opacity:10,//兼容
                  top:"0",
                  left:"0",//0就不要px了
                  position: "absolute",//这样就不会在按钮下面了
                  "z-index":900 //这句报错，不知道为什么“after property id”，
                      //css属性中带“-”的，一律用引号"z-index"/"background-color"
              }
          );
      }

	
}

</script>
</html>
