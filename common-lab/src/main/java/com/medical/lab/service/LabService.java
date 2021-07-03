package com.medical.lab.service;

import java.util.List;

import com.medical.lab.bean.LabBean;

public interface LabService {

	public List<LabBean> getLab();
	
	public long getTotalLabCount();
}
