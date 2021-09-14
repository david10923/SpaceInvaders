package tp.p2.Commands;

import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;

public class ShootLaserCommand extends Command {
	private static final String details = "ShootLaser:";
	private static final String supermissile = "supermissile";
	private static final String shortcut = "S";
	private static final String shortcutSP = "SM";
	private static final String name = "shoot";
	private static final String help = "UCM-Ship launches a missile.";
	private boolean superMisile = false;
	
	public ShootLaserCommand() {
		super(name, shortcut, details, help);

	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if (superMisile) {
			superMisile = false;
			game.shootSuperLaser();
			
		}else {
			game.shootLaser();
		}
		
		
		
		
		game.update();
		
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException  {
		
		
		if (matchCommandName(commandWords[0])) {
			
			if (commandWords.length ==1) {
				return this;
			}
			
			if (commandWords.length ==2) {
				
				if (commandWords[1].equalsIgnoreCase(shortcutSP)|
						commandWords[1].equalsIgnoreCase(supermissile)) {
						superMisile = true;
						return this;
				}else {
					throw new CommandParseException(incorrectNumArgsMsg);
					
				}
				
			}
			return this;
		}

		return null;
		
	}
}
