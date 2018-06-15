package com.pobreng.pedro.model;

import java.util.List;

public class Property {
    private int id;
    private String code;
    private String name;
    private String unit;
    private List<CriticalValue> critical_value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<CriticalValue> getCritical_value() {
        return critical_value;
    }

    public void setCritical_value(List<CriticalValue> critical_value) {
        this.critical_value = critical_value;
    }
}
