package visual.scheme;

import geometry.IPoint;

import java.util.ArrayList;
import java.util.Arrays;

public class SchemeComposite implements IScheme {

    private final ArrayList<IScheme> schemes = new ArrayList<>();

    public SchemeComposite(IScheme ...schemes) {
        this.schemes.addAll(Arrays.asList(schemes));
    }

    @Override
    public void drawStartPoint(IPoint point) {
        schemes.forEach(scheme -> scheme.drawStartPoint(point));
    }

    @Override
    public void drawLine(IPoint point, IPoint point1) {
        schemes.forEach(scheme -> scheme.drawLine(point, point1));
    }

    @Override
    public void drawEndPoint(IPoint point) {
        schemes.forEach(scheme -> scheme.drawEndPoint(point));
    }

}
