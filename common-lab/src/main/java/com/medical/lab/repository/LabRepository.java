package com.medical.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.medical.lab.bean.LabBean;

public interface LabRepository extends CrudRepository<LabBean, Integer>{
	@Query("FROM LabBean Order by labName")
	public List<LabBean> getLab();

}
