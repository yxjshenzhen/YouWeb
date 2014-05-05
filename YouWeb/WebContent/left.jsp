<%@page import="com.you.bean.ChuanGanModel"%>
<%@page import="com.you.bean.ControlModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.you.DBUtil.SQLUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>
<style type="text/css">
 body{ background-color:#1873aa; text-align:center; margin:0; padding:0; overflow:hidden; font-size:12px}
 .left{ width:165px;background:#FFFFFF; height:470px; margin:0 auto}
 .leftshang{ background:url(image/title.png); width:165px; height:28px; margin:0 auto; position:relative}
 .leftshangshang{ font-size:20px; font-weight:bold; color:#FFFFFF; text-align:center; width:140px; height:25px;
  position:absolute; top:4px; left:15px}
  .style2{}
  .style21{ margin-bottom:5px}
  .style211{ background:url(image/title2.png); width:151px; height:23px; margin:0 auto; position:relative}
  .style211 div{ color:#FFFFFF; position:absolute; top:5px; left:35px; font-size:13px}
  .style211 div a{ text-decoration:none; color:#FFFFFF}
  .style212{ border:2px #95d6e4 solid; width:145px; height:135px; margin:0 auto; color:#033d61; text-align:left}
  .style212 ul{ list-style-type:none; margin-top:10px; margin-left:20px }
  .style212 ul li{ margin-bottom:6px }
  .style212 ul li a{ text-decoration:none; color:#033d61}
  .style212 ul li a:hover{ text-decoration:underline; font-size:13px}
</style>
<script type="text/javascript">
   function hiddenDiv(div)
   {
     	div.style.display=(div.style.display=='none'?'block':'none');
   }
   
   function openAdd()
   {
	    window.showModelessDialog("add.html",window,"status:no;dialogHeight:410px;dialogWidth:560px;help:no");
	    
   }
   
   function openDelete()
   {
	   window.showModelessDialog("delete.html",window,"status:no;dialogHeight:410px;dialogWidth:560px;help:no");
	   
   }
   
   function openUpdate()
   {
	   window.showModelessDialog("update.html",window,"status:no;dialogHeight:410px;dialogWidth:560px;help:no");
   }
   
   function openDetail()
   {
	   window.showModelessDialog("detail.html",window,"status:no;dialogHeight:410px;dialogWidth:560px;help:no");
   }
</script>
<body>
<% 
	SQLUtil sql = new SQLUtil();
	ArrayList<ChuanGanModel> al1 = (ArrayList<ChuanGanModel>)sql.getChuanGanModel();
	
%>
   <div class="left">
        <div class="leftshang">
		  <span class="leftshangshang">管理中心</span>
		</div>
		<div class="style2">
		   <div class="style21">
		      <div class="style211">
			    <div><a href="javascript:void(0)" onclick="hiddenDiv(document.getElementById('style212'))">采集数据</a></div>
			  </div>
			  <div class="style212" id="style212">
			    <ul>
				   <% 
				   		for(int i = 0;i < al1.size(); i++){
				   
				   			%>
				   			<li><a href="#"><%out.print(al1.get(i).getChuanGanName()); %></a></li>
				   			<% 
				   		}
				   %>
				</ul>
			  </div>
		   </div>
		</div>
		
		<div class="style2">
		   <div class="style21">
		      <div class="style211">
			    <div><a href="javascript:void(0)" onclick="hiddenDiv(document.getElementById('style213'))">显示数据</a></div>
			  </div>
			  <div class="style212" id="style213">
			    <ul>
				   <% 
				   		for(int i = 0;i < al1.size(); i++){
				   
				   			%>
				   			<li><a href="#"><%out.print(al1.get(i).getChuanGanName()); %></a></li>
				   			<% 
				   		}
				   %>
				</ul>
			  </div>
		   </div>
		</div>
		
		<div class="style2">
		   <div class="style21">
		      <div class="style211">
			    <div><a href="javascript:void(0)" onclick="hiddenDiv(document.getElementById('style214'))">设备管理</a></div>
			  </div>
			  <div class="style212" id="style214">
			    <ul>
				   			<li><a href="#" onclick="openAdd();">添加设备</a></li>
				   			
				   			<li><a href="#" onclick="openDelete();">删除设备</a></li>
				   			
				   			<li><a href="#" onclick="openUpdate();">修改设备</a></li>
				   			
				   			<li><a href="#" onclick="openDetail();">查看设备</a></li>
				</ul>
			  </div>
		   </div>
		</div>
   </div>
</body>
</html>

