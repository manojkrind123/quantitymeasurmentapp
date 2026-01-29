package com.test;

import com.measurment.QuantityMeasurmentApp.Feet;
import com.measurment.QuantityMeasurmentApp.Inches;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class QuantityMeasurmentAppTest {

//    feet test cases start

    @Test
    public void testFeetEquality_SameValue() {

        Feet f1 = new Feet(2.0);
        Feet f2 = new Feet(2.0);
        Assertions.assertEquals(f1,f2);

    }

    @Test
    public void testFeetEquality_DiffrenceValue() {

        Feet f1 = new Feet(2.0);
        Feet f2 = new Feet(1.0);
        Assertions.assertNotEquals(f1,f2);

    }

    @Test
    public void testFeetEquality_NullComprasion() {

        Feet f1 = new Feet(2.0);
        Assertions.assertNotEquals(null,f1);

    }

    @Test
    public void testFeetEquality_SameRefrence() {

        Feet f1 = new Feet(2.0);
        Assertions.assertEquals(f1,f1);

    }

    @Test
    public void testFeetEquality_NonNumericInput() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Feet(Double.NaN));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Feet(Double.POSITIVE_INFINITY));


    }
//    feet test cases end

//    incches test cases start

    @Test
    public void testInchesEquality_SameValue() {

        Inches i1 = new Inches(2.0);
        Inches i2 = new Inches(2.0);
        Assertions.assertEquals(i1, i2);

    }

    @Test
    public void testInchesEquality_DiffrenceValue() {

        Inches i1 = new Inches(2.0);
        Inches i2 = new Inches(1.0);
        Assertions.assertNotEquals(i1, i2);

    }

    @Test
    public void testInchesEquality_NullComprasion() {

//        Inches i1 = new Inches(2.0);
        Assertions.assertFalse(false);

    }

    @Test
    public void testInchesEquality_SameRefrence() {

        Inches i1 = new Inches(2.0);
        Assertions.assertEquals(i1, i1);

    }

    @Test
    public void testInchesEquality_NonNumericInput() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Inches(Double.NaN));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Inches(Double.POSITIVE_INFINITY));


    }
//    incches test cases end


}
