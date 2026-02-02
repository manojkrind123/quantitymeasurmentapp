package test;


import main.Length;
import main.LengthUnit;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurmentAppUc5Test {

    //    FEET- INCHES
    @Test
    public void given1Feet_whenConvertedToInches_shouldReturn12() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = feet.convertTo(LengthUnit.INCHES);
        Assert.assertEquals(feet,inches);

    }

    @Test
    public void given12Inches_whenConvertedToFeet_shouldReturn1() {

        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length feet = inches.convertTo(LengthUnit.FEET);
        Assert.assertEquals(inches,feet);

    }
    //    YARD-FEET
    @Test
    public void given1Yard_whenConvertedToFeet_shouldReturn3() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = yard.convertTo(LengthUnit.FEET);
        Assert.assertEquals(yard,feet);

    }

    @Test
    public void given3Feet_whenConvertedToYard_shouldReturn1() {

        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = feet.convertTo(LengthUnit.YARDS);
        Assert.assertEquals(feet,yard);

    }
    //    CENTEMETER-INCHES
    @Test
    public void givenCentemeter_whenConvertedToInches_shouldReturn1() {

        Length cm = new Length(2.54, LengthUnit.CENTEMETERS);
        Length inches = cm.convertTo(LengthUnit.INCHES);
        Assert.assertEquals(cm,inches);

    }

    @Test
    public void givenInches_whenConvertedToCentemeter_shouldReturn2Point54() {

        Length inches = new Length(1, LengthUnit.INCHES);
        Length cm = inches.convertTo(LengthUnit.CENTEMETERS);
        Assert.assertEquals(inches,cm);

    }

    //    INvalid inputs

    @Test
    public void testInvalidValue() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Length(Double.NaN, LengthUnit.FEET));


    }

    @Test
    public void testnullUnit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Length(10.0, null));


    }


}