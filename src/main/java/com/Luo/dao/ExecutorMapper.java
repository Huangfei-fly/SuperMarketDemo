package com.Luo.dao;

import com.Luo.bean.Executor;
import com.Luo.bean.ExecutorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExecutorMapper {
    long countByExample(ExecutorExample example);

    int deleteByExample(ExecutorExample example);

    int deleteByPrimaryKey(String executorId);

    int insert(Executor record);

    int insertSelective(Executor record);

    List<Executor> selectByExample(ExecutorExample example);

    Executor selectByPrimaryKey(String executorId);

    int updateByExampleSelective(@Param("record") Executor record, @Param("example") ExecutorExample example);

    int updateByExample(@Param("record") Executor record, @Param("example") ExecutorExample example);

    int updateByPrimaryKeySelective(Executor record);

    int updateByPrimaryKey(Executor record);
}