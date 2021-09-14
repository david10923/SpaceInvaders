package tp.p2.Printer;


import tp.p2.Logic.Game;

public class Serializer implements GamePrinter {

	public final static String help = "serializer : prints the game as plain text"; 
	
	public final static String name = "serializer";
	
	
	
	@Override
	public String toString(Game game){
		return game.serialize();
	}

	@Override
	public GamePrinter parse(String name) {
		if (this.name == name) {
			return this;
		}
		return null;
	}

	@Override
	public String helpText() {
		return help;
	}

}
