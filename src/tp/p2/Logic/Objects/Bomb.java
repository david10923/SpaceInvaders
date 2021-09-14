package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;
import tp.p2.Logic.Move;

public class Bomb extends Weapon{
	private final static String letter = "B";
	private final static int DAMAGE=1;
	private boolean state;
	private final static int RESISTANCE=1;
	private Destroyer destroyer;
	
	public Bomb(Game game, int row, int column, Destroyer destroyer) {
		super(game, row, column, RESISTANCE, DAMAGE, letter);
		state = false;
		this.destroyer = destroyer;
	}
	
	public Bomb() {
	
	}
	
	public Bomb(Game game, int row, int column, boolean state, Destroyer destroyer) {
		super(game, row, column, RESISTANCE, DAMAGE, letter);
		this.state = state;
		this.destroyer = destroyer;

	}
	
	
	
	public static String getLetter() {
		return letter;
	}



	public String toString() {
		if (state) {
			return "*";
		}
		return "";
	}
	
	
	public void move() {
		if (state) {
			row++;
			if (isOut()) {
				life=0;
			}
		}
	}
	
	public boolean isOut() {
		return row > Game.DIM_X;
	}
	
	
	
	public boolean performAttack(GameObject other) {
		
		if (state) {
			
			if (row == other.getRow() && column == other.getColumn()) {
				
				if (other.receiveBombAttack(DAMAGE)) {
					life = 0;
					state = false;
					return true;
				}
			}
			
			
		}
		return false;
	}


	public String serializer() {
		
		if (state) {
			return letter + ";" + row + ";" + column /*+ destroyer.serialize()*/;
		}else {
			return letter + ";" + "NOP"+ ";" + "NOP" /*+ destroyer.serialize()*/;
		}
	}

	
	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}
	
	public void onDelete() {
		if (life == 0 || isOut()) {
			state=false;
			this.destroyer.setCanShootBomb(false);
		}
	}
	/*
	public boolean parse(String[] words, Game game) {
		
		GameObject object;
		if (words[0].equals(letter)) {
			
			
			object = new Bomb(game, Integer.parseInt(words[1]), Integer.parseInt(words[2]));
			
			game.addObject(object);
			return true;
		}
		return false;
	}
*/
}
