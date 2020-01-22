package entities;

import interfaces.Shape;

public class Circle implements Shape {

    private Point center;
    private Point other;

    public Circle(Point center, Point other) {
        this.center = center;
        this.other = other;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * center.getDistance(other);
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(center.getDistance(other), 2);
    }

    @Override
    public String print() {
        return String.format("Circle, area: %.3f, perimeter: %.3f\n", calculateArea(), calculatePerimeter());
    }
}
