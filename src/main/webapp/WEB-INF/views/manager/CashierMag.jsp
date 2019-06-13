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
				<h1>员工管理</h1>
			</div>
		</div>
		
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-10">
				<button type="button" class="btn btn-success" id="newCashier">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					录入新员工
				</button>		
			</div>
		</div>
		
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="cashierTable">
					<thead>
						<tr>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>生日</th>
							<th>性别</th>
							<th>电话</th>
							<th>所在连锁店</th>
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
	
	<!-- 添加新员工的模态框 -->
	<div class="modal fade" id="addCashierModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">新员工信息</h4>
	      </div>
	      <div class="modal-body">
	      <!-- 模态框中的表单，要实现同步，需要input的name属性和javabean中的属性一致 -->
	      	<form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">员工编号</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="cashierId" id="cashierId" placeholder="请输入编号">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="cashierName" id="cashierName" placeholder="请输入姓名">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
			    <div class="col-sm-10">
			      <select class="form-control" name="gender" id="gender_select">
					  
				  </select>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">生日</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="birthday" id="birthday" placeholder="格式为 0000-00-00">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">电话</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="phone" id="phone" placeholder="请输入电话">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">所在连锁店</label>
			    <div class="col-sm-10">
			      <select class="form-control" name="shopId" id="shopId_select">
					  
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
	
	<!-- 全局js -->
	<script src="${pageContext.request.contextPath }/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js?v=3.3.6"></script>
    <!-- 引入自定义的js文件 完成函数操作 -->
	<script><%@include file="/static/MYjs/CashierMag.js" %></script>
</body>
</html>