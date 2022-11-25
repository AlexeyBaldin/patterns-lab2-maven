package visual.operations.commands;

import visual.operations.ACommand;
import visual.operations.ICommand;
import visual.scheme.IScheme;
import visual.scheme.SchemeComposite;

import java.util.ArrayList;
import java.util.Arrays;

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
