package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;
import tp.p2.Logic.Level;
import tp.p2.Logic.Objects.Lists.GameObjectBoard;

public class BoardInitializer {
	
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	public  GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		
		
		initializeRegularAliens();
		initializeDestroyerAliens();
		Aliens.setRemainingAliens(board.getCurrentObjects());
		initializeOvni();
		return board;
	}
	
	public GameObjectBoard initializeEmpty(Game game, Level level) {
		
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		Aliens.setRemainingAliens(0);
		return board;
	}
	
	private void initializeOvni () {
		Ovni ovni = new Ovni (game,Game.MARGIN, Game.DIM_Y);
		board.add(ovni);
	}

	private void initializeRegularAliens () {
		int initialRow =1, rows, columns, initialColumn = (game.DIM_Y / 2)-1;
			
			rows = level.getNumRegularRows();
			
			columns = level.getNumRegularShips() / level.getNumRegularRows();
				
			for (int i= initialRow; i < rows + initialRow; i++) {
				for (int j=0; j < columns ; j++) {
					Regular regularShip = new Regular(game,i, initialColumn + j);
					board.add(regularShip);
				}
			}

	}
	
	private void initializeDestroyerAliens() {
		int initialRow =2, rows, columns, initialColumn = (game.DIM_Y / 2);
		
		rows = level.getDestroyerRows();
		
		columns = level.getNumDestroyerShips();
		
		if (level.getNumRegularShips() > 4) {
			if (level.getNumDestroyerShips() > 2) {
				initialColumn = (game.DIM_Y / 2)-1;
			}
			
			initialRow = level.getNumRegularRows()+1;
		}

		for (int i=0; i < level.getNumDestroyerShips(); i++) {
			Destroyer destroyerShip = new Destroyer(game,initialRow,initialColumn + i);
			board.add(destroyerShip);
		}
	}
}
