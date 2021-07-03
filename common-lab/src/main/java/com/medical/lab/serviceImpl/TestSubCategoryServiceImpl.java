package com.medical.lab.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.TestSubcategoryBean;
import com.medical.lab.repository.TestSubCategoryRepository;
import com.medical.lab.service.TestSubCategoryService;


@Transactional
@Service
public class TestSubCategoryServiceImpl implements TestSubCategoryService{

	@Autowired
	TestSubCategoryRepository testSubCategoryRepository;
	
	@Override
	public List<TestSubcategoryBean> getTestSubCategoryRecord(String categoryCode) {
		// TODO Auto-generated method stub
		return (List<TestSubcategoryBean>) testSubCategoryRepository.findRecord(categoryCode);
	}

}