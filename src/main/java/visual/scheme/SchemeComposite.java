package visual.scheme;

import geometry.Circle;
import geometry.IPointBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SchemeComposite implements IScheme {

    private final ArrayList<IScheme> schemes = new ArrayList<>();

    public SchemeComposite(IScheme ...schemes) {
        this.schemes.addAll(Arrays.asList(schemes));
    }

    @Override
    public void drawStartPoint(IPointBase point) {
        schemes.forEach(scheme -> scheme.drawStartPoint(point));
    }

    @Override
    public void drawLine(IPointBase point, IPointBase point1) {
        schemes.forEach(scheme -> scheme.drawLine(point, point1));
    }

    @Override
    public void drawEndPoint(IPointBase point) {
        schemes.forEach(scheme -> scheme.drawEndPoint(point));
    }

    @Override
    public void drawCircle(Circle circle) {
        schemes.forEach(scheme -> scheme.drawCircle(circle));
    }

    @Override
    public void fillCircle(Circle circle) {
        schemes.forEach(scheme -> scheme.fillCircle(circle));
    }

    @Override
    public void setColor(Color color) {
        schemes.forEach(scheme -> scheme.setColor(color));
    }

    @Override
    public void drawCenterPoint(IPointBase point) {
        schemes.forEach(scheme -> scheme.drawCenterPoint(point));
    }

    @Override
    public void clear() {
        schemes.forEach(IScheme::clear);
    }

}
