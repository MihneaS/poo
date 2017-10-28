package loop;

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
        simulateOn(hero, land);
        counter = ++counter % 3;
    }

    @Override
    public void simulateOn(Hero hero, Character land){
        double multipliedDamage = damage;
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
