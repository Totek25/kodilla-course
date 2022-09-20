package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double baseLength;
    private double height;

    public Triangle(double baseLength, double height) {
        this.baseLength = baseLength;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "triangle";
    }

    @Override
    public double getField() {
        return baseLength * height / 2.0;
    }
}
