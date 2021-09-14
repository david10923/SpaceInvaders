package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;

public class Laser extends Weapon{
	
	private final static String letter = "L";
	private final static int DAMAGE=1;
	private final static int RESISTANCE = 1;
	private boolean laserOn;
	
	public Laser(Game game, int row, int column) {
		super(game, row, column, RESISTANCE, DAMAGE, letter);
		laserOn=false;
	}
	


	
	public void move() {
		if(laserOn) {
			row--;	
			if (isOut()) {
				life =0;
			}
		}
		
	}
	
	public String toString() {
		if (laserOn) {
			return "oo";	
		}
		return "";
	}
	
	public boolean performAttack(GameObject other) {
		
		if(laserOn){
			if (row == other.getRow() && column == other.getColumn()) {
				if (other.receiveMissileAttack(DAMAGE)) {
					life = 0;
					laserOn = false;
					return true;
				}
			}

		}
		
		return false;
		
	}
	
	public boolean receiveBombAttack(int damage) {
		getDamage(damage);
		return true;
	}

	public boolean isLaserOn() {
		return laserOn;
	}

	public void setLaserOn(boolean laserOn) {
		this.laserOn = laserOn;
	}
	
	public boolean isOut() {
		return row < Game.MARGIN;
	}
	
	public void onDelete() {
		if (life == 0) {
			laserOn = false;
			
		}
		
	}
	
	public String serialize() {
		return letter + ";" + row + ";" + column + ";" + System.lineSeparator();
	}

	
	public boolean parse(String[] words, Game game) {
		GameObject object;
		if (words[0].equals(letter)) {
			
			object = new Ovni();
			game.addObject(object);
		}
		return false;
	}
	
}
