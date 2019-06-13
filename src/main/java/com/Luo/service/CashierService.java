package com.Luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.Cashier;
import com.Luo.dao.CashierMapper;

@Service
public class CashierService {
	
	@Autowired
	CashierMapper cashierMapper;
	
	public List<Cashier> getCashier() {
		// TODO Auto-generated method stub
		return cashierMapper.getAllCashier();
	}

	public void newCashier(Cashier cashier) {
		cashierMapper.insertSelective(cashier);// TODO Auto-generated method stub
		
	}

	public void deleteCa(String cashierId) {
		// TODO Auto-generated method stub
		cashierMapper.deleteByPrimaryKey(cashierId);
	}

	public Cashier getByid(String cashierId) {
		// TODO Auto-generated method stub
		return cashierMapper.selectByPrimaryKey(cashierId);
	}
	
}
