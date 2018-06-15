package com.pobreng.pedro.model;

public class CriticalValue {
    private int id;
    private String condition;
    private String description;
    private Float max_value;
    private Float min_value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getMax_value() {
        return max_value;
    }

    public void setMax_value(Float max_value) {
        this.max_value = max_value;
    }

    public Float getMin_value() {
        return min_value;
    }

    public void setMin_value(Float min_value) {
        this.min_value = min_value;
    }
}
