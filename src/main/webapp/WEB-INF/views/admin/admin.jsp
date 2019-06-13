<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% pageContext.setAttribute("APP_PATH", request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${pageContext.request.contextPath }/static/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/static/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- 标题行 -->
		<div class="row">
			<div class="col-md-12">
				<h1>用户管理</h1>
			</div>
		</div>
		
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-10">
				<button type="button" class="btn btn-success" id="newUser">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					新增用户
				</button>		
			</div>
		</div>
		
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="userTable">
					<thead>
						<tr>
							<th>账号</th>
							<th>密码</th>
							<th>职位</th>
							<th>操作</th>
						</tr>					
					</thead>
					<tbody>						
					</tbody>
				</table>
			</div>
		</div>
		<!-- 分页信息 -->
		<div class="row">
		<!-- 文字信息 -->
			<div class="col-md-6">
				当前
			</div>
		<!-- 分页条 -->
			<div class="col-md-6 col-md-offset-10" >
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				    <li>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li> 
				  </ul>
				</nav>
			</div>
		</div>						
	</div>
	
	<!-- 添加用户的模态框 -->
	<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">新增用户</h4>
	      </div>
	      <div class="modal-body">
	      <!-- 模态框中的表单，要实现同步，需要input的name属性和javabean中的属性一致 -->
	      	<form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">账号</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="userId" id="userId" placeholder="请输入账号">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="userPassword" id="userPassword" placeholder="请输入密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">职位</label>
			    <div class="col-sm-4">
			      <select class="form-control" name="roleId" id="user_add_select">
			      
				  </select>
			    </div>
			  </div>			  
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
	
		<!-- 编辑用户的模态框 -->
	<div class="modal fade" id="EditUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">编辑用户</h4>
	      </div>
	      <div class="modal-body">
	      <!-- 模态框中的表单，要实现同步，需要input的name属性和javabean中的属性一致 -->
	      	<form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">账号</label>
			    <div class="col-sm-10">
			      <p class="form-control-static" name="userId" id="userName_static"></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="userPassword" id="userPassword_update">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">职位</label>
			    <div class="col-sm-4">
			      <select class="form-control" name="roleId" id="user_update_select">
			      
				  </select>
			    </div>
			  </div>			  
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="updateBtn">更新</button>
	      </div>
	    </div>
	  </div>
	</div>	
	<!-- 全局js -->
	<script src="${pageContext.request.contextPath }/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js?v=3.3.6"></script>
    <!-- 引入自定义的js文件 完成函数操作 -->
	<script><%@include file="/static/MYjs/admin.js" %></script>
</body>
</html>