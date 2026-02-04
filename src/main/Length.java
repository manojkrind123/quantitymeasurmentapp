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
    public Length add(Length other){
        double baseSum= this.unit.toBaseUnit(this.value)+
                other.unit.toBaseUnit(other.value);
        double resultValue = this.unit.fromBaseUnit(baseSum);
        return new Length(round(resultValue),this.unit);
    }
    private double round(double value ){
        return Math.round(value * 100) / 100.0;
    }



    @Override
    public boolean equals(Object obj) {
        //if (this == obj) return true;
        if (!(obj instanceof Length)) return false;
        Length oth = (Length) obj;
        //double epsilion=0.0001;
        return Math.abs(this.unit.toBaseUnit(this.value)-
                oth.unit.toBaseUnit(oth.value))< 0.0001;
    }

    @Override
    public String toString() {
        return value + " ," + unit;
    }
}
