package com.medical.lab.service;

import java.util.List;

import com.medical.lab.bean.DoctorBean;

public interface DoctorSerivce {

	public List<DoctorBean> getDoctor(int labId);
	
	public void saveDoctor(DoctorBean bean);
}
