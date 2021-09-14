package tp.p2.Printer;

import tp.p2.Commands.Command;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;

public class PrinterGenerator {
	
	
	private static GamePrinter[] availablePrinters = {
			new FormattedPrinter(Game.DIM_X, Game.DIM_Y),
			new Serializer(),
	};
	
	public static GamePrinter printerParse(String name){
		GamePrinter printer;
		
		for (GamePrinter c : availablePrinters) {
			
			printer = c.parse(name);
				if (printer !=null) {
					return printer;
				}
				
			}
		
			return null;
	}
		
	
	
	public static String  printerHelp() {
		StringBuilder str = new StringBuilder();
			
		for (GamePrinter c : availablePrinters) {
			str.append(c.helpText() + System.lineSeparator());
		}
			
		return str.toString();
	}

}
