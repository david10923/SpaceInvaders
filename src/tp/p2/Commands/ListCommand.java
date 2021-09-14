package tp.p2.Commands;
import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;
public class ListCommand extends Command {

	
	private static final String details = "list:";
	private static final String shortcut = "L";
	private static final String name = "list";
	private static final String help = "Prints the list of available ships.";
	
	public ListCommand() {
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		System.out.println(game.listCommand());
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException  {
		if (matchCommandName(commandWords[0])) {
			return this;
		}
		return null;
	}

}
