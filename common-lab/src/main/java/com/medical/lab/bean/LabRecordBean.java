package com.medical.lab.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity	
@Table(name = "lab_record")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LabRecordBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "record_id")
	private int recordId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private LabBean labBeans;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TestBean testBeans;
	
	
	@Column(name = "offer_price")
	private float offerPrice;
	
	@Column(name = "offer_rate")
	private String offerRate;
	
	@CreationTimestamp
	@Column(name = "created_date")
	private Timestamp createdDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private Timestamp updatedDate;
	
	@Column(name = "record_status")
	private String recordStatus;

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public LabBean getLabBeans() {
		return labBeans;
	}

	public void setLabBeans(LabBean labBeans) {
		this.labBeans = labBeans;
	}

	public TestBean getTestBeans() {
		return testBeans;
	}

	public void setTestBeans(TestBean testBeans) {
		this.testBeans = testBeans;
	}

	public float getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(float offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getOfferRate() {
		return offerRate;
	}

	public void setOfferRate(String offerRate) {
		this.offerRate = offerRate;
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

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Override
	public String toString() {
		return "LabRecordBean [recordId=" + recordId + ", labBeans=" + labBeans + ", testBeans=" + testBeans
				+ ", offerPrice=" + offerPrice + ", offerRate=" + offerRate + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", recordStatus=" + recordStatus + "]";
	}

	
}
