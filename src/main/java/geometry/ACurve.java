package geometry;

public abstract class ACurve implements ICurve {

    private final IPoint a;
    private final IPoint b;

    public ACurve(IPoint a, IPoint b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public final IPoint getPoint(double t) {
        return doGetPoint(t, a, b);
    }

    protected abstract IPoint doGetPoint(double t, IPointBase a, IPointBase b);
}
