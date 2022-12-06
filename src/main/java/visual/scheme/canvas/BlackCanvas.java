package visual.scheme.canvas;

import geometry.Circle;
import geometry.IPointBase;
import visual.drawable.DrawableComposite;

import java.awt.*;

public class BlackCanvas extends ACanvas {

    private final int radius = 6;


    private Color color;

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    public BlackCanvas(DrawableComposite drawableComposite) {
        super(drawableComposite);
    }

    @Override
    public void drawStartPoint(IPointBase point) {
        Graphics graphics = this.getGraphics();
        graphics.fillRect((int)point.getX() - this.radius /2, (int)point.getY() - this.radius /2, this.radius, this.radius);
    }

    @Override
    public void drawLine(IPointBase point, IPointBase point1) {

        Graphics graphics = this.getGraphics();

        double length = Math.sqrt(Math.pow(point1.getX() - point.getX(), 2) + Math.pow(point1.getY() - point.getY(), 2));
        int pointsCount = (int)(length/3);
        pointsCount+=2;

        double stepX = (point1.getX() - point.getX())/pointsCount;
        double stepY = (point1.getY() - point.getY())/pointsCount;
        double lastX = point.getX();
        double lastY = point.getY();
        for (int i = 0; i < pointsCount; i++) {
            if(i%3 == 0) {
                graphics.drawLine((int)lastX, (int)lastY, (int)(lastX + stepX), (int)(lastY + stepY));
            }

            lastX += stepX;
            lastY += stepY;
//            System.out.println(length+ " " + stepX + " " + i + " " + lastX);
        }


    }

    @Override
    public void drawEndPoint(IPointBase point) {
        Graphics graphics = this.getGraphics();
        graphics.fillRect((int)point.getX() - radius/2, (int)point.getY() - radius/2, radius, radius);
    }

    @Override
    public void drawCenterPoint(IPointBase point) {
        this.fillCircle(new Circle(point.getX(), point.getY(), this.radius));
    }

    @Override
    public void drawCircle(Circle circle) {
        Graphics graphics = this.getGraphics();
        graphics.drawOval((int)(circle.getX() - circle.getRadius()), (int)(circle.getY() - circle.getRadius()), (int) circle.getRadius(), (int) circle.getRadius());
    }

    @Override
    public void fillCircle(Circle circle) {
        Graphics graphics = this.getGraphics();
        graphics.fillOval((int)(circle.getX() - circle.getRadius()), (int)(circle.getY() - circle.getRadius()), (int) circle.getRadius(), (int) circle.getRadius());
    }


}
