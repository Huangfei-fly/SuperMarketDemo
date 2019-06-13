package com.Luo.dao;

import com.Luo.bean.User;
import com.Luo.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);
    
    List<User> selectByExampleWithManager(UserExample example);

    User selectByPrimaryKeyWithManager(String userId);
    
    List<User> selectByExampleWithCashier(UserExample example);

    User selectByPrimaryKeyWithCashier(String userId);
    
    List<User> selectByExampleWithExecutor(UserExample example);

    User selectByPrimaryKeyWithExecutor(String userId);
    
    List<User> selectByExampleWithRole(UserExample example);
    
    User selectByPrimaryKeyWithRole(String userId);
    
    List<User> getallUsers();
    
    User LoginWithRole(@Param("userId") String userId, @Param("userPassword") String password);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}