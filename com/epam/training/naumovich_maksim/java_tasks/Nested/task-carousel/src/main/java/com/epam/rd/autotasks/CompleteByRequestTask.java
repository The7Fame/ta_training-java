package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    private boolean isFinished = false;
    private boolean wasCompleted = false;

    @Override
    public void execute() {
        if (this.wasCompleted) {
            this.isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public void complete() {
        this.wasCompleted = true;
    }
}
