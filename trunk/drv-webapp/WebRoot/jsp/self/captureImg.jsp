<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请人照片捕获界面</title>
</head>
<body>


	<div class="selfmaintophint">请拍摄一张清晰可见的申请人头像</div>
	<div class="selfmaincontent">
		<br />

		<table cellpadding="0" cellspacing="0" border="0" class="selftable">
			<tr>
				<th style="text-align: center">视频</th>
				<th style="text-align: center">拍照结果</th>
			</tr>
			<tr>
				<td><OBJECT ID="ETTSelfUSBVideoActiveX1" WIDTH=266 HEIGHT=320
						CLASSID="CLSID:07970878-4C36-470C-ACDC-9AB36FA2084B"
						codebase="ETTS.CAB#Version=1,0">
						<PARAM NAME="_Version" VALUE="65536">
						<PARAM NAME="_ExtentX" VALUE="2646">
						<PARAM NAME="_ExtentY" VALUE="1323">
						<PARAM NAME="_StockProps" VALUE="0">
					</OBJECT></td>
				<td><img src="#" id="imgPhoto" width="266px" height="320px" />
				</td>
			</tr>
			<tr>
				<td><input type="button" class="btnmain" value="重新拍摄"
					onclick="capture();" /></td>
				<td>
					<div>
						<s:form action="captureImg.action" name="subform" id="subform"
							method="POST" enctype="multipart/form-data">
							<div id="uploaddiv" style="display: none;">
								<s:file id="upload" name="upload" />
							</div>
							<input type="submit" class="btnmain" value="确定" />
						</s:form>

					</div></td>
			</tr>

		</table>
	</div>






	<script type="text/javascript">
		//var comStr = "<s:property value='frontCapture.com'/>";
		//var com = parseInt(comStr);
		function begin() {
			try
			{
			//alert("执行图像捕获初始化");
			ETTSelfUSBVideoActiveX1.BeginCapture(0);
			ETTSelfUSBVideoActiveX1.FileName="c:\\video.bmp";
			alert(ETTSelfUSBVideoActiveX1.BeginCapture);
			}
			catch(e)
			{
				//alert(e);
			}
			
		}

		function capture() {

			//ETTSelfUSBVideoActiveX1.CaptureBmp();

			var ret = ETTSelfUSBVideoActiveX1.CaptureBmp();
			if (ret == 1) {
				document.all.imgPhoto.src = ETTSelfUSBVideoActiveX1.FileName;
				document.forms["subform"].reset();
				//document.all.upload.focus();
				var WshShell = new ActiveXObject("WScript.Shell");
				//alert(WshShell);
				WshShell.sendKeys(ETTSelfUSBVideoActiveX1.FileName);
			}
		}

		if (Whole_Photo_Enable) {
			
			var intt = setTimeout("begin()", 100);
			//var intt22 = setTimeout("begin2()", 2000);
			var intt2 = setTimeout("capture()", 4000);
		} else {
			document.all.imgPhoto.src = "c:\\video.bmp";
			//alert(document.all.upload);
			document.all.upload.focus();
			var WshShell = new ActiveXObject("WScript.Shell");
			//alert(WshShell);
			WshShell.sendKeys("c:\\video.bmp");

		}
		
		//var int=self.setTimeout("begin2()",500) 
	</script>
</body>
</html>