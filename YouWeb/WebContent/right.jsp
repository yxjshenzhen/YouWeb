<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>
<style type="text/css">
 body{ background-color:#ffff;  text-align:center; margin-top:13px; padding-top:13px; overflow:hidden; font-size:12px}
 
 #div1 {
    background-image:url(images/jianjielan.jpg);
	width:200;
	height:305;
	color:#FFFFFF;
	}
	
 #span1{
 	font-family: 行楷;
	font-size: 15px;
	color:#0099FF;
	font-weight:bold;
	margin-left:65;
	margin-top:0px;
	}
	
</style>

<body>
<table width="845" height="430" border="1" align="center" bordercolor="#669933">
  <tr>
    <td width="610" rowspan="3" bgcolor="#FFFFFF">
		<iframe src="http://localhost:8080/YouWeb/ChartServlet"  name="centerframe" width="610" height="430"  scrolling="no"  />	
	</td>
	<td width="220" bgcolor="#FFFFFF">
      <iframe src="righttable.jsp" width="220" height="430"  scrolling="auto" style="float:right" align="top" />	
	</td>
  </tr>
 
</table>
   
</body>
</html>
