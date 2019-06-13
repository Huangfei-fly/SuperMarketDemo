function to_page(pn){
	$.ajax({
		url:"${APP_PATH}/getPurchase",
		data:"pn="+pn,
		type:"GET",
		success:function(result){
			bulid_page_nav(result);
			build_supply_table(result);
		}
	});
}

to_page(1);

/*建立订单表*/
function build_supply_table(result){
	$("#purchaseTable tbody").empty();
	var purchase = result.extend.pageInfo.list;
	$.each(purchase,function(index,item){
		var wareNameTd = $("<td></td>").append(item.warehouse.warehouseName);
		var comNameTd = $("<td></td>").append(item.commodity.comName);
		var NumTd = $("<td></td>").append(item.purchaseNum);
		$("<tr></tr>").append(wareNameTd)
		.append(comNameTd)
		.append(NumTd)
		.appendTo("#purchaseTable tbody");
	});
}

/*新增按钮的操作*/
$('#newPurchase').on('click',function(){
	getIt();
	$('#addPurchaseModal').modal({
		backdrop:'static'
	});
})

/*取得 放在下拉列表中*/
function getIt(){
	$("#warehouseId").empty();
	$.ajax({
		url:"${APP_PATH}/getWare",
		type:"GET",
		success:function(result){
			$.each(result.extend.pageInfo.list,function(){
				var optionEle = $("<option></option>").append(this.warehouseName).attr("value",this.warehouseId);
				optionEle.appendTo("#warehouseId");
			})
		}
	});
	
}

/*查询按钮操作*/
$("#getComW").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/getCom/"+$("#warehouseId").find("option:selected").attr("value"),
		type:"GET",
		success:function(result){
			$("#comId").empty();
			$.each(result.extend.commodities,function(){
				var optionEle = $("<option></option>").append(this.comName).attr("value",this.comId);
				optionEle.appendTo("#comId");
			})
		}
	})
})

/*模态框的保存按钮操作*/
$("#saveBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/newPurchase",
		type:"POST",
		data:$("#addPurchaseModal form").serialize(),
		success:function(result){
			$.ajax({
				url:"${APP_PATH}/Purchase/"+$("#warehouseId").find("option:selected").attr("value")
					+"/"+$("#comId").find("option:selected").attr("value")+"/"+$("#purchaseNum").val(),
				type:"POST",
				data:$("#addPurchaseModal form").serialize()+"&_method=PUT",
				success:function(result){
					to_page(1);
					$('#addPurchaseModal').modal('hide');					
				}
			})

		}
	})
	
})

		//解析显示分页条,点击分页有链接
		function bulid_page_nav(result) {
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");

			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("first").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//点击翻页事件
				firstPageLi.click(function() {
					to_page(1);
				});
				prePageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum - 1);
				});

			}

			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("tail").attr("href", "#"));
			if (result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum + 1);
				});
				lastPageLi.click(function() {
					to_page(result.extend.pageInfo.pages);
				});
			}

			//添加首页和前一页的提示
			ul.append(firstPageLi).append(prePageLi);
			//遍历给ul添加页码提示
			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {

				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页的提示
			ul.append(nextPageLi).append(lastPageLi);

			//ul加入到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}

