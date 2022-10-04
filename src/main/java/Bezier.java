public class Bezier extends ACurve {

    private IPoint c;
    private IPoint d;

    public Bezier(IPoint a, IPoint b, IPoint c, IPoint d) {
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
    public IPoint getPoint(double t) {
        IPoint point = new Point();
        point.setX(calculateBezier(a.getX(), c.getX(), d.getX(), b.getX(), t));
        point.setY(calculateBezier(a.getY(), c.getY(), d.getY(), b.getY(), t));
        return point;
    }
}
