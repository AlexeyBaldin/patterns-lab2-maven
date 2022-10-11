package visual;

import geometry.IPoint;
import visual.swing.Frame;

public class Drawer {

    private final int size;
    private final Frame frame;

    public Drawer(int size) {
        this.size = size;
        frame = new Frame(this.size);
    }

    public void drawLine(IPoint p1, IPoint p2) {
        frame.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public void clear() {
        frame.clear();
    }
}
