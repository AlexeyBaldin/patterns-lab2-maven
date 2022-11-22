package visual.scheme.canvas;

import visual.drawable.DrawableCompositeOld;
import visual.drawable.innerIterator.DrawableComposite;
import visual.scheme.IScheme;

import java.awt.*;

public abstract class ACanvas extends Canvas implements IScheme {

    private final DrawableComposite drawableComposite;

    public ACanvas(DrawableComposite drawableComposite) {
        super();
        this.drawableComposite = drawableComposite;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.drawableComposite.draw(this);
    }
}
