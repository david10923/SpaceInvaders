package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;

public class Ovni extends EnemyShip implements IExecuteRandomActions{
	
	public static Boolean state = false;
	private static final int RESISTANCE =1;
	private static final int DAMAGE = 0;
	private static final int POINTS = 25;
	private static final String LETTER= "O";
	private static final String NAME = "[O]vni";
	
	public Ovni(Game game, int row, int column) {
		super(game, row, column, RESISTANCE, LETTER, NAME, POINTS);
		state=false;
	}
	
	//contructor que usamos para hacer el load
	public Ovni(Game game, int row, int column, int life) {
		super(game, row, column, life, LETTER, NAME, POINTS);
		state=true;
	}
	
	public Ovni() {
		
	}
	
	
	
	public void move() {
		if (state) {
			column--;
			if (isOut()) {
				state = false;
			}
		}
	}

	
	public boolean isOut() {
		return column < Game.MARGIN;
	}
	
	public boolean receiveMissileAttack(int damage) {
		life = life - damage;
		return true;
	}
	
	public boolean receiveSuperMissileAttack(int  damage) {
		
		getDamage(damage);
		
		return true;
	}

	public String serialize() {
		if (state) {
			return letter + ";" + row + ";" + column + ";" + life 
					+ System.lineSeparator();
		}
		return "";
	}	
	
	public static String getInfo() {
		return NAME + "Points: " + POINTS + "Harm: " + DAMAGE + "Shield: " + RESISTANCE + System.lineSeparator();
	}
	
	public String toString() {
		
		if (state) {
			return LETTER + "[" + life + "]";
		}
		return " ";
	
	}
	
	public static boolean canGenerateRandomOvni(Game game){
		double prob=0;
		
		prob = game.getRandom().nextDouble();
		//System.out.println("probOVNI" + prob);
		return  prob < game.getLevel().getOvniFreq();
	}
	
	
	public void computerAction() {
		if (!state) {
			if (canGenerateRandomOvni(game)) {
				
				row = game.MARGIN;
				column = game.DIM_Y;
				state = true;
			}
		}
	}
	
	public void onDelete() {
		if (life == 0) {
			life = 1;
			state=false;
			game.receivePoints(POINTS);
			game.enableShockWave();
		}
		
	}

	/*
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
*/
	@Override
	public boolean parse(String[] words, Game game) {
		GameObject object;
		if (words[0].equals(LETTER)) {
			
			object = new Ovni(game, Integer.parseInt(words[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]));
			game.addObject(object);
			return true;
		}
		return false;
	}


	
	
}
