package visual.drawable;

import geometry.ICurve;
import geometry.IPointBase;

public abstract class VisualCurve implements ICurve, IDrawable {

    private final ICurve curve;

    public VisualCurve(ICurve curve) {
        this.curve = curve;
    }

    @Override
    public final IPointBase getPoint(double t) {
        return this.curve.getPoint(t);
    }

}
