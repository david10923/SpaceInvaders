package tp.p2.Commands;

import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;

public class BuyMissile extends Command {

	private static final String details = "BuyMissile";
	private static final String shortcut = "bm";
	private static final String name = "buy";
	private static final String help = "Buy a SuperMissile";
	
	public BuyMissile() {
		
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.buyMissile();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if (matchCommandName(commandWords[0])) {
			return this;
		}
		return null;
	}

}
