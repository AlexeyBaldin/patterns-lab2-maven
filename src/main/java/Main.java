import client.Service;
import client.UserInterface;
import geometry.Bezier;
import geometry.Line;
import geometry.Point;
import visual.Drawer;
import visual.IDrawable;
import visual.VisualBezier;
import visual.VisualLine;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Main extends JFrame {

    public static void main(String[] args) {
        Service service = new Service();
        UserInterface userInterface = new UserInterface(service);
        userInterface.run();
    }
}
