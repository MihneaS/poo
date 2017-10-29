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
    private Character land;
    private boolean alive = true;
    private List<InstantAbility> abilities =
            new ArrayList<InstantAbility>(2);
    private OverTimeEffect overTimeEffect = new SentinelEffect();
    private boolean stunned = false;
    private boolean toBeUnStunned = false;
    private int row;
    private int col;
    private boolean onCoolDown = false;

    public Hero(final Character raceP, final int rowP, final int colP) {
        this.race = raceP;
        this.row = rowP;
        this.col = colP;
        switch (race) {
            case 'P':
                maxHp = P_BASE_HP;
                hpPerLevel = P_PER_LEVEL_HP;
                abilities.add(new Fireblast());
                abilities.add(new Ignite());
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
                abilities.add(new Paralysis());
                break;
            default: break;
        }
        hp = maxHp;
    }

    public Hero() {
    }


    void reciveDamage(final int damage) {
        if (hp <= damage) {
            hp = 0;
            alive = false;
        } else {
            hp -= damage;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void levelUp() {
        maxHp += hpPerLevel;
        hp = maxHp;
        abilities.get(0).levelUp();
        abilities.get(1).levelUp();
        xpThreshold += XP_THRESHOLD_ADDITION;
        ++level;
    }

    void setOverTimeEffect(final OverTimeEffect overTimeEffectP) {
        this.overTimeEffect = overTimeEffectP;
    }

    void finishOvertimeEffect() {
        overTimeEffect = new SentinelEffect();
    }

    void stun() {
        stunned = true;
    }

    void unStun() {
        toBeUnStunned = true;
    }

    void setLand(final Character landP) {
        this.land = landP;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void applyOverTimeEffect() {
        overTimeEffect.applyTo(this);
    }

    public void applyAbilitiesTo(final Hero other, final Character landP) {
        if (!isOnCoolDown()) {
            onCoolDown = true;
            if (!other.isAlive()) {
                return;
            }
            abilities.get(0).applyTo(other, landP);
            abilities.get(1).applyTo(other, landP);
            if (!other.isAlive() && other.getRace() != 'N') {
                other.applyAbilitiesTo(this, landP);
                winXPAndLevelUpFrom(other);
            }
        }
    }

    private void winXPAndLevelUpFrom(final Hero killed) {
        if (this.isAlive()) {
            winXp(killed);
            while (canLevelUp()) {
                levelUp();
            }
        }
    }

    void simulateDamageOn(final Hero hero, final Character landP) {
        abilities.get(0).simulateOn(hero, landP);
        abilities.get(1).simulateOn(hero, landP);
    }

    private boolean canLevelUp() {
        return xp >= xpThreshold;
    }

    private int getLevel() {
        return level;
    }

    private void winXp(final Hero other) {
        xp += Math.max(0, BASE_XP_BONUS
                - (level - other.getLevel()) * XP_BONUS_PER_LEVEL);
    }

    int getHp() {
        return hp;
    }

    int getMaxHp() {
        return maxHp;
    }

    public Character getLand() {
        return land;
    }

    public Character getRace() {
        return race;
    }

    void moveTo(final Character direction) {
        switch (direction) {
            case 'U': row--; break;
            case 'D': row++; break;
            case 'L': col--; break;
            case 'R': col++; break;
            default: break;
        }
    }

    public void prepareForNextRound() {
        onCoolDown = false;
        abilities.get(0).refresh();
        abilities.get(1).refresh();
        if (toBeUnStunned) {
            toBeUnStunned = false;
            stunned = false;
        }
    }

    int getCol() {
        return col;
    }

    int getRow() {
        return row;
    }

    private boolean isOnCoolDown() {
        return onCoolDown;
    }

    @Override
    public String toString() {
        if (isAlive()) {
            return race + " " + level + " " + xp + " " + hp + " "
                    + row + " " + col;
        } else {
            return race + " dead";
        }
    }
}
