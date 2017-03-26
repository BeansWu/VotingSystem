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
	<title>主页</title>
</head>
<body>
	<div class="panel panel-success">
		<div class="panel-body">
			<div class="col-md-4">
		    	<div class="h2">在线投票系统</div>
		    </div>
			<div class="col-md-2 col-md-offset-6">
		    	欢迎登陆，管理员${user.name}
		    </div>
		</div>
	</div>
	<div class="manage-form">
		<div class="center-block">
			<div class="col-md-offset-1 col-md-6">
				<div class="panel panel-primary">
				  <div class="panel-heading">
				    <h3 class="panel-title">候选人</h3>
				  </div>
				  <div class="panel-body">
				    <table class="table table-striped table-bordered table-hover">
					    <tr>
					    	<th width="60">学号:</th>
				  			<th width="60">姓名:</th>
				  			<th width="200">票数</th>
				  			<th width="50">操作</th>
				  		</tr>
					  	<%
				  			ArrayList<User> candidates = (ArrayList<User>)request.getSession().getAttribute("candidates");
				  			for (User user : candidates) {
				  		%>
				  		<tr>
				  			<td><%=user.getId() %></th>
				  			<td><%=user.getName() %></td>
				  			<td>
				  				 <div class="progress">
								  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="<%=user.getVote() * 10 %>" aria-valuemin="0" aria-valuemax="100" style="min-width: 2em ;width: <%=user.getVote() %>%;">
								    <%=user.getVote() %>
								  </div>
								</div>
				  			</td>
				  			<td><a href="<%=request.getContextPath() %>/servlet/DeleteCandidateServlet?id=<%=user.getId() %>">删除</a>
				  		</tr>
				  		<%
				  			}
				  		 %>
				    </table>
				  </div><!-- panel body -->
				</div><!-- panel -->
			  </div><!-- col -->
			  <div class=" col-md-3">
				<div class="panel panel-primary">
				  <div class="panel-heading">
				    <h3 class="panel-title">非候选人</h3>
				  </div>
				  <div class="panel-body">
				    <table class="table table-striped table-bordered table-hover">
					    <tr>
				  			<th>姓名:</th>
				  			<th>操作</th>
				  		</tr>
					  	<%
				  			ArrayList<User> others = (ArrayList<User>)request.getSession().getAttribute("others");
				  			for (User user : others) {
				  		%>
				  		<tr>
				  			<td><%=user.getName() %></td>
				  			<td><a href="<%=request.getContextPath() %>/servlet/AddCandidateServlet?id=<%=user.getId() %>">添加</a>
				  		</tr>
				  		<%
				  			}
				  		 %>
				    </table>
				  </div><!-- panel body -->
				</div><!-- panel -->
			  </div><!-- col -->
		 </div><!-- center-block -->
	</div>
	    <div class="copyright">
        @2017 Powered by Andrew
    </div>
</body>
</html>