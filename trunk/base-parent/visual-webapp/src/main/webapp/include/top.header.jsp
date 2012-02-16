<%@page import="com.ett.visual.action.BaseVisualAction"%>
<%@page import="com.ett.visual.model.BaseVisualModel"%>
<%@page import="com.smartken.toyz4j.model.impl.BaseAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影像化</title>

<%=BaseVisualAction.importPageResourceContext() %>

<script type="text/javascript">
var oplist = new Array('driver', 'vehicle', 'admin');
$(document).ready(function() {
	$('#nav').find("a").click(function() {
		var id = $(this).attr('id');
		$.each(oplist, function(i, n) {
			$('#'+n).attr('class', 'inactive');
		});
		$(this).parents("li").attr('class', 'active');
	});
});
</script>

</head>
<body>

<div id="all">
	<div id="banner"><h1>后台管理登录</h1></div>
    <div id="nav">
    	<ul>
        	<li class="inactive" id="driver"><a href="menu.html" target="menu">驾驶人业务</a></li>
            <li class="inactive" id="vehicle"><a href="menu.html" target="menu">机动车业务</a></li>
            <li class="inactive" id="admin"><a href="menu.html" target="menu">系统管理</a></li>
        </ul>
    </div>
    <div id="main">
    	<div id="welcome">欢迎你回来,Admin! <img src="images/clock.gif" /> 现在时间: 2009年3月4日 星期三   16:47</div>
        <div id="adminop">
            <ul>
                <li><a href="#">站点首页</a></li>
                <li><a href="javascript:parent.location.reload();">管理首页</a></li>
                <li><a href="javascript:parent.location.reload();">退出管理</a></li>
                <li><a href="#">站点首页</a></li>
            </ul>
        </div>
    </div>
