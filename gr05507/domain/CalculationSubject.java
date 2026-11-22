package ru.gr05507.domain;

public interface CalculationSubject {
    void addObserver(CalculationObserver observer);
    void removeObserver(CalculationObserver observer);
}
