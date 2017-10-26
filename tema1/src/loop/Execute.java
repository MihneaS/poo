package loop;

import java.lang.Math;

public final class Execute extends KnightAbility implements InstantAbility{

    private Double hpLimit = .2;
    private int damage = 200;
    private static final int BONUS_DAMAGE_PER_LEVEL = 30;
    private static final Double BONUS_HP_LIMIT_PER_LEVEL = 0.01;
    private static final Double MAX_HP_LIMIT = 0.4;

    Execute() {
        super();
        raceModifier = new RaceModifier(1.15, 1d, 1.1, 0.8);
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
        hpLimit = Math.min(MAX_HP_LIMIT, hpLimit + BONUS_HP_LIMIT_PER_LEVEL);
    }

    @Override
    public void applyTo( Hero defender, Hero attacker, Character land) {
        int modifiedDamage;
        if ((double) defender.hp < hpLimit * defender.maxHp) {
            defender.reciveDamage(defender.hp,attacker);
        } else {
            modifiedDamage = (int) Math.round(damage *
                    raceModifier.get(defender.race) * landModifier.get(land));
            defender.reciveDamage(modifiedDamage, attacker);
        }
    }

}
