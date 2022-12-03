package visual.frame;

import geometry.Circle;
import geometry.IPointBase;
import visual.drawable.VisualCircle;
import visual.observer.IObserver;
import visual.observer.ISubject;
import visual.operations.CommandManager;
import visual.scheme.canvas.SimpleCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class NewFrame extends AFrame {

    private final SimpleCanvas canvas = new SimpleCanvas(drawableComposite);

    public NewFrame() {
        super();


        JButton undoButton = new JButton("Undo");

        undoButton.addActionListener(e -> {

        });

        addComponentToFrame(undoButton, GridBagConstraints.HORIZONTAL, 0, 0, 0.1, 0.1, 1);


        class Subject implements MouseMotionListener, ISubject {

            private final ArrayList<IObserver> observers = new ArrayList<>();

            private boolean isActive = false;

            private boolean isPressed = false;
            private VisualCircle activeCircle = null;

            @Override
            public void attach(IObserver observer) {
                observers.add(observer);
            }



            @Override
            public void mouseDragged(MouseEvent e) {
                if(!isPressed) {
                    isPressed = true;

                    VisualCircle circle = null;
                    for (IObserver observer :
                            observers) {
                        if(((VisualCircle) observer).isActive()) {
                            circle = (VisualCircle) observer;
                            break;
                        }
                    }
                    if(circle != null) {
                        activeCircle = circle;
                    }
                } else {
                    if(activeCircle != null) {
                        activeCircle.erase(canvas);
                        activeCircle.move(e.getX(), e.getY());
                        drawableComposite.draw(canvas);
                        activeCircle.draw(canvas);
                    }
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                isPressed = false;
                activeCircle = null;
                for (IObserver observer :
                        observers) {
                    VisualCircle visualCircle = (VisualCircle) observer;
                    boolean update = visualCircle.check(e.getX(), e.getY());
                    if(update && !visualCircle.isActive() && !isActive) {
                        isActive = true;
                        visualCircle.update();
                        visualCircle.draw(canvas);
                    } else if(!update && visualCircle.isActive() && isActive) {
                        isActive = false;
                        visualCircle.update();
                        visualCircle.draw(canvas);
                    }
                }
            }
        }
        VisualCircle circle = new VisualCircle(new Circle(400, 200, 50), Color.WHITE);
        VisualCircle circle2 = new VisualCircle(new Circle(200, 600, 75), Color.WHITE);
        VisualCircle circle3 = new VisualCircle(new Circle(600, 600, 100), Color.WHITE);
        this.drawableComposite.add(circle, circle2, circle3);
        Subject subject = new Subject();
        subject.attach(circle);
        subject.attach(circle2);
        subject.attach(circle3);
        this.canvas.addMouseMotionListener(subject);

        addCanvasToFrame(this.canvas,1, GridBagConstraints.HORIZONTAL, 0, 1, 0.9, 0.9, 1);

        setVisible(true);
    }
}
