package tp.p2.Logic;

public enum Level {
	
	EASY(4, 2, 0.1, 3, 0.5, 1,1, 0.05), HARD(8, 2, 0.3, 2, 0.2, 2, 1, 0.05), INSANE(8, 4, 0.5, 1, 0.1, 2,1, 0.05);

	
	private int numRegularShips;
	private int numDestroyerShips;
	private double shootFreq;
	private int speed;
	private double ovniFreq;
	private int numRegularRows;
	private int numDestroyerRows;
	private double exploteFreq;
	
	Level(int numRegularShips, int numDestroyerShips, double shootFreq, int speed, double ovniFreq, int numRegularRows, int numDestroyerRows, double exploteFreq) {
		this.numRegularShips = numRegularShips;
		this.numDestroyerShips = numDestroyerShips;
		this.shootFreq = shootFreq;
		this.speed = speed;
		this.ovniFreq = ovniFreq;
		this.numRegularRows = numRegularRows;
		this.numDestroyerRows = numDestroyerRows;
		this.exploteFreq = exploteFreq;
	}
	
	public static Level generateLevel(String levelArg) {
		Level level = null;
		
		switch(levelArg) {
		case "EASY":
			level = EASY;
			break;
		case "HARD":
			level = HARD;
			break;
		case "INSANE":
			level = INSANE;
			break;
		}
		
		return level;
	}

	public int getDestroyerRows() {
		return numDestroyerRows;
	}
	
	
	public int getNumRegularRows() {
		return numRegularRows;
	}

	public int getNumRegularShips() {
		return numRegularShips;
	}

	public int getNumDestroyerShips() {
		return numDestroyerShips;
	}

	public double getShootFreq() {
		return shootFreq;
	}

	public int getSpeed() {
		return speed;
	}

	public double getOvniFreq() {
		return ovniFreq;
	}

	public double getExploteFreq() {
		return exploteFreq;
	}

	
	
	
}

