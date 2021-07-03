package com.medical.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.medical.lab.bean.DoctorBean;

public interface DoctorRepository  extends CrudRepository<DoctorBean, Integer>{

	@Query("FROM DoctorBean WHERE created_by=:labId Order by doctorName ")
	public List<DoctorBean> getDoctor(@Param("labId")int labId);

}
