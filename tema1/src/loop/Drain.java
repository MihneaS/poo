package loop;

public final class Drain extends WizardAbility implements InstantAbility {
    private Double percent = 0.2;
    private static final Double BONUS_PERCENT_PER_LEVEL = 0.05;

    Drain() {
        super();
        raceModifier = new RaceModifier(0.8, 1.2, 0.9, 1.05);
    }

    @Override
    public void applyTo(Hero hero, Character land) {
        Double damage = percent *
                Math.min(0.3 * hero.getMaxHp(), hero.getHp());
        int modifiedDamage = (int) Math.round(damage *
                raceModifier.get(hero.race) * landModifier.get(land));
        hero.reciveDamage(modifiedDamage);
    }

    @Override
    public void levelUp() {
        percent += BONUS_PERCENT_PER_LEVEL;
    }
}