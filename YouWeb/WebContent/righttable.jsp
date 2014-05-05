<%@page import="com.you.bean.ChuanGanData"%>
<%@page import="com.you.bean.ChuanGanModel"%>
<%@page import="com.you.bean.ControlModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.you.DBUtil.SQLUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" errorPage="erro.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
-->
</style></head>

<body>
<hr size="3" color="#66CC00"/>
<center><a href="controlServlet?control=shuaxin">刷新数据</a></center>
  <%
		SQLUtil sql = new SQLUtil();
  		ArrayList<ControlModel> al = (ArrayList)sql.getAllControlModel();
  		
   %>
   <table width="100%" height="100%" border="1" align="center" bordercolor="#66CC00" style="font-size:13px"  >
  <tr>
    <td colspan="3"><div align="center">设备及管理</div></td>
  </tr>
  <tr>
    <td width="400"><div align="center">设备名称</div></td>
    <td width="270"><div align="center">设备状态</div></td>
    <td width="400"><div align="center">设备控制</div></td>
  </tr>
	<%
		for(int i=0;i<al.size();i++){
		
			%>
			<tr>
    		<td><div align="center"><%=al.get(i).getControlModelName()%></div></td>
    		<td><div align="center"><%=al.get(i).isControlModelState()%></div></td>
    		<td><div align="center">
      		<a href="http://localhost:8080/YouWeb/controlServlet?ControlModelId=<%=al.get(i).getControlModelId() %>&&ControlModelCode=<%=al.get(i).getControlModelOpen() %>">开机</a>
      		<a href="http://localhost:8080/YouWeb/controlServlet?ControlModelId=<%=al.get(i).getControlModelId() %>&&ControlModelCode=<%=al.get(i).getControlModelClose() %>">关机</a>
    		</div></td>
  			</tr>
  			<% 
		}
	%>
  
  
</table>
 



<br/>
<hr size="3" color="#66CC00"/>
<center><a href="controlServlet?control=shuaxin">刷新数据</a></center>
<% 
		ArrayList<ChuanGanModel> al1 = (ArrayList<ChuanGanModel>)sql.getChuanGanModel();
		
%>
<table width="100%" height="100%" border="1" align="center" bordercolor="#66CC00" style="font-size:13px">
 <tr>
    <td colspan="3"><div align="center">最近接收数据</div></td>
 </tr>
 <tr>
    <td width="400"><div align="center">设备名称</div></td>
    <td width="400"><div align="center">传感数据</div></td>
 </tr>
 <%
 		for(int i=0;i<al1.size();i++){
 			//ChuanGanData  cgd = (ChuanGanData)sql.getLastChuanGanDataById(17); 
 			
 			//ChuanGanData  cgd = (ChuanGanData)SQLUtil.getLastChuanGanDataById(al1.get(i).getChuanGanId()).get(0);
 				//ChuanGanData cgd = (ChuanGanData)sql.getChuanGanDataById(al1.get(1).getChuanGanId()).get(0);
			
			
 				//System.out.println("xxxxxxx"+al1.get(i).getChuanGanId());
				//System.out.println(cgd.getWenDu()+cgd.getTuRang()+cgd.getYuShui()+cgd.getGuangMin()+cgd.getWenDu()+cgd.getShiDu());
 			
 			
 			%>
 			<tr>
    		<td><div align="center"><%=al1.get(i).getChuanGanName()+al1.get(i).getChuanGanId() %></div></td>
    		<td><div align="center"><%//=cgd.getYanWu()+cgd.getTuRang()+cgd.getYuShui()+cgd.getGuangMin()+cgd.getWenDu()+cgd.getShiDu()%></div></td>
  			</tr>
  			<%
 		}
 %>
  
</table>
<p>&nbsp;</p>

</body>
</html>
