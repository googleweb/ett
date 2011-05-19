<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请人信息确认界面</title>
</head>
<body>
	<s:form action="/personInfoCheck.action">
	<div class="selfmaintophint">申请人信息确认</div>
	<div class="selfmaincontent">
	<br/>
		<table class="selftable" cellpadding="0" cellspacing="0">
			<tr>
				<th>身份证明号码</th>
				<td><s:property value="user.sfzmhm" />
				</td>
				<th>姓名</th>
				<td><s:property value="user.xm" />
				</td>
				<td rowspan="3">
					<img src='<s:url value="/self/imageShow!person.action"/>?idcard=' height="160" width="133"/>
				</td>
			</tr>
			<tr>
				<th>准驾车型</th>
				<td><s:property value="user.zkcx" />
				</td>
				<th>手机号码</th>
				<td><s:property value="user.sjhm" />
				</td>
			</tr>
				<tr>
				<th>有效期始</th>
				<td><s:date name="user.yxqs" format="yyyy-MM-dd" />
				</td>
				<th>有效期止</th>
				<td><s:date name="user.yxqz" format="yyyy-MM-dd" />
				</td>
			</tr>

		</table>
		<input class="btnmain" type="submit" value="确定" />
		</div>
	</s:form>
</body>
</html>