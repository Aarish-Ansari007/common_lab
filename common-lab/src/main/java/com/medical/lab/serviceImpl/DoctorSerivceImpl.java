package com.medical.lab.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.DoctorBean;
import com.medical.lab.repository.DoctorRepository;
import com.medical.lab.service.DoctorSerivce;

@Service
@Transactional
public class DoctorSerivceImpl implements DoctorSerivce{

	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public List<DoctorBean> getDoctor(int labId) {
		// TODO Auto-generated method stub
		return (List<DoctorBean>)doctorRepository.getDoctor(labId);
	}

	@Override
	public void saveDoctor(DoctorBean bean) {
		// TODO Auto-generated method stub
		doctorRepository.save(bean);
	}

}
