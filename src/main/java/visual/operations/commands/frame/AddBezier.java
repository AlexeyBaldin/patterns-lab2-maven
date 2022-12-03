package visual.operations.commands.frame;

import geometry.Bezier;
import geometry.Point;
import visual.drawable.VisualBezier;
import visual.drawable.innerIterator.DrawableComposite;
import visual.operations.ICommand;
import visual.scheme.SchemeComposite;

public class AddBezier extends FrameCommand {

    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final int x3;
    private final int y3;
    private final int x4;
    private final int y4;

    public AddBezier(SchemeComposite schemeComposite, DrawableComposite drawableComposite, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        super(schemeComposite, drawableComposite);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }

    @Override
    protected void doExecute() {
        VisualBezier visualBezier = new VisualBezier(
                new Bezier(
                        new Point(x1, y1),
                        new Point(x2, y2),
                        new Point(x3, y3),
                        new Point(x4, y4)
                )
        );
        visualBezier.draw(this.schemeComposite);
        this.drawableComposite.add(visualBezier);
    }

    @Override
    public ICommand clone() {
        return new AddBezier(schemeComposite, drawableComposite, x1, y1, x2, y2, x3, y3, x4, y4);
    }
}
