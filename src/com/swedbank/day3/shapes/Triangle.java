package com.swedbank.day3.shapes;

import com.swedbank.day3.Point;

import java.util.Arrays;

public class Triangle implements Shape {

    private double perimeter;
    private double area;
    private double[] lines;

    public Triangle(Point x1, Point x2, Point x3) {

        double line1 = this.calculateDistanceBetweenPoints(x1.getX(), x1.getY(), x2.getX(), x2.getY());
        double line2 = this.calculateDistanceBetweenPoints(x1.getX(), x1.getY(), x3.getX(), x3.getY());
        double line3 = this.calculateDistanceBetweenPoints(x2.getX(), x2.getY(), x3.getX(), x3.getY());

        this.lines = new double[]{line1, line2, line3};

        this.perimeter = this.calculatePerimeter(this.lines);
        this.area = this.calculateArea(this.lines);

    }

    public double calculateDistanceBetweenPoints(double x1, double y1, double x2, double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    @Override
    public double calculatePerimeter(double[] lines) {
        return Arrays.stream(lines).sum();
    }

    @Override
    public double calculateArea(double[] lines) {
        double p = this.perimeter/2;
        return Math.sqrt(p*(p-lines[0])*(p-lines[1])*(p-lines[2]));
    }

    @Override
    public String print() {

        StringBuilder printAnswer = new StringBuilder();

        printAnswer.append("Triangle, Sides ");
        printAnswer.append(String.format("%.3f", this.lines[0])+", ");
        printAnswer.append(String.format("%.3f", this.lines[1])+", ");
        printAnswer.append(String.format("%.3f", this.lines[2]));
        printAnswer.append(", area: ");
        printAnswer.append(String.format("%.3f", this.area));
        printAnswer.append(", perimeter: ");
        printAnswer.append(String.format("%.3f", this.perimeter));
        printAnswer.append("\n");

        return printAnswer.toString();
    }
}
