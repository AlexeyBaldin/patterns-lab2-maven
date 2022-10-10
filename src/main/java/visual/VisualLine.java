package visual;

import geometry.Line;
import geometry.Point;

public class VisualLine extends VisualCurve {

    public VisualLine(Line line) {
        this.curve = line;
    }

    @Override
    public void draw(Drawer drawer) {
        System.out.println("VisualLine.draw");

        drawer.drawLine(
                this.curve.getPoint(0),
                this.curve.getPoint(1)
        );
    }
}
