package com.epam.rd.autotasks;


public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {

        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        while (degrees < 0) {
            degrees += 360;
        }
        while (degrees >= 360) {
            degrees -= 360;
        }

        Direction[] direc = Direction.values();
        for (Direction dir : direc) {
            if (dir.degrees == degrees) {
                return dir;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        while (degrees < 0) {
            degrees += 360;
        }
        while (degrees >= 360) {
            degrees -= 360;
        }
        if (ofDegrees(degrees) != null) {
            return ofDegrees(degrees);
        }

        Direction closestDirection = Direction.N;
        Direction[] direc = Direction.values();
        for (Direction dir : direc) {
            if (Math.abs(dir.degrees - degrees) < Math.abs(closestDirection.degrees - degrees)) {
                closestDirection = dir;
            }
        }
        return closestDirection;
    }

    public Direction opposite() {
        int degreeFind = this.degrees;
        if (this.degrees >= 180) {
            degreeFind -= 180;
        } else {
            degreeFind += 180;
        }
        return ofDegrees(degreeFind);
    }

    public int differenceDegreesTo(Direction direction) {
        int degrees = Math.abs(this.degrees - direction.degrees);
        if (degrees > 180) {
            degrees = Math.abs(degrees - 360);
        }
        return degrees;
    }
}
