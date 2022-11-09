package visual.drawable;

import geometry.ACurve;
import geometry.Bezier;
import geometry.ICurve;
import geometry.Util;
import visual.scheme.IScheme;

public class VisualBezier extends VisualCurve {

    public VisualBezier(ICurve curve) {
        super(curve);
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
