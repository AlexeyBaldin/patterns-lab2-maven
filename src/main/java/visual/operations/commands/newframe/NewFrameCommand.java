package visual.operations.commands.newframe;

import visual.drawable.innerIterator.DrawableComposite;
import visual.operations.ACommand;
import visual.scheme.canvas.SimpleCanvas;

public abstract class NewFrameCommand extends ACommand {
    protected final SimpleCanvas canvas;
    protected final DrawableComposite drawableComposite;

    public NewFrameCommand(SimpleCanvas canvas, DrawableComposite drawableComposite) {
        this.canvas = canvas;
        this.drawableComposite = drawableComposite;
    }
}
