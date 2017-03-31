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
  <body>
 <!--ä¸­é´åºå -->	
      <div class="container">
     <ol class="breadcrumb">
       <li><a href="#">ç®¡çé¦é¡µ</a></li>
       <li><a href="#">æ ç®</a></li>
       <li><a href="#">å¢å æ ç®</a></li>
     </ol>
     <div class="row">
       <div class="col-md-12 col-lg-12">
          <div class="panel panel-default">
            <div class="panel-header">æè¿è®¢å</div>
            <div class="panel-body">
              <table class="table  table-bordered  table-condensed" >
                  <tr>
	                  <td class="col-sm-2 info" align="right" >åæ·ç®ç§°ï¼</td>
	                  <td class="col-sm-4" > <input type="text" class="form-control input-sm" name="merName" placeholder="è¾å¥ç¨æ·å"/></td>
	                  <td class="col-sm-2 info" align="right">åæ·wå¨ç§°ï¼</td>
	                  <td class="col-sm-4"><input type="text" class="form-control input-sm" name="merShortName" placeholder="è¾å¥ç¨æ·å" /></td>
	               </tr>
	              <tr>
	                  <td class="col-sm-2 info" align="right">è¥ä¸å°åï¼</td>
	                  <td class="col-sm-10" colspan="3">  
	                     <div class="col-sm-1">
	                     <select name="ss">
	                           <option value="1">è¯·éæ©</option>
					           <option value="1">ä¸­å½</option>
					           <option value="2">ç¾å½</option>
					           <option value="3">è±å½</option>
					           <option value="4">æ³å½</option>
					           </select> 
					     </div>
					    <div class="col-sm-1">
	                    <select name="ss">
	                           <option value="1">è¯·éæ©</option>
					           <option value="1">ä¸­å½</option>
					           <option value="2">ç¾å½</option>
					           <option value="3">è±å½</option>
					           <option value="4">æ³å½</option>
           				</select> 
           				</div>
           			  <div class="col-sm-4">
	                  <input type="text" class="form-control input-sm" name="merName" placeholder="è¾å¥ç¨æ·å"/>
	                  </div>
	                  <div class="col-sm-1" align="right"> 
	                     	é®ç¼ï¼
	                   </div>
	                   <div class="col-sm-3"> 
         	            <input type="text"  class="form-control input-sm" name="name" placeholder="è¾å¥ç¨æ·å" />
	                  </div>
	                  </td>
	               </tr>
	               <tr>
	                  <td class="col-sm-2 info" align="right">æ³¨åå°åï¼</td>
	                  <td class="col-sm-10" colspan="3">  
	                     <div class="col-sm-1">
	                     <select name="ss">
	                           <option value="1">è¯·éæ©</option>
					           <option value="1">ä¸­å½</option>
					           <option value="2">ç¾å½</option>
					           <option value="3">è±å½</option>
					           <option value="4">æ³å½</option>
					           </select> 
					     </div>
					    <div class="col-sm-1">
	                    <select name="ss">
	                           <option value="1">è¯·éæ©</option>
					           <option value="1">ä¸­å½</option>
					           <option value="2">ç¾å½</option>
					           <option value="3">è±å½</option>
					           <option value="4">æ³å½</option>
           				</select> 
           				</div>
           			  <div class="col-sm-4">
	                  <input type="text" class="form-control input-sm" name="merName" placeholder="è¾å¥ç¨æ·å"/>
	                  </div>
	                  <div class="col-sm-1" align="right"> 
	                     	é®ç¼ï¼
	                   </div>
	                   <div class="col-sm-3"> 
         	            <input type="text"  class="form-control input-sm" name="name" placeholder="è¾å¥ç¨æ·å" />
	                  </div>
	                  </td>
	               </tr>
	               
	              <tr>
	                  <td class="col-sm-2 info" align="right">è¥ä¸æ¶é´ï¼</td>
	                  <td class="col-sm-4"> <input type="text" class="form-control input-sm" name="merName" placeholder="è¾å¥ç¨æ·å"/></td>
	                  <td class="col-sm-2 info" align="right">åæ·wå¨ç§°ï¼</td>
	                  <td class="col-sm-4"><input type="text" class="form-control input-sm" name="merShortName" placeholder="è¾å¥ç¨æ·å" /></td>
	               </tr>
	                <tr>
	                  <td class="col-sm-2 info" align="right">åæ·ç®ç§°ï¼</td>
	                  <td class="col-sm-4"> <input type="text" class="form-control input-sm" name="merName" placeholder="è¾å¥ç¨æ·å"/></td>
	                  <td class="col-sm-2 info" align="right">åæ·wå¨ç§°ï¼</td>
	                  <td class="col-sm-4"><input type="text" class="form-control input-sm" name="merShortName" placeholder="è¾å¥ç¨æ·å" /></td>
	               </tr>
              </table>
            </div>
          </div>
       </div>
     </div>          
   </div>
</body>
</html>