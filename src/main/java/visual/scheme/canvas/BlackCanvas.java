package visual.scheme.canvas;

import geometry.ICurve;
import geometry.IPointBase;
import geometry.strategy.LengthStrategy;
import geometry.strategy.TStrategy;
import visual.scheme.IScheme;

import java.awt.*;

public class BlackCanvas extends Canvas implements IScheme {

    private final int radius = 10;

    @Override
    public void drawStartPoint(IPointBase point) {
        Graphics graphics = this.getGraphics();
        graphics.fillRect((int)point.getX() - radius/2, (int)point.getY() - radius/2, radius, radius);
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
        this.drawStartPoint(point);
    }

}
