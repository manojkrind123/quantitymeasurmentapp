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
    public static <U extends IMeasurable> Quantity<U> demonstrateSubstraction(Quantity<U> quantity1, Quantity<U> quantity2) {

        return quantity1.substract(quantity2);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateSubstraction1(Quantity<U> quantity1, Quantity<U> quantity2, U targetUnit) {

        return quantity1.substract(quantity2, targetUnit);
    }
    public static <U extends IMeasurable> double demonstrateDivision(Quantity<U> quantity1, Quantity<U> quantity2) {
        return quantity1.divide(quantity2);
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
 // UC11 - Volume
        Quantity<VolumeUnit> volume1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> volume3 =
                new Quantity<>(1.0, VolumeUnit.GALLON);
// Equality
        System.out.println(volume1.equals(volume2)); // true
// Conversion
        System.out.println(volume3.converTo(VolumeUnit.LITRE)); // 3.78541
// Addition
        Quantity<VolumeUnit> sum =
                volume1.add(volume3, VolumeUnit.LITRE);
        System.out.println(sum.getValue()); // 4.78541

//uc 12 substarction

        System.out.println("uc12 started ");

        Quantity<WeightUnit> weightPonds = new Quantity<WeightUnit>(2.204620, WeightUnit.POUND);
        Quantity<WeightUnit> weightKg = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight = demonstrateSubstraction(weightInKg, weightInPonds);
        System.out.println(weight.getValue() + "     unit 12 " + weight.getUnit());

        Quantity<LengthUnit> result = new Quantity<LengthUnit>(10, LengthUnit.FEET).substract(new Quantity<LengthUnit>(6,LengthUnit.INCHES));
        System.out.println(result);

        Quantity<WeightUnit> weight1 = new Quantity<WeightUnit>(10.0, WeightUnit.KILOGRAM).substract(new Quantity<WeightUnit>(5000.0,WeightUnit.GRAM));
        System.out.println(weight1);
        Quantity<VolumeUnit> volume12 = new Quantity<VolumeUnit>(5.0, VolumeUnit.LITRE).substract(new Quantity<VolumeUnit>(2.0,VolumeUnit.LITRE));
        System.out.println(volume12);

       // Substraction resulting negative
        Quantity<VolumeUnit> volume11 = new Quantity<VolumeUnit>(5.0, VolumeUnit.LITRE).substract(new Quantity<VolumeUnit>(10.0,VolumeUnit.LITRE));
        System.out.println(volume11);
        Quantity<WeightUnit> weight11 = new Quantity<WeightUnit>(2.0, WeightUnit.KILOGRAM).substract(new Quantity<WeightUnit>(5.0,WeightUnit.KILOGRAM));
        System.out.println(weight11);

        // Substraction resulting zero

        Quantity<LengthUnit> result12 = new Quantity<LengthUnit>(10, LengthUnit.FEET).substract(new Quantity<LengthUnit>(120,LengthUnit.INCHES));
        System.out.println(result12);

        Quantity<VolumeUnit> volume122 = new Quantity<VolumeUnit>(1.0, VolumeUnit.LITRE).substract(new Quantity<VolumeUnit>(1000.0,VolumeUnit.MILLILITRE));
        System.out.println(volume122);

        // Division operation

        double  result123 = new Quantity<LengthUnit>(10, LengthUnit.FEET).divide(new Quantity<LengthUnit>(2,LengthUnit.FEET));
        System.out.println(result123);

        double  result1234 = new Quantity<LengthUnit>(24, LengthUnit.INCHES).divide(new Quantity<LengthUnit>(2,LengthUnit.FEET));
        System.out.println(result1234);
        double weight111 = new Quantity<WeightUnit>(10.0, WeightUnit.KILOGRAM).divide(new Quantity<WeightUnit>(5.0,WeightUnit.KILOGRAM));
        System.out.println(weight111);
        double volume1224 = new Quantity<VolumeUnit>(5.0, VolumeUnit.LITRE).divide(new Quantity<VolumeUnit>(10.0,VolumeUnit.LITRE));
        System.out.println(volume1224);

        double volume12244 = new Quantity<VolumeUnit>(1000.0, VolumeUnit.MILLILITRE).divide(new Quantity<VolumeUnit>(1.0,VolumeUnit.LITRE));
        System.out.println(volume12244);

        double  result12345 = new Quantity<LengthUnit>(12, LengthUnit.INCHES).divide(new Quantity<LengthUnit>(1,LengthUnit.FEET));
        System.out.println(result12345);

        //error cases
        try {
            Quantity<LengthUnit> result1211 = new Quantity<LengthUnit>(10, LengthUnit.FEET).substract(null);
            System.out.println(result1211);
        }catch (IllegalArgumentException ex){
             ex.printStackTrace();
        }
        try {
        double result12111 = new Quantity<LengthUnit>(10, LengthUnit.FEET).divide(new Quantity<LengthUnit>(0.0,LengthUnit.FEET));
        System.out.println(result12111);
        }catch (ArithmeticException ex){
            ex.printStackTrace();
        }
        try {
            Quantity<LengthUnit> l1 =new Quantity<LengthUnit>(10, LengthUnit.FEET).substract(new Quantity<WeightUnit>(5.0,WeightUnit.KILOGRAM));
            //System.out.println(l1);
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }

        System.out.println("uc12 ended ");
        // UC12 ended
    }

}
