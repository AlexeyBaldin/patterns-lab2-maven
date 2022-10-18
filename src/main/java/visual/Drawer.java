package visual;

import geometry.IPoint;
import visual.swing.Frame;

public class Drawer {

    private final Frame frame;

    public Drawer() {
        frame = new Frame();
    }

    public void drawLine(IPoint p1, IPoint p2) {
        frame.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public void clear() {
        frame.clear();
    }
}
