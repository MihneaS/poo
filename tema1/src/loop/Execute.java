package loop;

import java.lang.Math;

public final class Execute extends KnightAbility implements InstantAbility{

    private Float hpLimit = .2f;
    private int damage = 200;
    private static final int BONUS_DAMAGE_PER_LEVEL = 30;
    private static final Float BONUS_HP_LIMIT_PER_LEVEL = 0.01f;
    private static final Float MAX_HP_LIMIT = 0.4f;

    Execute() {
        super();
        raceModifier = new RaceModifier(1.15f, 1f, 1.1f, 0.8f);
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
        hpLimit = Math.min(MAX_HP_LIMIT, hpLimit + BONUS_HP_LIMIT_PER_LEVEL);
    }

    @Override
    public void applyTo(final Hero hero, final Character land) {
        int modifiedDamage;
        int damageForSimulation;
        if ((double) hero.hp < hpLimit * hero.maxHp) {
            damageForSimulation = hero.hp;
            hero.reciveDamage(damageForSimulation);
        } else {
            modifiedDamage = (int) Math.round(damage *
                    raceModifier.get(hero.race) * landModifier.get(land));
            damageForSimulation = Math.round(damage * landModifier.get(land));
            hero.reciveDamage(modifiedDamage);
        }
        damageDealtThisRound = damageForSimulation;
        usedThisRound = true;
    }

    @Override
    public void simulateOn(Hero hero, Character land) {
        if (usedThisRound) {
            hero.reciveDamage(damageDealtThisRound);
        } else {
            applyTo(hero, land);
        }
    }

}
