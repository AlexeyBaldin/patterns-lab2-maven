package geometry.strategy;

public class TStrategy extends StrategyCalculator {
    @Override
    protected Double checkDone(double parameter, double length, double t) {
        if(Math.abs(parameter - length) < 1) {
            return t;
        }
        return null;
    }
}
