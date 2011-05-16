<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>框架构造测试</title>
<link rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css">
<script type="text/javascript" src="js/easyui/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">

</head>
<body>
	<div id="cc" style="width: 1024px; height: 768px;">

		<div region="north" title="" split="false"
			style="height: 100px;" border="true">
			
			north
			<a href="#">加为收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" id="btn" >修改密码</a>
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" id="btn" >退出系统</a>

			
			</div>

		<div region="south"  split="false"
			style="height: 60px;"  border="true">
			south
			</div>

		

		<div region="west" split="true" title="系统功能" style="width: 200px;"  border="true">
		west
		</div>

		<div region="center" title="欢迎使用本系统"
			style="padding: 5px; background: #eee;"  border="true">
			center
			</div>

	</div>

	<script type="text/javascript">
		$('#cc').layout();
	</script>

</body>
</html>