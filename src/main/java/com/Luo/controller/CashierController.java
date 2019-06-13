package com.Luo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Luo.bean.Bill;
import com.Luo.bean.Cashier;
import com.Luo.bean.Commodity;
import com.Luo.bean.Msg;
import com.Luo.bean.Shop;
import com.Luo.service.BillService;
import com.Luo.service.CashierService;
import com.Luo.service.CommodityService;
import com.Luo.service.ShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CashierController {
	
	@Autowired
	CommodityService commodityService;
	@Autowired
	ShopService shopService;
	@Autowired
	CashierService cashierService;
	@Autowired
	BillService billService;
	/* Ò³ÃæÌø×ª */
	@RequestMapping("/toSell")
	public String toPage() {
		return "cashier/Sell";
	}
	
	@RequestMapping("/toSellFormC")
	public String toPage1() {
		return "cashier/SellForm";
	}
	
	@RequestMapping("/toComManage")
	public String toPage2() {
		return "cashier/comManage";
	}
	
	@RequestMapping(value = "/getCom",method = RequestMethod.GET)
	@ResponseBody
	public Msg getCom() {
		List<Commodity> commodities = commodityService.getAll();
		return Msg.success().add("commodities", commodities);
	}
	
	@RequestMapping(value = "/getSHop/{shopId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getShop(@PathVariable("shopId")String shopId) {
		Shop shop = shopService.getShopByid(shopId);
		return Msg.success().add("shop", shop);
	}
	
	@RequestMapping(value = "/getCashier/{cashierId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getCa(@PathVariable("cashierId")String cashierId) {
		
		Cashier cashier = cashierService.getByid(cashierId);
		return Msg.success().add("cashier", cashier);
	}
	
	@RequestMapping(value = "/newBill",method = RequestMethod.POST)
	@ResponseBody
	public Msg addBill(Bill bill) {
		billService.addBill(bill);
		return Msg.success();
	}
	
	@RequestMapping(value = "/getBill/{cashierId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getBill(@RequestParam(value = "pn", defaultValue = "1") Integer pn,@PathVariable("cashierId")String cashierId) {
		PageHelper.startPage(pn, 5);
		List<Bill> bill = billService.getBillByca(cashierId);
		PageInfo page = new PageInfo(bill, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping(value = "/delBill",method = RequestMethod.DELETE)
	@ResponseBody
	public Msg DelBill(Bill bill) {
		billService.delBill(bill);
		return Msg.success();
	}
	
	@RequestMapping(value = "/getCom1",method = RequestMethod.GET)
	@ResponseBody
	public Msg getBill(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Commodity> commodity = commodityService.getAll();
		PageInfo page = new PageInfo(commodity, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping(value = "/newCom1",method = RequestMethod.POST)
	@ResponseBody
	public Msg newCom(Commodity commodity) {
		commodityService.newCom(commodity);
		return Msg.success();
	}
	
	@RequestMapping(value = "/getCom1/{comId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getComById(@PathVariable("comId")String comId) {
		Commodity commodity = commodityService.getById(comId);
		return Msg.success().add("commodity", commodity);
	}
	
	@RequestMapping(value = "/updateCom/{comId}",method = RequestMethod.PUT)
	@ResponseBody
	public Msg updateCom(Commodity commodity) {
		commodityService.updateById(commodity);
		return Msg.success();
	}
	
	@RequestMapping(value = "/delCom1/{comId}",method = RequestMethod.DELETE)
	@ResponseBody
	public Msg delCom(@PathVariable("comId")String comId) {
		commodityService.delCom(comId);
		return Msg.success();
	}
}
