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
				<h1>订单详情</h1>
			</div>
		</div>
			
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="billTable">
					<thead>
						<tr>
							<th>连锁店id</th>
							<th>连锁店名称</th>
							<th>收银员id</th>
							<th>收银员姓名</th>
							<th>商品id</th>
							<th>商品名称</th>
							<th>售价</th>
							<th>售出数量</th>
							<th>总价</th>
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
		<!-- 全局js -->
	<script src="${pageContext.request.contextPath }/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js?v=3.3.6"></script>
    <!-- 引入自定义的js文件 完成函数操作 -->
	<script><%@include file="/static/MYjs/SellForm.js" %></script>
</body>
</html>