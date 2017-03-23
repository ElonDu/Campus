<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 user-scalabe=no">
<title>登陆</title>
<link rel="stylesheet" href="css/bootstrap.min.css" > 
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container"> 
    <form action="#" method="post" class="form-horizontal" role="from">
       <fieldset disabled>
         <legend>用户登录</legend>     
         <div class="form-group">
         	<label class="col-sm-2 control-label">用户名：</label>
         	<div class="col-sm-8">
         		<input type="text" class="form-control" name="name" placeholder="输入用户名" />
         	</div>
         </div> 
         
         <div class="form-group">
            <label class="col-sm-2 control-label">密码：</label>
             <div class="col-sm-8">
             <input type="password" class="form-control" name="pwd" />
             </div>
         </div>      
         <button type="submit" class="btn btn-default">登录</button>       	
       </fieldset>           
    </form>
 </div>
</body>
</html>