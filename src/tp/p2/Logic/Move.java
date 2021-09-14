package tp.p2.Logic;


public enum Move {
	RIGHT, LEFT, DOWN;



	public static Move generateDirection(String direction) {
		Move dir=null;
		
		switch(direction) {
		case "RIGHT":
			dir = Move.RIGHT;
			break;
		case "LEFT":
			dir = Move.LEFT;
			break;
		case "DOWN":
			dir = Move.DOWN;
			break;
		}
		
		return dir;
		
	}
	
}