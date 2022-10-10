package visual;

import geometry.IPoint;
import swing.Frame;

public class Drawer {

    private final Frame frame = new Frame();

    public void drawLine(IPoint p1, IPoint p2) {
        System.out.println("Drawer is drawing");
        frame.draw(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
