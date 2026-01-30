package com.measurment;

public class Length {


    private final double value;
    private final LengthUnit unit;


    public Length(double value, LengthUnit unit) {
        if (unit == null) {

            throw new IllegalArgumentException("unit can not be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {

            throw new IllegalArgumentException("invalid numberic value");
        }

        this.value = value;
        this.unit = unit;
    }

    private double convertToInches() {

        return unit.toInches(value);
    }

    public boolean compare(Length other) {

        if (other == null) return false;
        return Double.compare(this.convertToInches(), other.convertToInches()) == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Length oth = (Length) obj;
        double epsilion=0.0001;
        return Math.abs(this.convertToInches()-oth.convertToInches())<epsilion;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToInches());
    }
}

