package com.epam.rd.autotasks.figures;


class Quadrilateral extends Figure {
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private double lenAB;
    private double lenAC;
    private double lenBC;
    private double lenCD;
    private double lenAD;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.lenAB = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        this.lenAC = Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2));
        this.lenBC = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2));
        this.lenCD = Math.sqrt(Math.pow(c.getX() - d.getX(), 2) + Math.pow(c.getY() - d.getY(), 2));
        this.lenAD = Math.sqrt(Math.pow(a.getX() - d.getX(), 2) + Math.pow(a.getY() - d.getY(), 2));
    }

    @Override
    public double area() {
        double halfPerimeterFirstTriangle = (lenAB + lenAC + lenBC) / 2;
        double areaFirstTriangle = Math.sqrt(halfPerimeterFirstTriangle * (halfPerimeterFirstTriangle - lenAB) * (halfPerimeterFirstTriangle - lenAC) * (halfPerimeterFirstTriangle - lenBC));
        double halfPerimeterSecondTriangle = (lenCD + lenAC + lenAD) / 2;
        double areaSecondTriangle = Math.sqrt(halfPerimeterSecondTriangle * (halfPerimeterSecondTriangle - lenCD) * (halfPerimeterSecondTriangle - lenAC) * (halfPerimeterSecondTriangle - lenAD));
        return areaFirstTriangle + areaSecondTriangle;
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
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
        if (d.getX() < leftPoint.getX()) {
            leftPoint = d;
        }
        return leftPoint;
    }

    public String toString() {
        return "Quadrilateral[" + pointsToString() + "]";
    }
}