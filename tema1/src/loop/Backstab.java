package loop;

import static loop.Hero.NA_RACE;

final class Backstab extends RogueAbility implements InstantAbility {

    private static final int BASE_DAMAGE = 200;
    private static final int BONUS_DAMAGE_PER_LEVEL = 20;
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
        Float intermediarDamage = calculateIntermediarDamage(land);
        int damageToDeal = modifyDamage(intermediarDamage,
                hero.getRace(), land);
        hero.reciveDamage(damageToDeal);
        damageDealtThisRound = modifyDamage(intermediarDamage, NA_RACE, land);
        usedThisRound = true;
        counter = ++counter % 3;
    }

    private int modifyDamage(final Float damage,
                             final Character race, final Character land) {
        return (int) Math.round(damage * landModifier.get(land) *
                raceModifier.get(race));
    }

    private Float calculateIntermediarDamage(final Character land) {
        float multipliedDamage = damage;
        if (counter == 0 && land == landModifier.getPreferredLand()) {
            multipliedDamage *= DAMAGE_MULTIPLIER;
        }
        return multipliedDamage;
    }

    @Override
    public void simulateOn(final Hero hero, final Character land){
        if (usedThisRound) {
            hero.reciveDamage(damageDealtThisRound);
        } else {
            hero.reciveDamage(modifyDamage(calculateIntermediarDamage(land),
                    hero.getRace(), land));
        }
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
