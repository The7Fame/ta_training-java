package com.epam.rd.autotasks;
import java.util.ArrayList;

public class TaskCarousel {

    private int capacity;
    public ArrayList<Task> tasks = new ArrayList<Task>();
    public int currIndex = 0;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
    }

    public boolean addTask(Task task) {
        if (task == null || task.isFinished() || this.isFull()) {
            return false;
        }

        tasks.add(task);
        return true;
    }

    public boolean execute() {
        if (!this.isEmpty()) {
            boolean wasRemoved = false;
            tasks.get(currIndex).execute();
            if (tasks.get(currIndex).isFinished()) {
                tasks.remove(currIndex);
                wasRemoved = true;
            }

            if (wasRemoved) {
                if (currIndex == tasks.size()) {
                    currIndex = 0;
                }
            } else {
                if (currIndex == tasks.size() - 1) {
                    currIndex = 0;
                } else {
                    currIndex++;
                }
            }

            return true;
        }
        return false;
    }

    public boolean isFull() {
        return capacity == tasks.size();
    }

    public boolean isEmpty() {
        return tasks.size() == 0;
    }

}
