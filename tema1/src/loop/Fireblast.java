package loop;

final class Fireblast extends PyromancerAbility implements InstantAbility {

    private static final int BASE_DAMAGE = 350;
    private static final int BONUS_DAMAGE_PER_LEVEL = 50;
    private static final float RM_ROGUE = 0.8f;
    private static final float RM_KNIGHT = 1.2f;
    private static final float RM_PYROMANCER = 0.9f;
    private static final float RM_WIZARD = 1.05f;
    private int damage = BASE_DAMAGE;

    Fireblast() {
        super();
        raceModifier = new RaceModifier(RM_ROGUE, RM_KNIGHT,
                RM_PYROMANCER, RM_WIZARD);
    }

    @Override
    public void applyTo(final Hero hero, final Character land) {
        int modifiedDamage = (int) Math.round(damage
                * raceModifier.get(hero.race) * landModifier.get(land));
        hero.receiveDamage(modifiedDamage);
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}

