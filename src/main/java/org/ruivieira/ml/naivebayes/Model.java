package org.ruivieira.ml.naivebayes;

public class Model {

    private final Labels labels = new Labels();
    private final Attributes attributes = new Attributes();

    private Model() {

    }

    public static Model create() {
        return new Model();
    }

    public Labels getLabels() {
        return labels;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void train(String text, String label) {
        String[] attributes = text.split(" ");
        this.train(attributes, label);
    }

    public void train(String[] attributes, String label) {
        this.labels.add(label);
        for (String attribute : attributes) {
            this.attributes.add(attribute, label);
        }

    }


}
