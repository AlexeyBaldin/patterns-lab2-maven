package geometry.strategy;

import geometry.ICurve;
import geometry.IPointBase;

public abstract class StrategyCalculator {

    public final double calculate(ICurve curve, double parameter) {
        double length = 0;
        double t = 0;

        int pointsCount = 200;
        for(double i = 0; i < pointsCount; i++) {
            IPointBase point = curve.getPoint(i / pointsCount);
            IPointBase point1 = curve.getPoint((i+1) / pointsCount);

            t = (i+1) / pointsCount;
            length += Math.sqrt(Math.pow(point.getX() - point1.getX(), 2) + Math.pow(point.getY() - point1.getY(), 2));
            double done = checkDone(parameter, length, t);
            if(done != -1) {
                return done;
            }
        }

        return -1;
    }

    abstract protected double checkDone(double parameter, double length, double t);
}
