package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;
import tp.p2.Logic.Move;

public class Destroyer extends Aliens implements IExecuteRandomActions{

	private static final int RESISTANCE = 1;
	private static final int DAMAGE = 1;
	private static final int POINTS = 5;
	protected boolean canShootBomb;
	private static final String LETTER = "D";
	private static final String NAME = "[D]estroyer ship";
	protected int damage;
	private Bomb bomb;

	
	
	public Destroyer(Game game, int row, int column) {
		super(game, row, column, RESISTANCE, LETTER, NAME,POINTS, game.getLevel().getSpeed(), Move.LEFT);
		this.damage = DAMAGE;
		this.bomb = new Bomb(game, row, column, this);
		canShootBomb = false;
	}
		
	public Destroyer(Game game, int row, int column, int cyclesToMove, int life, Move direction, boolean state) {
		super(game,row, column, life, LETTER, NAME,POINTS, cyclesToMove , direction);
		this.damage = DAMAGE;
		this.bomb = new Bomb(game, row, column, this);
		canShootBomb = state;
	}
	
	
	public Destroyer(Game game, int row, int column, int cyclesToMove, int life, Move direction, int bombRow, int bombColumn) {
		super(game,row, column, life, LETTER, NAME,POINTS, cyclesToMove , direction);
		this.damage = DAMAGE;
		this.bomb = new Bomb(game, bombRow, bombColumn, true, this);
		game.addObject(this.bomb);
		canShootBomb = true;
	}
	
	
	public Destroyer() {
		
	}

	public static boolean  canGenerateRandomBomb(Game game){
		double prob =0;
		prob = game.getRandom().nextDouble();
		//System.out.println(prob);
		return  prob < game.getLevel().getShootFreq();	
	}
	
	
	public void computerAction() {
		Bomb prueba=null;
		if (!canShootBomb) {
			if (canGenerateRandomBomb(game)) {
				
				bomb = new Bomb(game, row, column, this);
				game.addObject(bomb);
				bomb.setState(true);
				canShootBomb=true;
			}
		}
	}
	
		
	public String toString() {
		if (life <= 0) {
			return " ";
		}
		return LETTER + "[" + life + "]";
	}
	
	public static String getInfo() {
		return NAME + "Points: " + POINTS + "Harm: " + DAMAGE + "Shield: " + RESISTANCE + System.lineSeparator();
	}
	
	public void onDelete() {
		if (life <= 0) {
			setRemainingAliens(REMAINING_ALIENS-1);
			game.receivePoints(POINTS);
		}
	}
	
	
	public String serialize() {
		
		if (canShootBomb) {
			return letter + ";" + row + ";" + column + ";" + life 
					+ ";" + cyclesToMove + ";" + direction +  ";" + canShootBomb +  ";" + bomb.serializer() + System.lineSeparator();
		}
		
		
		return letter + ";" + row + ";" + column + ";" + life 
				+ ";" + cyclesToMove + ";" + direction +  ";" + canShootBomb + System.lineSeparator();
			
		
	}
	
	
	public boolean isCanShootBomb() {
		return canShootBomb;
	}

	public void setCanShootBomb(boolean canShootBomb) {
		this.canShootBomb = canShootBomb;
	}

	@Override
	public boolean parse(String[] words, Game game) {
		GameObject object;
		if (words[0].equals(LETTER)) {
			
			if (Boolean.parseBoolean(words[6])==true) {
				object = new Destroyer(game, Integer.parseInt(words[1]), Integer.parseInt(words[2]),
						Integer.parseInt(words[4]),Integer.parseInt(words[3]) ,
						Move.generateDirection(words[5]),
						Integer.parseInt(words[8]), Integer.parseInt(words[9]));
			}else {
				object = new Destroyer(game, Integer.parseInt(words[1]), Integer.parseInt(words[2]),
						Integer.parseInt(words[4]), Integer.parseInt(words[3]) ,
						Move.generateDirection(words[5]), Boolean.parseBoolean(words[6]));
			}
			
				
			
			
			game.addObject(object);
			Aliens.setRemainingAliens(Aliens.REMAINING_ALIENS + 1);
			return true;
		}
		return false;
	}







	
	
	

}
