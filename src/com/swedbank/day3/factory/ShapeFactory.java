package com.swedbank.day3.factory;

import com.swedbank.day3.Point;
import com.swedbank.day3.exceptions.WrongCoordinatesCountException;
import com.swedbank.day3.shapes.Circle;
import com.swedbank.day3.shapes.Rectangle;
import com.swedbank.day3.shapes.Shape;
import com.swedbank.day3.shapes.Triangle;

public class ShapeFactory {

    public static Shape createShape(String line) throws WrongCoordinatesCountException {

        Shape shape = null;
        double[] lines;

        char whichFigure = line.charAt(0);

        String[] points = line.substring(2).split(" ");

        switch (whichFigure) {
            case 'C':
                if (points.length != 4) {
                    throw new WrongCoordinatesCountException(points.length);
                }

                Point Cpoint1 = new Point(Double.parseDouble(points[0]), Double.parseDouble(points[1]));
                Point Cpoint2 = new Point(Double.parseDouble(points[2]), Double.parseDouble(points[3]));

                shape = new Circle(new double[]{Cpoint1.calculateDistanceBetweenPoints(Cpoint2)});

                break;
            case 'R':
                if (points.length == 8) {
                    throw new WrongCoordinatesCountException(points.length);
                }

                Point Rpoint1 = new Point(Double.parseDouble(points[0]), Double.parseDouble(points[1]));
                Point Rpoint2 = new Point(Double.parseDouble(points[2]), Double.parseDouble(points[3]));
                Point Rpoint3 = new Point(Double.parseDouble(points[4]), Double.parseDouble(points[5]));
                Point Rpoint4 = new Point(Double.parseDouble(points[6]), Double.parseDouble(points[7]));

                shape = new Rectangle(new double[]{
                        Rpoint1.calculateDistanceBetweenPoints(Rpoint2),
                        Rpoint2.calculateDistanceBetweenPoints(Rpoint3),
                        Rpoint3.calculateDistanceBetweenPoints(Rpoint4),
                        Rpoint1.calculateDistanceBetweenPoints(Rpoint4),
                }
                );

                break;
            case 'T':
                if (points.length == 6) {
                    throw new WrongCoordinatesCountException(points.length);
                }

                Point Tpoint1 = new Point(Double.parseDouble(points[0]), Double.parseDouble(points[1]));
                Point Tpoint2 = new Point(Double.parseDouble(points[2]), Double.parseDouble(points[3]));
                Point Tpoint3 = new Point(Double.parseDouble(points[4]), Double.parseDouble(points[5]));

                shape = new Triangle(new double[]{
                        Tpoint1.calculateDistanceBetweenPoints(Tpoint2),
                        Tpoint2.calculateDistanceBetweenPoints(Tpoint3),
                        Tpoint1.calculateDistanceBetweenPoints(Tpoint3),
                }
                );

                break;
            default:
                break;
        }

        return shape;
    }
}
