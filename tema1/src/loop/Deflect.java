/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

final class Deflect extends WizardAbility implements InstantAbility {
    private static final float BASE_PERCENT = 0.35f;
    private static final float BONUS_PERCENT_PER_LEVEL = 0.02f;
    private static final float MAX_PERCENT = 0.7f;
    private static final float RM_ROGUE = 1.2f;
    private static final float RM_KNIGHT = 1.4f;
    private static final float RM_PYROMANCER = 1.3f;
    private static final float RM_WIZARD = 0f;
    private final Hero owner;
    private float percent = BASE_PERCENT;

    Deflect(final Hero owner) {
        super();
        this.owner = owner;
        raceModifier = new RaceModifier(RM_ROGUE, RM_KNIGHT,
                RM_PYROMANCER, RM_WIZARD);
    }

    @Override
    public void applyTo(final Hero hero, final Character land) {
        if (hero.race != 'W') {
            int damage;
            PuppetHero puppet = new PuppetHero(owner.getHp(),
                    owner.getMaxHp());
            hero.applyAbilitiesTo(puppet, land);
            damage = (int) Math.round(puppet.getReceivedDamage() * percent
                    * raceModifier.get(hero.race) * landModifier.get(land));
            hero.receiveDamage(damage);
        }
    }

    @Override
    public void levelUp() {
        percent = Math.min(percent + BONUS_PERCENT_PER_LEVEL, MAX_PERCENT);
    }
}
