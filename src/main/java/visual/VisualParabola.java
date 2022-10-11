package visual;

import geometry.Parabola;

public class VisualParabola extends VisualCurve {

    public VisualParabola(Parabola parabola) {
        this.curve = parabola;
    }

    @Override
    public void draw(Drawer drawer) {
        int pointsCount = 100;

        for(int i = 1; i <= pointsCount; i++) {
            drawer.drawLine(
                    this.curve.getPoint(((double)(i)/pointsCount)),
                    this.curve.getPoint(((double)(i + 1))/pointsCount)
            );
        }
    }
}
