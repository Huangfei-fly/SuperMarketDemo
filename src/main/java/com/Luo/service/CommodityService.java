package com.Luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.Commodity;
import com.Luo.dao.CommodityMapper;

@Service
public class CommodityService {

	@Autowired
	CommodityMapper commodityMapper;
	
	public List<Commodity> getAll() {
		// TODO Auto-generated method stub
		return commodityMapper.selectByExample(null);
	}

	public void newCom(Commodity commodity) {
		// TODO Auto-generated method stub
		commodityMapper.insertSelective(commodity);
	}

	public Commodity getById(String comId) {
		// TODO Auto-generated method stub
		return commodityMapper.selectByPrimaryKey(comId);
	}

	public void updateById(Commodity commodity) {
		// TODO Auto-generated method stub
		commodityMapper.updateByPrimaryKeySelective(commodity);
	}

	public void delCom(String comId) {
		// TODO Auto-generated method stub
		commodityMapper.deleteByPrimaryKey(comId);
	}

	public List<Commodity> getByWare(String warehouseId) {
		// TODO Auto-generated method stub
		return commodityMapper.selectByWare(warehouseId);
	}

	public void Supply(String comId, String warehouseId, int supplyNum) {
		// TODO Auto-generated method stub
		commodityMapper.supply(comId, warehouseId, supplyNum);
	}

	public void Purchase(String comId, String warehouseId, int purchaseNum) {
		// TODO Auto-generated method stub
		commodityMapper.purchase(comId, warehouseId, purchaseNum);
	}

}
