package com.swedbank.day3.shapes;

import com.swedbank.day3.Point;

import java.util.Arrays;

public class Rectangle implements Shape {

    private double[] lines;

    public Rectangle(double[] lines) {
        this.lines = lines;
    }

    @Override
    public double calculatePerimeter(double[] lines) {
        return Arrays.stream(lines).sum();
    }

    @Override
    public double calculateArea(double[] lines) {

        double a = 0;
        double b = 0;

        for (int i = 0; i < lines.length; i++) {
            if (i == 0) {
                a = lines[i];
            }
            if (lines[i] > a) {
                b = lines[i];
            }
        }

        return a * b;
    }

    @Override
    public String print() {

        StringBuilder printAnswer = new StringBuilder();

        printAnswer.append("Rectangle, Sides ");
        printAnswer.append(String.format("%.3f", this.lines[0]) + ", ");
        printAnswer.append(String.format("%.3f", this.lines[1]) + ", ");
        printAnswer.append(String.format("%.3f", this.lines[2]) + ", ");
        printAnswer.append(String.format("%.3f", this.lines[3]));
        printAnswer.append(", area: ");
        printAnswer.append(String.format("%.3f", this.calculateArea(this.lines)));
        printAnswer.append(", perimeter: ");
        printAnswer.append(String.format("%.3f", this.calculateArea(this.lines)));
        printAnswer.append("\n");

        return printAnswer.toString();
    }
}
