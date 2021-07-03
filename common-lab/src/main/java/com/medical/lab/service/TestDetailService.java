package com.medical.lab.service;

import java.util.List;

import com.medical.lab.bean.TestDetailBean;

public interface TestDetailService {
	
	List<TestDetailBean> getTestDetailBeanData();
	List<TestDetailBean> getTestCodeById(int recordId);

}
