package test;


import main.Length;
import main.LengthUnit;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurmentAppUc6Test {

    @Test
    public void testAdd_SameUnit_FeetPlusFeet() {

        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(2.0, LengthUnit.FEET);

        Length result = feet1.add(feet2);
        Length expected = new Length(3.0,LengthUnit.FEET);
        Assert.assertEquals(result,expected);

    }

    @Test
    public void testAdd_SameUnit_InchPlusInch() {

        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        Length inch2 = new Length(2.0, LengthUnit.INCHES);

        Length result = inch1.add(inch2);
        Length expected = new Length(3.0,LengthUnit.INCHES);
        Assert.assertEquals(result,expected);

    }


}