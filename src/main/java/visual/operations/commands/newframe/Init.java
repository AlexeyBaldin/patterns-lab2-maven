package visual.operations.commands.newframe;

import geometry.Circle;
import visual.drawable.VisualCircle;
import visual.drawable.innerIterator.DrawableComposite;
import visual.observer.ISubject;
import visual.operations.ACommand;
import visual.operations.ICommand;
import visual.scheme.canvas.SimpleCanvas;

import java.awt.*;

public class Init extends NewFrameCommand {

    private ISubject subject;
    public Init(SimpleCanvas canvas, DrawableComposite drawableComposite, ISubject subject) {
        super(canvas, drawableComposite);

    }

    @Override
    protected void doExecute() {
        this.canvas.clear();

        VisualCircle circle = new VisualCircle(new Circle(400, 200, 50), Color.WHITE);
        VisualCircle circle2 = new VisualCircle(new Circle(200, 600, 75), Color.WHITE);
        VisualCircle circle3 = new VisualCircle(new Circle(600, 600, 100), Color.WHITE);

        this.drawableComposite.add(circle, circle2, circle3);

        this.drawableComposite.draw(this.canvas);
    }

    @Override
    public ICommand clone() {
        return new Init(this.canvas, this.drawableComposite, this.subject);
    }
}
