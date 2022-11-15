package geometry.strategy;

public class TStrategy implements IStrategy {
    @Override
    public Double stopper(double parameter, double length, double t) {
        if(Math.abs(parameter - length) < 1) {
            return t;
        }
        return null;
    }
}
