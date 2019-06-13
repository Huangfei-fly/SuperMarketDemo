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
				<h1>商品管理</h1>
			</div>
		</div>
		
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-10">
				<button type="button" class="btn btn-success" id="newCom">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					添加商品
				</button>		
			</div>
		</div>
		
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="ComTable">
					<thead>
						<tr>
							<th>商品Id</th>
							<th>商品名称</th>
							<th>售价</th>
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
			<div class="row">
							<!-- 文字信息 -->
							<div class="col-md-6" id="page_info_area"></div>
							<!-- 分页条 -->
							<div class="col-md-6" id="page_nav_area"></div>
			</div>
		</div>						
	</div>
	
	<!-- 添加用户的模态框 -->
	<div class="modal fade" id="addComModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">添加商品</h4>
	      </div>
	      <div class="modal-body">
	      <!-- 模态框中的表单，要实现同步，需要input的name属性和javabean中的属性一致 -->
	      	<form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-4 control-label">商品编号</label>
			    <div class="col-sm-8">
			      <input type="text"form-control" name="comId" id="comId" placeholder="请输入商品ID">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label">商品名称</label>
			    <div class="col-sm-8">
			      <input type="text"form-control" name="comName" id="comName" placeholder="请输入商品名称">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-4 control-label">售价</label>
			    <div class="col-sm-8">
			      <input type="number" form-control" name="sellPrice" id=sellPrice placeholder="请输入商品售价">
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
	<div class="modal fade" id="EditComModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">编辑商品</h4>
	      </div>
	      <div class="modal-body">
	      <!-- 模态框中的表单，要实现同步，需要input的name属性和javabean中的属性一致 -->
	      	<form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">商品编号</label>
			    <div class="col-sm-10">
			      <p class="form-control-static" name="comId" id="comId1"></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">商品名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="comName" id="comName1">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">售价</label>
			    <div class="col-sm-4">
			      <input type="number" class="form-control" name="sellPrice" id="sellPrice1">
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
	<script><%@include file="/static/MYjs/Com.js" %></script>
</body>
</html>