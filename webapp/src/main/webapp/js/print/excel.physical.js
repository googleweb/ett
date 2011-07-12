	var idTmr = "";
    var selectObj;
    var str="";
    function getSelectText(id)
    {
        selectObj=document.getElementById(id);
        return selectObj.options[selectObj.selectedIndex].text;
    }
    
    function getText(id)
    {
        str=getSelectText(id);
        return str.substring(str.indexOf("：")+1);
    }

    function printExcel(excelTempatePath,data)
    {
       var xls;
       try
       {
          	xls=new ActiveXObject("Excel.Application");
        }
        catch(e)
        {
        	alert("要打印该表，您必须安装Excel电子表格软件，同时浏览器须使用“ActiveX控件”，您的浏览器须允许执行控件。请【帮助】了解浏览器设置方法");
           	return;
        }
        alert('11111');
       	xls.visible=true;
        var xlBook=xls.Workbooks.Open(excelTempatePath);        
        var xlsheet2=xls.Workbooks(1).Worksheets(1);
       
        xlsheet2.Cells(4,4).Value=data["Xm"]||"";  
       /*
        * xlsheet2.Cells(4,4).Value=data["CXm"]||"";  
        * xlsheet2.Cells(4,8).Value=data["CSex"]||"";  
        xlsheet2.Cells(4,14).Value=data["CBirthday"]||"";  
        xlsheet2.Cells(4,24).Value=data["CNation"]||"";
        xlsheet2.Cells(5,4).Value=data["CIdcardtype"]||"";  
        	var IdCard=data["CIdcard"];
        	for(var j=0;j<IdCard.length;j++){
        		xlsheet2.Cells(5,11+j).Value=data["CIdcard"].charAt(j);
        	}
        xlsheet2.Cells(6,14).Value=data["CDabh"]||"";  
        */
        
       xlsheet2=null;
       xlsheet=null;
       xlBook=null;
       xls=null;
       xlsheet2.Printout;
       idTmr = window.setInterval("Cleanup();",1)    
    }
    function Cleanup() {
    window.clearInterval(idTmr);
    CollectGarbage();
  }