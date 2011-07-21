/** 
 *  页面加载等待页面 
 * 
 * @author gxjiang 
 * @date 2010/7/24 
 * 
 */  
 //var height = window.screen.height-250;  
 //var width = window.screen.width;  
 
  var _wiw=parseInt(window.innerWidth);
  var _wih=parseInt(window.innerHeight);

// var leftW = 300;  
// if(width>1200){  
//    leftW = 500;  
// }else if(width>1000){  
 //   leftW = 350;  
 //}else {  
//    leftW = 100;  
 //}  
 
  var _pageloadHeight=40;
  var _pageloadWidth=200;
  var _loadOffsetX=(_wiw/2)-(_pageloadWidth/2);
  var _loadOffsetY=(_wih/2)-(_pageloadHeight/2);
  
  
   
 var _html = "<div id='loading' style='position:absolute;left:0;width:100%;height:100%;top:0;background:#E0ECFF;opacity:0.8;filter:alpha(opacity=80);'>"  
 +"<div style='position:absolute;  cursor1:wait;left:"+_loadOffsetX+"px;top:"+_loadOffsetY+"px;width:"+_pageloadWidth+"px;height:"+_pageloadHeight+"px;text-align:center;"  
 +"border:2px solid #ccc;color:#000;background:white;'>正在加载，请等待...</div></div>";  
 
 
 
   
 $(document).ready(function(){  
    $("#loading").remove();  
 });
  
       
 document.write(_html);