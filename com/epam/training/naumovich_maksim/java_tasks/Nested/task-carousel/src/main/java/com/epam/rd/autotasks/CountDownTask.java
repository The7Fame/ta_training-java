package com.epam.rd.autotasks;

public class CountDownTask implements Task{

    private int val;
    private boolean isFinished;

    public CountDownTask(int val) {
        if (val <= 0) {
            this.val = 0;
            this.isFinished = true;
        } else {
            this.val = val;
            this.isFinished = false;
        }
    }

    public int getValue() {
        return this.val;
    }


    @Override
    public void execute() {
        if (!isFinished) {
            val--;
            if (val == 0) {
                isFinished = true;
            }
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
