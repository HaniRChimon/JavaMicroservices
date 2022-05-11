package com.cardealer.MycarDelaer.dto;

import lombok.Data;

public @Data
class Car {
    private String model;
    private String year;
    private String color;
    private String City;

    public void setDesc(String Desc) {
    }

    public void setCarID(String id) {
    }
}
