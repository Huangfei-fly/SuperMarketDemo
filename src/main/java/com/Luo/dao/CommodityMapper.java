package com.Luo.dao;

import com.Luo.bean.Commodity;
import com.Luo.bean.CommodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityMapper {
    long countByExample(CommodityExample example);

    int deleteByExample(CommodityExample example);

    int deleteByPrimaryKey(String comId);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    List<Commodity> selectByExample(CommodityExample example);

    Commodity selectByPrimaryKey(String comId);
    
    List<Commodity> selectByWare(String warehouseId);

    int updateByExampleSelective(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByPrimaryKeySelective(Commodity record);
    
    int supply(@Param("comId")String comId, @Param("warehouseId")String warehouseId, @Param("supplyNum")Integer supplyNum);
    
    int purchase(@Param("comId")String comId, @Param("warehouseId")String warehouseId, @Param("purchaseNum")Integer purchaseNum);

    int updateByPrimaryKey(Commodity record);
}