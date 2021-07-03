package com.medical.lab.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.ReportBean;
import com.medical.lab.repository.ReportRepository;
import com.medical.lab.service.ReportService;

@Transactional
@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	ReportRepository reportRepository;
	
	@Override
	public ReportBean getReportRecord(int recordId,  String subCatCode) {
		// TODO Auto-generated method stub
		return  reportRepository.findRecord(recordId, subCatCode);
	}

	@Override
	public  ReportBean save(ReportBean bean) {
		// TODO Auto-generated method stub
		return  reportRepository.save(bean);
	}
}
