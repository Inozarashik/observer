package ru.gr05507.ui;

import ru.gr05507.application.CalculationService;
import ru.gr05507.domain.Calculation;
import ru.gr05507.domain.CalculationObserver;

public class CalculationListPresenter implements CalculationObserver {
    private final CalculatorView view;
    private final CalculationService service;

    public CalculationListPresenter(CalculatorView view, CalculationService service) {
        this.view = view;
        this.service = service;
    }

    public void start() {
        service.addObserver(this);
        refresh();
    }

    public void refresh() {
        view.showCalculations(service.getAll());
    }

    public void deleteSelected() {
        Calculation calculation = view.getSelected();
        if (calculation == null) {
            view.showError("Выберите расчёт в списке");
            return;
        }
        service.delete(calculation);
    }

    @Override
    public void onCalculationAdded(Calculation calculation) {
        refresh();
    }

    @Override
    public void onCalculationRemoved(Calculation calculation) {
        refresh();
    }
}
