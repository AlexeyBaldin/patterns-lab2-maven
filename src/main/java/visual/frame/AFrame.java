package visual.frame;

import visual.drawable.innerIterator.DrawableComposite;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public abstract class AFrame extends JFrame {

    protected final Scanner scanner = new Scanner(System.in);
    protected final DrawableComposite drawableComposite = new DrawableComposite();

    protected AFrame() {
        setSize(800, 800);
        this.setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected void addComponentToFrame(Component component, int fill, int gridx, int gridy, double weightx, double weighty, int gridwidth) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = fill;
        c.gridx = gridx;
        c.gridy = gridy;
        c.weightx = weightx;
        c.weighty = weighty;
        c.gridwidth = gridwidth;
        this.add(component, c);
    }

    protected void addCanvasToFrame(Canvas canvas, double canvasCoeff, int fill, int gridx, int gridy, double weightx, double weighty, int gridwidth) {
        canvas.setSize((int)(this.getWidth() / canvasCoeff), (int)(this.getHeight() / canvasCoeff));
        this.addComponentToFrame(canvas, fill, gridx, gridy, weightx, weighty, gridwidth);
    }
}
