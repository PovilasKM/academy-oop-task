package com.swedbank.day3.shapes;

import com.swedbank.day3.Point;

import java.util.Arrays;

public class Triangle implements Shape {

    private double[] lines;

    public Triangle(double[] lines) {
        this.lines = lines;
    }

    @Override
    public double calculatePerimeter(double[] lines) {
        return Arrays.stream(lines).sum();
    }

    @Override
    public double calculateArea(double[] lines) {
        double p = this.calculatePerimeter(this.lines) / 2;
        return Math.sqrt(p * (p - lines[0]) * (p - lines[1]) * (p - lines[2]));
    }

    @Override
    public String print() {

        StringBuilder printAnswer = new StringBuilder();

        printAnswer.append("Triangle, Sides ");
        printAnswer.append(String.format("%.3f", this.lines[0]) + ", ");
        printAnswer.append(String.format("%.3f", this.lines[1]) + ", ");
        printAnswer.append(String.format("%.3f", this.lines[2]));
        printAnswer.append(", area: ");
        printAnswer.append(String.format("%.3f", this.calculateArea(this.lines)));
        printAnswer.append(", perimeter: ");
        printAnswer.append(String.format("%.3f", this.calculatePerimeter(this.lines)));
        printAnswer.append("\n");

        return printAnswer.toString();
    }
}
