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
       // var xlBook=xls.Workbooks.Open("c:\驾驶证申请表-初学.xlt");
       // alert("xls.Workbooks.count->"+xls.Workbooks.Count)
         //alert("xlBook->"+xlBook);
         //xlBook.Save();
        //var xlsheet=xlBook.Worksheets(1);
        //alert("xlsheet->"+xlsheet);
        
        
         var xlsheet2=xls.Workbooks(1).Worksheets(1);
         
         //xlsheet2.Cells(4,3).Value=document.getElementById("txtXm").value;
         xlsheet2.Cells(4,3).Value=data["Xm"]||"";
         xlsheet2.Cells(3,25).Value=data["Dabh"]||"";
         //xlsheet2.Cells(4,14).Value=document.getElementById("cbXbValue").value;
         xlsheet2.Cells(4,14).Value=data["Xb"]||"";
         //alert("csrq"+document.getElementById("txtCsrq").value);
         // xlsheet2.Cells(4,19).Value=document.getElementById("txtCsrq").value;
         //var csrq=new Date(data["csrq"]||"");
         var dateCsrq=new Date();
         xlsheet2.Cells(4,19).Value=dateCsrq.format("yyyy-MM-dd"); 
         
         //alert("cbGjValue"+getText("cbGjValue"));
         // xlsheet2.Cells(4,27).Value=getText("cbGjValue");
          xlsheet2.Cells(4,27).Value=data["Gj"]||"";
          
         
          //alert(document.getElementById("txtSfzmhm"));
          
          //var strtmp2=document.getElementById("txtSfzmhm").value;
          var strtmp2=data["Sfzmhm"]||"";
          //alert(strtmp2);
          
          
          
          //xlsheet2.Cells(5,3).Value=getText("cbSfzmmcValue");
          xlsheet2.Cells(5,3).Value=data["Sfzmmc"]=="1"?"居民身份证":"";
          var i=7;
          var len=strtmp2.length;
          for(var j=0;j<len;j++)
          {
 
             xlsheet2.Cells(5,i+j).Value=strtmp2.charAt(j);
          }
          
           var oSheet = xls.Workbooks(1).ActiveSheet; 
           //alert(oSheet);
          oSheet.Cells(5,25).Select();//选中Excel中的单元格 
          //var url="http://"+window.location.host+"/"+"DrvHelperSystem/DriverPerson/Apply"+"/ApplyInfoPhoto.aspx?idcard="+strtmp2;
          //document.write(url);
          //oSheet.Pictures.Insert(url);//插入图片
          
          //alert("zzz");
          //var tmp=document.getElementById("txtZzzm").value;
          var tmp=data["Zzzm"]||"";
         // alert(tmp);
          if(tmp&&tmp.length>0)
          {
            xlsheet2.Cells(6,3).Value="暂住证";
            len=tmp.length;
            for(var j=0;j<len;j++)
            {
                xlsheet2.Cells(6,i+j).Value=tmp.charAt(j);
            }
          }
          
            //xlsheet2.Cells(7,3).Value=document.getElementById("txtDjzsxxdz").value;
            
            //xlsheet2.Cells(8,3).Value=document.getElementById("txtLxzsxxdz").value;
            //xlsheet2.Cells(9,3).Value=document.getElementById("txtLxdh").value;
            
            //xlsheet2.Cells(9,18).Value=document.getElementById("txtLxzsyzbm").value;
            //xlsheet2.Cells(10,11).Value=document.getElementById("cbZkcxValue").value;
     
            xlsheet2.Cells(7,3).Value=data["Djzsxxdz"]||"";
            
            xlsheet2.Cells(8,3).Value=data["Lxzsxxdz"]||"";
            xlsheet2.Cells(9,3).Value=data["Lxdh"]||"";
            //xlsheet2.Cells(10,3).Value=data["sjhm"]||"";
            xlsheet2.Cells(9,18).Value=data["Lxzsyzbm"]||"";
            //xlsheet2.Cells(10,11).Value=data["djzsxxdz"]||"";document.getElementById("cbZkcxValue").value;
         
        //alert("xlsheet2->"+xlsheet2);
       
       xlsheet2=null;
       xlsheet=null;
       xlBook=null;
        xls.Quit();
       xls=null;
       xlsheet2.Printout;
       idTmr = window.setInterval("Cleanup();",1)
      
       
    
    }
    function Cleanup() {
    window.clearInterval(idTmr);
    CollectGarbage();
    
    
  }