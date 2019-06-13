package com.Luo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.Manager;
import com.Luo.bean.Shop;
import com.Luo.dao.ManagerMapper;
import com.Luo.dao.ShopMapper;

@Service
public class ManagerService {
	@Autowired
	ManagerMapper managerMapper;
	
	public Manager getMag(String id) {
		// TODO Auto-generated method stub
		return managerMapper.selectByPrimaryKey(id);
	}

}
