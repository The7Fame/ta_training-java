package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    private Point center;
    private double radius;

    private final double errorDelta = 1E-15;

    private boolean isCircle(Point center, double radius) {
        if (center == null) {
            return false;
        }
        return radius > 0;
    }

    public Circle(Point center, double radius) {

        if (!isCircle(center, radius)) {
            throw new IllegalArgumentException();
        }

        this.center = center;
        this.radius = radius;
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(figure instanceof Circle)) {
            return false;
        }
        return center.equals(((Circle) figure).center) && (Math.abs(radius - ((Circle) figure).radius) < errorDelta);
    }
}