package visual.drawable;

import geometry.ICurve;
import geometry.IPointBase;
import geometry.Util;
import visual.scheme.IScheme;

public class VisualCurve implements ICurve, IDrawable {

    private final ICurve curve;

    public VisualCurve(ICurve curve) {
        this.curve = curve;
    }

    @Override
    public final IPointBase getPoint(double t) {
        return this.curve.getPoint(t);
    }

    @Override
    public void draw(IScheme scheme) {
        scheme.drawStartPoint(getPoint(0));
        int pointsCount = 50;
        for(int i = 0; i < pointsCount; i++) {
            scheme.drawLine(
                    getPoint(((double)(i)/pointsCount)),
                    getPoint(((double)(i + 1))/pointsCount)
            );
        }
        scheme.drawEndPoint(getPoint(1));
        scheme.drawCenterPoint(Util.getCenterPoint(this));
    }

}
