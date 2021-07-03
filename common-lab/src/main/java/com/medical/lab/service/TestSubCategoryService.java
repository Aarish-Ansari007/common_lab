package com.medical.lab.service;

import java.util.List;

import com.medical.lab.bean.TestSubcategoryBean;

public interface TestSubCategoryService {
	public List<TestSubcategoryBean> getTestSubCategoryRecord(String categoryCode);

}
