package tp.p2.Logic.Objects;

import tp.p2.Exceptions.CommandExecuteException;

public interface IPlayerController  {
	
	// PLAYER ACTIONS	
	public boolean move (int numCells) throws CommandExecuteException ;
	public boolean shootLaser() throws CommandExecuteException;
	public boolean shockWave() throws CommandExecuteException;
	
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave() throws CommandExecuteException;
	public void enableMissile() throws CommandExecuteException;
	
}