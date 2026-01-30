package test;


import com.measurment.Length;
import com.measurment.LengthUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurmentAppUc3Test {

    @Test
    public void testFeetAndInchesEquality_SameValue() {

        Length foot = new Length(1.0, LengthUnit.FEET);
        Length tweleveInches = new Length(12.0, LengthUnit.INCHES);
        Assertions.assertTrue(foot.equals(tweleveInches));

    }

    @Test
    public void testFeetEquality_sameValue() {

        Length foot1 = new Length(1.0, LengthUnit.FEET);
        Length foot2 = new Length(1.0, LengthUnit.FEET);
        Assertions.assertTrue(foot1.equals(foot2));

    }

    @Test
    public void testInchesEquality_DiffrentValue() {

        Length i1 = new Length(1.0, LengthUnit.INCHES);
        Length i2 = new Length(12.0, LengthUnit.INCHES);
        Assertions.assertFalse(i1.equals(i2));

    }

    @Test
    public void testInvalidValue() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Length(Double.NaN, LengthUnit.FEET));


    }

    @Test
    public void testnullUnit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Length(10.0, null));


    }


}
