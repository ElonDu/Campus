<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.6000.16809" name=GENERATOR>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css" > 
<link href="<%=path%>/css/style.css" type="text/css">
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/main.js"></script>

</HEAD>
<title>model-psu</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<frameset rows="15%,84%" border="0">
	<frame src="<%=path%>/user/campus_top"  scrolling="no">
	<frameset cols="20%,80%">
		<frame src="<%=path%>/user/campus_menu" >
		<frame src="<%=path%>/user/campus_main" >
	</frameset>
</frameset>
</html>