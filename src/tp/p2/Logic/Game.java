package tp.p2.Logic;


import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import tp.p2.Commands.CommandGenerator;
import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.FileContentsException;
import tp.p2.Logic.Level;
import tp.p2.Logic.Objects.Aliens;
import tp.p2.Logic.Objects.BoardInitializer;
import tp.p2.Logic.Objects.Destroyer;
import tp.p2.Logic.Objects.GameObject;
import tp.p2.Logic.Objects.GameObjectGenerator;
import tp.p2.Logic.Objects.IPlayerController;
import tp.p2.Logic.Objects.Ovni;
import tp.p2.Logic.Objects.Regular;
import tp.p2.Logic.Objects.UCMShip;
import tp.p2.Logic.Objects.Lists.GameObjectBoard;
import tp.p2.Printer.FormattedPrinter;
import tp.p2.Printer.PrinterGenerator;

public class Game implements IPlayerController{
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;
	public final static int MARGIN = 0;
	public final static String letter = "G";
	private final int UCM_ROW_INI = 7;
	private final int UCM_COLUMN_INI = 4;
	private int currentCycle;
	private Random rand;
	private int seed;
	private Level level;

	GameObjectBoard board;
	private UCMShip player;
	
	private boolean doExit;
	private BoardInitializer initializer;
	
	public Game (Level level, int seed){
		rand = new Random();
		this.seed = seed;
		this.level = level;
		rand.setSeed(seed);
		initializer = new BoardInitializer();
		initGame();
	}
	
	
	public Game (Level level) {
		rand = new Random();
		this.level = level;
		this.board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
	}
	
	
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		
		player = new UCMShip(this, UCM_ROW_INI, UCM_COLUMN_INI);
		board.add(player);
	}

	public Random getRandom() {
		return rand;
	}
	
	
	
	public Level getLevel() {
		return level;
	}
	
	public void reset() {
		initGame();
	}
	
	public void addObject(GameObject object) {
		board.add(object);
	}
	
	public String positionToString(int row, int column) {
		return board.posToString(row, column);
	}
	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	
	public boolean aliensWin() {
		return !player.isAlive() || Aliens.haveLanded();
	}
	
	private boolean playerWin () {
		return Aliens.allDead();
	}
	
	
	
	
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}
	
	public boolean isOnBoard(int row, int column) {
		return row >= 0 && column >= 0 && row < DIM_X && column < DIM_Y;
	}
	
	
	public void exit() {
		doExit = true;
	}
	
	public void cambia(GameObject Object1,GameObject Object2){
        board.swap(Object1, Object2);
    }

    public boolean explosion(int i, int j, int damage){
       return board.explote(i, j, damage);
    }
	
  
	
	public String infoToString() {
		return "Cycles: " + currentCycle + "\n" +
			player.stateToString() +
			"Remaining aliens: " + (Aliens.getRemainingAliens()) + "\n" + 
			"Points: " + (player.getPoints()) + "\n" + 
			"ShockWave: " + (player.isShock()) + "\n" +
			"SuperMissile Counter: " + (player.getSuperMissileCounter()) + "\n"; 
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}

	public String helpCommand() {
		return CommandGenerator.commandHelp();
	}
	
	public String printerCommand() {
		return PrinterGenerator.printerHelp();
	}
	
	
	public String listCommand() {
		StringBuilder str = new StringBuilder();
		
		str.append(Regular.getInfo());
		str.append(Destroyer.getInfo());
		str.append(Ovni.getInfo());
		str.append(UCMShip.getInfo());
		

		return str.toString();
	}
	
	//métodos del interfaz IPlayerController:
	@Override
	public boolean move(int numCells) throws CommandExecuteException{
		
		player.move(numCells);
			
		return true;
	}

	public boolean shootSuperLaser() throws CommandExecuteException{
		player.shootSuperMissile();
		
		return true;
	}
	
	
	@Override
	public boolean shootLaser() throws CommandExecuteException{
		player.shoot();
		// TODO Auto-generated method stub
		return true;
	}
	
	public void buyMissile() throws CommandExecuteException {
		player.buyMissile();
	}
	
	public void shootSuperMissile() throws CommandExecuteException{
	
	}
	
	@Override
	public boolean shockWave() throws CommandExecuteException{
		player.shockWave();
		return false;
	}

	@Override
	public void receivePoints(int points) {
		player.addPoints(points);
		
	}

	@Override
	public void enableShockWave(){
		
		player.activateShockWave();
		
	}

	@Override
	public void enableMissile() {
		
	}
	
	
	public void restoreGame(Game game) {
		this.seed = game.seed;
		this.board = game.board;
		this.currentCycle = game.currentCycle;
	}
	
	
	public void resetGame(Game game, Level level, int cycles, int seed) {
		
		this.seed = seed;
		this.currentCycle = cycles;
		this.rand.setSeed(seed);
		this.board = initializer.initializeEmpty(this, level);
	}
	
	public void load(BufferedReader insStream) throws CommandExecuteException, FileContentsException {
		boolean exit = false;
		String[] aux=null;
		Game newGame;
		Game failSafe= new Game(level, seed);
		int seed;
		try {
			
			
			
			failSafe = this;
			
			
			
			String[] cadena = insStream.readLine().trim().split(";");
			
			if (cadena[0].equals(letter)) {
				

				
				resetGame(this, Level.generateLevel(cadena[2]), Integer.parseInt(cadena[1]), this.seed);
				
				
				
				while(!exit) {
					
					aux = insStream.readLine().trim().split(";");

					if (aux[0].equals("")) {
						exit = true;
					}else {
						
						if (aux[0].equals("P")) {
							
							player = new UCMShip(this, Integer.parseInt(aux[1]), Integer.parseInt(aux[2]),
									Integer.parseInt(aux[3]), Integer.parseInt(aux[4]), Boolean.parseBoolean(aux[5]),Integer.parseInt(aux[6]));
							addObject(player);
						}else {
							boolean object = GameObjectGenerator.objectParse(aux, this);	
						}
						
						
						
						
						/*
						if (object ) {
							throw new FileContentsException("[Game] load() - objectParseError!");
						}
						*/
						
					}
		
					
				}
				
				
				
			}else {
				throw new CommandExecuteException("[Game] - load() ParseGameFail!");
			}
	
			
		}catch(Exception e) {
			this.restoreGame(failSafe);
		}
		
	}
	
	public String serialize() {
		
		StringBuilder str = new StringBuilder();
		str.append("--- Space Invaders v2.0 ---" + System.lineSeparator());
		str.append("G;" + currentCycle + ";" + level + System.lineSeparator());
		str.append(board.serialize()+System.lineSeparator());
		str.append(" ");
		
		return str.toString();
	}
	
	public void cycleCounter() {
		currentCycle++;
	}

	
	public boolean isExit() {
		return doExit;
	}
	
	public void setSeed(int seed) {
		this.seed = seed;
	}
	
	
}
