package test;

import main.LengthUnit;
import main.Quantity;
import main.QuantityMeasurmentApp;
import main.WeightUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {


    // demonstrateEquality()


    @Test
    void shouldReturnTrue_whenLengthValuesAreEqual() {

        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);

        boolean result = QuantityMeasurmentApp.demonstrateEquality(feet, inches);

        Assertions.assertTrue(result);

    }

    @Test
    void shouldReturnTrue_whenWeightValuesAreEqual() {

        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram = new Quantity<>(1000.0, WeightUnit.GRAM);

        boolean result = QuantityMeasurmentApp.demonstrateEquality(kg, gram);

        Assertions.assertTrue(result);

    }


    // demonstrateConversion()


    @Test
    void shouldConvertFeetToInches() {

        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =

                QuantityMeasurmentApp.demonstrateConversion(feet, LengthUnit.INCHES);

        Assertions.assertEquals(12.0, result.getValue(), 0.0001);

        Assertions.assertEquals(LengthUnit.INCHES, result.getUnit());

    }

    @Test
    void shouldConvertKgToGram() {

        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =

                QuantityMeasurmentApp.demonstrateConversion(kg, WeightUnit.GRAM);

        Assertions.assertEquals(1000.0, result.getValue(), 0.0001);

        Assertions.assertEquals(WeightUnit.GRAM, result.getUnit());

    }


    // demonstrateAddition()


    @Test
    void shouldAddLengthUnits() {

        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =

                QuantityMeasurmentApp.demonstrateAddtion(feet, inches);

        Assertions.assertEquals(2.0, result.getValue(), 0.0001);

        Assertions.assertEquals(LengthUnit.FEET, result.getUnit());

    }

    @Test
    void shouldAddWeightUnits() {

        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =

                QuantityMeasurmentApp.demonstrateAddtion(kg, gram);

        Assertions.assertEquals(2.0, result.getValue(), 0.0001);

        Assertions.assertEquals(WeightUnit.KILOGRAM, result.getUnit());

    }


    // demonstrateAddition1(targetUnit)


    @Test
    void shouldAddWeightAndReturnInGram() {

        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =

                QuantityMeasurmentApp.demonstrateAddtion1(kg, gram, WeightUnit.GRAM);

        Assertions.assertEquals(2000.0, result.getValue(), 0.0001);

        Assertions.assertEquals(WeightUnit.GRAM, result.getUnit());

    }

    @Test
    void shouldAddLengthAndReturnInInches() {

        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =

                QuantityMeasurmentApp.demonstrateAddtion1(feet, inches, LengthUnit.INCHES);

        Assertions.assertEquals(24.0, result.getValue(), 0.0001);

        Assertions.assertEquals(LengthUnit.INCHES, result.getUnit());

    }

}

