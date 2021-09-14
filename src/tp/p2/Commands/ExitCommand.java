package tp.p2.Commands;

import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;

public class ExitCommand extends Command {
	private static final String details = "exit:";
	private static final String shortcut = "E";
	private static final String name = "exit";
	private static final String help = "Terminates the program.";
	
	public ExitCommand() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.exit();
		return true;
	}

	@Override
	public Command parse(String[] commandWords)  throws CommandParseException  {
		if (matchCommandName(commandWords[0])) {
			return this;
		}
		
		return null;
	}
	
}
