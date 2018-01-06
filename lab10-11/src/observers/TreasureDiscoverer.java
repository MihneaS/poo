package observers;

import entities.Hero;
import entities.Treasure;
import game.World;

import java.util.Observable;
import java.util.Observer;

/**
 * Observer that prints the lore of a treasure when a hero discovers it.
 *
 */
public class TreasureDiscoverer implements Observer {

    static TreasureDiscoverer instance = null;

    private TreasureDiscoverer() {}

    public static TreasureDiscoverer getInstance() {
        if (instance == null) {
            instance = new TreasureDiscoverer();
        }
        return instance;
    }

    public void update(Observable o, Object arg) {
        for (Hero hero: World.getInstance().getParty()) {
            if (World.getInstance().getMap()[hero.getPosx()][hero.getPosy()] == World.TREASURE_SPOT) {
                System.out.println(hero + " collected a treasure");
                hero.collect(World.getInstance().popTreasure(hero.getPosx(), hero.getPosy()));
            }
        }

    }
}
