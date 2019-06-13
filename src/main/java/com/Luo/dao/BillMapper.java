package com.Luo.dao;

import com.Luo.bean.Bill;
import com.Luo.bean.BillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillMapper {
    long countByExample(BillExample example);

    int deleteByExample(BillExample example);

    int insert(Bill record);

    int insertSelective(Bill record);

    List<Bill> selectByExample(BillExample example);
    
    List<Bill> selectWithAll();
    
    List<Bill> selectByCa(String cashierId);

    int updateByExampleSelective(@Param("record") Bill record, @Param("example") BillExample example);

    int updateByExample(@Param("record") Bill record, @Param("example") BillExample example);
}