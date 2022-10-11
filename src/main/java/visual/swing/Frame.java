package visual.swing;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class Frame extends JFrame {

    private final Canvas canvas;


    static class CanvasLine {
        int x1;
        int y1;
        int x2;
        int y2;

        public CanvasLine(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private ArrayList<CanvasLine> lines;

    public Frame() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lines = new ArrayList<>();
        this.canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for (CanvasLine line : lines) {
                    getGraphics().drawLine(line.x1, line.y1, line.x2, line.y2);
                }
            }
        };
        add(this.canvas);
        setResizable(true);
        setVisible(true);

    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        canvas.getGraphics().drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        lines.add(new CanvasLine((int)x1, (int)y1, (int)x2, (int)y2));
    }

    public void clear() {
        canvas.getGraphics().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        lines.clear();
    }

}
