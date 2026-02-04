package test;


import main.Length;
import main.LengthUnit;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurmentAppUc6Test {

    private static final double EPSILON = 0.01;
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

    @Test
    public void testAdd_CrossUnit_InchPlusFeet() {

        Length inch1 = new Length(12.0, LengthUnit.INCHES);
        Length feet1 = new Length(1.0, LengthUnit.FEET);

        Length result = inch1.add(feet1);
        Length expected = new Length(24.0,LengthUnit.INCHES);
        Assert.assertEquals(result,expected);

    }

    @Test
    public void testAdd_YardPlusFeet() {

        Length yards = new Length(1.0, LengthUnit.YARDS);
        Length feet1 = new Length(3.0, LengthUnit.FEET);

        Length result = yards.add(feet1);
        Length expected = new Length(2.0,LengthUnit.YARDS);
        Assert.assertEquals(result,expected);

    }
    @Test
    public void testAdd_WithZero() {

        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length zero = new Length(0.0, LengthUnit.INCHES);


        Length result = feet1.add(zero);
        Length expected = new Length(5.0,LengthUnit.FEET);
        Assert.assertEquals(result,expected);

    }

    @Test
    public void testAdd_WithNegative() {

        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(-3.0, LengthUnit.FEET);


        Length result = feet1.add(feet2);
        Length expected = new Length(2.0,LengthUnit.FEET);
        Assert.assertEquals(result,expected);



    }

    @Test
    public void testAdd_Commutativity() {

        Length inch1 = new Length(12.0, LengthUnit.INCHES);
        Length feet1 = new Length(1.0, LengthUnit.FEET);

        Length result1 = inch1.add(feet1);
        Length result2 = feet1.add(inch1);
        Assert.assertEquals(result1,result2);

    }
    }