package com.java.bootcamp.secondDay;

import java.util.Objects;

public class Probability {

    private double value;

    Probability(double probability) throws ProbabilityException {
        validate(probability);
        this.value = probability;
    }

    Probability not() throws ProbabilityException {
        return new Probability(1 - this.value);
    }

    Probability and(Probability otherProbability) throws ProbabilityException {
        return new Probability(this.value * otherProbability.value);
    }

    Probability or(Probability otherProbability) throws ProbabilityException {
        Probability otherImprobability = otherProbability.not();
        Probability improbability = this.not();
        Probability noOccurrenceProbability = improbability.and(otherImprobability);
        return noOccurrenceProbability.not();

    }

    private void validate(double probability) throws ProbabilityException {
        if (probability > 1 || probability < 0)
            throw new ProbabilityException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
