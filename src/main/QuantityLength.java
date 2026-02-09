package main;


public class QuantityLength {


    private final double value;
    private final LengthUnit unit;


    public QuantityLength(double value, LengthUnit unit) {
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
    public QuantityLength converTo( LengthUnit targetUnit){
        if ( targetUnit== null){
            throw new IllegalArgumentException("invalid input");
        }
        double baseValue= unit.convertToBaseUnit(this.value);
        double targetValue = targetUnit.convertFromBaseUnit(baseValue);
        return new QuantityLength(round(targetValue),targetUnit);
    }
    public QuantityLength add( QuantityLength other,LengthUnit targetUnit){
        if ( targetUnit== null || other==null){
            throw new IllegalArgumentException("invalid input");
        }
        double baseSum= unit.convertToBaseUnit(this.value)
                +other.unit.convertToBaseUnit(other.value);
        return new QuantityLength(round(targetUnit.convertFromBaseUnit(baseSum)),targetUnit);
    }
    private double round(double value ){
        return Math.round(value * 100) / 100.0;
    }
    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (!(obj instanceof QuantityLength)) return false;
        QuantityLength oth = (QuantityLength) obj;
        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = oth.unit.convertToBaseUnit(oth.value);
        return Math.abs(thisBase-otherBase)< 0.0001;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.convertToBaseUnit(value));
    }

    @Override
    public String toString() {
        return "Qunatity("+ value +  " ," + unit +")";
    }
}
