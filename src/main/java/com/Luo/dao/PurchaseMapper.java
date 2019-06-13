package com.Luo.dao;

import com.Luo.bean.Bill;
import com.Luo.bean.Purchase;
import com.Luo.bean.PurchaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseMapper {
    long countByExample(PurchaseExample example);

    int deleteByExample(PurchaseExample example);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    List<Purchase> selectByExample(PurchaseExample example);
    
    List<Purchase> selectWithAll();

    int updateByExampleSelective(@Param("record") Purchase record, @Param("example") PurchaseExample example);

    int updateByExample(@Param("record") Purchase record, @Param("example") PurchaseExample example);
}