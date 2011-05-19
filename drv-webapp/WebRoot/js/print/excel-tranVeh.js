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
    //alert("exe the method->printExcel");
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
       xls.visible=true;
       // alert("xls->"+xls);
       //var objBook=excelapp.Workbooks.Add(); 
      // var xlBook=xls.Workbooks.Add;
       //alert("xlBook->"+xlBook);
       /*var MissingValue=null;
        var xlBook=xls.Workbooks.Open("c:\驾驶证申请表-初学.xlt",MissingValue,
  MissingValue,MissingValue,MissingValue,
  MissingValue,MissingValue,MissingValue,
  MissingValue,MissingValue,MissingValue,
  MissingValue,MissingValue,MissingValue,
  MissingValue);
  */
       //var xlBook=xls.Workbooks.Open("http://"+window.location.host+"/"+"DrvHelperSystem"+"/Templates/驾驶证申请表-初学.xlt");
       var xlBook=xls.Workbooks.Open(excelTempatePath);
        
        var xlsheet2=xls.Workbooks(1).Worksheets(1);
         
        xlsheet2.Cells(4,7).Value=document.getElementById("plateClass").value; 
        xlsheet2.Cells(4,26).Value=document.getElementById("plateNo").value;
        xlsheet2.Cells(23,7).Value=document.getElementById("agentIdName").value;
        xlsheet2.Cells(16,7).Value=data["xm"]||""; 
        xlsheet2.Cells(16,7).Value=data["xm"]||""; 
        xlsheet2.Cells(17,7).Value=data["lxzsxxdz"]||"";
        xlsheet2.Cells(19,7).Value=data["lxzsyzbm"]||"";
        xlsheet2.Cells(21,7).Value=data["sjhm"]||"";
        xlsheet2.Cells(19,16).Value=data["lxdh"]||"";
        xlsheet2.Cells(21,16).Value=data["dzyx"]||"";
         
       xlsheet2=null;
       xlsheet=null;
       xlBook=null;
       // xls.Quit();
       xls=null;
       xlsheet2.Printout;
       idTmr = window.setInterval("Cleanup();",1)
      
       
    
    }
    function Cleanup() {
    window.clearInterval(idTmr);
    CollectGarbage();
  }