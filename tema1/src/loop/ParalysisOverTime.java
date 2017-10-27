package loop;

public final class ParalysisOverTime extends Paralysis
        implements OverTimeEffect {
    private static final int BASE_TURNS = 3;
    private static final int TURN_MULTIPLIER = 2;
    private final Character initialLand;

    ParalysisOverTime(Hero hero, Character land) {
        super();
        turns = BASE_TURNS;
        if (land == landModifier.getPreferredLand()) {
            turns *= 2;
        }
        initialLand = land;
        hero.stun();
    }

    public void applyTo(Hero hero) {
        double multipliedDamage = damage;
        multipliedDamage *= landModifier.get(initialLand) *
                raceModifier.get(hero.race);
        hero.reciveDamage((int) Math.round(multipliedDamage));
        if (--turns == 0) {
            hero.unStun();
            hero.finishOvertimeEffect();
        }
    }

    public void levelUp() {}

}
