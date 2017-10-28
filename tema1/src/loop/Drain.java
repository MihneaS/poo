package loop;

public final class Drain extends WizardAbility implements InstantAbility {
    private Float percent = 0.2f;
    private static final Float BONUS_PERCENT_PER_LEVEL = 0.05f;

    Drain() {
        super();
        raceModifier = new RaceModifier(0.8f, 1.2f, 0.9f, 1.05f);
    }

    @Override
    public void applyTo(Hero hero, Character land) {
        Float damage = percent *
                Math.min(0.3f * hero.getMaxHp(), hero.getHp());
        int modifiedDamage = (int) Math.round(damage *
                raceModifier.get(hero.race) * landModifier.get(land));
        hero.reciveDamage(modifiedDamage);
    }

    @Override
    public void levelUp() {
        percent += BONUS_PERCENT_PER_LEVEL;
    }
}
