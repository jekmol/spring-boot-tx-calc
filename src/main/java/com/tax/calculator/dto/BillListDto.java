package com.tax.calculator.dto;

import java.util.ArrayList;
import java.util.List;

public class BillListDto {

    List<BillDto> bills = new ArrayList<>();

    private double priceSubTotal;
    private double taxSubTotal;
    private double grandTotal;

    public BillListDto() {
        this.priceSubTotal = 0;
        this.taxSubTotal = 0;
        this.grandTotal = 0;
    }

    public List<BillDto> getBills() {
        return bills;
    }

    public void setBills(List<BillDto> bills) {
        this.bills = bills;
    }

    public double getPriceSubTotal() {
        return priceSubTotal;
    }

    public void setPriceSubTotal(double priceSubTotal) {
        this.priceSubTotal = priceSubTotal;
    }

    public double getTaxSubTotal() {
        return taxSubTotal;
    }

    public void setTaxSubTotal(double taxSubTotal) {
        this.taxSubTotal = taxSubTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
