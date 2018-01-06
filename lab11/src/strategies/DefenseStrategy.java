package strategies;

import entities.Hero;
import entities.Monster;
import entities.Treasure;

public class DefenseStrategy implements Strategy {

    Hero hero;
	//TODO Implement constructor with a Hero as argument
	public DefenseStrategy(Hero hero) {
	    this.hero = hero;
    }

	@Override
	public void attack(Monster m) {
	    // TODO implement me

        for (Treasure t: hero.getInventory()) {
            if (t.getDamageType() == hero.getDamageType()) {
                hero.setHP(hero.getHP() + t.getBoostHp());
                m.setHP(m.getHP() - hero.getBaseDamage());
                System.out.println(hero.getHP() + t.getBoostHp());
                return;
            }
        }
        hero.setHP(hero.getHP() + hero.getBaseHpBoost());
        m.setHP(m.getHP() - hero.getBaseDamage());
        System.out.println(hero.getHP() + hero.getBaseHpBoost());

	    /*	Attack algorithm
			if hero type weapon found boost HP with treasure.getHpBoost() + hero.getBaseHpBoost()
				else boost HP with getBaseHpBoost()
			Do a basic attack on the monster -> hero.getBaseDamage()
			--> In order to find the weapon, iterate through the inventory of the hero.
	    */
	}

}
