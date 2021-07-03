package com.medical.lab.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.TestRecordBean;
import com.medical.lab.repository.TestRecordRepository;
import com.medical.lab.service.TestRecordService;

@Transactional
@Service
public class TestRecordServiceImpl implements TestRecordService{
	
	@Autowired
	TestRecordRepository testRecordRepository;

	@Override
	public TestRecordBean saveTestRecord(TestRecordBean testRecordBean) {
		// TODO Auto-generated method stub
		return testRecordRepository.save(testRecordBean);
	}


	@Override
	public long getTotalPatientCount() {
		if(testRecordRepository.getTotalPatientCount()==null)
			return 0;
		else
			return testRecordRepository.getTotalPatientCount();
	}

	@Override
	public int deleteTestRecord(int recordId) {
		// TODO Auto-generated method stub
		return testRecordRepository.deleteTestRecord(recordId);
	}


	@Override
	public List<TestRecordBean> getTestRecordByAdmin(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return testRecordRepository.getTestRecordByAdmin(fromDate, toDate);
	}

	@Override
	public List<TestRecordBean> getTestRecordByStaff(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return testRecordRepository.getTestRecordByStaff(fromDate, toDate);
	}


	@Override
	public int updateTestReport(String filePath, int recordId) {
		// TODO Auto-generated method stub
		return testRecordRepository.updateTestReport(filePath, recordId);
	}
	
	@Override
	public List<TestRecordBean> getTestRecordBeanData() {
		// TODO Auto-generated method stub
		return (List<TestRecordBean>) testRecordRepository.findAll();
	}


	@Override
	public int isPresent(String barcode) {
		// TODO Auto-generated method stub
		return  testRecordRepository.isPresent(barcode);
	}
	

	@Override
	public TestRecordBean getTestRecordById(int testId) {
		// TODO Auto-generated method stub
		return testRecordRepository.fetchById(testId);
//		return  testRecordRepository.findOne(testId);
	}


	@Override
	public int updatePayment(TestRecordBean testRecordBean) {
		// TODO Auto-generated method stub
			return testRecordRepository.updatePayment(testRecordBean.getPaymentMode(), testRecordBean.getPaymentAcceptedBy(), testRecordBean.getPaymentStatus(), testRecordBean.getReceivedAmount(), testRecordBean.getPendingAmount(), testRecordBean.getRecordId());
	}


	
}
