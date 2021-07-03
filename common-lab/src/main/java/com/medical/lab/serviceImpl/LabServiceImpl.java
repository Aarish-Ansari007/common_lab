package com.medical.lab.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.LabBean;
import com.medical.lab.repository.LabRepository;
import com.medical.lab.service.LabService;

@Service
@Transactional
public class LabServiceImpl implements LabService{
	
	@Autowired
	LabRepository labRepository;

	@Override
	public List<LabBean> getLab() {
		// TODO Auto-generated method stub
		return (List<LabBean>) labRepository.findAll();
	}

	@Override
	public long getTotalLabCount() {
		// TODO Auto-generated method stub
		return labRepository.count();
	}

}
