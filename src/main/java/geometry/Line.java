package geometry;

public class Line extends ACurve {

    public Line(IPointBase a, IPointBase b) {
        super(a, b);
    }

    private double calculateLine(double a, double b, double t) {
        return (1.0 - t) * a + t * b;
    }

    @Override
    public IPoint doGetPoint(double t, IPointBase a, IPointBase b) {
        return new Point(calculateLine(a.getX(), b.getX(), t),
                calculateLine(a.getY(), b.getY(), t));
    }
}
