package loop;

class Paralysis extends RogueAbility implements InstantAbility {

    private static final int BASE_DAMAGE = 40;
    private static final int BONUS_DAMAGE_PER_LEVEL = 10;
    private static final float RM_ROGUE = 0.9f;
    private static final float RM_KNIGHT = 0.8f;
    private static final float RM_PYROMANCER = 1.2f;
    private static final float RM_WIZARD = 1.25f;
    protected int damage = BASE_DAMAGE;

    Paralysis() {
        super();
        raceModifier = new RaceModifier(RM_ROGUE, RM_KNIGHT,
                RM_PYROMANCER, RM_WIZARD);
    }

    @Override
    public void applyTo(final Hero hero, final Character land) {
        double multipliedDamage = damage;
        multipliedDamage *= landModifier.get(land)
                * raceModifier.get(hero.race);
        hero.reciveDamage((int) Math.round(multipliedDamage));
        hero.setOverTimeEffect(new ParalysisOverTime(hero, land));
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
