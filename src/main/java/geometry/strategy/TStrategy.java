package geometry.strategy;

public class TStrategy extends StrategyCalculator {
    @Override
    protected double checkDone(double parameter, double length, double t) {
        if(Math.abs(parameter - length) < 1) {
            return t;
        }
        return -1;
    }
}
