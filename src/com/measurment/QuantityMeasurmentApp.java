package com.measurment;

public class QuantityMeasurmentApp {

    public static class Feet {

        private final Double value;

        public Feet(Double value) {
            if(value == null){

                throw new IllegalArgumentException("value can not be null");
            }
            if (Double.isNaN(value) || Double.isInfinite(value)) {

                throw new IllegalArgumentException("invalid numberic value");
            }

            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;

            Feet oth = (Feet) obj;

            return Double.compare(this.value, oth.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    public boolean compareFeet(double d1, double d2) {

        if (Double.isNaN(d1) || Double.isNaN(d2)) {

            throw new IllegalArgumentException("invalid numbers : NaN not allowed");
        }

        if (Double.isInfinite(d1) || Double.isInfinite(d2)) {

            throw new IllegalArgumentException("invalid numbers : infinite values not allowed");
        }
        Feet f1 = new Feet(d1);
        Feet f2 = new Feet(d2);

        return f1.equals(f2);
    }


    public static void main(String[] args) {


        double feet1 = 12.0;
        double feet2 = 12.0;


        QuantityMeasurmentApp measurmentApp = new QuantityMeasurmentApp();

        boolean result = measurmentApp.compareFeet(feet1, feet2);

        System.out.println("Are both values equal   ==  " + result);


    }
}
