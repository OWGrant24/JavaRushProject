package JavaRush_Projects.Zip.command;


import JavaRush_Projects.Zip.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
