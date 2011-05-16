<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎使用自助车管所</title>
</head>
<body bgcolor="blue" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	<s:form cssClass="selfform">
	<!-- 国际化，系统全局配置文件用
	<s:text name="Post.Fee"/>
	<s:text name="Cash.Fee.Hint"/>
	 -->
		<div class="selfmain">
			<table border="0" style="width: 100%; height: 574px" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="selfhinttd" style="vertical-align: top;margin-left: 15px;padding-left: 15px;text-indent: 5px;">
						<table class="selfhinttable" width="250px" border="0"
							cellpadding="0" cellspacing="0">
							<tr>
								<td class="headerleft">&nbsp;</td>
								<td class="headerright">&nbsp;</td>
							</tr>
							<tr>
								<td class="hintmsg" colspan="2">欢迎使用
								<br/>
								车管自助终端
								</td>
							</tr>
							<tr>
								<td  class="hintcontent" colspan="2"><div>1、自助终端办理业务需携带您的二代身份证</div>
									<div>2、请先选择您要办理的业务类型</div></td>
							</tr>
							<tr>
								<td class="bottomleft">&nbsp;</td>
								<td class="bottomright">&nbsp;</td>
							</tr>
						</table></td>
					<td>
						<div style="text-align: center; height: 502px; line-height: 80px;">
						<br/>
							<ul>
								<li><input class="btnmain" value="机动车业务"
									onclick="javascript:document.location.href='<s:url value="/self/Vehicle/to/index.action"/>';"
									type="button" /></li>
								<li><input class="btnmain" value="驾驶证业务"
									onclick="javascript:document.location.href='<s:url value="/self/Driver/to/index.action"/>';"
									type="button" /></li>
								<li><input class="btnmain" value="违法系统业务" type="button"
									onclick="javascript:document.location.href='<s:url value="/self/idCardReader.action"/>?returnurl=<s:url value="vio!vehicleSelectList.action"/>';" />
								</li>
								
							</ul>
						</div>
					</td>
					<td>
				
					<div style="text-align: center; height: 502px; line-height: 80px;">
						<br/>
							<ul>
							
								<li><input class="btnmain" value="科目一预约签到" type="button"
									onclick="javascript:document.location.href='<s:url value="/self/preasign!func.action"/>';" />
								</li>
								<li><input class="btnmain" value="业务缴费"
									onclick="javascript:document.location.href='<s:url value="/self/idCardReader.action"/>?capture=false&agent=false&returnurl=<s:url value="fee!func.action"/>';"
									type="button" /></li>
								<li><input class="btnmain" value="回执补打申请"
									onclick="javascript:document.location.href='<s:url value="/self/idCardReader!func.action"/>?capture=true&returnurl=<s:url value="addPrintApply!func.action"/>';"
									type="button" /></li>
							</ul>
						</div>
					</td>
				</tr>
			</table>
		</div>
		
	</s:form>
</body>


</html>