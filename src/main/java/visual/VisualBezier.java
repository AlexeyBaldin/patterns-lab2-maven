package visual;

import geometry.Bezier;

public class VisualBezier extends VisualCurve {

    public VisualBezier(Bezier bezier) {
        super(bezier);
    }

    @Override
    public void draw(IScheme scheme) {
        scheme.drawStartPoint(getPoint(0));
        int pointsCount = 50;
        for(int i = 1; i <= pointsCount; i++) {
            scheme.drawLine(
                    getPoint(((double)(i)/pointsCount)),
                    getPoint(((double)(i + 1))/pointsCount)
            );
        }
        scheme.drawEndPoint(getPoint(1));
    }
}
