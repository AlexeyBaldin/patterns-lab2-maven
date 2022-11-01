package visual.swing.bridge;

public interface BridgeCanvas {
    void setSize(int width, int height);

    void drawLine(double x1, double y1, double x2, double y2);

    void clear();
}
