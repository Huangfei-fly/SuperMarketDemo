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
				<h1>进货记录</h1>
			</div>
		</div>
		
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-10">
				<button type="button" class="btn btn-success" id="newPurchase">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					进货
				</button>		
			</div>
		</div>
		
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="purchaseTable">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>仓库名称</th>
							<th>进货数量</th>
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
			<div class="col-md-6" id="page_info_area"></div>
							<!-- 分页条 -->
			<div class="col-md-6" id="page_nav_area"></div>
		</div>
						
	</div>
	
	<!-- 添加用户的模态框 -->
	<div class="modal fade" id="addPurchaseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">进货</h4>
	      </div>
	      <div class="modal-body">
	      <!-- 模态框中的表单，要实现同步，需要input的name属性和javabean中的属性一致 -->
	      	<form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">仓库编号</label>
			    <div class="col-sm-10">
			      <select class="form-control" name="warehouseId" id="warehouseId">
			      
				  </select>
				  <button type="button" class="btn btn-success" id="getComW">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					查询
				  </button>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">商品</label>
			    <div class="col-sm-4">
			      <select class="form-control" name="comId" id="comId">
			      
				  </select>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">进货数量</label>
			    <div class="col-sm-4">
			      <input type="number" class="form-control" name="purchaseNum" id="purchaseNum" placeholder="请输入进货数量">
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
	<script><%@include file="/static/MYjs/Purchase.js" %></script>
</body>
</html>