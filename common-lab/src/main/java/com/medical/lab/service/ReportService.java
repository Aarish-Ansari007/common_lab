package com.medical.lab.service;

import com.medical.lab.bean.ReportBean;

public interface ReportService {

	public ReportBean getReportRecord(int recordId, String subCatCode);
	
	public ReportBean save(ReportBean bean);
}
