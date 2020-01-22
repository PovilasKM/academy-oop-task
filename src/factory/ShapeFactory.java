package factory;

import entities.Circle;
import entities.Point;
import entities.Rectagle;
import entities.Triangle;
import interfaces.Shape;

public class ShapeFactory {

    public static Shape createShape(String line) {
        Shape shape = null;
        String[] parts = line.split(" ");
        switch(parts[0]) {
            case "C":
                shape = new Circle(new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])),
                        new Point(Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
                break;
            case "T":
                shape = new Triangle(new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])),
                        new Point(Double.parseDouble(parts[3]), Double.parseDouble(parts[4])),
                        new Point(Double.parseDouble(parts[5]), Double.parseDouble(parts[6])));
                break;
            case "R":
                shape = new Rectagle(new Point(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])),
                        new Point(Double.parseDouble(parts[3]), Double.parseDouble(parts[4])),
                        new Point(Double.parseDouble(parts[5]), Double.parseDouble(parts[6])),
                        new Point(Double.parseDouble(parts[7]), Double.parseDouble(parts[8])));
                break;
        }
        return shape;
    }
}
