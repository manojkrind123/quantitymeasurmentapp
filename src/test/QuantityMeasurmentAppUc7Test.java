package test;


import main.Length;
import main.LengthUnit;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class QuantityMeasurmentAppUc7Test {

    private static final double EPSILON = 0.01;
   @Test
    public void addFeetAndInches_ReturnFeet() {

       Length feet1 = new Length(1.0, LengthUnit.FEET);
       Length inches1 = new Length(12.0, LengthUnit.INCHES);

       Length result1 = feet1.add(inches1,LengthUnit.FEET);


        Length expected = new Length(2.0,LengthUnit.FEET);
        Assert.assertEquals(result1,expected);

    }
    @Test
    public void addFeetAndInches_ReturnInches() {

        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length inches1 = new Length(12.0, LengthUnit.INCHES);

        Length result1 = feet1.add(inches1,LengthUnit.INCHES);


        Length expected = new Length(24.0,LengthUnit.INCHES);
        Assert.assertEquals(result1,expected);

    }
    @Test
    public void addFeetAndInches_ReturnYards() {

        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length inches1 = new Length(12.0, LengthUnit.INCHES);

        Length result1 = feet1.add(inches1,LengthUnit.YARDS);


        Length expected = new Length(0.67,LengthUnit.YARDS);
        Assert.assertEquals(result1,expected);

    }

    @Test
    public void addZero() {

        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length inches1 = new Length(0.0, LengthUnit.INCHES);

        Length result1 = feet1.add(inches1,LengthUnit.YARDS);


        Length expected = new Length(1.67,LengthUnit.YARDS);
        Assert.assertEquals(result1,expected);

    }
    @Test
    public void nullTargetUnitThrowsExce() {

        Assert.assertThrows(IllegalArgumentException.class,
                ()-> new Length(1.0,LengthUnit.FEET).add(new Length(1.0,LengthUnit.FEET),null));

    }

    }