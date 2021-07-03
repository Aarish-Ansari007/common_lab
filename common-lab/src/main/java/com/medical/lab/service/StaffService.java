package com.medical.lab.service;

import java.util.List;

import com.medical.lab.bean.StaffBean;

public interface StaffService {
	public StaffBean getStaffDatabyEmailPass(String email, String password);
	
	public List<StaffBean> getStaffList();
	
	public long getTotalStaffCount();
	
	public int updatePassword(String password, int staffId);
	
	public int resetAmount(double assignAmount, int staffId);
	
	public int updateEarningAmount(double earningAmount, int staffId);
	
}
