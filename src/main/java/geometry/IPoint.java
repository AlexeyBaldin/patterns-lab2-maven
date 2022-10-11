package geometry;

interface IPointBase {

    double getX();
    double getY();
}

public interface IPoint extends IPointBase {

    void setX(double x);
    void setY(double y);
}
