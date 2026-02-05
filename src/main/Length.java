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
    public double getValue(){
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }
    // add two length
    public Length add(Length other, LengthUnit targetUnit){
        if (other == null || targetUnit== null){
            throw new IllegalArgumentException("invalid input");
        }
        double baseSum= this.unit.toBaseUnit(this.value)+
                other.unit.toBaseUnit(other.value);
        double targetValue = targetUnit.fromBaseUnit(baseSum);
        return new Length(round(targetValue),targetUnit);
    }
    private double round(double value ){
        return Math.round(value * 100) / 100.0;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Length)) return false;
        Length oth = (Length) obj;
        double thisBase = unit.toBaseUnit(value);
        double otherBase = oth.unit.toBaseUnit(oth.value);
        return Math.abs(thisBase-otherBase)< 0.0001;
    }

    @Override
    public String toString() {
        return "Qunatity("+ value +  " ," + unit +")";
    }
}
