package factories;

import entities.Hero;
import entities.Mage;
import entities.Priest;
import entities.Warrior;

public class HeroFactory {
	private static HeroFactory instance;

	private HeroFactory() {}

	public static HeroFactory getInstance() {
		if (instance == null) {
			instance = new HeroFactory();
		}
		return instance;
	}

	/**
	 *
	 * @param type the Hero type
	 * @param name
	 * @return
	 */
	public Hero createHero(Hero.Type type, String name) {
		Hero returnHero;
		switch (type) {
			case MAGE: returnHero = new Mage(); break;
			case PRIEST: returnHero = new Priest(); break;
			case WARRIOR: returnHero = new Warrior(); break;
			default: throw new IllegalArgumentException("The hero type " + type + " is not recognized.");
		}
		returnHero.setName(name);
		return returnHero;
	}
}
