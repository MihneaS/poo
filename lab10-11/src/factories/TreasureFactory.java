package factories;

import java.util.Random;

import entities.Treasure;
import game.World;


/**
 * Builds random treasure objects. Hides the treasure creation mechanism using
 * a factory method.
 *
 */
public class TreasureFactory {
	private static TreasureFactory instance;
	private final Random rand;



	// ideas for treasure names and lore:
	private final String [] names = {"Sword of Justice", 
			"Leg of St Andrew", 
			"Rabbit's Foot", 
			"5-leaf Clover", 
	"Shield of the Wise"};

	private final String [] lore = {"it looks quite old", 
			"you've heard of this before", 
	"tales of this legendary item are told in each tavern"};

	private TreasureFactory() {
        rand = new Random();
    }

	public static TreasureFactory getInstance() {
		if (instance == null) {
			instance = new TreasureFactory();
		}
		return instance;
	}

	public Treasure createTreasure() {
		Treasure returnTreasure = new Treasure(
		        names[Math.abs(rand.nextInt()) % names.length],
                lore[Math.abs(rand.nextInt()) % lore.length]);
        int j = Math.abs(rand.nextInt()) % World.getInstance().getMap().length;
        int k = Math.abs(rand.nextInt()) % World.getInstance().getMap().length;
        World.getInstance().getMap()[j][k] = World.TREASURE_SPOT;
        returnTreasure.setPosx(j);
        returnTreasure.setPosy(k);

		return returnTreasure;
	}
}