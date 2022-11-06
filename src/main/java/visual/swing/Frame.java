package visual.swing;

import geometry.IPoint;
import visual.IScheme;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Frame extends JFrame implements IScheme {

    private final ArrayList<IScheme> schemes = new ArrayList<>();

    private void addComponentToFrame(Component component, int fill, int gridx, int gridy, double weightx, double weighty, int gridwidth, boolean isCanvas) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = fill;
        c.gridx = gridx;
        c.gridy = gridy;
        c.weightx = weightx;
        c.weighty = weighty;
        c.gridwidth = gridwidth;
        if(isCanvas) {
            component.setSize(this.getWidth()/2, this.getHeight()/2);
        }
        this.add(component, c);
    }

    public Frame(IScheme ...schemes) {
        this.schemes.addAll(Arrays.asList(schemes));
        setSize(800, 800);
        this.setLayout(new GridBagLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        addComponentToFrame(new JButton("Generate curve"), GridBagConstraints.HORIZONTAL, 0, 0,0.2, 0.2, 2, false);
        addComponentToFrame(new JLabel("Scheme 1", SwingConstants.CENTER), GridBagConstraints.HORIZONTAL, 0, 1, 0.1, 0.1, 1, false);
        addComponentToFrame(new JLabel("Scheme 2", SwingConstants.CENTER), GridBagConstraints.HORIZONTAL, 1, 1, 0.1, 0.1, 1, false);
        int canvasIndex = 0;
        for (int i = 0; i < schemes.length; i++) {
            if(this.schemes.get(i) instanceof Canvas) {
                addComponentToFrame((Canvas) this.schemes.get(i), GridBagConstraints.HORIZONTAL, canvasIndex, 2, 0.8, 0.8, 1, true);
                canvasIndex++;
            }
        }
        addComponentToFrame(new JButton("Save Scheme 1 in SVG"), GridBagConstraints.HORIZONTAL, 0, 3, 0.2, 0.2, 1, false);
        addComponentToFrame(new JButton("Save Scheme 2 in SVG"), GridBagConstraints.HORIZONTAL, 1, 3, 0.2, 0.2, 1, false);

        setVisible(true);
    }

    @Override
    public void drawStartPoint(IPoint point) {
        schemes.forEach(scheme -> scheme.drawStartPoint(point));
    }

    @Override
    public void drawLine(IPoint point, IPoint point1) {
        schemes.forEach(scheme -> scheme.drawLine(point, point1));
    }

    @Override
    public void drawEndPoint(IPoint point) {
        schemes.forEach(scheme -> scheme.drawEndPoint(point));
    }
}
