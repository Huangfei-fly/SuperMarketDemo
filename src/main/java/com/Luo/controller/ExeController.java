package com.Luo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Luo.bean.Commodity;
import com.Luo.bean.Executor;
import com.Luo.bean.Msg;
import com.Luo.bean.Purchase;
import com.Luo.bean.Supply;
import com.Luo.bean.User;
import com.Luo.bean.Warehouse;
import com.Luo.service.CommodityService;
import com.Luo.service.PurchaseService;
import com.Luo.service.SupplyService;
import com.Luo.service.WarehouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class ExeController {
	
	@Autowired
	SupplyService supplyService;
	@Autowired
	CommodityService commodityService;
	@Autowired
	WarehouseService warehouseService;
	@Autowired
	com.Luo.service.ExecutorService executorService;
	@Autowired
	PurchaseService purchaseService;
	
	@RequestMapping("/toWareMa")
	public String topage1() {
		return "executor/WareMa";
	}
	
	@RequestMapping("/toPurchase")
	public String topage2() {
		return "executor/Purchase";
	}
	
	@RequestMapping("/toSupply")
	public String topage3() {
		return "executor/Supply";
	}
	
	@RequestMapping("/toStock")
	public String topage4() {
		return "executor/Stock";
	}
	
	@RequestMapping(value = "/getWare",method = RequestMethod.GET)
	@ResponseBody
	public Msg getWare(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Warehouse> warehouse = warehouseService.getWare();
		PageInfo page = new PageInfo(warehouse, 5);
		return Msg.success().add("pageInfo", page);
	}
	
//	getEx
	@RequestMapping(value = "/getEx/{executorId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getEx(@PathVariable("executorId")String executorId) {
		Executor executor = executorService.getEx(executorId);
		return Msg.success().add("executor", executor);
	}
	
	@RequestMapping(value = "/newWare",method = RequestMethod.POST)
	@ResponseBody
	public Msg newWare(Warehouse warehouse) {
		warehouseService.newWare(warehouse);
		return Msg.success();
	}
	
	@RequestMapping(value = "/getWare/{warehouseId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getWareByid(@PathVariable("warehouseId")String warehouseId) {
		Warehouse warehouse = warehouseService.getWareByid(warehouseId);
		return Msg.success().add("warehouse", warehouse);
	}
	
	@RequestMapping(value = "/updateWare/{warehouseId}",method = RequestMethod.PUT)
	@ResponseBody
	public Msg updateWare(Warehouse warehouse) {
		warehouseService.updateWare(warehouse);
		return Msg.success();
	}
	
	@RequestMapping(value = "/delWare/{warehouseId}",method = RequestMethod.DELETE)
	@ResponseBody
	public Msg DelWare(@PathVariable("warehouseId")String warehouseId) {
		warehouseService.delWare(warehouseId);
		return Msg.success();
	}
	
	@RequestMapping(value = "/getSupply",method = RequestMethod.GET)
	@ResponseBody
	public Msg getSupply(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Supply> supply = supplyService.getSupply();
		PageInfo page = new PageInfo(supply, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping(value = "/getCom/{warehouseId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getCom(@PathVariable("warehouseId")String warehouseId) {
		List<Commodity> commodities = commodityService.getByWare(warehouseId);
		return Msg.success().add("commodities", commodities);
	}
	
	@RequestMapping(value = "/newSupply",method = RequestMethod.POST)
	@ResponseBody
	public Msg newSupply(Supply supply) {
		supplyService.newSupply(supply);
		return Msg.success();
	}
	
	@RequestMapping(value = "/Supply/{warehouseId}/{comId}/{supplyNum}",method = RequestMethod.PUT)
	@ResponseBody
	public Msg Supply(@PathVariable("comId")String comId,@PathVariable("warehouseId")String warehouseId,
			@PathVariable("supplyNum")int supplyNum) {
		commodityService.Supply(comId,warehouseId,supplyNum);
		return Msg.success();
		
	}
	
	@RequestMapping(value = "/getPurchase",method = RequestMethod.GET)
	@ResponseBody
	public Msg getPurchase(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Purchase> purchase = purchaseService.getPur();
		PageInfo page = new PageInfo(purchase, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping(value = "/newPurchase",method = RequestMethod.POST)
	@ResponseBody
	public Msg newPurchase(Purchase purchase) {
		purchaseService.newPurchase(purchase);
		return Msg.success();
	}
	
	@RequestMapping(value = "/Purchase/{warehouseId}/{comId}/{purchaseNum}",method = RequestMethod.PUT)
	@ResponseBody
	public Msg Purchase(@PathVariable("comId")String comId,@PathVariable("warehouseId")String warehouId,
			@PathVariable("purchaseNum")int purchaseNum) {
		commodityService.Purchase(comId,warehouId,purchaseNum);
		return Msg.success();
		
	}
	
	@RequestMapping(value = "/getStock/{warehouseId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getStock(@RequestParam(value = "pn", defaultValue = "1") Integer pn,@PathVariable("warehouseId")String warehouseId) {
		PageHelper.startPage(pn, 5);
		List<Commodity> commoditiy = commodityService.getByWare(warehouseId);
		PageInfo page = new PageInfo(commoditiy, 5);
		return Msg.success().add("pageInfo", page);
	}
}
