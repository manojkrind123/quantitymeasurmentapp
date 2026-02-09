package main;



public class QuantityMeasurmentAppUc8 {

    public static boolean lengthEquality(QuantityLength length1, QuantityLength length2){
        return length1.equals(length2);
    }

    public static void main(String[] args) {


        System.out.println(new QuantityLength(1.0,LengthUnit.FEET).converTo(LengthUnit.INCHES));

        }
}