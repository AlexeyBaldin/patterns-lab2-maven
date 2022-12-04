package visual.operations.commands;

import visual.drawable.innerIterator.DrawableComposite;
import visual.operations.ACommand;
import visual.scheme.SchemeComposite;
import visual.scheme.canvas.SimpleCanvas;

public abstract class NewFrameCommand extends ACommand {
    protected final SchemeComposite schemeComposite;
    protected final DrawableComposite drawableComposite;

    public NewFrameCommand(SchemeComposite schemeComposite, DrawableComposite drawableComposite) {
        this.schemeComposite = schemeComposite;
        this.drawableComposite = drawableComposite;
    }
}
