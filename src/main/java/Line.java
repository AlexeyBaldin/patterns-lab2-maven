public class Line extends ACurve {

    public Line(IPoint a, IPoint b) {
        super(a, b);
    }

    private double calculateLine(double a, double b, double t) {
        return (1.0 - t) * a + t * b;
    }

    @Override
    public IPoint getPoint(double t) {
        IPoint point = new Point();
        point.setX(calculateLine(a.getX(), b.getX(), t));
        point.setY(calculateLine(a.getY(), b.getY(), t));
        return point;
    }
}
