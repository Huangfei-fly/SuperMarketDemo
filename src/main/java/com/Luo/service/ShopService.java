package com.Luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.Shop;
import com.Luo.dao.ShopMapper;

@Service
public class ShopService {

	@Autowired
	ShopMapper shopMapper;
	public List<Shop> getShop() {
		// TODO Auto-generated method stub
		return shopMapper.getAllShop();
	}
	public void addShop(Shop shop) {
		// TODO Auto-generated method stub
		shopMapper.insertSelective(shop);
	}
	
	public Shop getMa(String shopId) {
		return shopMapper.selectByPrimaryKeyWithMa(shopId);
	}
	public void delShop(String shopId) {
		// TODO Auto-generated method stub
		shopMapper.deleteByPrimaryKey(shopId);
	}
	public Shop getShopByid(String id) {
		// TODO Auto-generated method stub
		return shopMapper.selectByPrimaryKey(id);
	}

	public void updateShop(Shop shop) {
		// TODO Auto-generated method stub
		shopMapper.updateByPrimaryKeySelective(shop);
	}

}
