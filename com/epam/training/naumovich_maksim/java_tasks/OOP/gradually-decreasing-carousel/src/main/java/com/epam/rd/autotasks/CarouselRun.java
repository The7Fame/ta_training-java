package com.epam.rd.autotasks;

public class CarouselRun {

    int[] elems;
    int index = 0;
    boolean isFinished = false;
    int quantity;
    boolean isDecrementingCarousel = false;
    boolean isGraduallyDecreasingCarousel = false;
    int round = 1;

    public CarouselRun(int[] elems, int quantity, Object obj) {
        this.elems = elems;
        this.quantity = quantity;
        if (quantity == 0) {
            this.isFinished = true;
        }
        if (obj instanceof GraduallyDecreasingCarousel) {
            isGraduallyDecreasingCarousel = true;
        } else if (obj instanceof DecrementingCarousel) {
            isDecrementingCarousel = true;
        }
    }

    public int next() {
        if (isFinished) {
            return -1;
        }

        int retValue = elems[index];

        if (isDecrementingCarousel) {
            elems[index]--;
        } else if (isGraduallyDecreasingCarousel) {
            elems[index] -= round;
        }
        int currentIndex = index;

        do {
            if (index == elems.length - 1) {
                index = 0;
                round++;
            } else {
                index++;
            }
        } while (elems[index] <= 0 && index != currentIndex);

        if (index == currentIndex && elems[index] <= 0) {
            isFinished = true;
        }

        return retValue;
    }

    public boolean isFinished() {
        return isFinished;
    }

}