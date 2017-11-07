/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

class Ignite extends BasicIgnite implements InstantAbility {
    private static final int BASE_DAMAGE = 150;
    private static final int BONUS_DAMAGE_PER_LEVEL = 30;
    private int damage = BASE_DAMAGE;
    private final Hero owner;

    Ignite(final Hero owner) {
        super();
        this.owner = owner;
    }

    private int getLevel() {
        return owner.getLevel();
    }

    @Override
    public void applyTo(final Hero hero, final Character land) {
        int modifiedDamage = (int) Math.round(damage
                * raceModifier.get(hero.race) * landModifier.get(land));
        hero.receiveDamage(modifiedDamage);
        hero.setOverTimeEffect(new IgniteOverTime(land, getLevel()));
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}
