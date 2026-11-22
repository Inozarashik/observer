package ru.gr05507.domain;

public interface CalculationObserver {
    void onCalculationAdded(Calculation calculation);
    void onCalculationRemoved(Calculation calculation);
}
