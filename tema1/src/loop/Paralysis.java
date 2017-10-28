package loop;

public class Paralysis extends RogueAbility implements InstantAbility {
    protected int damage = 40;
    private final static int BONUS_DAMAGE_PER_LEVEL = 10;

    Paralysis () {
        super();
        raceModifier = new RaceModifier(0.9f, 0.8f, 1.2f, 1.25f);
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
