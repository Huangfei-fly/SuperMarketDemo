package com.Luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.Purchase;
import com.Luo.dao.PurchaseMapper;

@Service
public class PurchaseService {

	@Autowired
	PurchaseMapper purchaseMapper;
	
	public List<Purchase> getPur() {
		// TODO Auto-generated method stub
		return purchaseMapper.selectWithAll();
	}

	public void newPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		purchaseMapper.insertSelective(purchase);
	}

}
