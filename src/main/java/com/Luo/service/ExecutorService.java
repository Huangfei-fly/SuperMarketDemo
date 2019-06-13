package com.Luo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luo.bean.Executor;
import com.Luo.dao.ExecutorMapper;

@Service
public class ExecutorService {
	@Autowired
	ExecutorMapper executorMapper;
	
	public Executor getEx(String executorId) {
		// TODO Auto-generated method stub
		return executorMapper.selectByPrimaryKey(executorId);
	}

}
