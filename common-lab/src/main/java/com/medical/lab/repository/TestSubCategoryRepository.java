package com.medical.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.medical.lab.bean.TestSubcategoryBean;

public interface TestSubCategoryRepository extends CrudRepository<TestSubcategoryBean, Integer>{
	 
	@Query("FROM TestSubcategoryBean WHERE categoryCode=:categoryCode")
	public List<TestSubcategoryBean> findRecord(@Param("categoryCode")String categoryCode);
}
