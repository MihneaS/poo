/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

public final class ParalysisOverTime extends BasicParalysis
        implements OverTimeEffect {
    private static final int BASE_TURNS = 3;
    private static final int TURN_MULTIPLIER = 2;
    private static final int BASE_DAMAGE = 40;
    private static final int BONUS_DAMAGE_PER_LEVEL = 10;
    private final Character initialLand;
    protected int damage = BASE_DAMAGE;

    ParalysisOverTime(final Hero hero, final Character land, final int level) {
        super();
        turns = BASE_TURNS;
        if (land == landModifier.getPreferredLand()) {
            turns *= TURN_MULTIPLIER;
        }
        initialLand = land;
        hero.stun();

        damage += level * BONUS_DAMAGE_PER_LEVEL;
    }

    public void applyTo(final Hero hero) {
        double multipliedDamage = damage;
        multipliedDamage *= landModifier.get(initialLand)
                * raceModifier.get(hero.race);
        hero.receiveDamage((int) Math.round(multipliedDamage));
        if (--turns == 0) {
            hero.unStun();
            hero.finishOvertimeEffect();
        }
    }
}
