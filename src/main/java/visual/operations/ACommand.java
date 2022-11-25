package visual.operations;

public abstract class ACommand implements ICommand{

    @Override
    public final void execute() {
        CommandManager.getInstance().registry(this.clone());
        doExecute();
    }

    protected abstract void doExecute();

    @Override
    public abstract ICommand clone();

}
