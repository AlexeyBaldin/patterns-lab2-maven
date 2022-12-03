package visual.scheme.svg;

import geometry.Circle;
import geometry.IPointBase;
import visual.scheme.IScheme;

import java.awt.*;

public class BlackSVG extends SVG implements IScheme {


    private Color color = Color.BLACK;

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public void drawStartPoint(IPointBase point) {
        svgString += "<rect fill=\"black\" x=\"" + (point.getX() - this.radius /2) + "\" y=\"" + (point.getY() - this.radius /2) + "\" width=\"" + this.radius + "\" height=\"" + this.radius + "\" />\n";

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
        this.drawCircle(new Circle(point.getX(), point.getY(), this.radius));
    }

    @Override
    public void drawCircle(Circle circle) {
        svgString += "<circle cx=\"" + circle.getX() + "\" cy=\"" + circle.getY() + "\" r=\"" + radius /2 + "\" />\n";
    }

    @Override
    public void fillCircle(Circle circle) {
        svgString += "<circle fill=\"rgb(0,0,0)\" cx=\"" + circle.getX() + "\" cy=\"" + circle.getY() + "\" r=\"" + radius /2 + "\" />\n";
    }
}
