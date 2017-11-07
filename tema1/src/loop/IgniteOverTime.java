/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

final class IgniteOverTime extends BasicIgnite implements OverTimeEffect {
    private static final int BASE_DAMAGE = 50;
    private static final int BONUS_DAMAGE_PER_LEVEL = 30;
    private static final int INITIAL_TURNS = 2;
    private final Character initialLand;
    private int damage = BASE_DAMAGE;

    IgniteOverTime(final Character land, final int level) {
        super();
        initialLand = land;
        turns = INITIAL_TURNS;
        damage += BONUS_DAMAGE_PER_LEVEL * level;
    }

    public void applyTo(final Hero hero) {
        int modifiedDamage = Math.round(damage
                * raceModifier.get(hero.race) * landModifier.get(initialLand));
        hero.receiveDamage(modifiedDamage);
        if (--turns == 0) {
            hero.finishOvertimeEffect();
        }

    }

    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
