/*新增按钮的操作*/
$("#newSell").attr("caId","cashier1");
$("#newSell").attr("shopId","001");

$('#newSell').on('click',function(){
	getCa($(this).attr("caId"));
	getShop($(this).attr("shopId"));
	getCom("#comId");
	$('#addSellModal').modal({
		backdrop:'static'
	});
})

function getCom(ele){
	$(ele).empty();
	$.ajax({
		url:"${APP_PATH}/getCom",
		type:"GET",
		success:function(result){
			$.each(result.extend.commodities,function(){
				var optionEle = $("<option></option>").append(this.comName).attr("value",this.comId);
				optionEle.appendTo(ele);
			})
		}
	});
}

function getShop(id){
	$("#shopId").empty();
	$.ajax({
		url:"${APP_PATH}/getShop/"+id,
		type:"GET",
		success:function(result){
				var shop = result.extend.shop;
				var optionEle = $("<option></option>").append(shop.shopName).attr("value",shop.shopId);
				optionEle.appendTo("#shopId");
		}
	});
}

function getCa(id){
	$("#cashierId").empty();
	$.ajax({
		url:"${APP_PATH}/getCashier/"+id,
		type:"GET",
		success:function(result){
				var cashier = result.extend.cashier;
				var optionEle = $("<option></option>").append(cashier.cashierName).attr("value",cashier.cashierId);
				optionEle.appendTo("#cashierId");
		}
	});
}

/*模态框的保存按钮操作*/
$("#saveBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/newBill",
		data:$("#addSellModal form").serialize(),
		type:"POST",
		success:function(result){0
			$('#addSellModal').modal('hide');
		}
	})
})

function to_page(pn){
	$.ajax({
		url:"${APP_PATH}/getBill/"+$("#newSell").attr("caId"),
		data:"pn="+pn,
		type:"GET",
		success:function(result){
			bulid_page_nav(result);
			build_page_info(result);
			build_bill_table(result);
		}
	});
}

to_page(1);

/*建立订单表*/
function build_bill_table(result){
	$("#BillTable tbody").empty();
	var bill = result.extend.pageInfo.list;
	$.each(bill,function(index,item){
		var shopNameTd = $("<td></td>").append(item.shop.shopName);
		var comNameTd = $("<td></td>").append(item.commodity.comName);
		var priceTd = $("<td></td>").append(item.commodity.sellPrice);
		var sellNumTd = $("<td></td>").append(item.sellNum);
		var delBtn = $("<button></button>").addClass("btn btn-danger del-btn").append("delete");
		$("<tr></tr>")
		.append(shopNameTd)
		.append(comNameTd)
		.append(priceTd)
		.append(sellNumTd)
		.append(delBtn)
		.appendTo("#BillTable tbody");
	});
}

function build_page_info(result) {
	$("#page_info_area").empty();
	$("#page_info_area").append(
			"now is the " + result.extend.pageInfo.pageNum + " page");
	totalRecord = result.extend.pageInfo.total;
	currentPage = result.extend.pageInfo.pageNum;
}

/*删除按钮*/
$(document).on("click",".del-btn",function(){
	$.ajax({
		url:"${APP_PATH}/delBill",
		type:"DELETE",
		success:function(result){
			alert(result.msg);
			to_page(1);
		}
	})
})

//解析显示分页条,点击分页有链接
function bulid_page_nav(result) {
	$("#page_nav_area").empty();
	var ul = $("<ul></ul>").addClass("pagination");

	var firstPageLi = $("<li></li>").append(
			$("<a></a>").append("First").attr("href", "#"));
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
			$("<a></a>").append("Tail").attr("href", "#"));
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
