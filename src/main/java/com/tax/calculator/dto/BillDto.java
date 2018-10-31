package com.tax.calculator.dto;

import com.tax.calculator.Constants.TaxType;

public class BillDto {

    private String name;

    private double price;

    private double tax;

    private double amount;

    private String refundable;

    private Integer taxCode;

    private String type;

    public BillDto() {
        this.name = "";
        this.price = 0;
        this.tax = 0;
        this.amount = 0;
        this.taxCode = 1;
        this.type = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        if (this.taxCode.equals(TaxType.FOOD.getCode())) {
            this.tax = this.price * 10 / 100;
        } else if (this.taxCode.equals(TaxType.TOBACCO.getCode())) {
            this.tax = this.price * 2/100;
            this.tax += 10;
        } else if (this.taxCode.equals(TaxType.ENTERTAINMENT.getCode())) {
            if (0 < this.price && this.price < 100) {
                this.tax = 0;
            } else if (this.price >= 100 ){
                this.tax = 1/100 * (this.price - 100);
            }
        }
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getRefundable() {
        if (this.taxCode.equals(TaxType.FOOD.getCode())) {
            this.refundable = "Yes";
        } else if (this.taxCode.equals(TaxType.TOBACCO.getCode())) {
            this.refundable = "No";
        } else if (this.taxCode.equals(TaxType.ENTERTAINMENT.getCode())) {
            this.refundable = "No";
        }
        return refundable;
    }

    public void setRefundable(String refundable) {
        this.refundable = refundable;
    }

    public double getAmount() {
        this.amount = this.price + this.tax;
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(Integer taxCode) {
        this.taxCode = taxCode;
    }

    public String getType() {
        return TaxType.getType(this.taxCode);
    }

    public void setType(TaxType taxType) {
        if (taxCode == null) {
            this.taxCode = null;
        } else {
            this.taxCode = taxType.getCode();
        }
    }
}
