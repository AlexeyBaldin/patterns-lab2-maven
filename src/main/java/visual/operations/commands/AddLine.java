package visual.operations.commands;

import geometry.Line;
import geometry.Point;
import visual.drawable.VisualLine;
import visual.drawable.innerIterator.DrawableComposite;
import visual.operations.ICommand;
import visual.scheme.SchemeComposite;

public class AddLine extends FrameCommand {

    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public AddLine(SchemeComposite schemeComposite, DrawableComposite drawableComposite, int x1, int y1, int x2, int y2) {
        super(schemeComposite, drawableComposite);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void doExecute() {
        VisualLine visualLine = new VisualLine(
                new Line(
                        new Point(x1, y1),
                        new Point(x2, y2)
                )
        );
        visualLine.draw(schemeComposite);
        drawableComposite.add(visualLine);
    }

    @Override
    public AddLine clone() {
        return new AddLine(schemeComposite, drawableComposite, x1, y1, x2, y2);
    }
}
