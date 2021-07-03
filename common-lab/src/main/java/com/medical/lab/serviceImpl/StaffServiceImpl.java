package com.medical.lab.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.StaffBean;
import com.medical.lab.repository.StaffRepository;
import com.medical.lab.service.StaffService;

@Service
@Transactional
public class StaffServiceImpl implements StaffService{
	
	@Autowired StaffRepository staffRepository;

	@Override
	public StaffBean getStaffDatabyEmailPass(String email, String password) {
		return staffRepository.getStaffDatabyEmailPass(email, password);
	}
	
	@Override
	public List<StaffBean> getStaffList() {
		return(List<StaffBean>) staffRepository.findAll();
	}
	

	@Override
	public long getTotalStaffCount() {
		return staffRepository.count();
	}

	@Override
	public int updatePassword(String password, int staffId) {
		// TODO Auto-generated method stub
		return staffRepository.updatePassword(password, staffId);
	}

	@Override
	public int updateEarningAmount(double earningAmount, int staffId) {
		// TODO Auto-generated method stub
		return staffRepository.updateEarningAmount(earningAmount, staffId);
	}
	
	@Override
	public int resetAmount(double assignAmount, int staffId) {
		// TODO Auto-generated method stub
		return staffRepository.resetAmount(assignAmount, staffId);
	}



}
