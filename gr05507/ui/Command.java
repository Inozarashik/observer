package ru.gr05507.ui;

public interface Command {
    boolean canExecute();
    void execute();
}