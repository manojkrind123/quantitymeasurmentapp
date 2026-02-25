package test;

import main.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {


    private static final double EPLISION = 1e-6;
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

    //UC11 test

    // -------------------------
    // Conversion
    // -------------------------

    @Test
    void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.LITRE);
        double result = v.converTo(VolumeUnit.MILLILITRE);
        Assertions.assertEquals(1000.0, result, EPLISION);
    }

    @Test
    void testConversion_MillilitreToLitre() {
        Quantity<VolumeUnit> v = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        double result = v.converTo(VolumeUnit.LITRE);
        Assertions.assertEquals(1.0, result, EPLISION);
    }

    @Test
    void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.GALLON);
        double result = v.converTo(VolumeUnit.LITRE);
        Assertions.assertEquals(3.78541, result, EPLISION);
    }

    @Test
    void testConversion_LitreToGallon() {
        Quantity<VolumeUnit> v = new Quantity<>(3.78541, VolumeUnit.LITRE);
        double result = v.converTo(VolumeUnit.GALLON);
        Assertions.assertEquals(1.0, result, EPLISION);
    }

    @Test
    void testConversion_MillilitreToGallon() {
        Quantity<VolumeUnit> v = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        double result = v.converTo(VolumeUnit.GALLON);
        Assertions.assertEquals(0.26417217685798894, result);
    }

    @Test
    void testConversion_SameUnit() {
        Quantity<VolumeUnit> v = new Quantity<>(5.0, VolumeUnit.LITRE);
        double result = v.converTo(VolumeUnit.LITRE);
        Assertions.assertEquals(5.0, result, EPLISION);
    }

    @Test
    void testConversion_ZeroValue() {
        Quantity<VolumeUnit> v = new Quantity<>(0.0, VolumeUnit.LITRE);
        double result = v.converTo(VolumeUnit.MILLILITRE);
        Assertions.assertEquals(0.0, result, EPLISION);
    }

    @Test
    void testConversion_NegativeValue() {
        Quantity<VolumeUnit> v = new Quantity<>(-1.0, VolumeUnit.LITRE);
        double result = v.converTo(VolumeUnit.MILLILITRE);
        Assertions.assertEquals(-1000.0, result, EPLISION);
    }

    @Test
    void testConversion_RoundTrip() {
        Quantity<VolumeUnit> v = new Quantity<>(1.5, VolumeUnit.LITRE);
        double toMl = v.converTo(VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(toMl, VolumeUnit.MILLILITRE);
        double backToL = v2.converTo(VolumeUnit.LITRE);
        Assertions.assertEquals(1.5, backToL, EPLISION);
    }

    // -------------------------
    // Equality
    // -------------------------

    @Test
    void testEquality_LitreToLitre_SameValue() {
        boolean result = new Quantity<>(1.0, VolumeUnit.LITRE)
                .equals(new Quantity<>(1.0, VolumeUnit.LITRE));
        Assertions.assertTrue(result);
    }

    @Test
    void testEquality_LitreToLitre_DifferentValue() {
        boolean result = new Quantity<>(1.0, VolumeUnit.LITRE)
                .equals(new Quantity<>(2.0, VolumeUnit.LITRE));
        Assertions.assertFalse(result);
    }

    @Test
    void testEquality_LitreToMillilitre_EquivalentValue() {
        boolean result = new Quantity<>(1.0, VolumeUnit.LITRE)
                .equals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE));
        Assertions.assertTrue(result);
    }

    @Test
    void testEquality_MillilitreToLitre_EquivalentValue() {
        boolean result = new Quantity<>(1000.0, VolumeUnit.MILLILITRE)
                .equals(new Quantity<>(1.0, VolumeUnit.LITRE));
        Assertions.assertTrue(result);
    }

    @Test
    void testEquality_LitreToGallon_EquivalentValue() {
        boolean result = new Quantity<>(1.0, VolumeUnit.LITRE)
                .equals(new Quantity<>(0.264172, VolumeUnit.GALLON));
        Assertions.assertTrue(result);
    }

    @Test
    void testEquality_GallonToLitre_EquivalentValue() {
        boolean result = new Quantity<>(1.0, VolumeUnit.GALLON)
                .equals(new Quantity<>(3.78541, VolumeUnit.LITRE));
        Assertions.assertTrue(result);
    }

    @Test
    void testEquality_VolumeVsLength_Incompatible() {
        Quantity<VolumeUnit> vol = new Quantity<>(1.0, VolumeUnit.LITRE);
        @SuppressWarnings("rawtypes")
        boolean result = vol.equals(new Quantity<>(1.0, LengthUnit.FEET));
        Assertions.assertFalse(result);
    }

    @Test
    void testEquality_VolumeVsWeight_Incompatible() {
        Quantity<VolumeUnit> vol = new Quantity<>(1.0, VolumeUnit.LITRE);
        @SuppressWarnings("rawtypes")
        boolean result = vol.equals(new Quantity<>(1.0, main.WeightUnit.KILOGRAM));
        Assertions.assertFalse(result);
    }

    @Test
    void testEquality_NullComparison() {
        boolean result = new Quantity<>(1.0, VolumeUnit.LITRE).equals(null);
        Assertions.assertFalse(result);
    }

    @Test
    void testEquality_SameReference() {
        Quantity<VolumeUnit> q = new Quantity<>(1.0, VolumeUnit.LITRE);
        boolean result = q.equals(q);
        Assertions.assertTrue(result);
    }

    @Test
    void testEquality_NullUnit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Quantity<>(1.0, null));
    }

    @Test
    void testEquality_TransitiveProperty() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> b = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> c = new Quantity<>(1.0, VolumeUnit.LITRE);
        Assertions.assertTrue(a.equals(b));
        Assertions.assertTrue(b.equals(c));
        Assertions.assertTrue(a.equals(c));
    }

    @Test
    void testEquality_ZeroValue() {
        boolean result = new Quantity<>(0.0, VolumeUnit.LITRE)
                .equals(new Quantity<>(0.0, VolumeUnit.MILLILITRE));
        Assertions.assertTrue(result);
    }

    @Test
    void testEquality_NegativeVolume() {
        boolean result = new Quantity<>(-1.0, VolumeUnit.LITRE)
                .equals(new Quantity<>(-1000.0, VolumeUnit.MILLILITRE));
        Assertions.assertTrue(result);
    }

    @Test
    void testEquality_LargeVolumeValue() {
        boolean result = new Quantity<>(1_000_000.0, VolumeUnit.MILLILITRE)
                .equals(new Quantity<>(1000.0, VolumeUnit.LITRE));
        Assertions.assertTrue(result);
    }

    @Test
    void testEquality_SmallVolumeValue() {
        boolean result = new Quantity<>(0.001, VolumeUnit.LITRE)
                .equals(new Quantity<>(1.0, VolumeUnit.MILLILITRE));
        Assertions.assertTrue(result);
    }

    // -------------------------
    // Addition
    // -------------------------

    @Test
    void testAddition_SameUnit_LitrePlusLitre() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit>  result = a.add(new Quantity<>(2.0, VolumeUnit.LITRE)); // default to a's unit
        Assertions.assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE), result);

    }

    @Test
    void testAddition_SameUnit_MillilitrePlusMillilitre() {
        Quantity<VolumeUnit> a = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> b = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result1 = a.add(b);
        Assertions.assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), result1);


    }

    @Test
    void testAddition_CrossUnit_LitrePlusMillilitre_DefaultUnit() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = a.add(new Quantity<>(1000.0, VolumeUnit.MILLILITRE)); // result in LITRE
        Assertions.assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);
    }

    @Test
    void testAddition_CrossUnit_MillilitrePlusLitre_DefaultUnit() {
        Quantity<VolumeUnit> a = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = a.add(new Quantity<>(1.0, VolumeUnit.LITRE)); // result in MILLILITRE
        Assertions.assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);    }

    @Test
    void testAddition_CrossUnit_GallonPlusLitre_DefaultUnit() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> result = a.add(new Quantity<>(3.78541, VolumeUnit.LITRE)); // result in GALLON
        Assertions.assertEquals(new Quantity<>(2.0, VolumeUnit.GALLON), result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Litre() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = a.add(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), VolumeUnit.LITRE);
        Assertions.assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Millilitre() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = a.add(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), VolumeUnit.MILLILITRE);
        Assertions.assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Gallon() {
        Quantity<VolumeUnit> a = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = a.add(new Quantity<>(3.78541, VolumeUnit.LITRE), VolumeUnit.GALLON);
        Assertions.assertEquals(new Quantity<>(2.0, VolumeUnit.GALLON), result);
    }

    @Test
    void testAddition_Commutativity_WithExplicitTarget() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> b = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit>  sum1 = a.add(b, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit>  sum2 = b.add(a, VolumeUnit.MILLILITRE);
        Assertions.assertEquals(sum1, sum2);
        //Assertions.assertEquals(new Quantity<>(2.0, WeightUnit.KILOGRAM), result1);

    }

    @Test
    void testAddition_WithZero() {
        Quantity<VolumeUnit> a = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = a.add(new Quantity<>(0.0, VolumeUnit.MILLILITRE));
        //Assertions.assertEquals(5.0, result, EPLISION);
        Assertions.assertEquals(new Quantity<>(5.0, VolumeUnit.LITRE), result);
    }

    @Test
    void testAddition_NegativeValues() {
        Quantity<VolumeUnit> a = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = a.add(new Quantity<>(-2000.0, VolumeUnit.MILLILITRE));
        //Assertions.assertEquals(3.0, result, EPLISION);
        Assertions.assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE), result);
    }

    @Test
    void testAddition_LargeValues() {
        Quantity<VolumeUnit> a = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = a.add(new Quantity<>(1e6, VolumeUnit.LITRE));
        //Assertions.assertEquals(2e6, result, EPLISION);
        Assertions.assertEquals(new Quantity<>(2e6, VolumeUnit.LITRE), result);

    }

    @Test
    void testAddition_SmallValues() {
        Quantity<VolumeUnit> a = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = a.add(new Quantity<>(0.002, VolumeUnit.LITRE));
        //Assertions.assertEquals(0.003, result, EPLISION);
        Assertions.assertEquals(new Quantity<>(0.003, VolumeUnit.LITRE), result);
    }

    // -------------------------
    // Enum constants & base conversions
    // -------------------------

    @Test
    void testVolumeUnitEnum_LitreConstant() {
        double cf = VolumeUnit.LITRE.getConversionFactor();
        Assertions.assertEquals(1.0, cf, EPLISION);
    }

    @Test
    void testVolumeUnitEnum_MillilitreConstant() {
        double cf = VolumeUnit.MILLILITRE.getConversionFactor();
        Assertions.assertEquals(0.001, cf, EPLISION);
    }

    @Test
    void testVolumeUnitEnum_GallonConstant() {
        double cf = VolumeUnit.GALLON.getConversionFactor();
        Assertions.assertEquals(3.78541, cf, EPLISION);
    }

    @Test
    void testConvertToBaseUnit_LitreToLitre() {
        double base = VolumeUnit.LITRE.convertToBaseUnit(5.0);
        Assertions.assertEquals(5.0, base, EPLISION);
    }

    @Test
    void testConvertToBaseUnit_MillilitreToLitre() {
        double base = VolumeUnit.MILLILITRE.convertToBaseUnit(1000.0);
        Assertions.assertEquals(1.0, base, EPLISION);
    }

    @Test
    void testConvertToBaseUnit_GallonToLitre() {
        double base = VolumeUnit.GALLON.convertToBaseUnit(1.0);
        Assertions.assertEquals(3.78541, base, EPLISION);
    }

    @Test
    void testConvertFromBaseUnit_LitreToLitre() {
        double v = VolumeUnit.LITRE.convertFromBaseUnit(2.0);
        Assertions.assertEquals(2.0, v, EPLISION);
    }

    @Test
    void testConvertFromBaseUnit_LitreToMillilitre() {
        double v = VolumeUnit.MILLILITRE.convertFromBaseUnit(1.0);
        Assertions.assertEquals(1000.0, v, EPLISION);
    }

    @Test
    void testConvertFromBaseUnit_LitreToGallon() {
        double v = VolumeUnit.GALLON.convertFromBaseUnit(3.78541);
        Assertions.assertEquals(1.0, v, EPLISION);
    }
    //UC12 test cases
