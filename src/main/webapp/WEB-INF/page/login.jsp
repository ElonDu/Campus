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
<link rel="stylesheet" href="css/bootstrap.min.css" > 
<link type="text/css" href="<%=path%>/css/style.css">

<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/main.js"></script>
</HEAD>
<BODY>
 <div class="container"> 
<FORM id=form1 name=form1 action="<%=path%>/user/register" onsubmit="return_checkForm()" method=post>

<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0 background=img/login_2.jpg>
  <TBODY>
  <TR>
    <TD style="HEIGHT: 105px"><IMG src="<%=path%>/img/login_dl.gif" 
  border=0></TD></TR>
  <TR>
    <TD >
      <TABLE height=300 cellPadding=0 width=900 border=0>
        <TBODY>
        <TR>
          <TD style="height: 209px; ">
            <TABLE cellSpacing=1 cellPadding=1 border=0 align="center">
              <TBODY>
              <TR>
                <TD >
                 <div>
		         	<label class="col-sm-25 control-label ">用户名：</label>
		         </div> 
                </TD>
                <TD style="HEIGHT: 28px">
                    <div class="col-sm-25">
		         		<input type="text" class="form-control" name="userName" maxlength="20"/>
		         	</div>
                </TD>
                <TD style="HEIGHT: 28px" width=100>
                	<SPAN id="codeId" style="FONT-WEIGHT: bold;"></SPAN>
                 </TD>
              </TR>
               <TR>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD>
               </TR>
              <TR>
                <TD >
                 <div>
		         	<label class="col-sm-15 control-label">登陆密码：</label>
		         </div> 
                </TD>
                <TD style="HEIGHT: 28px">
                    <div class="col-sm-25">
		         		<input type="password" class="form-control" name="userPassword.userPsw" maxlength="20"/>
		         	</div>
                </TD>
                <TD style="HEIGHT: 28px" width=100>
                	<SPAN id=RequiredFieldValidator4 
                  	style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入密码</SPAN>
                 </TD>
                
              </TR>
              
              
              <TR>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD>
               </TR>
              <TR>
                <TD></TD>
                <TD align="center">
                 <button type="submit" class="btn btn-default" onclick="login()">登录</button>   
                 <button type="submit" class="btn btn-default" onclick="toRegist()">注册</button>
                  <TD></TD>
              </TR>
              </TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD><IMG src="<%=path%>/img/login_3.jpg" 
border=0>
</TD>
</TR>
</TBODY>
</TABLE>


</FORM></div></BODY></HTML>


