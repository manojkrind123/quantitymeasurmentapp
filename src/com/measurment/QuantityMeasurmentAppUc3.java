package com.measurment;

public class QuantityMeasurmentAppUc3 {

    public static boolean lengthEquality(Length length1, Length length2){
        return length1.equals(length2);
    }

    public static void main(String[] args) {

        Length foot = new Length(1.0, LengthUnit.FEET);
        Length tweleveInches = new Length(12.0, LengthUnit.INCHES);

        System.out.println("result === "+ foot.equals(tweleveInches));
    }
}
