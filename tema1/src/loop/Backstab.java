package loop;

public final class Backstab extends RogueAbility implements InstantAbility {

    private int damage = 200;
    private static final int BONUS_DAMAGE_PER_LEVEL = 20;
    private static final double DAMAGE_MULTIPLIER = 1.5;
    private int counter = 0;

    Backstab() {
        raceModifier = new RaceModifier(1.2, 0.9, 1.25, 1.25);
    }

    @Override
    public void applyTo(Hero hero, Character land) {
        double multipliedDamage = damage;
        counter = ++counter % 3;
        if (counter == 0 && land == landModifier.getPreferredLand()) {
            multipliedDamage *= DAMAGE_MULTIPLIER;
        }

        multipliedDamage *= landModifier.get(land) *
                raceModifier.get(hero.race);
        hero.reciveDamage((int) Math.round(multipliedDamage));
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
