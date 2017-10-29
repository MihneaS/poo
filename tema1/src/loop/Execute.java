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
    private Float hpLimit = BASE_HP_LIMIT;
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
        int modifiedDamage;
        int damageForSimulation;
        if ((double) hero.hp < hpLimit * hero.maxHp) {
            damageForSimulation = hero.hp;
            hero.reciveDamage(damageForSimulation);
        } else {
            modifiedDamage = (int) Math.round(damage
                    * raceModifier.get(hero.race) * landModifier.get(land));
            damageForSimulation = Math.round(damage * landModifier.get(land));
            hero.reciveDamage(modifiedDamage);
        }
        damageDealtThisRound = damageForSimulation;
        usedThisRound = true;
    }

    @Override
    public void simulateOn(final Hero hero, final Character land) {
        if (usedThisRound) {
            hero.reciveDamage(damageDealtThisRound);
        } else {
            applyTo(hero, land);
        }
    }

}
