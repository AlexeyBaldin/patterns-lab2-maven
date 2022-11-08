package geometry.strategy;

public class LengthStrategy extends StrategyCalculator {
    @Override
    protected double checkDone(double parameter, double length, double t) {
        if(parameter == t) {
            return length;
        }
        return -1;
    }
}
