package com.medical.lab.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.TestDetailBean;
import com.medical.lab.repository.TestDetailRepository;
import com.medical.lab.service.TestDetailService;

@Service
@Transactional
public class TestDetailServiceImpl implements TestDetailService{

	@Autowired
	TestDetailRepository testDetailRepository;
	
	@Override
	public List<TestDetailBean> getTestDetailBeanData() {
		// TODO Auto-generated method stub
		return (List<TestDetailBean>) testDetailRepository.findAll();
	}

	@Override
	public List<TestDetailBean> getTestCodeById(int recordId) {
		// TODO Auto-generated method stub
		return (List<TestDetailBean>) testDetailRepository.getTestCodeById(recordId);
	}

}
