package geometry.strategy;

public class LengthStrategy extends StrategyCalculator {
    @Override
    protected Double checkDone(double parameter, double length, double t) {
        if(parameter >= t) {
            return length;
        }
        return null;
    }
}
