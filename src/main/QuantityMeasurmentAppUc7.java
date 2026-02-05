package main;



public class QuantityMeasurmentAppUc7 {

    public static boolean lengthEquality(Length length1, Length length2){
        return length1.equals(length2);
    }

    public static void main(String[] args) {


        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length inches1 = new Length(12.0, LengthUnit.INCHES);

        Length result1 = feet1.add(inches1,LengthUnit.INCHES);

        System.out.println(result1);

        Length result2 = feet1.add(inches1,LengthUnit.YARDS);
        System.out.println(result2);
        Length result3 = feet1.add(inches1,LengthUnit.FEET);

        System.out.println(result3);

        Length inches2 = new Length(36.0, LengthUnit.INCHES);
        Length yards = new Length(1.0, LengthUnit.YARDS);


        Length result4 = inches2.add(yards,LengthUnit.INCHES);

        System.out.println(result4);
        Length cent = new Length(36.0, LengthUnit.CENTEMETERS);
        Length inches4 = new Length(12.0, LengthUnit.INCHES);


        Length result5 = cent.add(inches4,LengthUnit.CENTEMETERS);

        System.out.println(result5);
        }
}