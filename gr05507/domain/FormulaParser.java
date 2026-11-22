package ru.gr05507.domain;

import java.util.function.DoubleUnaryOperator;

public interface FormulaParser {
    DoubleUnaryOperator parse(String formula);
}