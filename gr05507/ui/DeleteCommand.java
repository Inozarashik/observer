package ru.gr05507.ui;

public class DeleteCommand implements Command {
    private final CalculatorView view;
    private final CalculationListPresenter presenter;

    public DeleteCommand(CalculatorView view, CalculationListPresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public boolean canExecute() {
        return view.getSelected() != null;
    }

    @Override
    public void execute() {
        if (canExecute()) presenter.deleteSelected();
    }
}