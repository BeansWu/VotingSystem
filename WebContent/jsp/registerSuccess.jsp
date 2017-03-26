<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
<title>注册成功</title>
</head>
<body>
	<div class="panel panel-success">
		<div class="panel-body">
			<div class="col-md-4">
		    	<div class="h2">在线投票系统</div>
		    </div>
			<div class="col-md-2 col-md-offset-6">
		    	欢迎登陆，${user.name}
		    </div>
		</div>
	</div>
	<div class="col-md-6 col-md-offset-3">
		<h2>注册成功，将在5秒后跳转到您的主页。</h2>
		<%
			String contextPath = request.getContextPath();
			response.setHeader("refresh", "5;url=" + contextPath +"/jsp/generalIndex.jsp");
		%>
	</div>
</body>
</html>