package test;

import main.LengthUnit;
import main.Quantity;
import main.VolumeUnit;
import main.WeightUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityTest {

    private static final double EPSILON = 1e-6;


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

        Assertions.assertEquals(5.0, result, EPSILON);

    }

    @Test
    void testDivision_SameUnit_LitreDividedByLitre() {

        double result =

                new Quantity<>(10.0, VolumeUnit.LITRE)

                        .divide(new Quantity<>(5.0, VolumeUnit.LITRE));

        Assertions.assertEquals(2.0, result, EPSILON);

    }

    @Test
    void testDivision_CrossUnit_KgDividedByGram() {

        double result =

                new Quantity<>(2.0, WeightUnit.KILOGRAM)

                        .divide(new Quantity<>(2000.0, WeightUnit.GRAM));

        Assertions.assertEquals(1.0, result, EPSILON);

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

        Assertions.assertEquals(0.5, result, EPSILON);

    }

    @Test
    void testDivision_RatioEqualToOne() {

        double result =

                new Quantity<>(10.0, LengthUnit.FEET)

                        .divide(new Quantity<>(10.0, LengthUnit.FEET));

        Assertions.assertEquals(1.0, result, EPSILON);

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

        Assertions.assertEquals(2.0, result, EPSILON);

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
