package tp.p2.Controller;

import java.util.Scanner;

import tp.p2.Commands.Command;
import tp.p2.Commands.CommandGenerator;
import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Exceptions.FileContentsException;
import tp.p2.Logic.Game;
import tp.p2.Printer.FormattedPrinter;
import tp.p2.Printer.GamePrinter;
import tp.p2.Printer.PrinterGenerator;

public class Controller {
	private static final String PROMPT = "Command >> "; 
	private Game game;
	private GamePrinter printer = new FormattedPrinter(Game.DIM_X, Game.DIM_Y);
	private static final String unknownCommandMsg = "Unknown Command";
	
	public Controller(Game game) {
		this.game = game;

	}
	
	public void run() {

		System.out.println(printer.toString(game));
		
		while (!game.isFinished() && !game.isExit()){
			
	
			Scanner in = new Scanner(System.in);	
			
			System.out.println(PROMPT);
			String[] words = in.nextLine().toLowerCase().trim().split ("\\s+");
			
			try {
				Command command = CommandGenerator.commandParse(words);
				if (command != null) {
					if (command.execute(game)) {
						if(!game.isExit()) {
							System.out.println(printer.toString(game));
						}
					
					}
				}else {
				System.err.format(unknownCommandMsg);
				}
			}catch (CommandParseException | CommandExecuteException | FileContentsException ex) {
				System.err.format(ex.getMessage() + " %n %n %n");
			}

			
			
		}
		
		System.out.println(game.getWinnerMessage());

	}
}
