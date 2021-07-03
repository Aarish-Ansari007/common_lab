package com.medical.lab.service;

import java.util.List;

import com.medical.lab.bean.TestRecordBean;

public interface TestRecordService {
	
	TestRecordBean saveTestRecord(TestRecordBean testRecordBean);
	
	List<TestRecordBean> getTestRecordByAdmin(String fromDate, String toDate);
	
	List<TestRecordBean> getTestRecordByStaff(String fromDate, String toDate);
	
	public long getTotalPatientCount();
	
	public int deleteTestRecord(int recordId);
	
	public int updatePayment(TestRecordBean testRecordBean);
	
	public int updateTestReport(String status, int recordId);
	
	List<TestRecordBean> getTestRecordBeanData();
	
	public int isPresent(String barcode);
	
	public TestRecordBean getTestRecordById(int testId);

}
