package ca.on.lsuc.jpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="ees_print_requisition")
public class PrintRequisition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EES_PRINT_REQUISITION_ID")
	private Long id;
	
	@Column(name = "PRODUCT_CODE")
	private String productCode;
	
	@Column(name = "BUSINESS_UNIT")
	private String businessUnit;
	
	@Column(name = "EES_STATUS_ID")
	private Long statusId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "QUANTITY_TO_PRINT")
	private Long quantityToPrint;
	
	@Column(name = "GL_CODE")
	private String glCode;
	
	@Column(name = "PROJECT_CODE")
	private String projectCode;
	
	@Column(name = "ACTIVITY_CODE")
	private String activityCode;
	
	@Column(name = "COST_CODE")
	private String costCode;
	
	@Column(name = "DATE_REQUISITION_CREATED")
	private BigDecimal dateRequisitionCreated;
	
	@Column(name = "DATE_REQUIRED")
	private BigDecimal dateRequired;
	
	@Column(name = "EES_FILE_TRANSFER_ID")
	private Long fileTransferId;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantityToPrint() {
		return quantityToPrint;
	}

	public void setQuantityToPrint(Long quantityToPrint) {
		this.quantityToPrint = quantityToPrint;
	}

	public String getGlCode() {
		return glCode;
	}

	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getCostCode() {
		return costCode;
	}

	public void setCostCode(String costCode) {
		this.costCode = costCode;
	}

	public BigDecimal getDateRequisitionCreated() {
		return dateRequisitionCreated;
	}

	public void setDateRequisitionCreated(BigDecimal dateRequisitionCreated) {
		this.dateRequisitionCreated = dateRequisitionCreated;
	}

	public BigDecimal getDateRequired() {
		return dateRequired;
	}

	public void setDateRequired(BigDecimal dateRequired) {
		this.dateRequired = dateRequired;
	}

	public Long getFileTransferId() {
		return fileTransferId;
	}

	public void setFileTransferId(Long fileTransferId) {
		this.fileTransferId = fileTransferId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", this.id)
				.append("productCode", this.productCode)
				.append("businessUnit", this.businessUnit)
				.append("statusId", this.statusId)
				.append("productName", this.productName)
				.append("quatityToPrint", this.quantityToPrint)
				.append("glCode", this.glCode)
				.append("activityCode", this.activityCode)
				.append("costCode", this.costCode)
				.append("dateRequisitionCreated", this.dateRequisitionCreated)
				.append("dateRequired", this.dateRequired)
				.append("fileTransferId", this.fileTransferId)
				.toString();
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 71 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (getClass() != other.getClass()) {
			return false;
		}
		
		BaseEntity otherEntity = (BaseEntity) other;
		return Objects.equals(this.id, otherEntity.id);
	}
}
