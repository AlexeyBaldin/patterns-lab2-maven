package geometry;

public abstract class ACurve implements ICurve {

    private final IPointBase a;
    private final IPointBase b;

    public ACurve(IPointBase a, IPointBase b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public final IPointBase getPoint(double t) {
        return doGetPoint(t, a, b);
    }

    protected abstract IPointBase doGetPoint(double t, IPointBase a, IPointBase b);

}
