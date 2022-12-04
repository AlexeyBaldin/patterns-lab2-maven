package geometry;

import visual.observer.IObserver;

import java.awt.*;

public class Circle extends Point implements ICurve {

    private final double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public IPointBase getPoint(double t) {
        return new Point(this.getX(), this.getY());
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "x=" + this.getX() +
                ", y=" + this.getY() +
                ", radius=" + radius +
                '}';
    }

}
