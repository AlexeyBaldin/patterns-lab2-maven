package visual.operations.commands.frame;

import visual.operations.ACommand;
import visual.operations.ICommand;
import visual.scheme.SchemeComposite;

public class Init extends ACommand {

    private final SchemeComposite schemeComposite;

    public Init(SchemeComposite schemeComposite) {
        this.schemeComposite = schemeComposite;
    }

    @Override
    protected void doExecute() {
        this.schemeComposite.clear();
    }

    @Override
    public ICommand clone() {
        return new Init(this.schemeComposite);
    }

}
