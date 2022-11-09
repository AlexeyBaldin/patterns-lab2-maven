package geometry;

import geometry.strategy.LengthStrategy;
import geometry.strategy.TStrategy;

public class Util {

    public static IPointBase getCenterPoint(ICurve curve) {
        TStrategy tStrategy = new TStrategy();
        LengthStrategy lengthStrategy = new LengthStrategy();
        double length = lengthStrategy.calculate(curve, 1);
        double t = tStrategy.calculate(curve, length/2);
        return curve.getPoint(t);
    }
}
