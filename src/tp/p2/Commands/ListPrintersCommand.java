package tp.p2.Commands;

import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;

public class ListPrintersCommand extends Command{
	
	private static final String details = "PrinterList";
	private static final String shortcut = "lp";
	private static final String name = "listprinters";
	private static final String help = "show printers avaliable";
	
	public ListPrintersCommand() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		return null;
	}

}
