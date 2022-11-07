package visual;

import geometry.Line;

public class VisualLine extends VisualCurve {

    public VisualLine(Line line) {
        super(line);
    }

    @Override
    public void draw(IScheme scheme) {
        scheme.drawStartPoint(getPoint(0));
        scheme.drawLine(getPoint(0), getPoint(1));
        scheme.drawEndPoint(getPoint(1), getPoint(0.95));
    }
}
