package loop;

class Paralysis extends BasicParalysis implements InstantAbility {

    private static final int BASE_DAMAGE = 40;
    private static final int BONUS_DAMAGE_PER_LEVEL = 10;
    protected int damage = BASE_DAMAGE;
    private final Hero owner;

    Paralysis(final Hero owner) {
        super();
        this.owner = owner;
    }

    private int getLevel() {
        return owner.getLevel();
    }

    @Override
    public void applyTo(final Hero hero, final Character land) {
        double multipliedDamage = damage;
        multipliedDamage *= landModifier.get(land)
                * raceModifier.get(hero.race);
        hero.receiveDamage((int) Math.round(multipliedDamage));
        hero.setOverTimeEffect(
                new ParalysisOverTime(hero, land, getLevel()));
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
