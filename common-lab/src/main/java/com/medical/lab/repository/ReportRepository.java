package com.medical.lab.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.medical.lab.bean.ReportBean;

public interface ReportRepository extends CrudRepository<ReportBean, Integer>{
	 
	@Query("FROM ReportBean WHERE recordId=:recordId AND subcategoryCode=:subCatCode")
	public ReportBean findRecord(@Param("recordId")int recordId, @Param("subCatCode")String subCatCode);

}
