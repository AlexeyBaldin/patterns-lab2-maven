package visual.operations;

import java.util.ArrayList;

public class CommandManager {

    private CommandManager() {}

    private static CommandManager instance;

    public static CommandManager getInstance() {
        if(instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    private final ArrayList<ICommand> commands = new ArrayList<>();
    private boolean lock = false;

    public void registry(ICommand command) {
        if(!lock) {
            commands.add(command);
        }
    }

    public void undo() {
        if(commands.size() > 1) {
            lock = true;
            commands.remove(commands.size() - 1);
            commands.forEach(ICommand::execute);
            lock = false;
        }
    }
}
