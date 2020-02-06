package com.swedbank.day3.factory;

import com.swedbank.day3.Point;
import com.swedbank.day3.shapes.Circle;
import com.swedbank.day3.shapes.Rectangle;
import com.swedbank.day3.shapes.Shape;
import com.swedbank.day3.shapes.Triangle;

public class ShapeFactory {

    public static Shape createShape(String line) {

        Shape shape = null;

        char whichFigure = line.charAt(0);

        String[] points = line.substring(2).split(" ");

        switch(whichFigure) {
            case 'C':
                shape = new Circle(
                        new Point(Double.parseDouble(points[0]), Double.parseDouble(points[1])),
                        new Point(Double.parseDouble(points[2]), Double.parseDouble(points[3]))
                );
                break;
            case 'R':
                shape = new Rectangle(
                        new Point(Double.parseDouble(points[0]), Double.parseDouble(points[1])),
                        new Point(Double.parseDouble(points[2]), Double.parseDouble(points[3])),
                        new Point(Double.parseDouble(points[4]), Double.parseDouble(points[5])),
                        new Point(Double.parseDouble(points[6]), Double.parseDouble(points[7]))
                );
                break;
            case 'T':
                shape = new Triangle(
                        new Point(Double.parseDouble(points[0]), Double.parseDouble(points[1])),
                        new Point(Double.parseDouble(points[2]), Double.parseDouble(points[3])),
                        new Point(Double.parseDouble(points[4]), Double.parseDouble(points[5]))
                );
                break;
            default: break;
        }

        return shape;
    }
}
