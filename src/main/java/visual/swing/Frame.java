package visual.swing;

import geometry.*;
import geometry.Line;
import geometry.Point;
import visual.IScheme;
import visual.VisualBezier;
import visual.VisualLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Frame extends JFrame {

    private final IScheme schemeComposite;
    private final Scanner scanner = new Scanner(System.in);

    private void addComponentToFrame(Component component, int fill, int gridx, int gridy, double weightx, double weighty, int gridwidth, boolean isCanvas) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = fill;
        c.gridx = gridx;
        c.gridy = gridy;
        c.weightx = weightx;
        c.weighty = weighty;
        c.gridwidth = gridwidth;
        if (isCanvas) {
            component.setSize(this.getWidth() / 2, this.getHeight() / 2);
        }
        this.add(component, c);
    }

    public Frame() {

        IScheme greenCanvas = new GreenCanvas();
        IScheme blackCanvas = new BlackCanvas();

        this.schemeComposite = new SchemeComposite(greenCanvas, blackCanvas);

        setSize(800, 800);
        this.setLayout(new GridBagLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton generateButton = new JButton("Generate curve");
        generateButton.addActionListener(e -> {
            System.out.print("Action(Line|Bezier|Clear): ");
            String input = scanner.next();
            switch (input.toLowerCase()) {
                case "line":
                    System.out.print("Line coordinates: ");
                    int x1 = scanner.nextInt();
                    int y1 = scanner.nextInt();
                    int x2 = scanner.nextInt();
                    int y2 = scanner.nextInt();
                    new VisualLine(new Line(
                            new Point(x1, y1),
                            new Point(x2, y2)
                    )).draw(schemeComposite);
                    break;
                case "bezier":
                    System.out.print("Bezier coordinates: ");
                    int x1b = scanner.nextInt();
                    int y1b = scanner.nextInt();
                    int x2b = scanner.nextInt();
                    int y2b = scanner.nextInt();
                    int x3b = scanner.nextInt();
                    int y3b = scanner.nextInt();
                    int x4b = scanner.nextInt();
                    int y4b = scanner.nextInt();

                    new VisualBezier(new Bezier(
                            new Point(x1b, y1b),
                            new Point(x2b, y2b),
                            new Point(x3b, y3b),
                            new Point(x4b, y4b)
                    )).draw(schemeComposite);

                    break;
                case "clear":

                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        });
        addComponentToFrame(generateButton, GridBagConstraints.HORIZONTAL, 0, 0, 0.2, 0.2, 2, false);

        addComponentToFrame(new JLabel("Scheme 1", SwingConstants.CENTER), GridBagConstraints.HORIZONTAL, 0, 1, 0.1, 0.1, 1, false);

        addComponentToFrame(new JLabel("Scheme 2", SwingConstants.CENTER), GridBagConstraints.HORIZONTAL, 1, 1, 0.1, 0.1, 1, false);

        addComponentToFrame((Canvas) greenCanvas, GridBagConstraints.HORIZONTAL, 0, 2, 0.8, 0.8, 1, true);

        addComponentToFrame((Canvas) blackCanvas, GridBagConstraints.HORIZONTAL, 1, 2, 0.8, 0.8, 1, true);

        JButton swgOneButton = new JButton("Save Scheme 1 in SVG");
        swgOneButton.addActionListener(e -> {
            System.out.println("swg1");
            System.out.println("swg1");
        });
        addComponentToFrame(swgOneButton, GridBagConstraints.HORIZONTAL, 0, 3, 0.2, 0.2, 1, false);

        JButton swgTwoButton = new JButton("Save Scheme 2 in SVG");
        swgOneButton.addActionListener(e -> {
            System.out.println("swg2");
            System.out.println("swg2");
        });
        addComponentToFrame(swgTwoButton, GridBagConstraints.HORIZONTAL, 1, 3, 0.2, 0.2, 1, false);

        setVisible(true);
    }


}
