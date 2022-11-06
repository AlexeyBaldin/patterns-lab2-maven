import geometry.Bezier;
import geometry.Line;
import geometry.Point;
import visual.VisualBezier;
import visual.VisualLine;
import visual.swing.Frame;

import java.util.Scanner;

public class UserInterface {

    private final Frame frame;
    private final Scanner scanner = new Scanner(System.in);

    public UserInterface(Frame frame) {
        this.frame = frame;
    }

    public void run() {
        boolean isRunning = true;
        System.out.println("Line|Bezier|Clear");
        while (isRunning) {

            System.out.print("Action: ");
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
                    )).draw(this.frame);
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
                    )).draw(this.frame);

                    break;
                case "clear":

                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }
    }
}
