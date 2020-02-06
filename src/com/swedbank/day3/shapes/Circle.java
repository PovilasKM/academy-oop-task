package com.swedbank.day3.shapes;

import com.swedbank.day3.Point;

public class Circle implements Shape {

    private double perimeter;
    private double area;
    private double[] lines;

    public Circle(Point x1, Point x2) {

        double line1 = this.calculateDistanceBetweenPoints(x1.getX(), x1.getY(), x2.getX(), x2.getY());

        this.lines = new double[]{line1};

        this.perimeter = this.calculatePerimeter(lines);
        this.area = this.calculateArea(lines);

    }

    public double calculateDistanceBetweenPoints(double x1, double y1, double x2, double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    @Override
    public double calculatePerimeter(double[] lines) {
        return 2*Math.PI*lines[0];
    }

    @Override
    public double calculateArea(double[] lines) {
        return Math.PI*Math.pow(lines[0], 2);
    }

    @Override
    public String print() {

        StringBuilder printAnswer = new StringBuilder();

        printAnswer.append("Circle, area: ");
        printAnswer.append(String.format("%.3f", this.area));
        printAnswer.append(", perimeter: ");
        printAnswer.append(String.format("%.3f", this.perimeter));
        printAnswer.append("\n");

        return printAnswer.toString();

    }
}
