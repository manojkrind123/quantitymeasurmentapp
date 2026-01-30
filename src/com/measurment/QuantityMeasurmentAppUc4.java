package com.measurment;

public class QuantityMeasurmentAppUc4 {

    public static boolean lengthEquality(Length length1, Length length2){
        return length1.equals(length2);
    }

    public static void main(String[] args) {

        Length cm = new Length(2.54, LengthUnit.CENTEMETERS);
        Length inches = new Length(1.0, LengthUnit.INCHES);

        System.out.println("result1 === "+ cm.equals(inches));


        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);

        System.out.println("result === "+ yard.equals(feet));
    }
}
