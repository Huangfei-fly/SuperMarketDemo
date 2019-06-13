function to_page(pn){
	$.ajax({
		url:"${APP_PATH}/getBill",
		data:"pn="+pn,
		type:"GET",
		success:function(result){
			build_bill_table(result);
		}
	});
}

to_page(1);

/*建立订单表*/
function build_bill_table(result){
	$("#billTable tbody").empty();
	var bill = result.extend.pageInfo.list;
	$.each(bill,function(index,item){
		var shopIdTd = $("<td></td>").append(item.shopId);
		var shopNameTd = $("<td></td>").append(item.shop.shopName);
		var cashierIdTd = $("<td></td>").append(item.cashierId);
		var cashierNameTd = $("<td></td>").append(item.cashier.cashierName);
		var comIdTd = $("<td></td>").append(item.comId);
		var comNameTd = $("<td></td>").append(item.commodity.comName);
		var priceTd = $("<td></td>").append(item.commodity.sellPrice);
		var sellNumTd = $("<td></td>").append(item.sellNum);
		var totalPriceTd = $("<td></td>").append();
		$("<tr></tr>").append(shopIdTd)
		.append(shopNameTd)
		.append(cashierIdTd)
		.append(cashierNameTd)
		.append(comIdTd)
		.append(comNameTd)
		.append(priceTd)
		.append(sellNumTd)
		.append(totalPriceTd)
		.appendTo("#billTable tbody");
	});
}