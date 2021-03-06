/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private static final int XP_THRESHOLD_ADDITION = 50;
    private static final int P_BASE_HP = 500;
    private static final int P_PER_LEVEL_HP = 50;
    private static final int K_BASE_HP = 900;
    private static final int K_PER_LEVEL_HP = 80;
    private static final int W_BASE_HP = 400;
    private static final int W_PER_LEVEL_HP = 30;
    private static final int R_BASE_HP = 600;
    private static final int R_PER_LEVEL_HP = 40;
    private static final int BASE_XP_THRESHOLD = 250;
    private static final int BASE_XP_BONUS = 200;
    private static final int XP_BONUS_PER_LEVEL = 40;
    static final char NA_RACE = 'N';

    protected Character race;
    protected int maxHp;
    protected int hp;
    private int hpPerLevel;
    private int level = 0;
    private int xp = 0;
    private int xpThreshold = BASE_XP_THRESHOLD;
    private boolean alive = true;
    private List<InstantAbility> abilities = new ArrayList<InstantAbility>(2);
    private OverTimeEffect overTimeEffect = new SentinelEffect();
    private boolean stunned = false;
    private boolean toBeUnStunned = false;
    private boolean onCoolDown = false;
    private int row;
    private int col;

    public Hero(final Character race, final int row, final int col) {
        this.race = race;
        this.row = row;
        this.col = col;
        switch (race) {
            case 'P':
                maxHp = P_BASE_HP;
                hpPerLevel = P_PER_LEVEL_HP;
                abilities.add(new Fireblast());
                abilities.add(new Ignite(this));
                break;
            case 'K':
                maxHp = K_BASE_HP;
                hpPerLevel = K_PER_LEVEL_HP;
                abilities.add(new Execute());
                abilities.add(new Slam());
                break;
            case 'W':
                maxHp = W_BASE_HP;
                hpPerLevel = W_PER_LEVEL_HP;
                abilities.add(new Drain());
                abilities.add(new Deflect(this));
                break;
            case 'R':
                maxHp = R_BASE_HP;
                hpPerLevel = R_PER_LEVEL_HP;
                abilities.add(new Backstab());
                abilities.add(new Paralysis(this));
                break;
            default: break;
        }
        hp = maxHp;
    }

    public Hero() { }

    /**
     * Scade damage din hp.
     */
    public void receiveDamage(final int damage) {
        if (hp <= damage) {
            hp = 0;
            alive = false;
        } else {
            hp -= damage;
        }
    }

    public final boolean isAlive() {
        return alive;
    }

    public final void levelUp() {
        maxHp += hpPerLevel;
        hp = maxHp;
        abilities.get(0).levelUp();
        abilities.get(1).levelUp();
        xpThreshold += XP_THRESHOLD_ADDITION;
        ++level;
    }

    public final void applyOverTimeEffect() {
        overTimeEffect.applyTo(this);
    }

    public final void fight(final Hero other, final Character land) {
        if (!isOnCoolDown()) {
            onCoolDown = true;
            if (!other.isAlive()) {
                return;
            }
            applyAbilitiesTo(other, land);
            if (!other.isAlive() && other.getRace() != 'N') {
                other.fight(this, land);
                winXPAndLevelUpFrom(other);
            }
        }
    }

    /**
     * Applies ability to this.
     * Used for double dispatch. Any Overriding should have the same body.
     */
    public void beAffectedBy(final InstantAbility ability, final Character land) {
        ability.applyTo(this, land);
    }

    final void applyAbilitiesTo(final Hero other, final Character land) {
        other.beAffectedBy(abilities.get(0), land);
        other.beAffectedBy(abilities.get(1), land);
    }

    final void setOverTimeEffect(final OverTimeEffect overTimeEffect) {
        this.overTimeEffect = overTimeEffect;
    }

    final void finishOvertimeEffect() {
        overTimeEffect = new SentinelEffect();
    }

    final void stun() {
        stunned = true;
    }

    final void unStun() {
        toBeUnStunned = true;
    }

    public final boolean isStunned() {
        return stunned;
    }

    private void winXPAndLevelUpFrom(final Hero killed) {
        if (this.isAlive()) {
            winXp(killed);
            while (canLevelUp()) {
                levelUp();
            }
        }
    }

    private boolean canLevelUp() {
        return xp >= xpThreshold;
    }

    final int getLevel() {
        return level;
    }

    private void winXp(final Hero other) {
        xp += Math.max(0, BASE_XP_BONUS
                - (level - other.getLevel()) * XP_BONUS_PER_LEVEL);
    }

    final int getHp() {
        return hp;
    }

    final int getMaxHp() {
        return maxHp;
    }

    public final Character getRace() {
        return race;
    }

    final void moveTo(final Character direction) {
        switch (direction) {
            case 'U': row--; break;
            case 'D': row++; break;
            case 'L': col--; break;
            case 'R': col++; break;
            default: break;
        }
    }

    public final void prepareForNextRound() {
        onCoolDown = false;
        abilities.get(0).refresh();
        abilities.get(1).refresh();
        if (toBeUnStunned) {
            toBeUnStunned = false;
            stunned = false;
        }
    }

    final int getCol() {
        return col;
    }

    final int getRow() {
        return row;
    }

    private boolean isOnCoolDown() {
        return onCoolDown;
    }

    @Override
    public final String toString() {
        if (isAlive()) {
            return race + " " + level + " " + xp + " " + hp + " "
                    + row + " " + col;
        } else {
            return race + " dead";
        }
    }
}
