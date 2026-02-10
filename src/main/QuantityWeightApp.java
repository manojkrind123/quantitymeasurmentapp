package main;



public class QuantityWeightApp {



    public static void main(String[] args) {
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);

        QuantityWeight w2 = new QuantityWeight(1, WeightUnit.KILOGRAM);


        System.out.println(w1.equals(w2));

        QuantityWeight w3 = new QuantityWeight(1, WeightUnit.KILOGRAM);

        QuantityWeight w4 = new QuantityWeight(500, WeightUnit.GRAM);

        System.out.println(w3.equals(w4));
        }
}