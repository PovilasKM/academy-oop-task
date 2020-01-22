package entities;

import interfaces.Shape;

import java.util.Arrays;

public class Rectagle implements Shape {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Rectagle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double calculatePerimeter() {
        return a.getDistance(b) + b.getDistance(c) + c.getDistance(d) + d.getDistance(a);
    }

    @Override
    public double calculateArea() {
        double[] sortedLengths = new double[]{a.getDistance(b), a.getDistance(c), a.getDistance(d)};
        Arrays.sort(sortedLengths);
        double width = sortedLengths[0];
        double length = sortedLengths[1];
        return width * length;
    }

    @Override
    public String print() {
        return String.format("Rectangle; Sides: %.3f, %.3f, %.3f, %.3f;  Area: %.3f; Perimeter: %.3f\n",
                a.getDistance(b), b.getDistance(c), c.getDistance(d), d.getDistance(a), calculateArea(), calculatePerimeter());
    }
}
