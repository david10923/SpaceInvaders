package tp.p2.Printer;

import tp.p2.Logic.Game;
import tp.p2.Utils.MyStringUtils;

public class FormattedPrinter implements GamePrinter {
	
	
	int numRows; 
	int numCols;
	String[][] board;
	public final static String help = "formattedPrinter : prints the game formatted "
			+ "as a board of dimension: 8x9"; 
	
	public final static String name = "formattedPrinter";
	
	final String space = " ";
	  
	public FormattedPrinter (int cols, int rows) {
	    this.numRows = rows;
	    this.numCols = cols;  
	  }
	  
	private void encodeGame(Game game) {
	    board = new String[numRows][numCols];
	    
	    // TODO Codifica el game como una matriz numRowsxnumCols de Strings
	    
	    for (int i=0; i < numRows; i++) {
	    	for (int j=0; j < numCols; j++) {
		    	board [i][j] = game.positionToString(i,j);
		    }
	    }
	  }

	
	@Override
	public String toString(Game game) {
		
		System.out.println(game.infoToString());	
		
		encodeGame(game);

	    int cellSize = 7;
	    int marginSize = 2;
	    String vDelimiter = "|";
	    String hDelimiter = "-";
	    
	    String rowDelimiter = MyStringUtils.repeat(hDelimiter, (numCols * (cellSize + 1)) - 1);
	    String margin = MyStringUtils.repeat(space, marginSize);
	    String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
	    
	    StringBuilder str = new StringBuilder();
	    
	    str.append(lineDelimiter);
	    
	    for(int i=0; i<numRows; i++) {
	        str.append(margin).append(vDelimiter);
	        for (int j=0; j<numCols; j++) {
	          str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
	        }
	        str.append(lineDelimiter);
	    }
	    return str.toString();
	  }



	public GamePrinter parse(String name) {
		
		if (name == this.name) {
			return this;
		}
		
		return null;
	}

	@Override
	public String helpText() {
		return help;
	}
}