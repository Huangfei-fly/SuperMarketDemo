function to_page(pn){
	$.ajax({
		url:"${APP_PATH}/getCom1",
		data:"pn="+pn,
		type:"GET",
		success:function(result){
			bulid_page_nav(result);
			build_page_info(result);
			build_Com_table(result);
		}
	});
}

to_page(1);

/*建立订单表*/
function build_Com_table(result){
	$("#ComTable tbody").empty();
	var com = result.extend.pageInfo.list;
	$.each(com,function(index,item){
		var comIdTd = $("<td></td>").append(item.comId);
		var comNameTd = $("<td></td>").append(item.comName);
		var priceTd = $("<td></td>").append(item.sellPrice);
		var delBtn = $("<button></button>").addClass("btn btn-danger del-btn").attr("del-id",item.comId).append("delete");
		var EditBtn = $("<button></button>").addClass("btn btn-success edit-btn").attr("edit-id",item.comId).append("edit");
		var BtnTd = $("<td></td>").append(EditBtn).append(" ").append(delBtn);
		$("<tr></tr>")
		.append(comIdTd)
		.append(comNameTd)
		.append(priceTd)
		.append(BtnTd)
		.appendTo("#ComTable tbody");
	});
}

/*新增按钮的操作*/
$('#newCom').on('click',function(){
	$('#addComModal').modal({
		backdrop:'static'
	});
})

/*模态框的保存按钮操作*/
$("#saveBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/newCom1",
		data:$("#addComModal form").serialize(),
		type:"POST",
		success:function(result){
			
			to_page(1);
			$('#addComModal').modal('hide');
		}
	})
})

/*edit按钮的操作 弹出修改模态框*/
$(document).on("click",".edit-btn",function(){
	getCom1($(this).attr("edit-id"));
	$("#updateBtn").attr("edit-id",$(this).attr("edit-id"));
	$('#EditComModal').modal({
		backdrop:'static'
	});
})

function getCom1(id){
	$.ajax({
		url:"${APP_PATH}/getCom1/"+id,
		type:"GET",
		success:function(result){
			var com = result.extend.commodity;
			$("#comId1").text(com.comId);
			$("#comName1").val(com.comName);
			$("#sellPrice1").val(com.sellPrice);
		}
	})
}

/*为更新按钮绑定事件 实现修改用户信息*/
$("#updateBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/updateCom/"+$(this).attr("edit-id"),
		type:"POST",
		data:$("#EditComModal form").serialize()+"&_method=PUT",
		success:function(result){
			alert(result.msg);
			to_page(1);
			$('#EditComModal').modal('hide');
		}
	})
})

/*删除按钮*/
$(document).on("click",".del-btn",function(){
	$.ajax({
		url:"${APP_PATH}/delCom1/"+$(this).attr("del-id"),
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

function build_page_info(result) {
	$("#page_info_area").empty();
	$("#page_info_area").append(
			"now is the " + result.extend.pageInfo.pageNum + " page");
	totalRecord = result.extend.pageInfo.total;
	currentPage = result.extend.pageInfo.pageNum;
}