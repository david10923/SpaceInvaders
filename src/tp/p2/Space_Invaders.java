package tp.p2;

import	tp.p2.Logic.Level;

import java.util.Random;

import tp.p2.Controller.Controller;
import tp.p2.Logic.Game;

public class Space_Invaders {

	public static void main(String[] args) {
				
		Level level = null;
		int seed =0;
	
			
		if (args.length > 0) {
			level = Level.generateLevel(args[0]);
			if(args.length == 2) {
				try {
					seed = Integer.parseInt(args[1]);
				}catch(NumberFormatException e) {
					System.err.println("Seed argument ERROR");
				}
			}
		}
	
		//System.out.println(level);
		//System.out.println(seed);
	
		if(level != null) {
			Game game = new Game(level, seed);
			Controller controller = new Controller(game);
		
		
		
			controller.run();
		}else {
			System.out.println("No existe ese nivel");
			
			
		}
	}

}
