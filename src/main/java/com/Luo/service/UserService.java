package com.Luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.User;
import com.Luo.dao.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	/* 实现登录 */
	public User login(String userId,String password){
		com.Luo.bean.User user = userMapper.LoginWithRole(userId, password);
		return user;
	}
	
	/* 查询用户 */
	public List<User> getUser(){
		return userMapper.getallUsers();
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insertSelective(user);
	}

	public User getUserByid(String id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKeyWithRole(id);
	}

	public void updateUserByid(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(user);
	}

	public void delUser(String userId) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(userId);
	}
}
