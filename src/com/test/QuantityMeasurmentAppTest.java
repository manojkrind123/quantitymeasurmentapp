package com.test;

import com.measurment.QuantityMeasurmentApp.Feet;
import org.junit.jupiter.api.Test;

public class QuantityMeasurmentAppTest {

   @Test
    public void testFeetEquality_SameValue(){

       Feet f1 = new Feet(1.0);
       Feet f2 = new Feet(1.0);
       assert(f1.equals(f2));



   }
}
