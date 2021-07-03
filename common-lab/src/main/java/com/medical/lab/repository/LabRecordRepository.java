package com.medical.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.medical.lab.bean.LabRecordBean;

public interface LabRecordRepository extends CrudRepository<LabRecordBean, Integer>{
	

}
