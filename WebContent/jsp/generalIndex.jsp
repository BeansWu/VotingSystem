<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, vs.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/script/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="../script/jquery.blockUI.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/script/vote.js"></script>
	<title>主页</title>
</head>
<body>
	<div class="panel panel-success">
		<div class="panel-body">
			<div class="col-md-4">
		    	<div class="h2">在线投票系统</div>
		    </div>
			<div class="col-md-2 col-md-offset-6">
		    	<div class="h5">欢迎登陆，${user.name}</div>
		    </div>
		</div>
	</div>
	<div class="vote-form">
	<div class="col-md-6 col-md-offset-3">
	  	<table class="table table-striped table-bordered table-hover">
	  		<tr>
	  			<th width="60">学号</th>
	  			<th width="60">姓名:</th>
	  			<th width="200">票数</th>
	  			<th width="50">操作</th>
	  		</tr>
	  	</table>
	 </div>
	</div>
</body>
</html>