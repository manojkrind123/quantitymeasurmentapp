package com.measurment;

public enum LengthUnit {

    FEET(12.0),
    INCHES( 1.0),
    YARDS(36.0),
    CENTEMETERS(0.393701);
    private final double conversionFactorToInches;

    LengthUnit(double conversionFactorToInches) {

        this.conversionFactorToInches = conversionFactorToInches;
    }

    public double toInches(double value) {

        return value * conversionFactorToInches;
    }
}
