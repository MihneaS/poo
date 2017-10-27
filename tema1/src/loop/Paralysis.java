package loop;

public class Paralysis extends RogueAbility implements InstantAbility {
    protected int damage = 40;
    private final static int BONUS_DAMAGE_PER_LEVEL = 10;

    Paralysis () {
        super();
        raceModifier = new RaceModifier(0.9, 0.8, 1.2, 1.25);
    }

    @Override
    public void applyTo(Hero hero, Character land) {
        double multipliedDamage = damage;
        multipliedDamage *= landModifier.get(land) *
                raceModifier.get(hero.race);
        hero.reciveDamage((int) Math.round(multipliedDamage));
        hero.setOverTimeEffect(new ParalysisOverTime(hero, land));
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
