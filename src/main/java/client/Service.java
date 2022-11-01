package client;

import geometry.ICurve;
import visual.Drawer;
import visual.VisualCurve;
import visual.swing.bridge.BlackCanvas;
import visual.swing.bridge.BridgeCanvas;
import visual.swing.bridge.GreenCanvas;

import java.awt.*;
import java.util.ArrayList;

public class Service {

    private final Drawer drawer;

    public Service() {

        BridgeCanvas canvas1 = new GreenCanvas();
        BridgeCanvas canvas2 = new BlackCanvas();

        drawer = new Drawer(canvas1, canvas2);
    }

    public void draw(VisualCurve curve) {
        curve.draw(drawer);
    }

    public void clear() {
        drawer.clear();
    }


}
