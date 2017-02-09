package ca.on.lsuc.dto.entity;

import java.math.BigDecimal;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.commons.lang3.builder.ToStringBuilder;

@CsvRecord(separator = "\\," , skipFirstLine = true)
public class PrintRequisition {

	@DataField(pos = 1, required = true)
	private String businessUnit;
	
	@DataField(pos = 2, required = true)
	private String productCode;
	
	@DataField(pos = 3, required = true)
	private Long quantityToPrint;

	@DataField(pos = 4, required = true)
	private String glCode;

	@DataField(pos = 5, required = false)
	private String projectCode;

	@DataField(pos = 6, required = false)
	private String activityCode;
	
	@DataField(pos = 7, required = false)
	private String costCode;
	
	@DataField(pos = 7, required = false)
	private BigDecimal dateRequisitionCreated;

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

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("productCode", this.productCode)
				.append("businessUnit", this.businessUnit)
				.append("quatityToPrint", this.quantityToPrint)
				.append("glCode", this.glCode)
				.append("activityCode", this.activityCode)
				.append("costCode", this.costCode)
				.append("dateRequisitionCreated", this.dateRequisitionCreated)
				.toString();
	}
}
