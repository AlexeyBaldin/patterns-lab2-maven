package visual.scheme.svg;

import geometry.IPointBase;
import visual.scheme.IScheme;

public class BlackSVG extends SVG implements IScheme {

    @Override
    public void drawStartPoint(IPointBase point) {
        svgString += "<rect fill=\"black\" x=\"" + (point.getX() - radius/2) + "\" y=\"" + (point.getY() - radius/2) + "\" width=\"" + radius + "\" height=\"" + radius + "\" />\n";

    }

    @Override
    public void drawLine(IPointBase point, IPointBase point1) {
        svgString += "<line x1=\"" + point.getX() + "\"  y1=\"" + point.getY() +
                "\" x2=\"" + point1.getX() + "\" y2=\"" + point1.getY() + "\" style=\"stroke:rgb(0,0,0);stroke-width:0.3;stroke-dasharray:3\" />\n";
    }

    @Override
    public void drawEndPoint(IPointBase point) {
        svgString += "<rect fill=\"black\" x=\"" + (point.getX() - radius/2) + "\" y=\"" + (point.getY() - radius/2) + "\" width=\"" + radius + "\" height=\"" + radius + "\" />\n";
    }

    @Override
    public void drawCenterPoint(IPointBase point) {
        this.drawStartPoint(point);
    }
}
