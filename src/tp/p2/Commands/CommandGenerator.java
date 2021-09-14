package tp.p2.Commands;

import tp.p2.Exceptions.CommandParseException;

public class CommandGenerator {
	
	private static Command[] avaliableCommands = {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new MoveCommand(),
			new ShootLaserCommand(),
			new ShockWaveCommand(),
			new SerializeCommand(),
			new SaveCommand(),
			new LoadCommand(),
			new BuyMissile(),
			new ListPrintersCommand()
	};
	
	
	public static Command commandParse(String[] words) throws CommandParseException {
		Command command;
		
		if 	(words.length == 0) {
			return null;
		}else {
			for (Command c : avaliableCommands) {
				command = c.parse(words);
				
				if (command !=null) {
					return command;
				}
				
			}
			return null;
		}
		
	}
	
	public static String commandHelp() {
		StringBuilder str = new StringBuilder();
			
		for (Command c : avaliableCommands) {
			str.append(c.helpText() + System.lineSeparator());
		}
			
		return str.toString();
	}
	
}
