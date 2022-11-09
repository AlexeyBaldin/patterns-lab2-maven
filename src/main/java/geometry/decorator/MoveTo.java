package geometry.decorator;

import geometry.ICurve;
import geometry.IPoint;
import geometry.IPointBase;
import geometry.Point;

public class MoveTo implements ICurve {

    private final ICurve curve;
    private final IPointBase point;
    private final IPointBase oldStartPoint;

    public MoveTo(ICurve curve, IPointBase point) {
        this.curve = curve;
        this.point = point;
        this.oldStartPoint = curve.getPoint(0);
    }

    @Override
    public IPointBase getPoint(double t) {
        IPointBase pointBase = curve.getPoint(t);
        return new Point(point.getX() + pointBase.getX() - oldStartPoint.getX(), point.getY() + pointBase.getY() - oldStartPoint.getY());
    }
}
