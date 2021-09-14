package tp.p2.Commands;
import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;
public class ShockWaveCommand extends Command {

	private static final String details = "shockWave:";
	private static final String shortcut = "w";
	private static final String name = "shockwave";
	private static final String help = "UCM-Ship releases a shock wave.";
	
	public ShockWaveCommand() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.shockWave();
		game.update();
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
