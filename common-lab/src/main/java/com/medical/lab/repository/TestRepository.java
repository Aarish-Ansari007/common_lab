package com.medical.lab.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.medical.lab.bean.TestBean;

public interface TestRepository extends CrudRepository<TestBean, Integer>{

	 @Query("FROM TestBean WHERE testCode=:testCode")
		public TestBean getTestInfo(@Param("testCode")String testCode);
}
