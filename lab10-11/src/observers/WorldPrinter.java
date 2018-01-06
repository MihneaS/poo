package observers;

/**
 * Observer that prints the game's world (the map with all the treasures,
 * heroes, obstacles)
 *
 */

import com.sun.org.apache.xpath.internal.operations.String;
import entities.Hero;
import game.World;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class WorldPrinter implements Observer {
    static WorldPrinter instance = null;

    private WorldPrinter() {}

    public static WorldPrinter getInstance() {
        if (instance == null) {
            instance = new WorldPrinter();
        }
        return instance;
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO obtain the World's map, treasures and heroes
		// print the map
		// e.g.
		// 0  1  1  1  0  
		// H  T  0  1  0  
		// 0  0  T  0  0  
		// 0  0  0  T  T  
		// 0  T  0  0  0  
		// T - treasure, H - hero, 1 - obstacle
		World world = World.getInstance();
		char[][] map;
        map = new char[World.MAP_SIZE][World.MAP_SIZE];
        int n = world.getMap().length;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j< n; ++j) {
                switch (world.getMap()[i][j]) {
                    case World.TREASURE_SPOT:
                        map[i][j] = 'T';
                        break;
                    case World.HERO_SPOT:
                        map[i][j] = 'H';
                        break;
                    case World.EMPTY_SPOT:
                        map[i][j] = '0';
                        break;
                    case World.OBSTACLE_SPOT:
                        map[i][j] = '1';
                        break;
                }
            }
		}
		for (Hero hero: World.getInstance().getParty()) {
		    map[hero.getPosx()][hero.getPosy()] = 'H';
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
	}
	
}