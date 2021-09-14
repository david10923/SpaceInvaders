package tp.p2.Commands;
import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;
public class UpdateCommand extends Command {

	private static final String details = "[none]: ";
	private static final String shortcut = "";
	private static final String name = "none";
	private static final String help = "Skips one cycle.";
	
	public UpdateCommand() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		game.update();
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
