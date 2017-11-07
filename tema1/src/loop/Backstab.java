/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

import static loop.Hero.NA_RACE;

final class Backstab extends RogueAbility implements InstantAbility {
    private static final int BASE_DAMAGE = 200;
    private static final int BONUS_DAMAGE_PER_LEVEL = 20;
    private static final int LUCKY_TURN = 3;
    private static final float DAMAGE_MULTIPLIER = 1.5f;
    private static final float RM_ROGUE = 1.2f;
    private static final float RM_KNIGHT = 0.9f;
    private static final float RM_PYROMANCER = 1.25f;
    private static final float RM_WIZARD = 1.25f;
    private int damage = BASE_DAMAGE;
    private int counter = 0;

    Backstab() {
        raceModifier = new RaceModifier(RM_ROGUE, RM_KNIGHT,
                RM_PYROMANCER, RM_WIZARD);
    }

    @Override
    public void applyTo(final Hero hero, final Character land) {
        float intermediarDamage = calculateIntermediaryDamage(land);
        int damageToDeal = modifyDamage(intermediarDamage,
                hero.getRace(), land);
        hero.receiveDamage(damageToDeal);
        damageDealtThisRound = modifyDamage(intermediarDamage, NA_RACE, land);
        usedThisRound = true;
        counter = ++counter % LUCKY_TURN;
    }

    @Override
    public void applyTo(final PuppetHero hero, final Character land) {
        if (usedThisRound) {
            hero.receiveDamage(damageDealtThisRound);
        } else {
            hero.receiveDamage(modifyDamage(calculateIntermediaryDamage(land),
                    hero.getRace(), land));
        }
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }

    private int modifyDamage(final float initDamage,
                             final Character race, final Character land) {
        return Math.round(initDamage * landModifier.get(land)
                * raceModifier.get(race));
    }

    private float calculateIntermediaryDamage(final Character land) {
        float multipliedDamage = damage;
        if (counter == 0 && land == landModifier.getPreferredLand()) {
            multipliedDamage *= DAMAGE_MULTIPLIER;
        }
        return multipliedDamage;
    }
}
