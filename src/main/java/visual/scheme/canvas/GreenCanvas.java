package visual.scheme.canvas;

import geometry.Circle;
import geometry.IPointBase;
import visual.drawable.DrawableComposite;

import java.awt.*;

public class GreenCanvas extends ACanvas {

    private final int radius = 6;

    private IPointBase arrowPoint;

    private Color color;

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public GreenCanvas(DrawableComposite drawableComposite) {
        super(drawableComposite);
    }

    @Override
    public void drawStartPoint(IPointBase point) {
        this.fillCircle(new Circle(point.getX(), point.getY(), this.radius));
    }

    @Override
    public void drawLine(IPointBase point, IPointBase point1) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.GREEN);
        graphics.drawLine((int)point.getX(), (int)point.getY(), (int)point1.getX(), (int)point1.getY());
        arrowPoint = point;
    }

    @Override
    public void drawEndPoint(IPointBase point) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.GREEN);

        if(arrowPoint != null) {
            int y0 = (int)arrowPoint.getY();
            int y1 = (int)point.getY();

            int x0 = (int)arrowPoint.getX();
            int x1 = (int)point.getX();

            int headLength = 10;

            double radians = 30 * Math.PI / 180.0;
            double angle = Math.atan2(y0 - y1, x0 - x1);
            int[] xs = { x1 + (int) (headLength * Math.cos(angle + radians)), x1,
                    x1 + (int) (headLength * Math.cos(angle - radians)) };
            int[] ys = { y1 + (int) (headLength * Math.sin(angle + radians)), y1,
                    y1 + (int) (headLength * Math.sin(angle - radians)) };
            graphics.fillPolygon(xs, ys, 3);

        } else {
            graphics.drawOval((int)point.getX() - radius/2, (int)point.getY() - radius/2, radius, radius);
        }
    }

    @Override
    public void drawCenterPoint(IPointBase point) {
        this.fillCircle(new Circle(point.getX(), point.getY(), this.radius));
    }

    @Override
    public void drawCircle(Circle circle) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.GREEN);
        graphics.drawOval((int)(circle.getX() - circle.getRadius()/2), (int)(circle.getY() - circle.getRadius()/2), (int) circle.getRadius(), (int) circle.getRadius());
    }

    @Override
    public void fillCircle(Circle circle) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.GREEN);
        graphics.fillOval((int)(circle.getX() - circle.getRadius()/2), (int)(circle.getY() - circle.getRadius()/2), (int) circle.getRadius(), (int) circle.getRadius());
    }
}
