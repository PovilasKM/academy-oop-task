package com.swedbank.day3.shapes;

import com.swedbank.day3.Point;

import java.util.Arrays;

public class Rectangle implements Shape {

    private double perimeter;
    private double area;
    private double[] lines;

    public Rectangle(Point x1, Point x2, Point x3, Point x4) {

        double line1 = this.calculateDistanceBetweenPoints(x1.getX(), x1.getY(), x2.getX(), x2.getY());
        double line2 = this.calculateDistanceBetweenPoints(x2.getX(), x2.getY(), x3.getX(), x3.getY());
        double line3 = this.calculateDistanceBetweenPoints(x3.getX(), x3.getY(), x4.getX(), x4.getY());
        double line4 = this.calculateDistanceBetweenPoints(x1.getX(), x1.getY(), x4.getX(), x4.getY());

        this.lines = new double[]{line1, line2, line3, line4};

        this.perimeter = this.calculatePerimeter(lines);
        this.area = this.calculateArea(lines);

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

        double a = 0;
        double b = 0;

        for(int i = 0; i < lines.length; i++) {
            if(i == 0) {
                a = lines[i];
            }
            if(lines[i] > a) {
                b = lines[i];
            }
        }

        return a*b;
    }

    @Override
    public String print() {

        StringBuilder printAnswer = new StringBuilder();

        printAnswer.append("Rectangle, Sides ");
        printAnswer.append(String.format("%.3f", this.lines[0])+", ");
        printAnswer.append(String.format("%.3f", this.lines[1])+", ");
        printAnswer.append(String.format("%.3f", this.lines[2])+", ");
        printAnswer.append(String.format("%.3f", this.lines[3]));
        printAnswer.append(", area: ");
        printAnswer.append(String.format("%.3f", this.area));
        printAnswer.append(", perimeter: ");
        printAnswer.append(String.format("%.3f", this.perimeter));
        printAnswer.append("\n");

        return printAnswer.toString();
    }
}
