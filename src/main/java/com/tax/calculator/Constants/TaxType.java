package com.tax.calculator.Constants;

public enum TaxType {

    FOOD(1, "Food & Beverage"),
    TOBACCO(2, "Tobacco"),
    ENTERTAINMENT(3, "Entertainment");

    private int code;
    private String name;

    private TaxType(int code, String name){
        this.code = code;
        this.name = name;
    }

    public static String getType(Integer code) {

        if (code == null) {
            return null;
        }

        for (TaxType taxType : TaxType.values()) {
            if (code.equals(taxType.getCode())) {
                return taxType.getName();
            }
        }
        throw new IllegalArgumentException("No matching type for tax code " + code);
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}



