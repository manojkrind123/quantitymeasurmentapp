package main;

public class QuantityMeasurmentApp {

    public static <U extends IMeasurable> boolean demonstrateEquality(Quantity<U> quantity1, Quantity<U> quantity2) {

        return quantity1.equals(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(Quantity<U> quantity, U targetUnit) {
        double convertedValue = quantity.converTo(targetUnit);
        return new Quantity<>(convertedValue, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddtion(Quantity<U> quantity1, Quantity<U> quantity2) {

        return quantity1.add(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddtion1(Quantity<U> quantity1, Quantity<U> quantity2, U targetUnit) {

        return quantity1.add(quantity2, targetUnit);
    }


    public static void main(String[] args) {

        // equality check
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(120.0, LengthUnit.INCHES);

        System.out.println(demonstrateEquality(lengthInFeet, lengthInInches));

        // conversion
        System.out.println(demonstrateConversion(lengthInFeet, LengthUnit.INCHES));

        // addtion first unit
        Quantity<WeightUnit> weightInPonds = new Quantity<WeightUnit>(2.204620, WeightUnit.POUND);
        Quantity<WeightUnit> weightInKg = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> someWeight = demonstrateAddtion(weightInKg, weightInPonds);

        System.out.println(someWeight.getValue() + "     unit " + someWeight.getUnit());

        // addtion two unit

        Quantity<WeightUnit> someWeightfor = demonstrateAddtion1(weightInKg, weightInPonds, WeightUnit.POUND);
        System.out.println(someWeightfor.getValue() + "     unit " + someWeightfor.getUnit());

    }
}
