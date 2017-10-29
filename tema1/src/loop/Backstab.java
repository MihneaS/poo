package loop;

import static loop.Hero.NA_RACE;

public final class Backstab extends RogueAbility implements InstantAbility {

    private int damage = 200;
    private static final int BONUS_DAMAGE_PER_LEVEL = 20;
    private static final double DAMAGE_MULTIPLIER = 1.5;
    private int counter = 0;

    Backstab() {
        raceModifier = new RaceModifier(1.2f, 0.9f, 1.25f, 1.25f);
    }

    @Override
    public void applyTo(Hero hero, Character land) {
        Double intermediarDamage = calculateIntermediarDamage(hero, land);
        int damageToDeal = modifyDamage(intermediarDamage,
                hero.getRace(), land);
        hero.reciveDamage(damageToDeal);
        damageDealtThisRound = modifyDamage(intermediarDamage, NA_RACE, land);
        usedThisRound = true;
        counter = ++counter % 3;
    }

    private int modifyDamage(Double damage, Character race, Character land) {
        return (int) Math.round(damage * landModifier.get(land) *
                raceModifier.get(race));
    }

    private Double calculateIntermediarDamage(Hero hero, Character land) {
        double multipliedDamage = damage;
        if (counter == 0 && land == landModifier.getPreferredLand()) {
            multipliedDamage *= DAMAGE_MULTIPLIER;
        }
        return multipliedDamage;
    }

    @Override
    public void simulateOn(Hero hero, Character land){
        if (usedThisRound) {
            hero.reciveDamage(damageDealtThisRound);
        } else {
            hero.reciveDamage(modifyDamage(
                    calculateIntermediarDamage(hero, land),
                    hero.getRace(), land));
        }
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
