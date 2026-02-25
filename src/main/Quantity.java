package main;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private static final double EPLISION = 1e-6;
    private double value;
    private U unit;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("other can not be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("invalid numeric value");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public <U extends IMeasurable> double converTo(U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("targetUnit can not be null");
        }

        if (unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("incompatible unit type");
        }
        double baseValue = unit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public Quantity<U> add(Quantity<U> other) {

        if (other == null) {
            throw new IllegalArgumentException("targetUnit can not be null");
        }

        if (unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("incompatible unit type");
        }
        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        double sumBase = base1 + base2;
        double result = unit.convertFromBaseUnit(sumBase);
        return new Quantity<>(result, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("targetUnit can not be null");
        }

        if (unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("incompetable unit type");
        }
        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        double sumBase = base1 + base2;
        double result = targetUnit.convertFromBaseUnit(sumBase);
        return new Quantity<>(result, targetUnit);
    }
    //substract
    public Quantity<U> substract(Quantity<?> other) {

        if (other == null) {
            throw new IllegalArgumentException("targetUnit can not be null");
        }

        if (unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("incompatible unit type- cross unit");
        }
        Quantity<U> typeOther = (Quantity<U>) other;
        double base1 = unit.convertToBaseUnit(value);
        double base2 = typeOther.unit.convertToBaseUnit(typeOther.value);
        double sumBase = base1 - base2;
        double result = unit.convertFromBaseUnit(sumBase);
        return new Quantity<>(result, unit);
    }

    public Quantity<U> substract(Quantity<U> other, U targetUnit) {

        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("targetUnit can not be null");
        }

        if (unit.getClass() != other.unit.getClass() || unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("incompetable unit type");
        }
        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        double diff = base1 - base2;
        double result = targetUnit.convertFromBaseUnit(diff);
        return new Quantity<>(result, targetUnit);
    }



    //substract end

    //Divide
    public double divide(Quantity<?> other) {

        if (other == null) {
            throw new IllegalArgumentException("targetUnit can not be null");
        }

        if (unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("incompatible unit type");
        }
        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        if(Math.abs(base2)< EPLISION){

            throw new ArithmeticException("division by Zero");
        }
        return  base1 / base2 ;
    }

    //Divede end




    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> oth)) return false;
        //if(obj==null || getClass() != obj.getClass()) return false;
        if (unit.getClass() != oth.unit.getClass()) return false;
        Quantity<?> other = (Quantity<?>) obj;
        if (this.unit.getClass() != other.unit.getClass()) return false;
        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);
        //return Double.compare(thisBase, otherBase)==0;
        return Math.abs(thisBase - otherBase) < EPLISION;
    }

    @Override
    public int hashCode() {
        double base = unit.convertToBaseUnit(value);
        long rounded = Math.round(base / EPLISION);
        return Objects.hash(unit.getClass(), rounded);
    }

    @Override
    public String toString() {
        return value + " " + getUnit();
    }

    public static void main(String[] args) {

        //example usages for LengthUnit

        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(120.0, LengthUnit.INCHES);
        System.out.println(lengthInFeet.equals(lengthInInches));

        //example usages for WaightUnit
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInGram = new Quantity<>(1000.0, WeightUnit.GRAM);
        System.out.println(weightInKilogram.equals(weightInGram));

        //example conversion
        double conversion = lengthInFeet.converTo(LengthUnit.INCHES);
        System.out.println(conversion);

        //example addtion lengthUnit
        Quantity<LengthUnit> totalLength = lengthInFeet.add(lengthInInches, LengthUnit.FEET);
        System.out.println(totalLength);

        //example addtion weightUnit
        Quantity<WeightUnit> weightInPounds = new Quantity<>(2.0, WeightUnit.POUND);
        Quantity<WeightUnit> totalWeigh = weightInKilogram.add(weightInPounds, WeightUnit.KILOGRAM);
        System.out.println(totalWeigh);


    }
}
