package org.ruivieira.ml.naivebayes;

import java.util.HashMap;
import java.util.Map;

public class Attributes {
    private final Map<String, Map<String, Double>> attributes = new HashMap<>();


    public void add(String attribute, String label) {
        if (!this.attributes.containsKey(attribute)) {
            this.attributes.put(attribute, new HashMap<>());
        }
        Double f = this.attributes.get(attribute).getOrDefault(label, 0.0) + 1;
        this.attributes.get(attribute).put(label, f);
    }

    public Double getFrequency(String attribute, String label) throws IllegalArgumentException {
        if (attributes.containsKey(attribute)) {
            return this.attributes.get(attribute).get(label);
        } else {
            throw new IllegalArgumentException("Unknown attribute " + attribute);
        }


    }

}
