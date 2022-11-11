package visual;

import geometry.*;
import geometry.Line;
import geometry.Point;
import geometry.decorator.Fragment;
import geometry.decorator.MoveTo;
import visual.drawable.DrawableComposite;
import visual.drawable.VisualBezier;
import visual.drawable.VisualCurve;
import visual.drawable.VisualLine;
import visual.scheme.canvas.BlackCanvas;
import visual.scheme.canvas.GreenCanvas;
import visual.scheme.IScheme;
import visual.scheme.SchemeComposite;
import visual.scheme.svg.BlackSVG;
import visual.scheme.svg.GreenSVG;

import javax.swing.*;
import java.awt.*;
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

        GreenCanvas greenCanvas = new GreenCanvas();
        BlackCanvas blackCanvas = new BlackCanvas();
        GreenSVG greenSVG = new GreenSVG();
        BlackSVG blackSVG = new BlackSVG();

        this.schemeComposite = new SchemeComposite(greenCanvas, blackCanvas, greenSVG, blackSVG);

        setSize(800, 800);
        this.setLayout(new GridBagLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton generateButton = new JButton("Generate curve");

        JButton swgOneButton = new JButton("Save Scheme 1 in SVG");
        swgOneButton.setEnabled(false);

        JButton swgTwoButton = new JButton("Save Scheme 2 in SVG");
        swgTwoButton.setEnabled(false);

        generateButton.addActionListener(e -> {
            System.out.print("Action(Line|Bezier): ");
            String input = scanner.next();
            switch (input.toLowerCase()) {
                case "line":
                    System.out.print("Line coordinates: ");
                    int x1 = scanner.nextInt();
                    int y1 = scanner.nextInt();
                    int x2 = scanner.nextInt();
                    int y2 = scanner.nextInt();
//                    new VisualLine(new Line(
//                            new Point(x1, y1),
//                            new Point(x2, y2)
//                    )).draw(schemeComposite);

                    ICurve moveTo = new Fragment(new Line(
                            new Point(x1, y1),
                            new Point(x2, y2)
                    ), 1, 0);

                    new VisualLine(moveTo).draw(schemeComposite);

//                    new DrawableComposite(
//                            new VisualLine(new Line(
//                                    new Point(100, 100),
//                                    new Point(200, 200)
//                            )),
//                            new VisualLine(new Line(
//                                    new Point(100, 200),
//                                    new Point(200, 100)
//                            )
//                    )).draw(schemeComposite);


                    swgOneButton.setEnabled(true);
                    swgTwoButton.setEnabled(true);

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

//                    new DrawableComposite(
//                            new VisualBezier(new Bezier(
//                                    new Point(100, 100),
//                                    new Point(300, 300),
//                                    new Point(120, 150),
//                                    new Point(280, 250)
//                            )),
//                            new VisualBezier(new Bezier(
//                                    new Point(100, 300),
//                                    new Point(300, 100),
//                                    new Point(120, 250),
//                                    new Point(280, 150)
//                            )
//                            )).draw(schemeComposite);

                    swgOneButton.setEnabled(true);
                    swgTwoButton.setEnabled(true);

                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        });
        addComponentToFrame(generateButton, GridBagConstraints.HORIZONTAL, 0, 0, 0.2, 0.2, 2, false);

        addComponentToFrame(new JLabel("Scheme 1", SwingConstants.CENTER), GridBagConstraints.HORIZONTAL, 0, 1, 0.1, 0.1, 1, false);

        addComponentToFrame(new JLabel("Scheme 2", SwingConstants.CENTER), GridBagConstraints.HORIZONTAL, 1, 1, 0.1, 0.1, 1, false);

        addComponentToFrame(greenCanvas, GridBagConstraints.HORIZONTAL, 0, 2, 0.8, 0.8, 1, true);

        addComponentToFrame(blackCanvas, GridBagConstraints.HORIZONTAL, 1, 2, 0.8, 0.8, 1, true);


        swgOneButton.addActionListener(e -> {
            greenSVG.flush("scheme1");
            System.out.println("SVG save is done in file: scheme1.svg");
        });
        addComponentToFrame(swgOneButton, GridBagConstraints.HORIZONTAL, 0, 3, 0.2, 0.2, 1, false);


        swgTwoButton.addActionListener(e -> {
            blackSVG.flush("scheme2");
            System.out.println("SVG save is done in file: scheme2.svg");
        });
        addComponentToFrame(swgTwoButton, GridBagConstraints.HORIZONTAL, 1, 3, 0.2, 0.2, 1, false);

        setVisible(true);
    }


}
