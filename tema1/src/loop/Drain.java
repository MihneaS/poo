package loop;

public final class Drain extends WizardAbility implements InstantAbility {
    private Double percent = 0.2;
    private static final Double BONUS_PERCENT_PER_LEVEL = 0.05;

    Drain() {
        super();
        raceModifier = new RaceModifier(0.8, 1.2, 0.9, 1.05);
    }

    @Override
    public void applyTo(Hero defender, Hero attacker, Character land) {
        Double damage = percent *
                Math.min(0.3 * defender.getMaxHp(), defender.getHp());
        int modifiedDamage = (int) Math.round(damage *
                raceModifier.get(defender.race) * landModifier.get(land));
        defender.reciveDamage(modifiedDamage, attacker);
    }

    @Override
    public void levelUp() {
        percent += BONUS_PERCENT_PER_LEVEL;
    }
}