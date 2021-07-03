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
@Table(name = "lab_name")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LabBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lab_id")
	private int labId;
	
	@Column(name = "lab_name")
	private String labName;
	
	@Column(unique=true, name = "lab_code")
	private String labCode;
	
	@CreationTimestamp
	@Column(name = "created_date")
	private Timestamp createdDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private Timestamp updatedDate;
	
	@Column(name = "lab_status")
	private String labStatus;
	
	@Column(name = "role")
	private String role;

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
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

	public String isLabStatus() {
		return labStatus;
	}

	public void setLabStatus(String labStatus) {
		this.labStatus = labStatus;
	}

	public String getLabCode() {
		return labCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	}

	public String getLabStatus() {
		return labStatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LabBean [labId=" + labId + ", labName=" + labName + ", labCode=" + labCode + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", labStatus=" + labStatus + ", role=" + role + "]";
	}

	

}
