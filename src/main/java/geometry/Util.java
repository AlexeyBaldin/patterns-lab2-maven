package geometry;

import geometry.strategy.IStrategy;
import geometry.strategy.LengthStrategy;
import geometry.strategy.StrategyCalculator;
import geometry.strategy.TStrategy;

public class Util {
    public static IPointBase getCenterPoint(ICurve curve) {
        IStrategy tStrategy = new TStrategy();
        IStrategy lengthStrategy = new LengthStrategy();
        double length = StrategyCalculator.calculate(curve, 1, lengthStrategy);
        double t = StrategyCalculator.calculate(curve, length/2, tStrategy);
        return curve.getPoint(t);
    }
}
