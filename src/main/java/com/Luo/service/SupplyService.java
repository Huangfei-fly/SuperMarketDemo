package com.Luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.Supply;
import com.Luo.dao.SupplyMapper;

@Service
public class SupplyService {

	@Autowired
	SupplyMapper supplyMapper;
	
	public List<Supply> getSupply() {
		// TODO Auto-generated method stub
		return supplyMapper.selectWithAll();
	}

	public void newSupply(Supply supply) {
		// TODO Auto-generated method stub
		supplyMapper.insertSelective(supply);
	}

}
