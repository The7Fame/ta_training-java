package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Triangle extends Figure {

    private Point a;
    private Point b;
    private Point c;

    private boolean isTriangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            return false;
        }
        if ((c.getX() - a.getX()) * (b.getY() - a.getY()) - (b.getX() - a.getX()) * (c.getY() - a.getY()) == 0) {
            return false;
        }
        double lengthAB = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        double lengthAC = Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2));
        double lengthBC = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2));
        if ((lengthAB > lengthAC + lengthBC) || (lengthAC > lengthAB + lengthBC) || (lengthBC > lengthAB + lengthAC)) {
            return false;
        }
        return true;
    }

    public Triangle(Point a, Point b, Point c) {

        if (!isTriangle(a, b, c)) {
            throw new IllegalArgumentException();
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    private Point middle(Point start, Point end) {
        double middleX;
        double middleY;

        double halfX = Math.abs(end.getX() - start.getX()) / 2;
        if (start.getX() < end.getX()) {
            middleX = start.getX() + halfX;
        } else {
            middleX = end.getX() + halfX;
        }

        double halfY = Math.abs(end.getY() - start.getY()) / 2;
        if (start.getY() < end.getY()) {
            middleY = start.getY() + halfY;
        } else {
            middleY = end.getY() + halfY;
        }

        return new Point(middleX, middleY);
    }

    Point intersection(Point start1, Point end1, Point start2, Point end2) {

        double denominator = (end2.getY() - start2.getY()) * (end1.getX() - start1.getX()) - (end2.getX() - start2.getX()) * (end1.getY() - start1.getY());
        if (denominator == 0) {
            return null;
        }

        double u1 = ((end2.getX() - start2.getX()) * (start1.getY() - start2.getY()) - (end2.getY() - start2.getY()) * (start1.getX() - start2.getX())) / denominator;
        double u2 = ((end1.getX() - start1.getX()) * (start1.getY() - start2.getY()) - (end1.getY() - start1.getY()) * (start1.getX() - start2.getX())) / denominator;
        if (!(u1 >= 0 && u1 <= 1) || !(u2 >= 0 && u2 <= 1)) {
            return null;
        }

        double x = start1.getX() + u1 * (end1.getX() - start1.getX());
        double y = start1.getY() + u1 * (end1.getY() - start1.getY());
        return new Point(x, y);
    }

    @Override
    public Point centroid() {
        Point middleAB = middle(a, b);
        Point middleAC = middle(a, c);
        return intersection(middleAB, c, middleAC, b);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(figure instanceof Triangle)) {
            return false;
        }
        Point[] points = {a, b, c};
        Point[] figurePoints = {((Triangle) figure).a, ((Triangle) figure).b, ((Triangle) figure).c};
        Arrays.sort(points);
        Arrays.sort(figurePoints);
        return Arrays.equals(points, figurePoints);
    }
}