package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;
import tp.p2.Logic.Move;

public class Regular extends Aliens implements IExecuteRandomActions {
	
	private static final int RESISTANCE =2;
	private static final int DAMAGE = 0;
	private static final int POINTS = 5;
	private static final String LETTER = "R";
	private static final String NAME = "[R]egular ship";
	private boolean state=false;
		
	public Regular(Game game, int row, int column) {
		super(game, row, column, RESISTANCE, LETTER, NAME,POINTS, game.getLevel().getSpeed(), Move.LEFT);
		state = false;
	}
	
	public Regular(Game game, int row, int column, int cyclesToMove, int life, Move direction) {
		super(game,row, column, life, LETTER, NAME,POINTS, cyclesToMove , direction);
		state = false;
	}
	
	public Regular() {
		
	}
	
	
	
	public void onDelete() {
		if (life <= 0) {
			setRemainingAliens(REMAINING_ALIENS-1);
			game.receivePoints(POINTS);
		}
	}
	
	
	public String serialize() {
		return letter + ";" + row + ";" + column + ";" + life 
				+ ";" + cyclesToMove + ";" + direction + System.lineSeparator();
	}
	
	public String toString() {
		if (life <= 0) {
			return " ";
		}
		return LETTER + "[" + life + "]";
	}
	

	public static String getInfo() {
		return NAME + "Points: " + POINTS + "Harm: " + DAMAGE + "Shield: " + RESISTANCE + System.lineSeparator();
	}
	
	public static boolean canGenerateExplosiveShip(Game game){
        return game.getRandom().nextDouble() < game.getLevel().getExploteFreq();
    }


    public void computerAction (){
        GameObject object;
        if(canGenerateExplosiveShip(game)){
            state = true;
            object = new ExplosiveShip(game,row,column, life,cyclesToMove,direction);
            game.cambia(this,object);
           // game.update();
        }

    }

	@Override
	public boolean parse(String[] words, Game game) {
		
		GameObject object;
		if (words[0].equals(LETTER)) {
			
			object = new Regular(game, Integer.parseInt(words[1]), Integer.parseInt(words[2]),
					Integer.parseInt(words[4]),Integer.parseInt(words[3]) , Move.generateDirection(words[5]));
			game.addObject(object);
			Aliens.setRemainingAliens(Aliens.REMAINING_ALIENS + 1);
			return true;
		}
		return false;
	}
	
}
