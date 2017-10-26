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

    public void applyTo(Hero defender, Hero attacker) {
        double multipliedDamage = damage;
        multipliedDamage *= landModifier.get(initialLand) *
                raceModifier.get(defender.race);
        defender.reciveDamage((int) Math.round(multipliedDamage), attacker);
        if (--turns == 0) {
            defender.unStun();
            defender.finishOvertimeEffect();
        }
    }

    public void levelUp() {}

}
