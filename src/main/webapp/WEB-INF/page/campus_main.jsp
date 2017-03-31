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
<body>
 <!--ä¸­é´åºå -->	
   <div class="page_main">
     <ol class="breadcrumb">
       <li><a href="#">ç®¡çé¦é¡µ</a></li>
       <li><a href="#">æ ç®</a></li>
       <li><a href="#">å¢å æ ç®</a></li>
     </ol>
     <div class="row">
       <div class="col-md-10 col-lg-10">
          <div class="panel panel-default">
            <div class="panel-header">æè¿è®¢å</div>
            <div class="panel-body table table-responesive">
              <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                  <td>#</td>
                  <td>è®¢åå·</td>
                  <td>è®¢åæ¥æ</td>
                  <td>æ»ä»·</td>
                  <td>ç¶æ</td>
                </tr>
                </thead>
                <tbody>
                  <tr>
	                  <td>1</td>
	                  <td>1000001å·</td>
	                  <td>2017-03-10</td>
	                  <td>30</td>
	                  <td>å®æ</td>
	               </tr>
	               <tr>
	                   <td>1</td>
	                  <td>1000001å·</td>
	                  <td>2017-03-10</td>
	                  <td>30</td>
	                  <td>å®æ</td>
	               </tr>
	               <tr>
	                   <td>1</td>
	                  <td>1000001å·</td>
	                  <td>2017-03-10</td>
	                  <td>30</td>
	                  <td>å®æ</td>
	                </tr>
	                <tr>
	                   <td>1</td>
	                  <td>1000001å·</td>
	                  <td>2017-03-10</td>
	                  <td>30</td>
	                  <td>å®æ</td>
                 </tr>
                </tbody>
              </table>
             <nav class="pull-right">
              <ul class="pagination pagination-sm" style="magin-top:10px;">
				 <li><a href="#">ä¸ä¸é¡µ</a></li>
				 <li><a href="#">1</a></li>
				 <li><a href="#">2</a></li>
				 <li><a href="#">3</a></li>
				 <li><a href="#">4</a></li>
				 <li><a href="#">5</a></li>
				 <li><a href="#">ä¸ä¸é¡µ</a></li>
			 </ul>
            </nav>
            </div>
          </div>
       </div>
     </div>
     
     
   </div>
   
   
   
</body>
</html>
