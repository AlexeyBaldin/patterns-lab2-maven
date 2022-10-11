package geometry;

public class Parabola extends ACurve {

    public Parabola(IPoint a, IPoint b) {
        super(a, b);
    }

    @Override
    protected IPoint doGetPoint(double t, IPointBase a, IPointBase b) {
        return new Point(a.getX() + t, b.getY() + t*t);
    }

}
