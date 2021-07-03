package com.medical.lab.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity	
@Table(name = "test_detail")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TestDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "detail_id")
	private int detailId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "record_id")
	    @JsonIgnore
	 private TestRecordBean testRecordBean;

	
	@Column(name = "test_code")
	private String testCode;	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_code", referencedColumnName = "test_code", insertable = false, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TestBean testBeans;
	
	@Column(name = "base_price")
	private float basePrice;
	
	@Column(name = "offer_price")
	private float offerPrice;
	
	@Column(name = "offer_rate")
	private String offerRate;
	
	@Column(name = "discount")
	private float discount;
	
	@Column(name = "net_price")
	private float netPrice;
	
	@Column(name = "detail_status")
	private int detailStatus;

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public TestRecordBean getTestRecordBean() {
		return testRecordBean;
	}

	public void setTestRecordBean(TestRecordBean testRecordBean) {
		this.testRecordBean = testRecordBean;
	}

	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}

	public TestBean getTestBeans() {
		return testBeans;
	}

	public void setTestBeans(TestBean testBeans) {
		this.testBeans = testBeans;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
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

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(float netPrice) {
		this.netPrice = netPrice;
	}


	public int getDetailStatus() {
		return detailStatus;
	}

	public void setDetailStatus(int detailStatus) {
		this.detailStatus = detailStatus;
	}
	
	

	@Override
	public String toString() {
		return "TestDetailBean [detailId=" + detailId + ", testRecordBean=" + testRecordBean + ", testCode=" + testCode
				+ ", testBeans=" + testBeans + ", basePrice=" + basePrice + ", offerPrice=" + offerPrice
				+ ", offerRate=" + offerRate + ", discount=" + discount + ", netPrice=" + netPrice
				+ ", detailStatus=" + detailStatus + "]";
	}


	
	
}
