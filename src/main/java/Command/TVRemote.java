package Command;

//INVOKER
public class TVRemote {
    private ICommand command;

    void setCommand(ICommand command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}
