package visual.scheme.canvas;

import geometry.Circle;
import geometry.IPointBase;
import visual.drawable.DrawableComposite;

import java.awt.*;

public class SimpleCanvas extends ACanvas {

    private Color color = Color.WHITE;

    public void setColor(Color color) {
        this.color = color;
    }

    public SimpleCanvas(DrawableComposite drawableComposite) {
        super(drawableComposite);
    }

    @Override
    public void drawStartPoint(IPointBase point) {
    }

    @Override
    public void drawLine(IPointBase point, IPointBase point1) {
        this.getGraphics().drawLine((int) point.getX(), (int) point.getY(), (int) point1.getX(), (int) point1.getY());
    }

    @Override
    public void drawEndPoint(IPointBase point) {
    }

    @Override
    public void drawCenterPoint(IPointBase point) {
    }

    @Override
    public void drawCircle(Circle circle) {
        Graphics graphics = this.getGraphics();
        graphics.drawOval((int) (circle.getX() - circle.getRadius() / 2), (int) (circle.getY() - circle.getRadius() / 2), (int) circle.getRadius(), (int) circle.getRadius());
    }

    @Override
    public void fillCircle(Circle circle) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(this.color);
        graphics.fillOval((int) (circle.getX() - circle.getRadius() / 2), (int) (circle.getY() - circle.getRadius() / 2), (int) circle.getRadius(), (int) circle.getRadius());
    }

}
