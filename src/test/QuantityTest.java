package test;

import main.LengthUnit;
import main.Quantity;
import main.WeightUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityTest {

    // ---------- 1. Length Equality Test ----------

    @Test
    void testGenericQuantity_LengthOperations_Equality() {

        Quantity<LengthUnit> oneFoot =

                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> twelveInches =

                new Quantity<>(12.0, LengthUnit.INCHES);

        Assertions.assertTrue(oneFoot.equals(twelveInches));

    }

    // ---------- 2. Weight Equality ----------

    @Test
    void testGenericQuantity_WeightOperations_Equality() {

        Quantity<WeightUnit> oneKg =

                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> thousandGram =

                new Quantity<>(1000.0, WeightUnit.GRAM);

        Assertions.assertTrue(oneKg.equals(thousandGram));

    }

    // ---------- 3. Length Conversion ----------

    @Test
    void testGenericQuantity_LengthOperations_Conversion() {

        Quantity<LengthUnit> oneFoot =

                new Quantity<>(1.0, LengthUnit.FEET);

        double inches = oneFoot.converTo(LengthUnit.INCHES);

        Assertions.assertEquals(12.0, inches);

    }

    // ---------- 4. Weight Conversion ----------

    @Test
    void testGenericQuantity_WeightOperations_Conversion() {

        Quantity<WeightUnit> oneKg =

                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        double grams = oneKg.converTo(WeightUnit.GRAM);

        Assertions.assertEquals(1000.0, grams);

    }

    // ---------- 5. Length Addition ----------

    @Test
    void testGenericQuantity_LengthOperations_Addition() {

        Quantity<LengthUnit> oneFoot =

                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> twelveInches =

                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =

                oneFoot.add(twelveInches);

        Assertions.assertEquals(new Quantity<>(2.0, LengthUnit.FEET), result);

    }

    // ---------- 6. Weight Addition ----------

    @Test
    void testGenericQuantity_WeightOperations_Addition() {

        Quantity<WeightUnit> oneKg =

                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> thousandGram =

                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =

                oneKg.add(thousandGram);

        Assertions.assertEquals(new Quantity<>(2.0, WeightUnit.KILOGRAM), result);

    }

    // ---------- 7. Cross Category Prevention ----------

    @Test
    void testCrossCategoryPrevention_LengthVsWeight() {

        Quantity<LengthUnit> length =

                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =

                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Assertions.assertNotEquals(length, weight);

    }

    // ---------- 8. Null Unit Validation ----------

    @Test
    void testGenericQuantity_ConstructorValidation_NullUnit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Quantity<>(1.0, null);

        });

    }

    // ---------- 9. Invalid Value Validation ----------

    @Test
    void testGenericQuantity_ConstructorValidation_InvalidValue() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Quantity<>(Double.NaN, LengthUnit.FEET);

        });

    }

    // ---------- 10. Addition With Target Unit ----------

    @Test
    void testAddition_WithTargetUnit() {

        Quantity<WeightUnit> oneKg =

                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> thousandGram =

                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =

                oneKg.add(thousandGram, WeightUnit.GRAM);

        Assertions.assertEquals(new Quantity<>(2000.0, WeightUnit.GRAM), result);

    }

}

