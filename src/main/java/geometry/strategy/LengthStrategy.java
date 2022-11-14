package geometry.strategy;

public class LengthStrategy implements IStrategy {
    @Override
    public Double checkDone(double parameter, double length, double t) {
        if(parameter >= t) {
            return length;
        }
        return null;
    }
}
