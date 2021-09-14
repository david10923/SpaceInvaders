package tp.p2.Logic.Objects;

import java.util.Random;

import tp.p2.Logic.Game;
import tp.p2.Logic.Level;

public interface IExecuteRandomActions {
	
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFreq();
	}
	
	static boolean  canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFreq();	
	}
	
	static boolean canGenerateExplosiveShip(Game game){
        return game.getRandom().nextDouble() < game.getLevel().getExploteFreq();
    }
	
}
