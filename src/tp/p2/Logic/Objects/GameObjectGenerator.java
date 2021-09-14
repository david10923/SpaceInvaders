package tp.p2.Logic.Objects;

import tp.p2.Commands.Command;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Logic.Game;

public class GameObjectGenerator {
	
	
	
	private static GameObject[] availableObjects = {
		new Regular(),
		new Destroyer(),
		new Bomb(),
		new UCMShip(),
		new Ovni(),
		new ExplosiveShip()	
		
	};
	
	
	
	public static boolean objectParse(String[] words, Game game) {
		boolean object;
		
		if 	(words.length == 0) {
			return false;
		}else {
			for (GameObject o : availableObjects) {
				object = o.parse(words, game);
				
				if (object !=false) {
					return true;
				}
				
			}
			return false;
		}
		
	}
	
	
}
