package com.medical.lab.service;

import java.util.List;

import com.medical.lab.bean.LabRecordBean;

public interface LabRecordService {
	
	public List<LabRecordBean> getLabRecordByLabId();

}
