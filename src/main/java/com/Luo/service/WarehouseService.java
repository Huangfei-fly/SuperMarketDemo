package com.Luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.Warehouse;
import com.Luo.dao.WarehouseMapper;

@Service
public class WarehouseService {
	
	@Autowired
	WarehouseMapper warehouseMapper;
	
	public List<Warehouse> getWare() {
		// TODO Auto-generated method stub
		return warehouseMapper.selectByExample(null);
	}

	public void newWare(Warehouse warehouse) {
		// TODO Auto-generated method stub
		warehouseMapper.insertSelective(warehouse);
	}

	public Warehouse getWareByid(String warehouseId) {
		// TODO Auto-generated method stub
		return warehouseMapper.selectByPrimaryKey(warehouseId);
	}

	public void updateWare(Warehouse warehouse) {
		// TODO Auto-generated method stub
		warehouseMapper.updateByPrimaryKeySelective(warehouse);
	}

	public void delWare(String warehouseId) {
		// TODO Auto-generated method stub
		warehouseMapper.deleteByPrimaryKey(warehouseId);
	}

}
