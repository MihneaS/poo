/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

final class Drain extends WizardAbility implements InstantAbility {
    private static final float BASE_PERCENT = 0.2f;
    private static final float BONUS_PERCENT_PER_LEVEL = 0.05f;
    private static final float RM_ROGUE = 0.8f;
    private static final float RM_KNIGHT = 1.2f;
    private static final float RM_PYROMANCER = 0.9f;
    private static final float RM_WIZARD = 1.05f;
    private static final float MAXIMUM_AFFECTED_HP_PERCENT = 0.3f;
    private float percent = BASE_PERCENT;

    Drain() {
        super();
        raceModifier = new RaceModifier(RM_ROGUE, RM_KNIGHT,
                RM_PYROMANCER, RM_WIZARD);
    }

    @Override
    public void applyTo(final Hero hero, final Character land) {
        float damage = percent
                * Math.min(
                        MAXIMUM_AFFECTED_HP_PERCENT * hero.getMaxHp(),
                        hero.getHp());
        int modifiedDamage = (int) Math.round(damage
                * raceModifier.get(hero.race) * landModifier.get(land));
        hero.receiveDamage(modifiedDamage);
    }

    @Override
    public void levelUp() {
        percent += BONUS_PERCENT_PER_LEVEL;
    }
}
