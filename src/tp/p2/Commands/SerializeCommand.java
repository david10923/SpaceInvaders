package tp.p2.Commands;

import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;
import tp.p2.Printer.PrinterGenerator;
import tp.p2.Printer.Serializer;

public class SerializeCommand extends Command {
	
	private static final String details = "Serializer:";
	private static final String shortcut = "ser";
	private static final String name = "serialize";
	private static final String help = "prints the game as plain text	";
	
	public SerializeCommand() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		Serializer printer = new Serializer();
		System.out.println(printer.toString(game));
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
