/*ajaxè¯·æ±å®æè§£æ*/
function to_page(pn){
	$("#newShop").attr("mag-id","manager");
	$.ajax({
		url:"${APP_PATH }/getShop",
		data:"pn="+pn,
		type:"GET",
		success:function(result){
//			build_shop_table(result);
			build_shop_table(result);
		}
	});
}
to_page(1);

/*建立连锁店表*/
function build_shop_table(result){
	$("#shopTable tbody").empty();
	var shop = result.extend.pageInfo.list;
	$.each(shop,function(index,item){
		var shopIdTd = $("<td></td>").append(item.shopId);
		var shopNameTd = $("<td></td>").append(item.shopName);
		var addressTd = $("<td></td>").append(item.address);
		var phoneTd = $("<td></td>").append(item.phone);
		var managerTd = $("<td></td>").append(item.manager.managerName);
		var delBtn = $("<button></button>").addClass("btn btn-danger del-btn").attr("del-id",item.shopId).append("close");
		var EditBtn = $("<button></button>").addClass("btn btn-success edit-btn").attr("edit-id",item.shopId).append("edit");
		var BtnTd = $("<td></td>").append(EditBtn).append(" ").append(delBtn);
		$("<tr></tr>").append(shopIdTd)
		.append(shopNameTd)
		.append(addressTd)
		.append(phoneTd)
		.append(managerTd).
		append(BtnTd)
		.appendTo("#shopTable tbody");
	});
}

/*新增按钮的操作*/
$('#newShop').on('click',function(){
	getManager($(this).attr("mag-id"));
	$('#addShopModal').modal({
		backdrop:'static'
	});
})

/*模态框的保存按钮操作*/
$("#saveBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/newShop",
		data:$("#addShopModal form").serialize(),
		type:"POST",
		success:function(result){
			
			to_page(1);
			$('#addShopModal').modal('hide');
		}
	})
})

/*取得当前经理*/
function getManager(id){
	$.ajax({
		url:"${APP_PATH}/getManager/"+id,
		type:"GET",
		success:function(result){
			console.log(result);
			var magByid = result.extend.manager;
			$("#managerId").text(magByid.managerId);
			$("#managerId").val(magByid.managerId);
			$("#managerName_static").text(magByid.managerName);
		}
	})
}

function getShopByid(id){
	$.ajax({
		url:"${APP_PATH}/getShop/"+id,
		type:"GET",
		success:function(result){
			console.log(result);
			var shopByid = result.extend.shop;
			$("#shopId_static_update").text(shopByid.shopId);
			$("#shopName_update").val(shopByid.shopName);
			$("#address_update").val(shopByid.address);
			$("#phone_update").val(shopByid.phone);
		}
	})
}

/*edit按钮的操作 弹出修改模态框*/
$(document).on("click",".edit-btn",function(){
	getShopByid($(this).attr("edit-id"));
	$("#updateBtn").attr("edit-id",$(this).attr("edit-id"));
	$('#EditShopModal').modal({
		backdrop:'static'
	});
})

/*删除按钮*/
$(document).on("click",".del-btn",function(){
	$.ajax({
		url:"${APP_PATH}/delShop/"+$(this).attr("del-id"),
		type:"DELETE",
		success:function(result){
			alert(result.msg);
			to_page(1);
		}
	})
})

/*为更新按钮绑定事件 实现修改用户信息*/
$("#updateBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/updateShop/"+$(this).attr("edit-id"),
		type:"POST",
		data:$("#EditShopModal form").serialize()+"&_method=PUT",
		success:function(result){
			alert(result.msg);
			to_page(1);
			$('#EditShopModal').modal('hide');
		}
	})
})