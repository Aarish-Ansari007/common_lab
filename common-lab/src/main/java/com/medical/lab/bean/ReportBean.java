package com.medical.lab.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity	
	@Table(name = "report_table")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	public class ReportBean implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "report_id")
		private int reportId;
		
		@Column(name = "record_id")
		private int recordId;

		@Column(name = "subcategory_code")
		private String subcategoryCode;

		@Column(name = "value")
		private String value;
		
		@Column(name = "status")
		private int status;
		
		@UpdateTimestamp
		@Column(name = "updated_date")
		private Timestamp updatedDate;

		public int getReportId() {
			return reportId;
		}

		public void setReportId(int reportId) {
			this.reportId = reportId;
		}

		public int getRecordId() {
			return recordId;
		}

		public void setRecordId(int recordId) {
			this.recordId = recordId;
		}

		public String getSubcategoryCode() {
			return subcategoryCode;
		}

		public void setSubcategoryCode(String subcategoryCode) {
			this.subcategoryCode = subcategoryCode;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public Timestamp getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(Timestamp updatedDate) {
			this.updatedDate = updatedDate;
		}

		@Override
		public String toString() {
			return "ReportBean [reportId=" + reportId + ", recordId=" + recordId + ", subcategoryCode="
					+ subcategoryCode + ", value=" + value + ", status=" + status + ", updatedDate=" + updatedDate
					+ "]";
		}
		
		
}
