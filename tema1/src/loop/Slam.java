package loop;

final class Slam extends KnightAbility implements InstantAbility {

    private static final int BASE_DAMAGE = 100;
    private static final int BONUS_DAMAGE_PER_LEVEL = 40;
    private static final float RM_ROGUE = 0.8f;
    private static final float RM_KNIGHT = 1.2f;
    private static final float RM_PYROMANCER = 0.9f;
    private static final float RM_WIZARD = 1.05f;
    private int damage = BASE_DAMAGE;

    Slam() {
        raceModifier = new RaceModifier(RM_ROGUE, RM_KNIGHT,
                RM_PYROMANCER, RM_WIZARD);
    }

    public void applyTo(final Hero hero, final Character land) {
        int modifiedDamage = (int) Math.round(damage *
                raceModifier.get(hero.getRace()) * landModifier.get(land));
        hero.reciveDamage(modifiedDamage);
        hero.setOverTimeEffect(new SlamOverTime(hero));
    }

    public int getDamage() {
        return damage;
    }

    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
