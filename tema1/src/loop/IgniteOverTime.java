package loop;

final class IgniteOverTime extends Ignite implements OverTimeEffect{

    private int damage = 50;
    private static final int BONUS_DAMAGE_PER_LEVEL = 30;
    private final Character initialLand;

    IgniteOverTime(Character land) {
        super();
        initialLand = land;
        turns = 2;
    }

    public void applyTo(Hero hero) {
        int modifiedDamage = (int) Math.round(damage *
                raceModifier.get(hero.race) * landModifier.get(initialLand));
        hero.reciveDamage(modifiedDamage);
        if (--turns == 0) {
            hero.finishOvertimeEffect();
        }

    }

    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
