package com.Luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.Role;
import com.Luo.dao.RoleMapper;

@Service
public class RoleService {
	@Autowired
	RoleMapper roleMapper;
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		List<Role> roles=roleMapper.selectByExample(null);
		return roles;
	}

}
