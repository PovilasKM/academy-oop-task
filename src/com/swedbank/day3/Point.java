package com.swedbank.day3;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double calculateDistanceBetweenPoints(Point externalPoint) {
        return Math.sqrt((externalPoint.getY() - this.y) * (externalPoint.getY() - this.y) + (externalPoint.getX() - this.x) * (externalPoint.getX() - this.x));
    }
}