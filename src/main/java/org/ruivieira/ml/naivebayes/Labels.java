package org.ruivieira.ml.naivebayes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Labels {
    private final Map<String, Integer> counts = new HashMap<>();

    public Labels() {

    }

    public void add(String label) {
        this.add(label, 1);
    }

    public void add(String label, Integer amount) {
        Integer count = this.counts.getOrDefault(label, 0);
        this.counts.put(label, count + amount);
    }

    public Set<String> getNames() {
        return this.counts.keySet();
    }

    public Integer getCount(String label) {
        return this.counts.getOrDefault(label, null);
    }

    public Integer getTotal() {
        return this.counts.values().stream().reduce(0, (x, y) -> x + y);
    }

}
