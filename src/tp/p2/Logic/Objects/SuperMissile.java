package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;

public class SuperMissile extends Weapon{
	
	
	private static final String letter = "X";
	private final static int DAMAGE=2;
	private final static int RESISTANCE = 1;
	private boolean superMissileOn;
	
	public SuperMissile(Game game, int row, int column) {
		super(game, row, column, RESISTANCE, DAMAGE, letter);
		superMissileOn=false;
	}
	
	public SuperMissile() {
		
	}

	
	public void move() {
		if(superMissileOn) {
			row--;	
			if (isOut()) {
				life =0;
			}
		}
		
	}
	
	public String toString() {
		if (superMissileOn) {
			return "^^";	
		}
		return "";
	}
	
	public boolean performAttack(GameObject other) {
		if(superMissileOn){
			
			if (row == other.getRow() && column == other.getColumn()) {
				
				if (other.receiveSuperMissileAttack(DAMAGE)) {
					life = 0;
					superMissileOn = false;
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
	
	public String serialize() {
		return letter + ";" + row + ";" + column + ";" + System.lineSeparator();
	}


	public boolean isLaserOn() {
		return superMissileOn;
	}

	public void setLaserOn(boolean superMissileOn) {
		this.superMissileOn = superMissileOn;
	}
	
	public boolean isOut() {
		return row == Game.MARGIN-1;
	}
	
	public void onDelete() {
		if (life == 0) {
			superMissileOn = false;
			
		}
		
	}
	
}
