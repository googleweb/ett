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
		<div  class="selfmaintophint">
		请确认驾驶证业务缴费信息
		</div>
		<div class="selfmaincontent"><br />
			<input type="hidden" id="money" name="money" value="0"/>
			<input type="hidden" id="lsh" name="lsh" value="0"/>
			<script type="text/javascript">
			function beginFee()
			{
				//alert("准备开始缴费！");
				try
                {
				var href='<s:url value="/self/fee!feeTypeSelect.action?allowguitai=false"/>'+"&returnurl="+'<s:url value="fee!personFee.action"/>';;
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
			
<table width="600" border="0" cellPadding="0"  cellSpacing="0" class="selftable">
<tr><th colspan="4" style="text-align: center">驾驶证业务缴费信息</th></tr>  
     <s:iterator id="entity" value="lists" status="stuts">
     <tr>
     <Th>流水号:</Th> 
     <td><a name="lshall"><s:property value="lsh"/></a></td>
     <th>身份证明号码：</th>
     <td><s:property value="sfzmhm"/>&nbsp;</td>
     </td>
     </tr>
      <tr>
     <Th>姓名:</Th> 
     <td><s:property value="xm"/>&nbsp;</a></td>
     <th>业务类型:</th>
     <td><s:property value="ywlx"/>&nbsp;</td>
     </td>
     </tr>
       <tr>
     <Th>业务原因:</Th> 
     <td><s:property value="ywyy"/>&nbsp;</a></td>
     <th>业务开始时间:</th>
     <td  >
    <s:date name="kssj" format="yyyy-MM-dd HH:mm:ss" />
     </td>
     </tr>

     <Th>金额:</Th> 
     <td class="moneyhint" colspan="3">
     
     <a class="moneyall"  name="moneyall"><s:property value="bz"/></a>
     </a>
    
     </td>
     
     </tr> 
</s:iterator> 
<tr> <td colspan="4"><input type="button" style="width:300px" class="btnmain" onclick="beginFee();" value="确认"/></td></tr>
    </table>  			
</div>
		</s:form>
</body>

</html>