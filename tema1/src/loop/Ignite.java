package loop;

class Ignite extends  PyromancerAbility implements InstantAbility{

    private int damage = 150;
    private static final int BONUS_DAMAGE_PER_LEVEL = 30;

    Ignite() {
        super();
        raceModifier = new RaceModifier(0.8f, 1.2f, 0.9f, 1.05f);
    }

    @Override
    public void applyTo(final Hero hero, final Character land) {
        int modifiedDamage = (int) Math.round(damage *
                raceModifier.get(hero.race) * landModifier.get(land));
        hero.reciveDamage(modifiedDamage);
        hero.setOverTimeEffect(new IgniteOverTime(land));
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
