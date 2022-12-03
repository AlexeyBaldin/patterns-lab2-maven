package visual.scheme;

import geometry.Circle;
import geometry.IPointBase;

import java.awt.*;

public interface IScheme {
    void drawStartPoint(IPointBase point);
    void drawLine(IPointBase point, IPointBase point1);
    void drawEndPoint(IPointBase point);
    void drawCenterPoint(IPointBase point);
    void drawCircle(Circle circle);
    void fillCircle(Circle circle);
    void setColor(Color color);
    void clear();
}
