package visual.swing;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Frame extends JFrame {

    private final Canvas canvas;
    private final int size;

    public Frame(int size) {
        this.size = size;
        setSize(this.size, this.size);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.canvas = new Canvas();
        add(this.canvas);
        setResizable(false);
        setVisible(true);

    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        canvas.getGraphics().drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    }

    public void clear() {
        canvas.getGraphics().clearRect(0, 0, this.size, this.size);
    }

}
