package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;
import tp.p2.Logic.Move;

public abstract class GameObject implements IAttack {
	protected int row;
	protected int column;
	protected int life;
	protected Game game;
	
	public GameObject(Game game, int row, int column, int life) {	
		this.row = row;
		this.column = column;
		this.game = game;
		this.life = life;
	}
	
	public GameObject() {
		
	}
	
	public GameObject(Game game, int life) {
		this.life = life;
	}
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public boolean isAlive() {
		return this.life > 0;
	}

	public int getLive() {
		return this.life;
	}
	
	
	public boolean isOnPosition(int row, int column) {
		return this.row == row && this.column == column;
	}

	public void getDamage (int damage) {
		this.life = damage >= this.life ? 0 : this.life - damage;
	}
	
	public boolean isOut() {
		return !game.isOnBoard(row, column);
	}

	public abstract void computerAction();
	public abstract void onDelete(); //se elimina y da puntos o explota
	public abstract void move();
	public abstract String serialize();
	public abstract String toString();
	public abstract boolean parse(String[] words, Game game);
	
	
}
