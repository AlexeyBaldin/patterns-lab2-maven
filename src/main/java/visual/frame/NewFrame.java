package visual.frame;

import geometry.Circle;
import geometry.IPointBase;
import visual.drawable.VisualCircle;
import visual.observer.IObserver;
import visual.observer.ISubject;
import visual.operations.CommandManager;
import visual.operations.commands.Init;
import visual.operations.commands.MoveCircle;
import visual.scheme.SchemeComposite;
import visual.scheme.canvas.SimpleCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class NewFrame extends AFrame {

    private final SimpleCanvas canvas = new SimpleCanvas(drawableComposite);

    public NewFrame() {
        super();

        JButton undoButton = new JButton("Undo");

        undoButton.addActionListener(e -> CommandManager.getInstance().undo());

        addComponentToFrame(undoButton, GridBagConstraints.HORIZONTAL, 0, 0, 0.1, 0.1, 1);

        class Subject implements MouseMotionListener, MouseListener, ISubject {

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

            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {
                if(activeCircle != null) {
                    new MoveCircle(schemeComposite, drawableComposite, activeCircle, e.getX(), e.getY()).execute();
                }
                activeCircle = null;
                isPressed = false;
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }

        VisualCircle circle = new VisualCircle(new Circle(400, 200, 50), Color.WHITE);
        VisualCircle circle2 = new VisualCircle(new Circle(200, 600, 75), Color.WHITE);
        VisualCircle circle3 = new VisualCircle(new Circle(600, 600, 100), Color.WHITE);

        Subject subject = new Subject();
        subject.attach(circle);
        subject.attach(circle2);
        subject.attach(circle3);
        this.canvas.addMouseMotionListener(subject);
        this.canvas.addMouseListener(subject);

        addCanvasToFrame(this.canvas,1, GridBagConstraints.HORIZONTAL, 0, 1, 0.9, 0.9, 1);

        this.schemeComposite = new SchemeComposite(this.canvas);

        setVisible(true);

        new Init(this.schemeComposite, this.drawableComposite, circle, circle2, circle3).execute();
    }
}
