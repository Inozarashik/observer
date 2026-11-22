package ru.gr05507.ui;

import ru.gr05507.application.CalculationService;
import ru.gr05507.domain.Calculation;
import ru.gr05507.domain.CalculationObserver;
public class CalculationStatusPresenter implements CalculationObserver {
    private final CalculatorView view;
    private final CalculationService service;

    public CalculationStatusPresenter(CalculatorView view, CalculationService service) {
        this.view = view;
        this.service = service;
    }

    public void start() {
        service.addObserver(this);
        view.showStatus(buildStatus("Готово"));
    }

    @Override
    public void onCalculationAdded(Calculation calculation) {
        view.showStatus(buildStatus("Добавлен расчёт, I = " + String.format("%.8f", calculation.getResult())));
    }

    @Override
    public void onCalculationRemoved(Calculation calculation) {
        view.showStatus(buildStatus("Расчёт удалён"));
    }

    private String buildStatus(String event) {
        return "Расчётов: " + service.getAll().size() + " | " + event;
    }
}
