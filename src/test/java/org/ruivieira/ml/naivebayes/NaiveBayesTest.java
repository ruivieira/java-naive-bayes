package org.ruivieira.ml.naivebayes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NaiveBayesTest {

    final static double epsilon = 1e-9;
    final static String BRAND_A = "Brand A";
    final static String BRAND_B = "Brand B";

    @BeforeEach
    void setUp() {
    }

    @Test
    void classifyString() {
        final Model model = Model.create();
        model.train("Anna Engineering US", BRAND_A);
        model.train("Anna Marketing US", BRAND_B);
        model.train("Anna Marketing US", BRAND_B);
        model.train("Bill Marketing US", BRAND_B);
        model.train("Bill Engineering US", BRAND_A);
        model.train("Bill Engineering US", BRAND_A);
        model.train("Bill Marketing US", BRAND_B);
        model.train("Charles Marketing UK", BRAND_B);

        NaiveBayes naiveBayes = new NaiveBayes(model);
        Map<String, Double> c = naiveBayes.classify(new String[]{"Anna", "Marketing"});
        assertEquals(c.size(), 2);
        assertTrue(Math.abs(c.get(BRAND_B) - 25.0) < epsilon);
    }

    @Test
    void classifyArray() {
        final Model model = Model.create();
        model.train(new String[]{"Anna", "Engineering", "US"}, BRAND_A);
        model.train(new String[]{"Anna", "Marketing", "US"}, BRAND_B);
        model.train(new String[]{"Anna", "Marketing", "US"}, BRAND_B);
        model.train(new String[]{"Bill", "Marketing", "US"}, BRAND_B);
        model.train(new String[]{"Bill", "Engineering", "US"}, BRAND_A);
        model.train(new String[]{"Bill", "Engineering", "US"}, BRAND_A);
        model.train(new String[]{"Bill", "Marketing", "US"}, BRAND_B);
        model.train(new String[]{"Charles", "Marketing", "UK"}, BRAND_B);

        NaiveBayes naiveBayes = new NaiveBayes(model);
        Map<String, Double> c = naiveBayes.classify(new String[]{"Anna", "Marketing"});
        assertEquals(c.size(), 2);
        assertTrue(Math.abs(c.get(BRAND_B) - 25.0) < epsilon);

    }
}