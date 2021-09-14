package tp.p2.Logic.Objects;

import tp.p2.Logic.Game;

public class ShockWave extends Weapon {

	private final static int DAMAGE=1;
	private final static int RESISTANCE=1;
	private boolean state;
	
	


	public ShockWave(Game game) {
		super(game, RESISTANCE, DAMAGE);
		state=false;
		
	}
	
	
	public boolean performAttack(GameObject other) {
		if (state) {
			if (other.receiveShockWaveAttack(DAMAGE)) {
				life = 0;
				return true;
			}
		}
		
		return true;
			
	}
	
	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}
	
	public void onDelete() {
		if (life == 0) {
			state=false;
		}
	}
	
}
