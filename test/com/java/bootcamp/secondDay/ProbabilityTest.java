package com.java.bootcamp.secondDay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {

    @Test
    @DisplayName("should not create instance of probability and throw the exception if the probability is less than zero")
    void shouldThrowExceptionWhenValueIsLessThanZero() {
        assertThrows(Exception.class, () -> new Probability(-0.3));
    }

    @Test
    @DisplayName("should not create instance of probability and throw the exception if the probability is greater than 1")
    void shouldThrowExceptionWhenValueIsGreaterThanOne() {
        assertThrows(Exception.class, () -> new Probability(2));
    }

    @Test
    @DisplayName("should create instance of probability if probability is valid")
    void shouldCreateInstance() {
        assertDoesNotThrow(() -> new Probability(0.3));
    }

    @Test
    @DisplayName("should return probability of not happening")
    void shouldCalculateInverseProbability() throws ProbabilityException {
        Probability probability = new Probability(0.45);
        Probability expected = new Probability(0.55);
        Probability improbability = probability.not();
        assertEquals(expected, improbability);
    }

    @Test
    @DisplayName("should return probability of getting same on both")
    void shouldCalculateProbabilityOfTwoOccurrences() throws ProbabilityException {
        Probability probability = new Probability(0.5);
        Probability actual = probability.and(new Probability(0.5));
        Probability expected = new Probability(0.25);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should return probability of getting at least one occurrence")
    void shouldCalculateProbabilityOfAtLeastOneOccurrence() throws ProbabilityException {
        Probability probability = new Probability(0.5);
        Probability actual = probability.or(new Probability(0.5));
        Probability expected = new Probability(0.75);
        assertEquals(expected, actual);
    }

}