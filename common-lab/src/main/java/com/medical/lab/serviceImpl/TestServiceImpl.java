package com.medical.lab.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.TestBean;
import com.medical.lab.repository.TestRepository;
import com.medical.lab.service.TestService;

@Transactional
@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestRepository testRepository;

	@Override
	public long getTotalTestCount() {
		// TODO Auto-generated method stub
		return testRepository.count();
	}

	@Override
	public TestBean getTestRecord(String testCode) {
		// TODO Auto-generated method stub
		return testRepository.getTestInfo(testCode);
	}

}
