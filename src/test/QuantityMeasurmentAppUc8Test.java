package test;


import main.QuantityLength;
import main.LengthUnit;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurmentAppUc8Test {

    private static final double EPSILON = 0.01;

    // feet -> Inches
    @Test

    void givenFeet_whenConvertedToInches_shouldReturn12Inches() {

        QuantityLength length = new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength result = length.converTo(LengthUnit.INCHES);

        Assertions.assertEquals(12.0, result.getValue());

        Assertions.assertEquals(LengthUnit.INCHES, result.getUnit());

    }
    // inches -> feet

    @Test

    void givenInches_whenConvertedToFeet_shouldReturn1Feet() {

        QuantityLength length = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = length.converTo(LengthUnit.FEET);
        System.out.println(result);

        Assertions.assertEquals(1.0, result.getValue());

    }
    // feet -> Yards

    @Test

    void givenFeet_whenConvertedToYards_shouldReturnOneThirdYard() {

        QuantityLength length = new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength result = length.converTo(LengthUnit.YARDS);

        Assertions.assertEquals(0.33, result.getValue(), 0.001);

    }
    // centemeter -> Inches

    @Test

    void givenCentimeters_whenConvertedToInches_shouldReturnOneInch() {

        QuantityLength length = new QuantityLength(2.54, LengthUnit.CENTEMETERS);

        QuantityLength result = length.converTo(LengthUnit.INCHES);

        Assertions.assertEquals(1.0, result.getValue(), 0.01);

    }

    @Test
        // 12 inches == foot

    void given12InchesAnd1Foot_whenCompared_shouldBeEqual() {

        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);

        Assertions.assertEquals(inches, feet);

    }
    // inches  -> yard

    @Test

    void given36InchesAnd1Yard_whenCompared_shouldBeEqual() {

        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);

        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);

        Assertions.assertTrue(inches.equals(yard));

    }
    // diffrent length not equal

    @Test

    void givenDifferentLengths_whenCompared_shouldNotBeEqual() {

        QuantityLength length1 = new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength length2 = new QuantityLength(2.0, LengthUnit.FEET);

        Assertions.assertNotEquals(length1, length2);

    }


}