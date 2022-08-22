package com.epam.rd.autotasks;

public class CarouselRun {

    int[] elems;
    int index = 0;
    boolean isFinished = false;
    int quantity;
    boolean isDecrementingCarousel = false;
    boolean isHalvingCarousel = false;

    public CarouselRun(int[] elems, int quantity, Object obj) {
        this.elems = elems;
        this.quantity = quantity;
        if (quantity == 0) {
            this.isFinished = true;
        }
        if (obj instanceof HalvingCarousel) {
            isHalvingCarousel = true;
        } else if (obj instanceof DecrementingCarousel) {
            isDecrementingCarousel = true;
        }
    }

    public int next() {
        if (isFinished) {
            return -1;
        }

        int val = elems[index];

        if (isDecrementingCarousel) {
            elems[index]--;
        } else if (isHalvingCarousel) {
            elems[index] = elems[index] / 2;
        }
        int curIndex = index;

        do {
            if (index == elems.length - 1) {
                index = 0;
            } else {
                index++;
            }
        } while (elems[index] == 0 && index != curIndex);

        if (index == curIndex && elems[index] == 0) {
            isFinished = true;
        }

        return val;
    }

    public boolean isFinished() {
        return isFinished;
    }

}
