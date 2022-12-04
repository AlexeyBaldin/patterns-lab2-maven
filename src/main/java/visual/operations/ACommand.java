package visual.operations;

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

    protected abstract void doExecute();

}
