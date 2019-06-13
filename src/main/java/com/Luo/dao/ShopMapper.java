package com.Luo.dao;

import com.Luo.bean.Shop;
import com.Luo.bean.ShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopMapper {
    long countByExample(ShopExample example);

    int deleteByExample(ShopExample example);

    int deleteByPrimaryKey(String shopId);

    int insert(Shop record);

    int insertSelective(Shop record);

    List<Shop> selectByExample(ShopExample example);

    Shop selectByPrimaryKey(String shopId);
    
    Shop selectByPrimaryKeyWithMa(String shopId);

    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

	List<Shop> getAllShop();
}