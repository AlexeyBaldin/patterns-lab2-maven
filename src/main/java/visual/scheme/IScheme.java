package visual.scheme;

import geometry.IPoint;

public interface IScheme {
    void drawStartPoint(IPoint point);
    void drawLine(IPoint point, IPoint point1);
    void drawEndPoint(IPoint point);
}
