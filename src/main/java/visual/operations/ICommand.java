package visual.operations;

public interface ICommand {
    void execute();
    ICommand clone();
}
