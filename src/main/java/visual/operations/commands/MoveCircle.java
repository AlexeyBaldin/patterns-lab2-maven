package visual.operations.commands;

import visual.drawable.VisualCircle;
import visual.drawable.DrawableComposite;
import visual.scheme.SchemeComposite;

public class MoveCircle extends NewFrameCommand {

    private final VisualCircle visualCircle;
    private final int newX;
    private final int newY;

    public MoveCircle(SchemeComposite schemeComposite, DrawableComposite drawableComposite, VisualCircle visualCircle, int newX, int newY) {
        super(schemeComposite, drawableComposite);
        this.visualCircle = visualCircle;
        this.newX = newX;
        this.newY = newY;
    }

    @Override
    protected void doExecute() {
        this.visualCircle.move(newX, newY);
        this.schemeComposite.clear();
        this.drawableComposite.draw(this.schemeComposite);
    }

    @Override
    public MoveCircle clone() {
        try {
            return (MoveCircle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
