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
<title>model-psu-top</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
@media(min-width:768px){
	#model-psu-menu{
	width:250px;
	position:absolute;
	z-index:1;
	height:600px;
	}
	
 .mysearch{margin:10px 0;}
 .page_main{margin-left:255px;}
}

</style>
</head>
<body>
<!-- 导航 -->
      <nav class="navbar navbar-default varbar-static-top">
		<div class="row">
		  <div class="col-md-6">
		    <h4>模仿pus平台</h4>
		   </div>
		   <div class="col-md-6">
			 <ul class="nav navbar-nav navbar-right" style="margin-right:20px;">
			    <li><a href="#"><span class="badge" style="background:#B2DBA1;">23</span></a></li>
			    <li><a href="#"><span class="glyphicon glyphicon-off"></span>&nbsp;注销</a></li>
		    </ul>
		 </div>
		</div>
		<ul class="nav nav-tabs nav-sm" >
			  	<li class="active"><a href="#">商户管理</a></li>
			  	<li><a href="#">交易管理</a></li>
			  	<li><a href="#">财务管理</a></li>
			  	<li><a href="#">终端管理</a></li>
			  	<li><a href="#">系统管理</a></li>
			  	<li><a href="#">风控管理</a></li>					  			  
	  </ul>
	  </nav>
</body>
		