package main;


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
    private double toBaseUnit() {

        return unit.toInches(value);
    }
    public Length convertTo(LengthUnit targetUnit){
        if (targetUnit == null) {

            throw new IllegalArgumentException("targetUnit can not be null");
        }
        double inches = this.toBaseUnit();
        double convertedValue = targetUnit.fromInches(inches);
        return new Length(convertedValue, targetUnit);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;
        Length oth = (Length) obj;
        double epsilion=0.0001;
        return Math.abs(this.toBaseUnit()-oth.toBaseUnit())<epsilion;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBaseUnit());

    }

    @Override
    public String toString() {
        return String.format("%.2f %s",value,unit);
    }
}

