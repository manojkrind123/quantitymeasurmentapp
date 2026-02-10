package test;


import main.QuantityWeight;
import main.WeightUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityWeightUc9Test {



        @Test

        void givenSameWeightInKg_WhenCompared_ShouldReturnTrue() {

            QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);

            QuantityWeight w2 = new QuantityWeight(1, WeightUnit.KILOGRAM);

            Assertions.assertTrue(w1.equals(w2));

        }

        @Test

        void givenKgAndGram_WhenCompared_ShouldReturnTrue() {

            QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);

            QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

            Assertions.assertTrue(w1.equals(w2));

        }

        @Test

        void givenKgAndPound_WhenCompared_ShouldReturnTrue() {

            QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);

            QuantityWeight w2 = new QuantityWeight(2.20462, WeightUnit.POUND);

            Assertions.assertTrue(w1.equals(w2));

        }

        @Test

        void givenDifferentWeights_WhenCompared_ShouldReturnFalse() {

            QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);

            QuantityWeight w2 = new QuantityWeight(500, WeightUnit.GRAM);

            Assertions.assertFalse(w1.equals(w2));

        }

        @Test

        void givenTwoWeightsInKg_WhenAdded_ShouldReturnSum() {

            QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);

            QuantityWeight w2 = new QuantityWeight(2, WeightUnit.KILOGRAM);

            QuantityWeight result = w1.add(w2);

            Assertions.assertTrue(result.equals(new QuantityWeight(3, WeightUnit.KILOGRAM)));

        }

        @Test

        void givenKgAndGram_WhenAdded_ShouldReturnCorrectSum() {

            QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);

            QuantityWeight w2 = new QuantityWeight(500, WeightUnit.GRAM);

            QuantityWeight result = w1.add(w2);

            Assertions.assertTrue(result.equals(new QuantityWeight(1.5, WeightUnit.KILOGRAM)));

        }

        @Test

        void givenNullUnit_WhenCreatingWeight_ShouldThrowException() {

            Assertions.assertThrows(IllegalArgumentException.class,

                    () -> new QuantityWeight(10, null));

        }

    }
