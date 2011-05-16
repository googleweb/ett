<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请人照片捕获界面</title>
</head>
<body>
<s:form action ="/captureImg.action" method ="POST" enctype ="multipart/form-data" > 
<div style="display:none"><s:file name="upload" /></div>
      <table>
      <tr><th>视频</th><th>拍照结果</th></tr>
      <tr><td><OBJECT ID="ETTSelfUSBVideoActiveX1" WIDTH=133 HEIGHT=160
 CLASSID="CLSID:07970878-4C36-470C-ACDC-9AB36FA2084B" codebase="ETTS.CAB#Version=1,0">
    <PARAM NAME="_Version" VALUE="65536">
    <PARAM NAME="_ExtentX" VALUE="2646">
    <PARAM NAME="_ExtentY" VALUE="1323">
    <PARAM NAME="_StockProps" VALUE="0">
</OBJECT></td><td><img src="#" id="imgPhoto" width="133px" height="160px" /></td></tr>
      <tr><td><input type="button" value="重新拍摄" onclick="capture();"/></td><td>
      
      <input type="submit" value="确定"/>
      </td></tr>
      
      </table>
</s:form> 



<script type="text/javascript" >
function begin()
{
ETTSelfUSBVideoActiveX1.BeginCapture(0);
ETTSelfUSBVideoActiveX1.FileName="c:\\video.bmp";
}
//var int=self.setTimeout("begin()",100) 

function capture()
{

//ETTSelfUSBVideoActiveX1.CaptureBmp();

var ret=ETTSelfUSBVideoActiveX1.CaptureBmp();
if(ret==1){document.all.imgPhoto.src=ETTSelfUSBVideoActiveX1.FileName;}
}
</script>
</body>
</html>