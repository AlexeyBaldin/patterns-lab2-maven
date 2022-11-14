package geometry.strategy;

public class LengthStrategy implements IStrategy {
    @Override
    public Double checkDone(double parameter, double length, double t) {
        if(Math.abs(parameter - t) < 0.01) {
            return length;
        }
        return null;
    }
}
