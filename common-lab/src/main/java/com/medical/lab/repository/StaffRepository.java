package com.medical.lab.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.StaffBean;

public interface StaffRepository extends CrudRepository<StaffBean, Integer>{

	@Query("FROM StaffBean where staffEmail=:email AND staffPassword=:password")
	public StaffBean getStaffDatabyEmailPass(@Param("email")String email, @Param("password")String password);

	
	@Transactional
	@Modifying
	@Query("UPDATE StaffBean SET staffPassword=:password where staffId=:staffId")
	public int updatePassword(@Param("password")String password, @Param("staffId")int staffId);
	
	@Transactional
	@Modifying
	@Query("UPDATE StaffBean SET assignAmount=:assignAmount, earningAmount=0 where staffId=:staffId")
	public int resetAmount(@Param("assignAmount")double assignAmount, @Param("staffId")int staffId);
	
	@Transactional
	@Modifying
	@Query("UPDATE StaffBean SET earningAmount=:earningAmount where staffId=:staffId")
	public int updateEarningAmount(@Param("earningAmount")double earningAmount, @Param("staffId")int staffId);
	
}
