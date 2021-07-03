package com.medical.lab.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.LabRecordBean;
import com.medical.lab.repository.LabRecordRepository;
import com.medical.lab.service.LabRecordService;

@Service
@Transactional
public class LabRecordServiceImpl implements LabRecordService{

	@Autowired
	LabRecordRepository labRecordRepository;
	
	@Override
	public List<LabRecordBean> getLabRecordByLabId() {
		// TODO Auto-generated method stub
		return (List<LabRecordBean>) labRecordRepository.findAll();
	}

}
