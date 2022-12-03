package visual.scheme.svg;

import geometry.Circle;
import geometry.IPointBase;
import visual.scheme.IScheme;

import java.awt.*;

public class GreenSVG extends SVG implements IScheme {

    boolean isMarkerAdd = false;

    private IPointBase arrowPoint;

    private Color color;

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawStartPoint(IPointBase point) {
        this.drawCircle(new Circle(point.getX(), point.getY(), this.radius));
    }

    @Override
    public void drawLine(IPointBase point, IPointBase point1) {
        svgString += "<line x1=\"" + point.getX() + "\"  y1=\"" + point.getY() +
                "\" x2=\"" + point1.getX() + "\" y2=\"" + point1.getY() + "\" style=\"stroke:rgb(0,255,0);stroke-width:0.3\" />\n";
        arrowPoint = point;
    }

    @Override
    public void drawEndPoint(IPointBase point) {
        if(!isMarkerAdd) {
            svgString += "<marker\n" +
                    "      id=\"arrow\"\n" +
                    "      viewBox=\"0 0 10 10\"\n" +
                    "      refX=\"5\"\n" +
                    "      refY=\"5\"\n" +
                    "      markerWidth=\"30\"\n" +
                    "      markerHeight=\"30\"\n" +
                    "      fill=\"rgb(0,255,0)\"\n" +
                    "      orient=\"auto-start-reverse\">\n" +
                    "      <path d=\"M 0 0 L 10 5 L 0 10 z\" />\n" +
                    "    </marker>";
            isMarkerAdd = true;
        }

        svgString += "<line x1=\"" + arrowPoint.getX() + "\"  y1=\"" + arrowPoint.getY() +
                "\" x2=\"" + point.getX() + "\" y2=\"" + point.getY() + "\" style=\"stroke:rgb(0,255,0);stroke-width:0.3\" marker-end=\"url(#arrow)\" />\n";
    }

    @Override
    public void drawCenterPoint(IPointBase point) {
        this.drawCircle(new Circle(point.getX(), point.getY(), this.radius));
    }

    @Override
    public void drawCircle(Circle circle) {
        svgString += "<circle cx=\"" + circle.getX() + "\" cy=\"" + circle.getY() + "\" r=\"" + radius /2 + "\" />\n";
    }

    @Override
    public void fillCircle(Circle circle) {
        svgString += "<circle fill=\"rgb(0,255,0)\" cx=\"" + circle.getX() + "\" cy=\"" + circle.getY() + "\" r=\"" + radius /2 + "\" />\n";
    }


}
