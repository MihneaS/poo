package loop;

public final class Slam extends KnightAbility implements InstantAbility {

    private int damage = 100;
    private static final int BONUS_DAMAGE_PER_LEVEL = 40;

    Slam() {
        raceModifier = new RaceModifier(0.8, 1.2,  0.9, 1.05);
    }

    public void applyTo(final Hero defender, Hero attacker, final Character land) {
        int modifiedDamage = (int) Math.round(damage *
                raceModifier.get(defender.getRace()) * landModifier.get(land));
        defender.reciveDamage(modifiedDamage, attacker);
        defender.setOverTimeEffect(new SlamOverTime(defender));
    }

    public int getDamage() {
        return damage;
    }

    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
