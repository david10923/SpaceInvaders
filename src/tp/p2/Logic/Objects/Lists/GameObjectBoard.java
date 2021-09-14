package tp.p2.Logic.Objects.Lists;

import tp.p2.Logic.Game;
import tp.p2.Logic.Objects.GameObject;

public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;

	
	public GameObjectBoard (int width, int height) {
		// TODO implement
		objects = new GameObject[width*height];
		currentObjects = 0;
	}
	
	public int getCurrentObjects () {
		return currentObjects;

	}
	
	public void add (GameObject object) {
		objects[currentObjects] = object;
		currentObjects +=1;
	}
	
	private GameObject getObjectInPosition (int x, int y) {
		boolean ok=false;
		int i=0;
		
		while (i < currentObjects && !ok) {
			if (objects[i].getRow() == x && objects[i].getColumn()==y) {
				ok = true;
				return objects[i];
			
			}
			i++;
		}
		
		return null;
	}
	
	private int getIndex(int x, int y) {
        int pos=0;
        boolean found=false;
        GameObject other = getObjectInPosition(x, y);

        while(!found && pos < currentObjects) {
            if (objects[pos] == other) {
                found = true;
            }else {
                pos++;
            }
        }

        return pos;
    }
	

	private void remove (GameObject object) {
		int pos=0;
		
	
		if (object.getLive() == 0) {
			
			pos = getPosition(object);
			
			if (objects[pos] == object) {
				objects[pos] = null;
				moveList(pos);
				currentObjects = currentObjects - 1;
			}
			
		}
			
			
		
		
		
	}
	public void update() {

		for (int i = 0; i < currentObjects; i ++) {
			objects[i].move();	
			checkAttacks(objects[i]);
			
		}
		
		
		removeDead();
	
	}
	
	private int getPosition(GameObject object){

        int pos=0;
        boolean found=false;

        while(!found && pos < currentObjects) {
            if (objects[pos] == object) {
                found = true;
            }else {
                pos++;
            }
        }

        return pos;
    }
	
	private void moveList(int pos) {
		
		for (int i=pos ; i < currentObjects; i++) {
			
			objects[i] = objects[i+1];
		}
		
	}
	
	
	private void checkAttacks(GameObject object) {
		
		for (int i= 0 ; i < currentObjects; i++) {
			GameObject other = objects[i];
			
			if (other != object) {
				
				
			object.performAttack(other);	
				
					
			}
		}
	}
	
	public void computerAction() {
		for (int i=0; i < currentObjects; i++) {
			objects[i].computerAction();
		}
	}
	
	
	public boolean explote(int i, int j, int damage){ 
		
		for(int k =0;k< currentObjects;k++){	
			
			if (objects[k].getColumn() == i && objects[k].getRow() == j) {
				

				
				objects[k].receiveExploteAttack(damage);
			
				
				return true;
			}
			
		}

		return false;
		
	}
	
	
	public void swap(GameObject Object1 , GameObject Object2){
        int pos; 

        pos = getIndex(Object1.getRow(),Object2.getColumn());
        objects[pos] = Object2;


    }
	
	private void removeDead() {

		for (int i=0; i<currentObjects;i++) {
			
			if (objects[i].getLive() == 0) {
				objects[i].onDelete();
				remove(objects[i]);
				
				i=-1;
			}
		}
		
		
	
	}

	public String posToString(int x, int y) {
		
		GameObject object;
		
		object = getObjectInPosition(x, y);
		
		if (object != null) {
			return object.toString();
		}
		return " ";
	}
	
	public String serialize() {
		StringBuilder str = new StringBuilder();
		
		for(int i=0; i< currentObjects; i++) {
			str.append(objects[i].serialize());
		}
		
		
		return str.toString();
	}
	

}
