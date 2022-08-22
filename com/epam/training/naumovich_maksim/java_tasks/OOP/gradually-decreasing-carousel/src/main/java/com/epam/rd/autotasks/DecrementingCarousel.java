package com.epam.rd.autotasks;

public class DecrementingCarousel {

    int capacity;
    int[] elems;
    int count = 0;
    boolean isRun = false;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.elems = new int[capacity];
    }

    public boolean addElement(int element) {
        if (element <= 0 || count == capacity || isRun) {
            return false;
        }

        elems[count] = element;
        count++;
        return true;
    }

    public CarouselRun run() {
        if (isRun) {
            return null;
        }
        isRun = true;
        return new CarouselRun(elems, count, this);
    }
}
