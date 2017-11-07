/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

final class Execute extends KnightAbility implements InstantAbility {
    private static final float BASE_HP_LIMIT = 0.2f;
    private static final int BASE_DAMAGE = 200;
    private static final int BONUS_DAMAGE_PER_LEVEL = 30;
    private static final float BONUS_HP_LIMIT_PER_LEVEL = 0.01f;
    private static final float MAX_HP_LIMIT = 0.4f;
    private static final float RM_ROGUE = 1.15f;
    private static final float RM_KNIGHT = 1f;
    private static final float RM_PYROMANCER = 1.1f;
    private static final float RM_WIZARD = 0.8f;
    private float hpLimit = BASE_HP_LIMIT;
    private int damage = BASE_DAMAGE;

    Execute() {
        super();
        raceModifier = new RaceModifier(RM_ROGUE, RM_KNIGHT,
                RM_PYROMANCER, RM_WIZARD);
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
        hpLimit = Math.min(MAX_HP_LIMIT, hpLimit + BONUS_HP_LIMIT_PER_LEVEL);
    }

    @Override
    public void applyTo(final Hero hero, final Character land) {
        int finalDamage;
        int damageForSimulation;
        if ((double) hero.hp < hpLimit * hero.maxHp) {
            finalDamage = hero.hp;
            damageForSimulation = hero.hp;
        } else {
            finalDamage = (int) Math.round(damage
                    * raceModifier.get(hero.race) * landModifier.get(land));
            damageForSimulation = Math.round(damage * landModifier.get(land));
        }
        hero.receiveDamage(finalDamage);
        damageDealtThisRound = damageForSimulation;
        usedThisRound = true;
    }

    @Override
    public void applyTo(final PuppetHero hero, final Character land) {
        if (usedThisRound) {
            hero.receiveDamage(damageDealtThisRound);
        } else {
            applyTo((Hero) hero, land);
        }
    }
}
