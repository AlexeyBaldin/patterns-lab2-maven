package visual.operations.commands;

import visual.drawable.DrawableComposite;
import visual.operations.ACommand;
import visual.scheme.SchemeComposite;

public abstract class NewFrameCommand extends ACommand {
    protected final SchemeComposite schemeComposite;
    protected final DrawableComposite drawableComposite;

    public NewFrameCommand(SchemeComposite schemeComposite, DrawableComposite drawableComposite) {
        this.schemeComposite = schemeComposite;
        this.drawableComposite = drawableComposite;
    }
}
