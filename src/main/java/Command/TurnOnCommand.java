package Command;

public class TurnOnCommand implements ICommand{

    private final TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}