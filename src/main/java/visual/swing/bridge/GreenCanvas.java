package visual.swing.bridge;

import java.awt.*;

public class GreenCanvas extends Canvas implements BridgeCanvas {

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.GREEN);
        graphics.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    }

    @Override
    public void clear() {
        getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
    }
}
