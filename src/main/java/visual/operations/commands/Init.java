package visual.operations.commands;

import javafx.util.Pair;
import visual.drawable.VisualCircle;
import visual.drawable.innerIterator.DrawableComposite;
import visual.scheme.SchemeComposite;
import visual.scheme.canvas.SimpleCanvas;

import java.util.ArrayList;
import java.util.Arrays;

public class Init extends NewFrameCommand {

    private final ArrayList<VisualCircle> circles = new ArrayList<>();
    private final ArrayList<Double> listX = new ArrayList<>();
    private final ArrayList<Double> listY = new ArrayList<>();
    public Init(SchemeComposite schemeComposite, DrawableComposite drawableComposite, VisualCircle ...circles) {
        super(schemeComposite, drawableComposite);
        for (VisualCircle circle : circles) {
            this.circles.add(circle);
            listX.add(circle.getX());
            listY.add(circle.getY());
        }
    }

    @Override
    protected void doExecute() {
        this.schemeComposite.clear();
        this.drawableComposite.clear();
        for (int i = 0; i < this.circles.size(); i++) {
            this.drawableComposite.add(this.circles.get(i));
            this.circles.get(i).move(this.listX.get(i), this.listY.get(i));
        }

        this.drawableComposite.draw(this.schemeComposite);
    }

    @Override
    public Init clone() {
        try {
            return (Init) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
