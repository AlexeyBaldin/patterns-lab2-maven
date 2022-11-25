package visual;

import geometry.*;
import geometry.Line;
import geometry.Point;
import visual.drawable.*;
import visual.drawable.innerIterator.DrawableComposite;
import visual.operations.ACommand;
import visual.operations.CommandManager;
import visual.operations.commands.AddBezier;
import visual.operations.commands.AddLine;
import visual.operations.commands.Init;
import visual.scheme.canvas.BlackCanvas;
import visual.scheme.canvas.GreenCanvas;
import visual.scheme.IScheme;
import visual.scheme.SchemeComposite;
import visual.scheme.svg.BlackSVG;
import visual.scheme.svg.GreenSVG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Frame extends JFrame {

    private final SchemeComposite schemeComposite;
    private final DrawableComposite drawableComposite = new DrawableComposite();
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

        GreenCanvas greenCanvas = new GreenCanvas(this.drawableComposite);
        BlackCanvas blackCanvas = new BlackCanvas(this.drawableComposite);
        GreenSVG greenSVG = new GreenSVG();
        BlackSVG blackSVG = new BlackSVG();

        this.schemeComposite = new SchemeComposite(greenCanvas, blackCanvas, greenSVG, blackSVG);

        new Init(this.schemeComposite).execute();

        setSize(800, 800);
        this.setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton generateButton = new JButton("Generate curve");
        JButton undoButton = new JButton("Undo");

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

                    new AddLine(schemeComposite, drawableComposite, x1, y1, x2, y2).execute();

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

                    new AddBezier(schemeComposite, drawableComposite, x1b, y1b, x2b, y2b, x3b, y3b, x4b, y4b).execute();

                    swgOneButton.setEnabled(true);
                    swgTwoButton.setEnabled(true);

                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        });

        undoButton.addActionListener(e -> {
            CommandManager.getInstance().undo();
            blackCanvas.repaint();
            greenCanvas.repaint();

            AtomicInteger counter = new AtomicInteger();
            drawableComposite.iterate((i) -> counter.getAndIncrement());
            if(counter.get() == 0) {
                swgOneButton.setEnabled(false);
                swgTwoButton.setEnabled(false);
            }
        });

        addComponentToFrame(generateButton, GridBagConstraints.HORIZONTAL, 0, 0, 0.2, 0.2, 1, false);
        addComponentToFrame(undoButton, GridBagConstraints.HORIZONTAL, 1, 0, 0.2, 0.2, 1, false);

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
