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
	<title>用户注册</title>
</head>
<body>
	<div class="head">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="col-md-4">
		    	<div class="h2">在线投票系统</div>
		    </div>
		</div>
	</div>
	</div>
	
		<div class="col-md-8 col-md-offset-2">
			<div class="panel panel-primary">
				<div class="panel-heading">
				    <div class="h4" align="center">用户注册</div>
				</div>
				<div class="panel-body">
					<form action="<%=request.getContextPath() %>/servlet/RegisterServlet" method="post">
						<div class="row">
							<div class="form-group col-md-4">
								<label>学号</label>
								<input class="form-control" name="id" type="text">
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-4">
								<label>姓名</label>
								<input class="form-control" name="name" type="text">
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-4">
								<label>密码</label>
								<input class="form-control" name="password" type="text">
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-4">
								<label>性别&nbsp;&nbsp;</label>
								<label class="radio-inline">
								    <input type="radio" name="sex" value="male">男
								</label>
								<label class="radio-inline">
								    <input type="radio" name="sex" value="female">女
								</label>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-4">
								<label>城市&nbsp;&nbsp;</label>
								<select name="city" class="form-control">
								  <option value="福州">福州</option>
								  <option value="厦门">厦门</option>
								  <option value="泉州">泉州</option>
								  <option value="晋江">晋江</option>
								  <option value="莆田">莆田</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-8">
								<label>兴趣&nbsp;&nbsp;</label>
								<label class="checkbox-inline">
								    <input type="checkbox" name="hobby" value="唱歌"> 唱歌
								</label>
								<label class="checkbox-inline">
								    <input type="checkbox" name="hobby" value="运动"> 运动
								</label>
								<label class="checkbox-inline">
								    <input type="checkbox" name="hobby" value="看书"> 看书
								</label>
								<label class="checkbox-inline">
								    <input type="checkbox" name="hobby" value="旅游"> 旅游
								</label>
								<label class="checkbox-inline">
								    <input type="checkbox" name="hobby" value="画画"> 画画
								</label>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-8">
							<label>自我介绍&nbsp;&nbsp;</label>
								<textarea class="form-control" name="introduction"rows="5" cols="5"></textarea>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-1">
								<button class="btn btn-primary"type="submit">提交</button>
							</div>
							<div class="form-group col-md-1">
								<button class="btn btn-warning"type="reset">重置</button>
							</div>
						</div>
					</form>
				</div><!-- panel=body -->
			</div><!-- panel -->
		</div><!-- col -->
	
	<div class="tail">
		<div class="copyright" align="center">@2017 Powered by Andrew</div>
	</div>
</body>
</html>