package com.tax.calculator.model;

import com.tax.calculator.Constants.TaxType;


import javax.persistence.*;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private int taxCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(int taxCode) {
        this.taxCode = taxCode;
    }


}
