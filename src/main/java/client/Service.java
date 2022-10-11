package client;

import geometry.ICurve;
import visual.Drawer;
import visual.VisualCurve;

import java.util.ArrayList;

public class Service {

    private final Drawer drawer;

    public Service() {

        drawer = new Drawer();
    }

    public void draw(VisualCurve curve) {
        curve.draw(drawer);
    }

    public void clear() {
        drawer.clear();
    }


}
