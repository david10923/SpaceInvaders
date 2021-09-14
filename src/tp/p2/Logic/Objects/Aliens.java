package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;

import tp.p2.Logic.Move;

public abstract class Aliens extends EnemyShip {
	
	protected static int REMAINING_ALIENS=0;
	protected static int isInFinalRow;
	protected static int SHIPS_ON_BORDER=-1;
	protected static boolean shipsDescending =false;
	protected static boolean down =false;
	protected static int cycles=0;
	protected Move direction;
	protected int cyclesToMove;
	private static boolean aliensLanded= false;
	
	public Aliens(Game game, int row, int column, int resistance, String letter, String name, int points, int cyclesToMove, Move direction) {
		super(game, row, column, resistance, letter, name, points);
		this.cyclesToMove = cyclesToMove;
		this.direction = direction;
	
	}
	
	public Aliens() {
		
	}
	
	public void update(Move dir) {
		if (dir == Move.DOWN) {
			row++;

		}
		if (dir == Move.LEFT) {
			column--;

		}
		if (dir == Move.RIGHT) {
			column++;

		}
	}
	
	public boolean receiveExploteAttack(int damage) {
		getDamage(damage);
		
		return true;
	}
	
	public boolean receiveSuperMissileAttack(int  damage) {
		
		getDamage(damage);
		
		return true;
	}
	
	public boolean receiveMissileAttack(int damage) {
		getDamage(damage);
		return true;
	}
	
	public boolean receiveShockWaveAttack(int damage) {
		getDamage(damage);
		return true;
	}
	
	public static boolean allDead() {

		return REMAINING_ALIENS == 0;
	}


	public static boolean haveLanded() {
		
		return aliensLanded;
	}


	public static void setRemainingAliens(int num) {
		REMAINING_ALIENS = num;
	}
	
	public static int getRemainingAliens() {
		return REMAINING_ALIENS;
	}
	
	public boolean isOnBorder(int column) {
		if(direction == Move.LEFT && column == 0) return true;
		if(direction == Move.RIGHT && column == Game.DIM_Y) return true;
		return false;

	}

	
	public void move() {
		

		if (cyclesToMove == 0){
			
			cyclesToMove = game.getLevel().getSpeed();
			
			
			if (direction == Move.LEFT) {
				column--;
			}else if (direction == Move.RIGHT) {
				column++;
			}
			
			
			if (isOnBorder(column)) {
				SHIPS_ON_BORDER = REMAINING_ALIENS;
			}
			
		}
		else if(ShipsDescending()) {
			descent();
		}
		else {
			cyclesToMove--;
		}
		
	}
	
	public boolean ShipsDescending() {
		return SHIPS_ON_BORDER > 0;
	}
	
	
	public void descent() {
		row++;
		if (row == Game.DIM_Y-1) aliensLanded= true;
		direction = swap(direction);	
		SHIPS_ON_BORDER--;	
		
	}
	
	
	public Move swap(Move direction) {
		
		if (direction == Move.LEFT) {
			return Move.RIGHT;
		}
		
		return Move.LEFT;

	}
	
	
	
	
	
	
	
	public void cycleCounter() {
		cycles++;
	}
	

}
