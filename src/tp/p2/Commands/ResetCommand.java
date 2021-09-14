package tp.p2.Commands;
import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;
public class ResetCommand extends Command {

	
	private static final String details = "reset:";
	private static final String shortcut = "R";
	private static final String name = "reset";
	private static final String help = "Starts a new game.";
	
	public ResetCommand() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		game.reset();
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
