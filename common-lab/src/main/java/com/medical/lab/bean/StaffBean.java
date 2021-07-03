package com.medical.lab.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity	
@Table(name = "staff_table")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StaffBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "staff_id")
	private int staffId;
	
	@Column(name = "staff_name")
	private String staffName;
	
	@Column(name = "staff_code")
	private String staffCode;
	
	@Column(name = "staff_email")
	private String staffEmail;
	
	@Column(name = "staff_password")
	private String staffPassword;
	
	@Column(name = "staff_phone")
	private String staffPhone;
	
	@Column(name = "staff_address")
	private String staffAddress;
	
	@Column(name = "role")
	private String staffRole;
	
	@CreationTimestamp
	@Column(name = "created_date")
	private Timestamp createdDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private Timestamp updatedDate;
	
	@Column(name = "staff_status")
	private String staffStatus;

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public String getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	public String getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getStaffStatus() {
		return staffStatus;
	}

	public void setStaffStatus(String staffStatus) {
		this.staffStatus = staffStatus;
	}

	@Override
	public String toString() {
		return "StaffBean [staffId=" + staffId + ", staffName=" + staffName + ", staffCode=" + staffCode
				+ ", staffEmail=" + staffEmail + ", staffPassword=" + staffPassword + ", staffPhone=" + staffPhone
				+ ", staffAddress=" + staffAddress + ", staffRole=" + staffRole + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", staffStatus=" + staffStatus + "]";
	}


}
