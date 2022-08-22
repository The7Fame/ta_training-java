package com.epam.rd.autotasks.triangle;

class Triangle {
    Point a;
    Point b;
    Point c;
    double lenAB;
    double lenAC;
    double lenBC;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if ((c.getX() - a.getX())
                * (b.getY() - a.getY())
                - (b.getX() - a.getX())
                * (c.getY() - a.getY()) == 0) {
            throw new IllegalArgumentException();
        }
        lenAB = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        lenAC = Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2));
        lenBC = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2));
        if ((lenAB > lenAC + lenBC) || (lenAC > lenAB + lenBC) || (lenBC > lenAB + lenAC)) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        double halfP = (lenAB + lenAC + lenBC) / 2;
        return Math.sqrt(halfP * (halfP - lenAB) * (halfP - lenAC) * (halfP - lenBC));
    }

    Point middle(Point start, Point end) {
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
    public Point centroid(){
        Point middleAB = middle(a, b);
        Point middleAC = middle(a, c);
        return intersection(middleAB, c, middleAC, b);
    }
}
