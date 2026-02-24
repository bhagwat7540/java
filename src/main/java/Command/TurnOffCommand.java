package Command;

public class TurnOffCommand implements ICommand{

    private final TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.turnOff();
    }
}
