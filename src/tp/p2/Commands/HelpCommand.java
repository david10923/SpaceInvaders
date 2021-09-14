package tp.p2.Commands;
import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;
public class HelpCommand extends Command {

	private static final String details = "help:";
	private static final String shortcut = "H";
	private static final String name = "help";
	private static final String help = "Prints this help message.";
	
	public HelpCommand() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		System.out.println(game.helpCommand());
		return true;
	}

	@Override
	public Command parse(String[] commandWords)  throws CommandParseException {
		if (matchCommandName(commandWords[0])) {
			return this;
		}
		return null;
	}

}
