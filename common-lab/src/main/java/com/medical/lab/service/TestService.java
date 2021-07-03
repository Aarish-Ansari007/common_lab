package com.medical.lab.service;

import com.medical.lab.bean.TestBean;

public interface TestService {
	
	public long getTotalTestCount();
	public TestBean getTestRecord(String testCode);

}
