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
	@Table(name = "test_subcategory")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	public class TestSubcategoryBean implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private int id;
		
		@Column(name = "category_code")
		private String categoryCode;
		
		@Column(name = "subcategory_code")
		private String subcategoryCode;

		@Column(name = "test_name")
		private String testName;
		
		@Column(name = "unit")
		private String unit;
		
		@Column(name = "normal_value")
		private String normalValue;
		
		@Column(name = "status")
		private String status;
		
		@CreationTimestamp
		@Column(name = "created_date")
		private Timestamp createdDate;
		
		@UpdateTimestamp
		@Column(name = "updated_date")
		private Timestamp updatedDate;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCategoryCode() {
			return categoryCode;
		}

		public void setCategoryCode(String categoryCode) {
			this.categoryCode = categoryCode;
		}

		public String getTestName() {
			return testName;
		}

		public void setTestName(String testName) {
			this.testName = testName;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getNormalValue() {
			return normalValue;
		}

		public void setNormalValue(String normalValue) {
			this.normalValue = normalValue;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
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
		
		

		public String getSubcategoryCode() {
			return subcategoryCode;
		}

		public void setSubcategoryCode(String subcategoryCode) {
			this.subcategoryCode = subcategoryCode;
		}

		@Override
		public String toString() {
			return "TestSubcategoryBean [id=" + id + ", categoryCode=" + categoryCode + ", subcategoryCode="
					+ subcategoryCode + ", testName=" + testName + ", unit=" + unit + ", normalValue=" + normalValue
					+ ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
		}

		
		
}
