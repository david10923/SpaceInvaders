package tp.p2.Commands;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Exceptions.FileContentsException;
import tp.p2.Logic.Game;

public class LoadCommand extends Command {
	
	private static final String details = "Load:";
	private static final String shortcut = "ld";
	private static final String name = "load";
	private static final String help = "charges a saved game";
	private String filename;
	private static final String fileHeaderString= "--- Space Invaders v2.0 ---";
	
	
	public LoadCommand() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean execute(Game game) throws CommandExecuteException, FileContentsException {
	
		try(BufferedReader bf = new BufferedReader(new FileReader(filename + ".txt"))){
			
			System.err.println("HA COLAO");
			if (bf.readLine().equals(fileHeaderString)) {
				
			
					
				game.load(bf);
				
				
			}else {
				throw new CommandExecuteException("FileHead doesn't mach with --- Space Invaders v2.0 --- ");
			}
			
		}catch(Exception e) {
			throw new FileContentsException("NO ABRE BIEN BRO");
		}
		
		
		
		
		
		
		return true;
	}

	@Override
	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		if (commandWords.length == 2) {
			
			if (matchCommandName(commandWords[0])) {
				
				filename = commandWords[1];
				
				return this;
								
				
			}
			
		}
		return null;
	}

}
