package visual;

import geometry.Bezier;

public class VisualBezier extends VisualCurve {

    public VisualBezier(Bezier bezier) {
        this.curve = bezier;
    }

    @Override
    public void draw(Drawer drawer) {
        System.out.println("VisualBezier.draw");

        int pointsCount = 100;

        for(int i = 1; i <= pointsCount; i++) {
            drawer.drawLine(
                    this.curve.getPoint(((double)(i)/pointsCount)),
                    this.curve.getPoint(((double)(i + 1))/pointsCount)
            );
        }
    }
}
