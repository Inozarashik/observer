package ru.gr05507.domain;

import java.util.function.DoubleUnaryOperator;

public final class Integrator {

    private Integrator() { }

    public static double integrate(DoubleUnaryOperator f, double a, double b,
                                   int n, MethodRealisation method) {
        if (!(a < b))
            throw new IllegalArgumentException("Нижний предел должен быть меньше верхнего");
        if (n < 1)
            throw new IllegalArgumentException("Число отрезков должно быть не меньше 1");

        double sum = method.strategy().calculateOfIntegral(f, a, b, n);
        if (!Double.isFinite(sum))
            throw new IllegalArgumentException("Функция не определена или не ограничена на отрезке");
        return sum;
    }
}