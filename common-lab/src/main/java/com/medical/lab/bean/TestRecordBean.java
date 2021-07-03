package com.medical.lab.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity	
@Table(name = "test_record")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TestRecordBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "record_id")
	private int recordId;
	
	@Column(name = "lab_code")
	private String labCode;
	
	@Column(name = "patient_title")
	private String patientTitle;
	
	@Column(name = "patient_first_name")
	private String patientFirstName;
	
	@Column(name = "patient_last_name")
	private String patientLastName;
	
	@Column(name = "patient_age")
	private String patientAge;
	
	@Column(name = "patient_dob")
	private String patientDOB;
	
	@Column(name = "patient_sex")
	private String patientSex;
	
	@Column(name = "patient_phone")
	private String patientPhone;
	
	@Column(name = "bar_code")
	private String barCode;
	
	@Column(name = "reference_doctor_id")
	private String referenceDoctorId;	
	
	@Column(name = "created_by")
	private int createdBy;
	
	@Column(name = "report_image_path")
	private String reportImagePath;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private Timestamp updatedDate;
	
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name = "payment_accepted_by")
	private String paymentAcceptedBy;
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "received_amount")
	private double receivedAmount;	
	
	@Column(name = "pending_amount")
	private double pendingAmount;	
	
	@Column(name = "payment_status")
	private int paymentStatus;
	
	@Column(name = "record_status")
	private int recordStatus;

	 @OneToMany(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "testRecordBean")
	 private List<TestDetailBean> testDetailBean;

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getLabCode() {
		return labCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	}

	public String getPatientTitle() {
		return patientTitle;
	}

	public void setPatientTitle(String patientTitle) {
		this.patientTitle = patientTitle;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(String patientDOB) {
		this.patientDOB = patientDOB;
	}

	public String getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getReferenceDoctorId() {
		return referenceDoctorId;
	}

	public void setReferenceDoctorId(String referenceDoctorId) {
		this.referenceDoctorId = referenceDoctorId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getReportImagePath() {
		return reportImagePath;
	}

	public void setReportImagePath(String reportImagePath) {
		this.reportImagePath = reportImagePath;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(int recordStatus) {
		this.recordStatus = recordStatus;
	}

	public List<TestDetailBean> getTestDetailBean() {
		return testDetailBean;
	}

	public void setTestDetailBean(List<TestDetailBean> testDetailBean) {
		this.testDetailBean = testDetailBean;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentAcceptedBy() {
		return paymentAcceptedBy;
	}

	public void setPaymentAcceptedBy(String paymentAcceptedBy) {
		this.paymentAcceptedBy = paymentAcceptedBy;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public double getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	@Override
	public String toString() {
		return "TestRecordBean [recordId=" + recordId + ", labCode=" + labCode + ", patientTitle=" + patientTitle
				+ ", patientFirstName=" + patientFirstName + ", patientLastName=" + patientLastName + ", patientAge="
				+ patientAge + ", patientDOB=" + patientDOB + ", patientSex=" + patientSex + ", patientPhone="
				+ patientPhone + ", barCode=" + barCode + ", referenceDoctorId=" + referenceDoctorId + ", createdBy="
				+ createdBy + ", reportImagePath=" + reportImagePath + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", paymentMode=" + paymentMode + ", paymentAcceptedBy=" + paymentAcceptedBy
				+ ", totalAmount=" + totalAmount + ", receivedAmount=" + receivedAmount + ", pendingAmount="
				+ pendingAmount + ", paymentStatus=" + paymentStatus + ", recordStatus=" + recordStatus
				+ ", testDetailBean=" + testDetailBean + "]";
	}


	}
