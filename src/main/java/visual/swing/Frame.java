package visual.swing;

import visual.swing.bridge.BridgeCanvas;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private BridgeCanvas canvas1;
    private BridgeCanvas canvas2;

    private void addComponentToFrame(Component component, int fill, int gridx, int gridy, double weightx, double weighty, int gridwidth) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = fill;
        c.gridx = gridx;
        c.gridy = gridy;
        c.weightx = weightx;
        c.weighty = weighty;
        c.gridwidth = gridwidth;
        this.add(component, c);
    }

    private void addComponentToFrame(BridgeCanvas canvas, int canvasIndex, int fill, int gridx, int gridy, double weightx, double weighty, int gridwidth) {
        canvas.setSize(this.getWidth()/2, this.getHeight()/2);
        if(canvasIndex == 0) {
            this.canvas1 = canvas;
        } else {
            this.canvas2 = canvas;
        }
        addComponentToFrame((Component) canvas, fill, gridx, gridy, weightx, weighty, gridwidth);
    }

    public Frame(BridgeCanvas canvas1, BridgeCanvas canvas2) {
        setSize(800, 800);
        this.setLayout(new GridBagLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentToFrame(new JButton("Generate curve"), GridBagConstraints.HORIZONTAL, 0, 0,0.2, 0.2, 2);
        addComponentToFrame(new JLabel("Scheme 1", SwingConstants.CENTER), GridBagConstraints.HORIZONTAL, 0, 1, 0.1, 0.1, 1);
        addComponentToFrame(new JLabel("Scheme 2", SwingConstants.CENTER), GridBagConstraints.HORIZONTAL, 1, 1, 0.1, 0.1, 1);
        addComponentToFrame(canvas1,0, GridBagConstraints.HORIZONTAL, 0, 2, 0.8, 0.8, 1);
        addComponentToFrame(canvas2,1, GridBagConstraints.HORIZONTAL, 1, 2, 0.8, 0.8, 1);
        addComponentToFrame(new JButton("Save Scheme 1 in SVG"), GridBagConstraints.HORIZONTAL, 0, 3, 0.2, 0.2, 1);
        addComponentToFrame(new JButton("Save Scheme 2 in SVG"), GridBagConstraints.HORIZONTAL, 1, 3, 0.2, 0.2, 1);

        setVisible(true);
    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        canvas1.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        canvas2.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    }

    public void clear() {
        canvas1.clear();
        canvas2.clear();
    }

}
