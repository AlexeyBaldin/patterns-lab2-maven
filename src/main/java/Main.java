import geometry.Bezier;
import geometry.Line;
import geometry.Point;
import visual.IDrawable;
import visual.VisualBezier;
import visual.VisualLine;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) throws InterruptedException {
        Drawer drawer = new Drawer();

        Thread.sleep(10);

        IDrawable line = new VisualLine(new Line(
                new Point(100, 100),
                new Point(333, 333)
        ));
        line.draw(drawer);

        IDrawable bezier = new VisualBezier(new Bezier(
                new Point(50, 50),
                new Point(150, 150),
                new Point(100, 50),
                new Point(100, 150)
        ));

        bezier.draw(drawer);
    }
}
