package main;

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);
    private final double conversionFactor;
    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    public double getConversionFactor() {
        return conversionFactor;
    }
    public double convertToBaseUnit(double value) {
        return value * conversionFactor; // to kilograms
    }
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor; // from kilograms
    }
}
