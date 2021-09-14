package tp.p2.Logic.Objects;

import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Logic.Game;
import tp.p2.Logic.Move;

public class UCMShip extends Ship {
	
	private final static int RESISTANCE=3;
	private int points;
	private final int superMissilePrize = 20;
	private int superMissileCounter;
	private boolean shootLaser;
	private Laser laser;
	private SuperMissile superMissile;
	private final static String icon = "^__^: ";
	private final static String letter = "P";
	private boolean shock;
	private ShockWave shockWave;
	
	public UCMShip(Game game, int row, int column) {
		super(game, row, column, RESISTANCE);
		this.points = 0;
		laser = new Laser(game, row, column);
		superMissile = new SuperMissile(game, row, column);
		shock = false;
		
		superMissileCounter=0;
		
		// TODO Auto-generated constructor stub
	}
	
	public UCMShip() {
		
	}
	
	public UCMShip(Game game, int row, int column, int life, int points, boolean shock, int missils) {
		super(game, row, column, life);
		this.points = points;
		laser = new Laser(game, row, column);
		superMissile = new SuperMissile(game, row, column);
		this.shock = shock;
		
		this.superMissileCounter= missils;
		
		// TODO Auto-generated constructor stub
	}

	public boolean isShock() {
		return shock;
	}
	
	public int getSuperMissileCounter() {
		return superMissileCounter;
	}
	
	public String stateToString() {
		
		return "Life:" + life + "\n";
	}
	
	public int getPoints() {
		return points;
	}
	
	public void addPoints(int num) {
		points = points + num;
	}
	
	public String toString() { 
		if (life == 0) {
			return "!xx!";
		}
		return "^__^";
	}
	
	public void move(int cells) throws CommandExecuteException{
		
		if ((column + cells >=Game.MARGIN && column + cells <= Game.DIM_Y)) {
			column = column +cells;
		}else {
			throw new CommandExecuteException("Player cannot move!");
		}
		
		
	}

	public void buyMissile() throws CommandExecuteException {
		
		if (points >= superMissilePrize) {
			superMissileCounter++;
			points = points - superMissilePrize;
		}else {
			throw new CommandExecuteException("No points to buy");
		}
	}
	
	public void shoot() throws CommandExecuteException {
		
		
		if (!laser.isLaserOn() && !superMissile.isLaserOn()) {
			laser = new Laser(game, row, column);	
			game.addObject(laser);
			laser.setLaserOn(true);
		
		}
		else {
			throw new CommandExecuteException("[UCMship] shoot() - Laser is already on the Board");
		}
		
	}
	
	public void shootSuperMissile() throws CommandExecuteException {
		
		
		if (!superMissile.isLaserOn() && superMissileCounter>0 && !laser.isLaserOn()) {
			superMissile = new SuperMissile(game, row, column);	
			game.addObject(superMissile);
			superMissile.setLaserOn(true);
			superMissileCounter--;
		
		}
		else {
			throw new CommandExecuteException("[UCMship] shootSuperMissile() - SupperMissileOFF");
		}
		
	}
	
	
	/*
	public void OnDelete() {
		if(!laser.isLaserOn())
			laser = null;
	}
	
	*/
	
	public boolean receiveBombAttack(int damage) {
		getDamage(damage);
		return true;
	}
	
	public boolean receiveExploteAttack(int damage) {
		getDamage(damage);
		
		return true;
	}
	
	public void activateShockWave(){
		
		
		if (!shock) {
			shock = true;
			shockWave = new ShockWave(game);
			game.addObject(shockWave);
		}
		
		
	}
	
	public void shockWave() throws CommandExecuteException{
		
		if (shock) {
			shockWave.setState(true);
			shock = false;
		}else {
			throw new CommandExecuteException("[UCMship] shockWave() - no shock true");
		}
		
	}
	
	public static String getInfo() {
		return icon + "Shield: " + RESISTANCE + System.lineSeparator();
	}
	
	public String serialize() {
		return letter + ";" + row + ";" + column + ";" + life 
				+ ";" + points + ";" + shock + ";"+ superMissileCounter;
	}
	
	@Override
	public void move() {

		
	}

	
	/*
	public boolean parse(String[] words,Game game) {
		GameObject object;
		if (words[0].equals(letter)) {
			
			object = new UCMShip(game, Integer.parseInt(words[1]), Integer.parseInt(words[2]),
					Integer.parseInt(words[3]), Integer.parseInt(words[4]), Boolean.parseBoolean(words[5]),Integer.parseInt(words[6]));
			game.addObject(object);
			return true;
		}
		return false;
	}
*/
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean parse(String[] words, Game game) {
		// TODO Auto-generated method stub
		return false;
	}
}
