package com.Luo.dao;

import com.Luo.bean.Supply;
import com.Luo.bean.SupplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplyMapper {
    long countByExample(SupplyExample example);

    int deleteByExample(SupplyExample example);

    int insert(Supply record);

    int insertSelective(Supply record);

    List<Supply> selectByExample(SupplyExample example);
    
    List<Supply> selectWithAll();

    int updateByExampleSelective(@Param("record") Supply record, @Param("example") SupplyExample example);

    int updateByExample(@Param("record") Supply record, @Param("example") SupplyExample example);
}