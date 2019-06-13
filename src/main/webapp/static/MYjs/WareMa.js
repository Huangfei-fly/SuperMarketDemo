$("#newWare").attr("ExId","executor1");

function to_page(pn){
	$.ajax({
		url:"${APP_PATH}/getWare",
		data:"pn="+pn,
		type:"GET",
		success:function(result){
			console.log(result);
			build_ware_table(result);
		}
	});
}

to_page(1);

/*建立用户表*/
function build_ware_table(result){
	$("#wareTable tbody").empty();
	var ware = result.extend.pageInfo.list;
	$.each(ware,function(index,item){
		var warehouseId = $("<td></td>").append(item.warehouseId);
		var warehouseName = $("<td></td>").append(item.warehouseName);
		var address = $("<td></td>").append(item.address);
		var phone = $("<td></td>").append(item.phone);
		var delBtn = $("<button></button>").addClass("btn btn-danger del-btn").attr("del-id",item.warehouseId).append("delete");
		var EditBtn = $("<button></button>").addClass("btn btn-success edit-btn").attr("edit-id",item.warehouseId).append("edit");
		var BtnTd = $("<td></td>").append(EditBtn).append(" ").append(delBtn);
		$("<tr></tr>").append(warehouseId)
		.append(warehouseName)
		.append(address)
		.append(phone)
		.append(BtnTd)
		.appendTo("#wareTable tbody");
	});
}

/*新增按钮的操作*/
$('#newWare').on('click',function(){
	getEx($(this).attr("exid"));
	$('#addWareModal').modal({
		backdrop:'static'
	});
})

function getEx(id){
	$.ajax({
		url:"${APP_PATH}/getEx/"+id,
		type:"GET",
		success:function(result){
			var Ex = result.extend.executor;
			var optionEle = $("<option></option>").append(Ex.executorName).attr("value",Ex.executorId);
			optionEle.appendTo("#executorId");
		}
	})
}

/*模态框的保存按钮操作*/
$("#saveBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/newWare",
		data:$("#addWareModal form").serialize(),
		type:"POST",
		success:function(result){
			
			to_page(1);
			$('#addWareModal').modal('hide');
		}
	})
})

/*edit按钮的操作 弹出修改模态框*/
$(document).on("click",".edit-btn",function(){
	$("#updateBtn").attr("edit-id",$(this).attr("edit-id"));
	getWare($(this).attr("edit-id"));
	$('#EditWareModal').modal({
		backdrop:'static'
	});
})

function getWare(id){
	$.ajax({
		url:"${APP_PATH}/getWare/"+id,
		type:"GET",
		success:function(result){
			var Ex = result.extend.warehouse;
			$("#warehouseId1").text(Ex.warehouseId);
			$("#warehouseName1").val(Ex.warehouseName);
			$("#address1").val(Ex.address);
			$("#phone1").val(Ex.phone);
		}
	})
}

/*为更新按钮绑定事件 实现修改用户信息*/
$("#updateBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/updateWare/"+$(this).attr("edit-id"),
		type:"POST",
		data:$("#EditWareModal form").serialize()+"&_method=PUT",
		success:function(result){
			alert(result.msg);
			to_page(1);
			$('#EditWareModal').modal('hide');
		}
	})
})

/*删除按钮*/
$(document).on("click",".del-btn",function(){
	$.ajax({
		url:"${APP_PATH}/delWare/"+$(this).attr("del-id"),
		type:"DELETE",
		success:function(result){
			alert(result.msg);
			to_page(1);
		}
	})
})