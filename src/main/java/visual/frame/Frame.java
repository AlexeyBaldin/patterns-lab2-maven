package visual.frame;

import geometry.Bezier;
import geometry.Line;
import geometry.Point;
import visual.drawable.VisualBezier;
import visual.drawable.VisualLine;
import visual.scheme.canvas.BlackCanvas;
import visual.scheme.canvas.GreenCanvas;
import visual.scheme.SchemeComposite;
import visual.scheme.svg.BlackSVG;
import visual.scheme.svg.GreenSVG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.atomic.AtomicInteger;

public class Frame extends AFrame {

    public Frame() {
        super();

        GreenCanvas greenCanvas = new GreenCanvas(this.drawableComposite);
        BlackCanvas blackCanvas = new BlackCanvas(this.drawableComposite);
        GreenSVG greenSVG = new GreenSVG();
        BlackSVG blackSVG = new BlackSVG();

        this.schemeComposite = new SchemeComposite(greenCanvas, blackCanvas, greenSVG, blackSVG);

        JButton generateButton = new JButton("Generate curve");

        JButton swgOneButton = new JButton("Save Scheme 1 in SVG");
        swgOneButton.setEnabled(false);

        JButton swgTwoButton = new JButton("Save Scheme 2 in SVG");
        swgTwoButton.setEnabled(false);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                blackCanvas.setSize(getWidth() / 2, getHeight() / 2);
                greenCanvas.setSize(getWidth() / 2, getHeight() / 2);
            }
        });


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

                    VisualLine visualLine = new VisualLine(new Line(new Point(x1, y1), new Point(x2, y2)));
                    this.drawableComposite.add(visualLine);
                    this.drawableComposite.draw(this.schemeComposite);


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

                    VisualBezier visualBezier = new VisualBezier(new Bezier(new Point(x1b, y1b), new Point(x2b, y2b), new Point(x3b, y3b), new Point(x4b, y4b) ));
                    this.drawableComposite.add(visualBezier);
                    this.drawableComposite.draw(this.schemeComposite);

                    swgOneButton.setEnabled(true);
                    swgTwoButton.setEnabled(true);

                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        });


        addComponentToFrame(generateButton, GridBagConstraints.HORIZONTAL, 0, 0, 0.2, 0.2, 2);

        addComponentToFrame(new JLabel("Scheme 1", SwingConstants.CENTER), GridBagConstraints.HORIZONTAL, 0, 1, 0.1, 0.1, 1);

        addComponentToFrame(new JLabel("Scheme 2", SwingConstants.CENTER), GridBagConstraints.HORIZONTAL, 1, 1, 0.1, 0.1, 1);

        addCanvasToFrame(greenCanvas,2, GridBagConstraints.HORIZONTAL, 0, 2, 0.8, 0.8, 1);

        addCanvasToFrame(blackCanvas,2, GridBagConstraints.HORIZONTAL, 1, 2, 0.8, 0.8, 1);


        swgOneButton.addActionListener(e -> {
            greenSVG.flush("scheme1");
            System.out.println("SVG save is done in file: scheme1.svg");
        });
        addComponentToFrame(swgOneButton, GridBagConstraints.HORIZONTAL, 0, 3, 0.2, 0.2, 1);


        swgTwoButton.addActionListener(e -> {
            blackSVG.flush("scheme2");
            System.out.println("SVG save is done in file: scheme2.svg");
        });
        addComponentToFrame(swgTwoButton, GridBagConstraints.HORIZONTAL, 1, 3, 0.2, 0.2, 1);

        setVisible(true);
    }


}
