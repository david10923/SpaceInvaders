
package tp.p2.Commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;
import tp.p2.Printer.GamePrinter;
import tp.p2.Printer.Serializer;

public class SaveCommand extends Command {

	private static final String details = "Save:";
	private static final String shortcut = "sv";
	private static final String name = "save";
	private static final String help = "save serialized game in txt";
	private String fileWriteError = "not saved";
	private String filename;
	private static final String successfullyMessage = "Game successfully saved in file "
			+ "<nombre_proporcionado_por_el_usuario>.dat. Use the load command to reload it";
	
	public SaveCommand() {
		super(name, shortcut, details, help);
		
	}

	public boolean execute(Game game) throws CommandExecuteException {
		
		
		try(BufferedWriter outStream = new BufferedWriter(new FileWriter(filename + ".txt"))){
			
			GamePrinter printer = new Serializer();
			outStream.write("" + printer.toString(game));
			
			return false;
			
		}catch (IOException ioe) {
			throw new CommandExecuteException(fileWriteError, ioe);
		}
	}
	

	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		
		if (commandWords.length == 2) {
			
			if (matchCommandName(commandWords[0])) {
				
				filename = commandWords[1];
				
				return this;
			}
			
		}
		return null;
	}

}
