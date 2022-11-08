package geometry;

public class Bezier extends ACurve {

    private final IPointBase c;
    private final IPointBase d;

    public Bezier(IPointBase a, IPointBase b, IPointBase c, IPointBase d) {
        super(a, b);
        this.c = c;
        this.d = d;
    }

    private double calculateBezier(double a, double c, double d, double b, double t) {
        return Math.pow(1 - t, 3) * a
                + 3 * t * Math.pow(1 - t, 2) * c
                + 3 * Math.pow(t, 2) * (1 - t) * d
                + Math.pow(t, 3) * b;
    }

    @Override
    public IPoint doGetPoint(double t, IPointBase a, IPointBase b) {
        return new Point(calculateBezier(a.getX(), c.getX(), d.getX(), b.getX(), t),
                calculateBezier(a.getY(), c.getY(), d.getY(), b.getY(), t));
    }
}
