<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/login.css">
	<title>用户登录</title>
</head>
<body>
	<div class="h1 head">在线投票系统</div>
  	<div class="container">
  		<div class="panel panel-primary">
  			<div class="panel-heading"><h3 class="panel-title">用户登陆</h3></div>
  			<div class="panel body">
		  		<form class="form-signin" name="logForm" action="<%=request.getContextPath() %>/servlet/LoginServlet" method="post">
		  			<div class="input-group">
                        <input type="text" name="id" id="inputId" class="form-control" placeholder="学号" required autofocus>
                    </div>
                    <div class="input-group">
                        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="密码" required autofocus>
                    </div>
                    <br>
                    <div class="submit">
                        <div class="login">
                            <button class="btn btn-primary" type="submit">&nbsp;&nbsp;登陆&nbsp;&nbsp;</button>
                        </div>
                        <div class="reset">
                            <button class="btn btn-warning" type="reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
                        </div>
                        <div class="register">
	                        <a href="<%=request.getContextPath() %>/jsp/register.jsp">注册</a>
                        </div>
                    </div>
		  		</form><!-- form-signin -->
	  		</div><!-- div panel body -->
  		</div><!-- div panel -->
  	</div><!-- div container -->
  	<div class="copyright">
        @2017 Powered by Andrew
    </div>
</body>
</html>