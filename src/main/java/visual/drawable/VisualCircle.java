package visual.drawable;

import geometry.Circle;
import visual.observer.IObserver;
import visual.scheme.IScheme;

import java.awt.*;

public class VisualCircle implements IDrawable, IMovable, IObserver {

    private final Circle circle;
    private Color color;
    private final double pow2Radius;
    private boolean isActive = false;

    public VisualCircle(Circle circle, Color color) {
        this.circle = circle;
        this.color = color;
        this.pow2Radius = Math.pow(circle.getRadius(), 2) / 4;
    }
    public boolean isActive() {
        return isActive;
    }

    public double getX() {
        return this.circle.getX();
    }

    public double getY() {
        return this.circle.getY();
    }

    @Override
    public void move(double x, double y) {
        this.circle.setX(x);
        this.circle.setY(y);
    }

    @Override
    public void draw(IScheme scheme) {
        scheme.setColor(this.color);
        scheme.fillCircle(circle);
        scheme.drawCircle(circle);
    }

    public void erase(IScheme scheme) {
        scheme.setColor(new Color(238, 238, 238));
        scheme.fillCircle(new Circle(circle.getX(), circle.getY(), circle.getRadius() + 3));
    }

    public boolean check(double x, double y) {
        return Math.pow(this.circle.getX() - x, 2) + Math.pow(this.circle.getY() - y, 2) <= this.pow2Radius;
    }

    @Override
    public void update() {
        if (this.color == Color.WHITE) {
            this.isActive = true;
            this.color = Color.GREEN;
        } else {
            this.isActive = false;
            this.color = Color.WHITE;
        }
    }


}
