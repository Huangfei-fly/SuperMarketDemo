package com.Luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.Bill;
import com.Luo.dao.BillMapper;

@Service
public class BillService {

	@Autowired
	BillMapper billMapper;
	public List<Bill> getbill() {
		// TODO Auto-generated method stub
		return billMapper.selectWithAll();
	}
	public void addBill(Bill bill) {
		// TODO Auto-generated method stub
		billMapper.insertSelective(bill);
	}
	public List<Bill> getBillByca(String cashierId) {
		// TODO Auto-generated method stub
		return billMapper.selectByCa(cashierId);
	}
	public void delBill(Bill bill) {
		// TODO Auto-generated method stub
	}

}
