package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;
import tp.p2.Logic.Move;

public class ExplosiveShip extends Aliens {

	private static final int DAMAGE = 1;
	private static final int POINTS = 5;
	private static final String LETTER = "E";
	private static final String NAME = "[E]xplosive ship";
	
		
	
	public ExplosiveShip(Game game, int row, int column, int life, int cyclesToMove,Move direction) {
		super(game, row, column, life, LETTER, NAME, POINTS, cyclesToMove, direction);		
		
	}

	public ExplosiveShip() {
		
	}

	public boolean receiveMissileAttack(int damage) {
		life = life - damage;
		return true;
	}
	
	public boolean receiveShockWaveAttack(int damage) {
		life = life - damage;
		return true;
	}
	
	public static int getDamage(){
		return DAMAGE;
	}
	
	
	
	
	public void onDelete() {	
		
		if (life <=0) {
			for (int i=this.getColumn()-1; i<this.getColumn()+2;i++) {
				for (int j = this.getRow()-1; j <this.getRow()+2; j++) {
					game.explosion(i,j,DAMAGE);
					
				}
			}
			
		}
		setRemainingAliens(REMAINING_ALIENS-1);
		game.receivePoints(points);
	}

	
	
	@Override
	public String toString() {
		if (life <= 0) {
			return " ";
		}
		return LETTER + "[" + life + "]";
	}


	@Override
	public String serialize() {		
		return LETTER + ";" + row + ";" + column + ";" + life 
				+ ";" + cyclesToMove + ";" + direction + System.lineSeparator();	
	}

	@Override
	public boolean parse(String[] words,Game game) {
		GameObject object;
		if (words[0].equals(LETTER)) {
			
				object = new ExplosiveShip(game, Integer.parseInt(words[1]), Integer.parseInt(words[2]),
						Integer.parseInt(words[3]), Integer.parseInt(words[4]),
						Move.generateDirection(words[5]));
			
			
			game.addObject(object);
			Aliens.setRemainingAliens(Aliens.REMAINING_ALIENS + 1);
			return true;
		}
		return false;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

}
