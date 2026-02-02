package main;



public class QuantityMeasurmentAppUc5 {

    public static boolean lengthEquality(Length length1, Length length2){
        return length1.equals(length2);
    }

    public static void main(String[] args) {


        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = feet.convertTo(LengthUnit.INCHES);
        System.out.println("result === "+ inches);
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet2 = yard.convertTo(LengthUnit.FEET);
        System.out.println("result2 === "+ feet2);
        Length cm = new Length(2.54, LengthUnit.CENTEMETERS);
        Length inches1 = new Length(1.0,LengthUnit.CENTEMETERS);
        System.out.println("result3 === "+ cm.equals(inches1));
    }
}
