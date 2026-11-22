package ru.gr05507.infrastructure;

import ru.gr05507.domain.Calculation;
import ru.gr05507.domain.CalculationObserver;

public class ConsoleCalculationLogger implements CalculationObserver {

    @Override
    public void onCalculationAdded(Calculation c) {
        System.out.println("[LOG] Добавлен расчёт: f(x) = " + c.getFormula()
                + ", [" + c.getLower() + "; " + c.getUpper() + "]"
                + ", метод: " + c.getMethod()
                + ", n = " + c.getIntervals()
                + ", I = " + c.getResult());
    }

    @Override
    public void onCalculationRemoved(Calculation c) {
        System.out.println("[LOG] Удалён расчёт: f(x) = " + c.getFormula()
                + ", I = " + c.getResult());
    }
}