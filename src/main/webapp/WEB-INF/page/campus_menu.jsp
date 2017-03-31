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
<title>ç½ç«åå°ç®¡ç</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
@media(min-width:768px){
	#slider_sub{
	width:200px;
	position:absolute;
	z-index:1;
	height:600px;
	}	
 .mysearch{margin:10px 0;}
 .page_main{margin-left:205px;}
}

</style>
</head>
<body>
<!-- 侧边功能 -->	
   <div class="navbar-default navbar-collapse" id="slider_sub">
     <ul class="nav">
         <li>
         	<div class="input-group mysearch"> 
               <input type="text" class="form-control"/>
               <span class="input-group-btn">
               		<button type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-search"></span>
                    </button>
               </span>
         	</div>
         </li>
         <li>
         	<a href="#sub1"  data-toggle="collapse">机构信息管理<span class="glyphicon glyphicon-chevron-down  pull-right" ></span></a>
           	<ul id="sub1" class="nav collapse">
             <li><a href="#"><span class="glyphicon glyphicon-info-sign">&nbsp;</span>系统信息</a></li>
             <li><a href="#"><span class="glyphicon glyphicon-user">&nbsp;</span>管理员管理</a></li>
             <li><a href="#"><span class="glyphicon glyphicon-list-alt">&nbsp;</span>日志信息</a></li>
             <li><a href="#"><span class="glyphicon glyphicon-remove-circle">&nbsp;</span>退出</a></li>
           </ul>               
         </li>
                  	         
         <li>
         	<a href="#sub3"  data-toggle="collapse">操作员管理<span class="glyphicon glyphicon-chevron-down  pull-right" ></span></a>
           	<ul id="sub3" class="nav collapse">
             <li><a href="#">我的密码修改</a></li>
             <li><a href="#">操作员查询</a></li>
             <li><a href="#">操作员新增</a></li>
             <li><a href="#">操作员密码重置</a></li>
           </ul>               
         </li>
         
          <li>
         	<a href="#sub4"  data-toggle="collapse">销售人员管理<span class="glyphicon glyphicon-chevron-down  pull-right" ></span></a>
           	<ul id="sub4" class="nav collapse">
             <li><a href="#">销售人员维护</a></li>
             <li><a href="#">销售人员查询</a></li>
           </ul>               
         </li>
         
          <li>
         	<a href="#sub5"  data-toggle="collapse">平台公告<span class="glyphicon glyphicon-chevron-down  pull-right" ></span></a>
           	<ul id="sub5" class="nav collapse">
             <li><a href="#">系统公告</a></li>
           </ul>               
         </li>
     </ul> 
   </div>
</body>
