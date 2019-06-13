/*ajaxè¯·æ±å®æè§£æ*/
function to_page(pn){
	$.ajax({
		url:"${APP_PATH}/getUser",
		data:"pn="+pn,
		type:"GET",
		success:function(result){
			console.log(result);
			build_user_table(result);
		}
	});
}

to_page(1);

/*建立用户表*/
function build_user_table(result){
	$("#userTable tbody").empty();
	var user = result.extend.pageInfo.list;
	$.each(user,function(index,item){
		var userIdTd = $("<td></td>").append(item.userId);
		var userPasswordTd = $("<td></td>").append(item.userPassword);
		var roleNameTd = $("<td></td>").append(item.role.roleName);
		var delBtn = $("<button></button>").addClass("btn btn-danger del-btn").attr("del-id",item.userId).append("delete");
		var EditBtn = $("<button></button>").addClass("btn btn-success edit-btn").attr("edit-id",item.userId).append("edit");
		var BtnTd = $("<td></td>").append(EditBtn).append(" ").append(delBtn);
		$("<tr></tr>").append(userIdTd)
		.append(userPasswordTd)
		.append(roleNameTd)
		.append(BtnTd)
		.appendTo("#userTable tbody");
	});
}

/*新增按钮的操作*/
$('#newUser').on('click',function(){
	getRole('#addUserModal select');
	$('#addUserModal').modal({
		backdrop:'static'
	});
})

/*取得权限名 放在下拉列表中*/
function getRole(ele){
	$(ele).empty();
	$.ajax({
		url:"${APP_PATH}/getRoles",
		type:"GET",
		success:function(result){
			$.each(result.extend.role,function(){
				var optionEle = $("<option></option>").append(this.roleName).attr("value",this.roleId);
				optionEle.appendTo(ele);
			})
		}
	});
}

/*模态框的保存按钮操作*/
$("#saveBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/newUser",
		data:$("#addUserModal form").serialize(),
		type:"POST",
		success:function(result){
			
			to_page(1);
			$('#addUserModal').modal('hide');
		}
	})
})

function getUser(id){
	$.ajax({
		url:"${APP_PATH}/getUser/"+id,
		type:"GET",
		success:function(result){
			console.log(result);
			var userByid = result.extend.user1;
			$("#userName_static").text(userByid.userId);
			$("#userPassword_update").val(userByid.userPassword);
			$("#EditUserModal select").val(userByid.roleId);
		}
	})
}
/*edit按钮的操作 弹出修改模态框*/
$(document).on("click",".edit-btn",function(){
	getRole('#EditUserModal select');
	getUser($(this).attr("edit-id"));
	$("#updateBtn").attr("edit-id",$(this).attr("edit-id"));
	$('#EditUserModal').modal({
		backdrop:'static'
	});
})

/*为更新按钮绑定事件 实现修改用户信息*/
$("#updateBtn").on("click",function(){
	$.ajax({
		url:"${APP_PATH}/updateUser/"+$(this).attr("edit-id"),
		type:"POST",
		data:$("#EditUserModal form").serialize()+"&_method=PUT",
		success:function(result){
			alert(result.msg);
			to_page(1);
			$('#EditUserModal').modal('hide');
		}
	})
})

/*删除按钮*/
$(document).on("click",".del-btn",function(){
	$.ajax({
		url:"${APP_PATH}/delUser/"+$(this).attr("del-id"),
		type:"DELETE",
		success:function(result){
			alert(result.msg);
			to_page(1);
		}
	})
})
