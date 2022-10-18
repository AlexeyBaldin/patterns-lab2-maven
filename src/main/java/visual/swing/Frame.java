package visual.swing;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class Frame extends JFrame {

    private final Canvas canvas;
    private final Canvas canvas2;


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


    public Frame() {
        setSize(800, 800);
        this.setLayout(new GridBagLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        JButton button = new JButton("Generate curve");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.3;
        c.weighty = 0.3;
        c.gridwidth = 2;
        this.add(button, c);
        JLabel label = new JLabel("Scheme 1", SwingConstants.CENTER);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.2;
        c.weighty = 0.2;
        this.add(label, c);
        label = new JLabel("Scheme 2", SwingConstants.CENTER);
        c.gridx = 1;
        c.gridy = 1;
        this.add(label, c);

        this.canvas = new Canvas();
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.7;
        c.weighty = 0.7;
        this.canvas.setSize(this.getWidth()/2, this.getHeight()/2);
        add(this.canvas, c);
        this.canvas2 = new Canvas();
        c.gridx = 1;
        c.gridy = 2;
        this.canvas2.setSize(this.getWidth()/2, this.getHeight()/2);
        add(this.canvas2, c);
        button = new JButton("Save Scheme 1 in SVG");
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 3;
        this.add(button,c);
        button = new JButton("Save Scheme 2 in SVG");
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.gridx = 1;
        c.gridy = 3;
        this.add(button, c);



        setVisible(true);

    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        canvas.getGraphics().drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        canvas2.getGraphics().drawLine(0, 0, 300, 300);
    }

    public void clear() {
        canvas.getGraphics().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}