//SUBTRACTION TEST CASES


    @Test
    void testSubtraction_SameUnit_FeetMinusFeet() {

        Quantity<LengthUnit> result =

                new Quantity<>(10.0, LengthUnit.FEET)

                        .substract(new Quantity<>(5.0, LengthUnit.FEET));

        Assertions.assertEquals(new Quantity<>(5.0, LengthUnit.FEET), result);

    }

    @Test
    void testSubtraction_SameUnit_LitreMinusLitre() {

        Quantity<VolumeUnit> result =

                new Quantity<>(10.0, VolumeUnit.LITRE)

                        .substract(new Quantity<>(3.0, VolumeUnit.LITRE));

        Assertions.assertEquals(new Quantity<>(7.0, VolumeUnit.LITRE), result);

    }

    @Test
    void testSubtraction_CrossUnit_FeetMinusInches() {

        Quantity<LengthUnit> result =

                new Quantity<>(10.0, LengthUnit.FEET)

                        .substract(new Quantity<>(6.0, LengthUnit.INCHES));

        Assertions.assertEquals(new Quantity<>(9.5, LengthUnit.FEET), result);

    }

    @Test
    void testSubtraction_CrossUnit_InchesMinusFeet() {

        Quantity<LengthUnit> result =

                new Quantity<>(120.0, LengthUnit.INCHES)

                        .substract(new Quantity<>(5.0, LengthUnit.FEET));

        Assertions.assertEquals(new Quantity<>(60.0, LengthUnit.INCHES), result);

    }

    @Test
    void testSubtraction_ExplicitTargetUnit() {

        Quantity<LengthUnit> result =

                new Quantity<>(10.0, LengthUnit.FEET)

                        .substract(new Quantity<>(6.0, LengthUnit.INCHES), LengthUnit.INCHES);

        Assertions.assertEquals(new Quantity<>(114.0, LengthUnit.INCHES), result);

    }

    @Test
    void testSubtraction_ResultingNegative() {

        Quantity<LengthUnit> result =

                new Quantity<>(5.0, LengthUnit.FEET)

                        .substract(new Quantity<>(10.0, LengthUnit.FEET));

        Assertions.assertEquals(new Quantity<>(-5.0, LengthUnit.FEET), result);

    }

    @Test
    void testSubtraction_NullOperand() {

        Assertions.assertThrows(IllegalArgumentException.class,

                () -> new Quantity<>(10.0, LengthUnit.FEET).substract(null));

    }

    @Test
    void testSubtraction_NullTargetUnit() {

        Assertions.assertThrows(IllegalArgumentException.class,

                () -> new Quantity<>(10.0, LengthUnit.FEET)

                        .substract(new Quantity<>(5.0, LengthUnit.FEET), null));

    }

    @Test
    void testSubtraction_CrossCategory() {

        Assertions.assertThrows(IllegalArgumentException.class,

                () -> new Quantity<>(10.0, LengthUnit.FEET)

                        .substract(new Quantity<>(5.0, WeightUnit.KILOGRAM)));

    }

    @Test
    void testSubtraction_ChainedOperations() {

        Quantity<LengthUnit> result =

                new Quantity<>(10.0, LengthUnit.FEET)

                        .substract(new Quantity<>(2.0, LengthUnit.FEET))

                        .substract(new Quantity<>(1.0, LengthUnit.FEET));

        Assertions.assertEquals(new Quantity<>(7.0, LengthUnit.FEET), result);

    }


    //DIVISION TEST CASES


    @Test
    void testDivision_SameUnit_FeetDividedByFeet() {

        double result =

                new Quantity<>(10.0, LengthUnit.FEET)

                        .divide(new Quantity<>(2.0, LengthUnit.FEET));

        Assertions.assertEquals(5.0, result, EPLISION);

    }

    @Test
    void testDivision_SameUnit_LitreDividedByLitre() {

        double result =

                new Quantity<>(10.0, VolumeUnit.LITRE)

                        .divide(new Quantity<>(5.0, VolumeUnit.LITRE));

        Assertions.assertEquals(2.0, result, EPLISION);

    }

    @Test
    void testDivision_CrossUnit_KgDividedByGram() {

        double result =

                new Quantity<>(2.0, WeightUnit.KILOGRAM)

                        .divide(new Quantity<>(2000.0, WeightUnit.GRAM));

        Assertions.assertEquals(1.0, result, EPLISION);

    }

    @Test
    void testDivision_RatioGreaterThanOne() {

        double result =

                new Quantity<>(10.0, LengthUnit.FEET)

                        .divide(new Quantity<>(2.0, LengthUnit.FEET));

        Assertions.assertTrue(result > 1.0);

    }

    @Test
    void testDivision_RatioLessThanOne() {

        double result =

                new Quantity<>(5.0, LengthUnit.FEET)

                        .divide(new Quantity<>(10.0, LengthUnit.FEET));

        Assertions.assertEquals(0.5, result, EPLISION);

    }

    @Test
    void testDivision_RatioEqualToOne() {

        double result =

                new Quantity<>(10.0, LengthUnit.FEET)

                        .divide(new Quantity<>(10.0, LengthUnit.FEET));

        Assertions.assertEquals(1.0, result, EPLISION);

    }

    @Test
    void testDivision_ByZero() {

        Assertions.assertThrows(ArithmeticException.class,

                () -> new Quantity<>(10.0, LengthUnit.FEET)

                        .divide(new Quantity<>(0.0, LengthUnit.FEET)));

    }

    @Test
    void testDivision_NullOperand() {

        Assertions.assertThrows(IllegalArgumentException.class,

                () -> new Quantity<>(10.0, LengthUnit.FEET).divide(null));

    }

    @Test

    void testDivision_CrossCategory() {

        Assertions.assertThrows(IllegalArgumentException.class,

                () -> new Quantity<>(10.0, LengthUnit.FEET)

                        .divide(new Quantity<>(5.0, WeightUnit.KILOGRAM)));

    }

    @Test
    void testDivision_AssociativityAwareness() {

        double left =

                new Quantity<>(10.0, LengthUnit.FEET)

                        .divide(new Quantity<>(2.0, LengthUnit.FEET));

        double right =

                new Quantity<>(2.0, LengthUnit.FEET)

                        .divide(new Quantity<>(10.0, LengthUnit.FEET));

        Assertions.assertNotEquals(left, right);

    }

    @Test
    void testSubtractionAndDivision_Integration() {

        double result =

                new Quantity<>(10.0, LengthUnit.FEET)

                        .substract(new Quantity<>(2.0, LengthUnit.FEET))

                        .divide(new Quantity<>(4.0, LengthUnit.FEET));

        Assertions.assertEquals(2.0, result, EPLISION);

    }

    @Test
    void testImmutability_Subtraction() {

        Quantity<LengthUnit> original =

                new Quantity<>(10.0, LengthUnit.FEET);

        original.substract(new Quantity<>(5.0, LengthUnit.FEET));

        Assertions.assertEquals(new Quantity<>(10.0, LengthUnit.FEET), original);

    }

    @Test
    void testImmutability_Division() {

        Quantity<LengthUnit> original =

                new Quantity<>(10.0, LengthUnit.FEET);

        original.divide(new Quantity<>(2.0, LengthUnit.FEET));

        Assertions.assertEquals(new Quantity<>(10.0, LengthUnit.FEET), original);

    }

}


