package main;


public class QuantityWeight {


    private final double value;
    private final WeightUnit unit;
    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Weight unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }
    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }
    public boolean equals(QuantityWeight other) {
        if (other == null) return false;
        double eplision = 0.0001;
        return Math.abs(this.toBaseUnit()-other.toBaseUnit()) <eplision;
    }
    public QuantityWeight add(QuantityWeight other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot add null weight");
        }
        double totalInKg = this.toBaseUnit() + other.toBaseUnit();
        double resultValue = unit.convertFromBaseUnit(totalInKg);
        return new QuantityWeight(resultValue, this.unit);
    }
}