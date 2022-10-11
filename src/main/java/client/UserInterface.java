package client;

import geometry.Bezier;
import geometry.Line;
import geometry.Parabola;
import geometry.Point;
import visual.VisualBezier;
import visual.VisualLine;
import visual.VisualParabola;

import java.util.Scanner;

public class UserInterface {

    private Service service;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface(Service service) {
        this.service = service;
    }

    public void run() {
        boolean isRunning = true;
        System.out.println("Line|Bezier|Clear|Stop");
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
                    service.draw(new VisualLine(new Line(
                            new Point(x1, y1),
                            new Point(x2, y2)
                    )));
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

                    service.draw(new VisualBezier(new Bezier(
                            new Point(x1b, y1b),
                            new Point(x2b, y2b),
                            new Point(x3b, y3b),
                            new Point(x4b, y4b)
                    )));

                    break;
                case "clear":
                    service.clear();
                    break;
                default:
                    isRunning = false;
                    break;
            }
        }
    }
}
