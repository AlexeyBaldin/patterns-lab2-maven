package geometry.decorator;

import geometry.ICurve;
import geometry.IPointBase;

public class Fragment implements ICurve {

    private final ICurve curve;
    private final double tStart;
    private final double tFinish;

    public Fragment(ICurve curve, double tStart, double tFinish) {
        this.curve = curve;
        this.tStart = tStart;
        this.tFinish = tFinish;
    }

    @Override
    public IPointBase getPoint(double t) {
        return curve.getPoint(tStart + t * (tFinish - tStart));
    }
}
