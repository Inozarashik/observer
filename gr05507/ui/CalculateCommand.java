package ru.gr05507.ui;

public class CalculateCommand implements Command {
    private final CalculatorView view;
    private final CalculationFormPresenter presenter;

    public CalculateCommand(CalculatorView view, CalculationFormPresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public boolean canExecute() {
        return filled(view.getFormula())
                && filled(view.getLowerText())
                && filled(view.getUpperText())
                && filled(view.getIntervalsText());
    }

    @Override
    public void execute() {
        if (canExecute()) presenter.calculateClicked();
    }

    private boolean filled(String text) {
        return text != null && !text.isBlank();
    }
}