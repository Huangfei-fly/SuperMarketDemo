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
import com.Luo.bean.Manager;
import com.Luo.bean.Msg;
import com.Luo.bean.Shop;
import com.Luo.bean.User;
import com.Luo.service.BillService;
import com.Luo.service.CashierService;
import com.Luo.service.ManagerService;
import com.Luo.service.ShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class ManagerController {
	
	@Autowired
	ShopService shopService;
	@Autowired
	ManagerService managerService;
	@Autowired
	CashierService cashierService;
	@Autowired
	BillService billService;
	/* 跳转到连锁店管理页面 */
	@RequestMapping("/ToShopManage")
	public String ToShopManage() {
		return "manager/ShopManage";
	}
	
	@RequestMapping("/ToSellForm")
	public String ToSellForm() {
		return "manager/SellForm";
	}
	/* 查询连锁店 */
	@RequestMapping(value = "/getShop", method = RequestMethod.GET)
	@ResponseBody
	public Msg ToAdmin1(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Shop> shop = shopService.getShop();
		PageInfo page = new PageInfo(shop, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/* 新增连锁店 */
	@RequestMapping(value = "/newShop", method = RequestMethod.POST)
	@ResponseBody
	public Msg AddShop(Shop shop) {
		shopService.addShop(shop);
		return Msg.success();
	}
	
	/* 以id取得经理信息 */
	@RequestMapping(value = "/getManager/{managerId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg GetManager(@PathVariable("managerId") String id) {
		Manager manager = managerService.getMag(id);
		return Msg.success().add("manager", manager);
	}
	
	@RequestMapping(value = "/getShop/{shopId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getshopMsg(@PathVariable("shopId") String id) {
		Shop shop = shopService.getShopByid(id);
		return Msg.success().add("shop", shop);
	}
	
	/* 删除用户 */
	@RequestMapping(value = "/delShop/{shopId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delUser(@PathVariable("shopId")String shopId) {
		shopService.delShop(shopId);
	}
	
	@RequestMapping("/ToCashierManage")
	public String ToCashier() {
		return "/manager/CashierMag";
	}
	
	/* 查询员工 */
	@RequestMapping(value = "/getCashier", method = RequestMethod.GET)
	@ResponseBody
	public Msg ToCashier(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Cashier> cashier = cashierService.getCashier();
		PageInfo page = new PageInfo(cashier, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping(value = "/updateShop/{shopId}",method = RequestMethod.PUT)
	@ResponseBody
	public Msg UpdateShop(Shop shop) {
		shopService.updateShop(shop);
		return Msg.success();
	}
	
	@RequestMapping(value = "/newCashier",method = RequestMethod.POST)
	@ResponseBody
	public Msg newCashierMsg(Cashier cashier) {
		cashierService.newCashier(cashier);
		return Msg.success();
	}
	
	@RequestMapping(value = "/delCashier/{cashierId}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCashier(@PathVariable("cashierId")String cashierId) {
		cashierService.deleteCa(cashierId);
	}
	
	
	/* 查询订单 */
	@RequestMapping(value = "/getBill", method = RequestMethod.GET)
	@ResponseBody
	public Msg getBill(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Bill> bill = billService.getbill();
		PageInfo page = new PageInfo(bill, 5);
		return Msg.success().add("pageInfo", page);
	}
}
