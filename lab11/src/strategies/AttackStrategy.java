package strategies;

import entities.Hero;
import entities.Monster;
import entities.Treasure;

public class AttackStrategy implements Strategy {

    Hero hero;

	public AttackStrategy(Hero hero) {
	    this.hero = hero;
    }

	//TODO Implement constructor with a Hero as argument
	@Override
	public void attack(Monster m) {

        for (Treasure t: hero.getInventory()) {
            if (t.getDamageType() == hero.getDamageType()) {
                m.setHP(m.getHP() - 3 * t.getDmg());
                return;
            }
        }

        for (Treasure t: hero.getInventory()) {
            if (t.getDamageType() == m.getWeakness()) {
                m.setHP(m.getHP() - 2 * t.getDmg());
                return;
            }
        }


        m.setHP(m.getHP() - hero.getBaseDamage());
        // TODO implement me

	    /*	Attack algorithm
			if hero type weapon found use it (x3 weapon damage)
				else if counter weapon found use it (x2 weapon damage)
				else basic attack (no bonus)
			--> In order to find the weapon, iterate through the inventory of the hero.
	    */
	}

}
