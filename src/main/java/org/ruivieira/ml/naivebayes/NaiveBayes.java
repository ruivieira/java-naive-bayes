package org.ruivieira.ml.naivebayes;

import java.util.*;

public class NaiveBayes {

    private static final double minimumProbability = 1e-10;
    private final Model model;

    public NaiveBayes(Model model) {
        this.model = model;
    }

    public Map<String, Double> classify(String[] attributes) {
        final Set<String> attributesSet = new HashSet<>(Arrays.asList(attributes));
        final Map<String, Double> labelProbabilities = new HashMap<>();

        for (String label : model.getLabels().getNames()) {
            final List<Double> attributesProbabilities = new ArrayList<>();
            for (String attribute : attributesSet) {
                final Double p = calculateAttributeProbability(attribute, label);
                if (p != null) {
                    attributesProbabilities.add(p);
                }
            }
            final Double attributeLikelihood = attributesProbabilities.stream().reduce(1.0, (x, y) -> x * y);

            labelProbabilities.put(label, attributeLikelihood * this.calculatePrior(label) * 100.0);
        }
        return labelProbabilities;

    }

    public Map<String, Double> classify(String text) {
        return this.classify(text.split(" "));
    }

    private Double calculatePrior(String label) {
        return this.model.getLabels().getCount(label).doubleValue() / this.model.getLabels().getTotal().doubleValue();
    }

    private Double calculateAttributeProbability(String attribute, String label) {
        Double attributeFrequency;
        try {
            attributeFrequency = this.model.getAttributes().getFrequency(attribute, label);
        } catch (IllegalArgumentException e) {
            return null;
        }
        if (attributeFrequency == null) {
            return minimumProbability;
        }
        return (attributeFrequency / this.model.getLabels().getCount(label));
    }

}
