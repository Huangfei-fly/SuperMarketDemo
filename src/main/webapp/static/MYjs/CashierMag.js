function to_page(pn){
	$.ajax({
		url:"${APP_PATH}/getCashier",
		data:"pn="+pn,
		type:"GET",
		success:function(result){
			build_cashier_table(result);
		}
	});
}

to_page(1);

/*建立用户表*/
function build_cashier_table(result){
	$("#cashierTable tbody").empty();
	var cashier = result.extend.pageInfo.list;
	$.each(cashier,function(index,item){
		var cashierIdTd = $("<td></td>").append(item.cashierId);
		var cashierNameTd = $("<td></td>").append(item.cashierName);
		var birthdayTd = $("<td></td>").append(item.birthday);
		var genderTd = $("<td></td>").append(item.gender==1?"man":"women");
		var phoneTd = $("<td></td>").append(item.phone);
		var shopTd = $("<td></td>").append(item.shop.shopName);
		var delBtn = $("<button></button>").addClass("btn btn-danger del-btn").attr("del-id",item.cashierId).append("delete");
		$("<tr></tr>").append(cashierIdTd)
		.append(cashierNameTd)
		.append(birthdayTd)
		.append(genderTd)
		.append(phoneTd)
		.append(shopTd)
		.append(delBtn)
		.appendTo("#cashierTable tbody");
	});
}

/*新增按钮的操作*/
$('#newCashier').on('click',function(){
	gender("#gender_select");
	getShop("#shopId_select");
	$('#addCashierModal').modal({
		backdrop:'static'
	});
})

/*取得性别 放在下拉列表中*/
function gender(ele){
	$(ele).empty();
	var optionEle = $("<option></option>").append("men").attr("value",1);
	var optionEle1 = $("<option></option>").append("women").attr("value",0);
	optionEle.appendTo(ele);
	optionEle1.appendTo(ele);
}

/*取得连锁店名 放在下拉列表中*/
function getShop(ele){
	$(ele).empty();
	$.ajax({
		url:"${APP_PATH}/getShop",
		type:"GET",
		success:function(result){
			$.each(result.extend.pageInfo.list,function(){
				var optionEle = $("<option></option>").append(this.shopName).attr("value",this.shopId);
				optionEle.appendTo(ele);
			})
		}
	});
}

/*模态框的保存按钮操作*/
$("#saveBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/newCashier",
		data:$("#addCashierModal form").serialize(),
		type:"POST",
		success:function(result){
			to_page(1);
			$('#addCashierModal').modal('hide');
		}
	})
})

/*删除按钮*/
$(document).on("click",".del-btn",function(){
	$.ajax({
		url:"${APP_PATH}/delCashier/"+$(this).attr("del-id"),
		type:"DELETE",
		success:function(result){
			alert(result.msg);
			to_page(1);
		}
	})
})