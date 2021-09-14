package tp.p2.Printer;

import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;

public interface GamePrinter {
	public String toString(Game game);
	public GamePrinter parse(String name);
	public String helpText();
}
