package visual.operations;

import java.util.ArrayList;

public abstract class ACommand implements ICommand, Cloneable{

    @Override
    public final void execute() {
        try {
            CommandManager.getInstance().registry((ICommand) this.clone());
            doExecute();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    //protected ArrayList<ICommand> commands = CommandManager.getInstance().commands;
    protected abstract void doExecute();

}
