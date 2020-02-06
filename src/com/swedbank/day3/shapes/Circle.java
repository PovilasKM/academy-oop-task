package com.swedbank.day3.shapes;

import com.swedbank.day3.Point;

public class Circle implements Shape {

    private double[] lines;

    public Circle(double[] lines) {
        this.lines = lines;
    }

    @Override
    public double calculatePerimeter(double[] lines) {
        return 2 * Math.PI * lines[0];
    }

    @Override
    public double calculateArea(double[] lines) {
        return Math.PI * Math.pow(lines[0], 2);
    }

    @Override
    public String print() {

        StringBuilder printAnswer = new StringBuilder();

        printAnswer.append("Circle, area: ");
        printAnswer.append(String.format("%.3f", this.calculateArea(lines)));
        printAnswer.append(", perimeter: ");
        printAnswer.append(String.format("%.3f", this.calculatePerimeter(lines)));
        printAnswer.append("\n");

        return printAnswer.toString();

    }
}
