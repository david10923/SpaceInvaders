package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;

public class Weapon extends GameObject {
	protected int damage;
	private static String letter;
	
	public Weapon(Game game, int row, int column, int live, int damage, String letter) {
		super(game, row, column, live);
		this.damage = damage;
		this.letter = letter;
	}
	
	public Weapon() {
		
	}
	
	public Weapon(Game game, int life, int damage) {
		super(game, life);
		this.damage = damage;
	}
	
	public String serialize() {
		return "";
	}

	
	public boolean receiveMissileAttack(int damage) {
		getDamage(damage);
		return true;
	}
	
	public boolean receiveSuperMissileAttack(int  damage) {
		getDamage(damage);
		return true;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public boolean parse(String[] words, Game game) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
