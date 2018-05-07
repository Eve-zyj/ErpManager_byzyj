package pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Storage {

    private String warehouseNo;
    private String commodityName;
    private String supplier;
    private String specifications;
    private String specificationUnit;
    private int number;
    private String Unit;
    private String price;
    @JSONField(format="yyyy-MM-dd")//解决AJAX日期问题
    private Date storagDate;
    private String remarks;

    public Storage() {
    }

    public Storage(String warehouseNo, String commodityName, String supplier, String specifications, String specificationUnit, int number, String unit, String price, Date storagDate, String remarks) {
        this.warehouseNo = warehouseNo;
        this.commodityName = commodityName;
        this.supplier = supplier;
        this.specifications = specifications;
        this.specificationUnit = specificationUnit;
        this.number = number;
        this.Unit = unit;
        this.price = price;
        this.storagDate = storagDate;
        this.remarks = remarks;
    }

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getSpecificationUnit() {
        return specificationUnit;
    }

    public void setSpecificationUnit(String specificationUnit) {
        this.specificationUnit = specificationUnit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getStoragDate() {
        return storagDate;
    }

    public void setStoragDate(Date storagDate) {
        this.storagDate = storagDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "warehouseNo='" + warehouseNo + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", supplier='" + supplier + '\'' +
                ", specifications='" + specifications + '\'' +
                ", specificationUnit='" + specificationUnit + '\'' +
                ", number=" + number +
                ", Unit='" + Unit + '\'' +
                ", price='" + price + '\'' +
                ", storagDate=" + storagDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
