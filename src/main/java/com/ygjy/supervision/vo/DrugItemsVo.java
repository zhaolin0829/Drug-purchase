package com.ygjy.supervision.vo;

import java.io.Serializable;

/**
 * drug_items
 * @author 
 */
public class DrugItemsVo implements Serializable {
    /**
     * 品目号
     */
    private String drugItemsNumber;

    /**
     * 通用名
     */
    private String commonName;

    /**
     * 剂型id
     */
    private String dosageFormId;

    /**
     * 规格
     */
    private String specification;

    /**
     * 单位
     */
    private String unit;

    /**
     * 转换系数
     */
    private String conversionFraction;

    /**
     * 药品类别
     */
    private String drugCategoryId;

    /**
     * 状态(0:正常 1：删除)
     */
    private String state;


    public String getDrugItemsNumber() {
        return drugItemsNumber;
    }

    public void setDrugItemsNumber(String drugItemsNumber) {
        this.drugItemsNumber = drugItemsNumber;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getDosageFormId() {
        return dosageFormId;
    }

    public void setDosageFormId(String dosageFormId) {
        this.dosageFormId = dosageFormId;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getConversionFraction() {
        return conversionFraction;
    }

    public void setConversionFraction(String conversionFraction) {
        this.conversionFraction = conversionFraction;
    }

    public String getDrugCategoryId() {
        return drugCategoryId;
    }

    public void setDrugCategoryId(String drugCategoryId) {
        this.drugCategoryId = drugCategoryId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DrugItemsVo other = (DrugItemsVo) that;
        return (this.getDrugItemsNumber() == null ? other.getDrugItemsNumber() == null : this.getDrugItemsNumber().equals(other.getDrugItemsNumber()))
            && (this.getCommonName() == null ? other.getCommonName() == null : this.getCommonName().equals(other.getCommonName()))
            && (this.getDosageFormId() == null ? other.getDosageFormId() == null : this.getDosageFormId().equals(other.getDosageFormId()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getConversionFraction() == null ? other.getConversionFraction() == null : this.getConversionFraction().equals(other.getConversionFraction()))
            && (this.getDrugCategoryId() == null ? other.getDrugCategoryId() == null : this.getDrugCategoryId().equals(other.getDrugCategoryId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugItemsNumber() == null) ? 0 : getDrugItemsNumber().hashCode());
        result = prime * result + ((getCommonName() == null) ? 0 : getCommonName().hashCode());
        result = prime * result + ((getDosageFormId() == null) ? 0 : getDosageFormId().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getConversionFraction() == null) ? 0 : getConversionFraction().hashCode());
        result = prime * result + ((getDrugCategoryId() == null) ? 0 : getDrugCategoryId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugItemsNumber=").append(drugItemsNumber);
        sb.append(", commonName=").append(commonName);
        sb.append(", dosageFormId=").append(dosageFormId);
        sb.append(", specification=").append(specification);
        sb.append(", unit=").append(unit);
        sb.append(", conversionFraction=").append(conversionFraction);
        sb.append(", drugCategoryId=").append(drugCategoryId);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}