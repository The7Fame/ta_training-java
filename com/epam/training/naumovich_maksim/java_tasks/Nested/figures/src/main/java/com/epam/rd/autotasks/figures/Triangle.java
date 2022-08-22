package com.epam.rd.autotasks.figures;

class Triangle extends Figure {

    private Point a;
    private Point b;
    private Point c;
    private double lenAB;
    private double lenAC;
    private double lenBC;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.lenAB = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        this.lenAC = Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2));
        this.lenBC = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2));
    }

    @Override
    public double area() {
        double halfPerimeter = (this.lenAB + this.lenAC + this.lenBC) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - lenAB) * (halfPerimeter - lenAC) * (halfPerimeter - lenBC));
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point leftPoint = a;
        if (b.getX() < leftPoint.getX()) {
            leftPoint = b;
        }
        if (c.getX() < leftPoint.getX()) {
            leftPoint = c;
        }
        return leftPoint;
    }

    public String toString() {
        return "Triangle[" + pointsToString() + "]";
    }
}