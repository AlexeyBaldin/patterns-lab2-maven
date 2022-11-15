package visual.drawable;

import geometry.ICurve;
import geometry.Line;
import geometry.Util;
import visual.scheme.IScheme;

public class VisualLine extends VisualCurve {
    public VisualLine(Line curve) {
        super(curve);
    }

    @Override
    public void draw(IScheme scheme) {
        scheme.drawStartPoint(getPoint(0));
        scheme.drawLine(getPoint(0), getPoint(1));
        scheme.drawEndPoint(getPoint(1));
        scheme.drawCenterPoint(Util.getCenterPoint(this));
    }
}
