package com.epam.rd.autotasks.figures;

class Point implements Comparable {
    private double x;
    private double y;

    private final double errorDelta = 1E-15;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Point point = (Point) obj;
        return Math.abs(this.x - point.x) < errorDelta && Math.abs(this.y - point.y) < errorDelta;
    }

    @Override
    public int compareTo(Object obj) {
        Point tmp = (Point) obj;
        if (this.getX() < tmp.getX()) {
            return -1;
        } else if (this.getX() > tmp.getX()) {
            return 1;
        } else {
            if (this.getY() < tmp.getY()) {
                return -1;
            } else if (this.getY() > tmp.getY()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
