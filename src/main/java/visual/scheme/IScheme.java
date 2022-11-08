package visual.scheme;

import geometry.IPointBase;

public interface IScheme {
    void drawStartPoint(IPointBase point);
    void drawLine(IPointBase point, IPointBase point1);
    void drawEndPoint(IPointBase point);
}
