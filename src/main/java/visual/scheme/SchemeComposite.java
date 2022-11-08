package visual.scheme;

import geometry.IPointBase;

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

}
