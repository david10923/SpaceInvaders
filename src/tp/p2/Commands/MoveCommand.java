package tp.p2.Commands;
import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;
public class MoveCommand extends Command {

	private static final String details = "move <left|right><1|2>:";
	private static final String shortcut = "M";
	private static final String name = "move";
	private static final String help = "Moves UCM-Ship to the indicated direction.";
	
	private String direccion;
	private int cells;
	
	public MoveCommand() {
		super(name, shortcut, details, help);

	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
			
		game.move(cells);
		game.update();

		return true;
		
	}

	@Override
	public Command parse(String[] commandWords)  throws CommandParseException{


			if (matchCommandName(commandWords[0])) {
				
				if (commandWords.length == 3) {
					
					
					direccion = commandWords[1];
					
					
					
					if (!(direccion.equals("l")|| direccion.equals("left") || direccion.equals("r")|| direccion.equals("right"))) {
						throw new CommandParseException(incorrectArgsMsg);
					}else {
						
						try  {
							
							cells = Integer.parseInt(commandWords[2]);	
							
							
							
							if (!(cells ==1 || cells ==2)) {
								throw new CommandParseException("1 or 2");
							}else {
								if (direccion.equals("l")|| direccion.equals("left")) {
									cells = -cells;
								}
							}
							return this;
						}catch(NumberFormatException e) {
							System.err.println("[MoveCommand] cells parseInt FAIL");
						}
		
					}

				}else {
					if(commandWords.length >3 || commandWords.length <3 ) {
						throw new CommandParseException(incorrectNumArgsMsg);
					}
				}
			
		}
		
		
		
		
		
		return null;
	}

}
