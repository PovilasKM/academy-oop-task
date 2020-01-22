package entities;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(Point other) {
        return Math.sqrt(Math.pow(Math.abs(x - other.getX()), 2) + Math.pow(Math.abs(y - other.y), 2));
    }
}
