package visual.operations.commands;

import visual.drawable.innerIterator.DrawableComposite;
import visual.operations.ACommand;
import visual.scheme.SchemeComposite;

public abstract class FrameCommand extends ACommand {
    protected final SchemeComposite schemeComposite;
    protected final DrawableComposite drawableComposite;

    protected FrameCommand(SchemeComposite schemeComposite, DrawableComposite drawableComposite) {
        this.schemeComposite = schemeComposite;
        this.drawableComposite = drawableComposite;
    }
}
