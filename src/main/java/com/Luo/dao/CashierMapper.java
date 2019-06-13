package com.Luo.dao;

import com.Luo.bean.Cashier;
import com.Luo.bean.CashierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CashierMapper {
    long countByExample(CashierExample example);

    int deleteByExample(CashierExample example);

    int deleteByPrimaryKey(String cashierId);

    int insert(Cashier record);

    int insertSelective(Cashier record);

    List<Cashier> selectByExample(CashierExample example);

    Cashier selectByPrimaryKey(String cashierId);

    int updateByExampleSelective(@Param("record") Cashier record, @Param("example") CashierExample example);

    int updateByExample(@Param("record") Cashier record, @Param("example") CashierExample example);

    int updateByPrimaryKeySelective(Cashier record);

    int updateByPrimaryKey(Cashier record);

	List<Cashier> getAllCashier();
}