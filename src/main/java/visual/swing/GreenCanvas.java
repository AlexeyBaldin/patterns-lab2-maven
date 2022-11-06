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
        graphics.drawOval((int)point.getX() - radius/2, (int)point.getY() - radius/2, radius, radius);
    }

    @Override
    public void drawLine(IPoint point, IPoint point1) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.GREEN);
        graphics.drawLine((int)point.getX(), (int)point.getY(), (int)point1.getX(), (int)point1.getY());
    }

    @Override
    public void drawEndPoint(IPoint point) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.GREEN);

        graphics.drawOval((int)point.getX() - radius/2, (int)point.getY() - radius/2, radius, radius);
        graphics.drawRect((int)point.getX() - radius/2, (int)point.getY() - radius/2, radius/2, radius/2);
    }
}
