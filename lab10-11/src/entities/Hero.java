package entities;

import java.util.ArrayList;
import java.util.List;

import game.World;

public abstract class Hero {

	protected String name;
	protected List<Treasure> inventory = new ArrayList<Treasure>();
	protected int posx, posy;

	/* Hero actions */
	public void move(Direction direction) {

		World world = World.getInstance();

		switch(direction) {
		case E:
			posy = (posy + 1) % World.MAP_SIZE;
			break;
		case W:
			posy = (posy + World.MAP_SIZE -1) % World.MAP_SIZE;
			break;
		case S:
			posx = (posx + 1) % World.MAP_SIZE;
			break;
		case N:
			posx = (posx + World.MAP_SIZE -1) % World.MAP_SIZE;
			break;
		
		}

		World.getInstance().update();
	}

	public void collect(Treasure treasure) {

		inventory.add(treasure);

	}

	public abstract void attack();


	/* Getters and setters */
	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public enum Direction{
		S, N, E, W
	}
	
	public enum Type {
		WARRIOR, MAGE, PRIEST
	}

}


