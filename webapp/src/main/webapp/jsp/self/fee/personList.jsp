<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>驾驶人待缴费列表</title>
</head>
<body>
	<s:form cssClass="selfform" name="subform" id="subform">
		<div class="selfmaincontent">
			 <img style="margin-top:10px;" src="<s:url value="/images/beginflowfeehint.jpg"/>" width="800" border="0px" height="50" alt="提示语"/>
			
			</div>
		<div
			style="text-align: center; height: 502px; background: url('<s:url value="/images/bottom3.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
			<br />
			<input type="hidden" id="money" name="money" value="0"/>
			<input type="hidden" id="lsh" name="lsh" value="0"/>
			<script type="text/javascript">
			function beginFee()
			{
				//alert("准备开始缴费！");
				try
                {
				var href='<s:url value="/self/fee!feeTypeSelect.action"/>';
				//var returnurl='<s:url value="/self/fee!feePerson.action"/>';
				//var lsh='<s:property value="user.lsh"/>';
				/*
				var arrChk=$("input[name='chk_list'][checked]"); 
				$(arrChk).each(function(){ 
				window.alert(this.value); 
				}); 
				}); 
                */
                var sum=0;
                //alert($);
                
                var arrMoney=$("a[name='moneyall']");
                $(arrMoney).each(function(){
                	//alert($(this).html());
                	sum=sum+parseInt($(this).html());
                	
                });
                if(sum<=0)
                	{
                	alert("您没有任何可缴费的业务！");
                	return false;
                	}
                var lsh="";
                var arrlsh=$("a[name='lshall']");
                $(arrlsh).each(function(){
                	//alert($(this).html());
                	lsh=lsh+","+$(this).html();
                	
                });
                $("#lsh").attr("value",lsh);

               //alert("->"+arrMoney);
				//alert("获取对象的数量为 "+arrMoney);
                //alert("总金额为:"+sum);
				//document.location.href=href+"?returnurl="+returnurl+"?lsh="+lsh+"&money="+sum;
				$("#money").attr("value",sum);
				//$("#lsh").attr("value",$("#lshall").attr("value"));
				//document.location.href=href;
				$("#subform").attr("action",href);
				$("#subform").submit();
                }
				 catch(ex)
	                {
						alert(ex);
	                }
				
			}
			</script>
			<input type="button" style="width:300px" onclick="beginFee();" class="btnmain"    value="进行处理"/>
			<br />您目前驾驶人业务还有如下缴费的记录: <br/>
			
			
<table id="mytablettt" width="900" border="0" cellPadding="0"  cellSpacing="0" class="selftable">  
      <tr class="selftableheader">  
     <TD align="center">序号</TD>  
      <TD align="center">流水号</TD>  
        <TD align="center">身份证明号码</TD>  
         <TD align="center">姓名</TD>  
          <TD align="center">业务类型</TD>  
          <TD align="center">业务原因</TD>
        <TD align="center">金额</TD>  
      
    </tr>  
     <s:iterator id="entity" value="lists" status="stuts">   
<tr class="<s:if test="#stuts.even==true">selftablecontentEven</s:if>">   
    <td >${stuts.count }</td>   
    <td><a name="lshall"><s:property value="lsh"/></a></td>   
    <td><s:property value="sfzmhm"/></td>   
    <td><s:property value="xm"/></td>   
    <td><s:property value="ywlx"/></td>   
     <td><s:property value="ywyy"/></td>   
    <td><a class="moneyall"  name="moneyall"><s:property value="bz"/></a>
    </td>   
       
</tr>   
</s:iterator> 
    </table>  
			
		</div>
		</s:form>
</body>

</html>