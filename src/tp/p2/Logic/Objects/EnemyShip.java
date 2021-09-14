package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;

public abstract class EnemyShip extends Ship{
	
	protected int points;
	protected String letter;
	protected String name;
	
	public EnemyShip(Game game, int row, int column, int resistance, String letter, String name, int points) {
		super(game, row, column, resistance);
		this.letter = letter;
		this.name = name;
		this.points = points;
	}
	
	public EnemyShip() {
		
	}

	
	
		
	
}
