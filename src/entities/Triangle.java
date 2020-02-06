package entities;

import interfaces.Shape;

public class Triangle implements Shape {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculatePerimeter() {
        return a.getDistance(b) + b.getDistance(c) + c.getDistance(a);
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s*(s - a.getDistance(b))*(s - b.getDistance(c))*(s-c.getDistance(a)));
    }

    @Override
    public String print() {
        return String.format("Triangle; Sides %.3f, %.3f, %.3f;  Area: %.3f; Perimeter: %.3f\n",
                a.getDistance(b), b.getDistance(c), c.getDistance(a), calculateArea(), calculatePerimeter());
    }
}
