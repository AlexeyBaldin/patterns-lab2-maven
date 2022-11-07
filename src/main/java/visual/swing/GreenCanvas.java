package visual.swing;

import geometry.IPoint;
import visual.IScheme;

import java.awt.*;

public class GreenCanvas extends Canvas implements IScheme {

    private final int radius = 6;


    @Override
    public void drawStartPoint(IPoint point) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.GREEN);
        graphics.drawOval((int)point.getX() - radius, (int)point.getY() - radius, radius, radius);
    }

    @Override
    public void drawLine(IPoint point, IPoint point1) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.GREEN);
        graphics.drawLine((int)point.getX(), (int)point.getY(), (int)point1.getX(), (int)point1.getY());
        System.out.println(point + " ---> " + point1);
    }

    @Override
    public void drawEndPoint(IPoint point, IPoint prevPoint) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.GREEN);

        if(prevPoint != null) {
            int y0 = (int)prevPoint.getY();
            int y1 = (int)point.getY();

            int x0 = (int)prevPoint.getX();
            int x1 = (int)point.getX();

            int headLength = 10;

            double offs = 30 * Math.PI / 180.0;
            double angle = Math.atan2(y0 - y1, x0 - x1);
            int[] xs = { x1 + (int) (headLength * Math.cos(angle + offs)), x1,
                    x1 + (int) (headLength * Math.cos(angle - offs)) };
            int[] ys = { y1 + (int) (headLength * Math.sin(angle + offs)), y1,
                    y1 + (int) (headLength * Math.sin(angle - offs)) };
            graphics.drawPolyline(xs, ys, 3);

            System.out.println(point);
        } else {
            graphics.drawOval((int)point.getX() - radius, (int)point.getY() - radius, radius, radius);
        }
    }
}
