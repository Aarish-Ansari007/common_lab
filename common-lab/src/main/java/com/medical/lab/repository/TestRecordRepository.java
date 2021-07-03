package com.medical.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.medical.lab.bean.TestRecordBean;

public interface TestRecordRepository extends CrudRepository<TestRecordBean, Integer>{

	@Query("FROM TestRecordBean WHERE recordStatus=0 AND createdDate >=:fromDate AND createdDate <=:toDate")
	public List<TestRecordBean> getTestRecordByAdmin(@Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
	@Query("FROM TestRecordBean WHERE recordStatus=0 AND createdDate >=:fromDate AND createdDate <=:toDate")
	public List<TestRecordBean> getTestRecordByStaff(@Param("fromDate")String fromDate, @Param("toDate")String toDate);

	@Query("SELECT COUNT(DISTINCT patientLastName) FROM TestRecordBean ")
	public Long getTotalPatientCount();
	
	@Query("SELECT COUNT(*) FROM TestRecordBean where barCode=:barcode and recordStatus=0")
	public int isPresent(@Param("barcode")String barcode);
	
	  @Transactional
	  @Modifying
	@Query("UPDATE TestRecordBean SET recordStatus=1 WHERE recordId=:recordId")
	public int deleteTestRecord(@Param("recordId")int recordId);
	
	  @Transactional
	  @Modifying
	@Query("UPDATE TestRecordBean SET paymentMode=:mode, paymentAcceptedBy=:paby, paymentStatus=:status, receivedAmount=:recAmount, pendingAmount=:penAmount WHERE recordId=:recordId")
	public int updatePayment(@Param("mode")String mode,@Param("paby")String paby, @Param("status")int status, @Param("recAmount")Double recAmount, @Param("penAmount")Double penAmount, @Param("recordId")int recordId);
	  
	  @Transactional
	  @Modifying
	@Query("UPDATE TestRecordBean SET reportImagePath=:filePath WHERE recordId=:recordId")
	public int updateTestReport(@Param("filePath")String filePath, @Param("recordId")int recordId);
	  
	  
	  @Query("FROM TestRecordBean WHERE record_id=:testId")
		public TestRecordBean fetchById(@Param("testId")int testId);

}
