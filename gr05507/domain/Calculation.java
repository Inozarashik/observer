package ru.gr05507.domain;

public class Calculation {
    private final String formula;
    private final double lower;
    private final double upper;
    private final int intervals;
    private final MethodRealisation method;
    private final double result;

    public Calculation(String formula, double lower, double upper,
                       int intervals, MethodRealisation method, double result) {
        if (formula == null || formula.isBlank())
            throw new IllegalArgumentException("Формула не может быть пустой");
        if (method == null)
            throw new IllegalArgumentException("Метод обязателен");
        this.formula = formula.trim();
        this.lower = lower;
        this.upper = upper;
        this.intervals = intervals;
        this.method = method;
        this.result = result;
    }

    public String getFormula()            { return formula; }
    public double getLower()              { return lower; }
    public double getUpper()              { return upper; }
    public int getIntervals()             { return intervals; }
    public MethodRealisation getMethod()  { return method; }
    public double getResult()             { return result; }
}