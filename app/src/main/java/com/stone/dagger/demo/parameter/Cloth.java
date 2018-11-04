package com.stone.dagger.demo.parameter;

/**
 * 布料
 */
public class Cloth {
    private String color;

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + "布料";
    }
}