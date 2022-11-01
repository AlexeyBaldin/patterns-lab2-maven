package visual;

import geometry.IPoint;
import visual.swing.Frame;
import visual.swing.bridge.BridgeCanvas;

import java.awt.*;

public class Drawer {

    private final Frame frame;

    public Drawer(BridgeCanvas canvas1, BridgeCanvas canvas2) {
        frame = new Frame(canvas1, canvas2);
    }

    public void drawLine(IPoint p1, IPoint p2) {
        frame.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public void clear() {
        frame.clear();
    }
}
