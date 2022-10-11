package client;

import geometry.ICurve;
import visual.Drawer;
import visual.VisualCurve;

import java.util.ArrayList;

public class Service {

    private Drawer drawer;
    private final int canvasSize;

    public Service(int canvasSize) {
        this.canvasSize = canvasSize;

        drawer = new Drawer(canvasSize);
    }

    public int getSize() {
        return this.canvasSize;
    }

    public void draw(VisualCurve curve) {
        curve.draw(drawer);
    }

    public void clear() {
        drawer.clear();
    }


}
