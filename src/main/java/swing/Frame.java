package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Frame extends JFrame {

    private final Canvas canvas;

    public Frame() {
        setSize(500, 500);
        this.canvas = new Canvas();
        add(this.canvas);
        setResizable(false);
        setVisible(true);
    }

    public void draw(double x1, double y1, double x2, double y2) {
        System.out.println("Frame.paint");
        canvas.getGraphics().drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    }

}
