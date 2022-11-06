import geometry.Bezier;
import geometry.Line;
import geometry.Point;
import visual.IDrawable;
import visual.IScheme;
import visual.VisualBezier;
import visual.VisualLine;
import visual.swing.BlackCanvas;
import visual.swing.Frame;
import visual.swing.GreenCanvas;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {

        IScheme greenCanvas = new GreenCanvas();
        IScheme blackCanvas = new BlackCanvas();

        Frame frame = new Frame(greenCanvas, blackCanvas);

        UserInterface ui = new UserInterface(frame);
        ui.run();
    }
}
