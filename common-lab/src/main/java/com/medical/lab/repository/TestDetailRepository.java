package com.medical.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.medical.lab.bean.TestDetailBean;

public interface TestDetailRepository extends CrudRepository<TestDetailBean, Integer>{

	@Query("FROM TestDetailBean WHERE record_id=:recordId")
	public List<TestDetailBean> getTestCodeById(@Param("recordId")int recordId);
	
	
}
