package ru.gr05507.application;

import ru.gr05507.domain.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.DoubleUnaryOperator;

public class CalculationService implements CalculationSubject {
    private final CalculationRepository repository;
    private final FormulaParser parser;
    private final List<CalculationObserver> observers = new CopyOnWriteArrayList<>();

    public CalculationService(CalculationRepository repository, FormulaParser parser) {
        this.repository = repository;
        this.parser = parser;
    }

    @Override
    public void addObserver(CalculationObserver observer) {
        if (observer == null)
            throw new IllegalArgumentException("Наблюдатель не может быть null");
        if (!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void removeObserver(CalculationObserver observer) {
        observers.remove(observer);
    }

    public Calculation calculate(String formula, double lower, double upper,
                                 int intervals, MethodRealisation method) {
        DoubleUnaryOperator f = parser.parse(formula);
        double result = Integrator.integrate(f, lower, upper, intervals, method);
        Calculation calculation = new Calculation(formula, lower, upper, intervals, method, result);
        repository.save(calculation);
        for (CalculationObserver observer : observers) observer.onCalculationAdded(calculation);
        return calculation;
    }

    public void delete(Calculation calculation) {
        repository.delete(calculation);
        for (CalculationObserver observer : observers) observer.onCalculationRemoved(calculation);
    }

    public List<Calculation> getAll() {
        return repository.findAll();
    }
}