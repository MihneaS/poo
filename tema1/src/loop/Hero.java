package loop;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractSet;
import java.util.HashSet;

public class Hero {

    private final static int XP_THRESHOLD_ADDITION = 50;
    private final static int P_BASE_HP = 500;
    private final static int P_PER_LEVEL_HP = 50;
    private final static int K_BASE_HP = 900;
    private final static int K_PER_LEVEL_HP = 80;
    private final static int W_BASE_HP = 400;
    private final static int W_PER_LEVEL_HP = 30;
    private final static int R_BASE_HP = 600;
    private final static int R_PER_LEVEL_HP = 40;
    final static char NA_RACE = 'N';

    protected Character race;
    int maxHp;
    int hp;
    private int hpPerLevel;
    private int level = 0;
    private int xp = 0;
    private int xpThreshold = 250;
    private Character land;
    private boolean alive = true;
    private List<InstantAbility> abilities =
            new ArrayList<InstantAbility>(2);
    private OverTimeEffect overTimeEffect = new SentinelEffect();
    private boolean stunned = false;
    private int row;
    private int col;
    private boolean onCoolDown = false;

    public Hero(Character race, int row, int col) {
        this.race = race;
        this.row = row;
        this.col = col;
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
        }
        hp = maxHp;
    }

    public Hero() {
    }


    void reciveDamage(int damage) {
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

    void setOverTimeEffect(final OverTimeEffect overTimeEffect) {
        this.overTimeEffect = overTimeEffect;
    }

    void finishOvertimeEffect () {
        overTimeEffect = new SentinelEffect();
    }

    void stun() {
        stunned = true;
    }

    void unStun() {
        stunned = false;
    }

    void setLand(final Character land) {
        this.land = land;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void applyOverTimeEffect() {
        overTimeEffect.applyTo(this);
    }

    public void applyAbilitiesTo(Hero other, Character land) {
        if (!isOnCoolDown()) {
            onCoolDown = true;
            if (!other.isAlive()) {
                return;
            }
            abilities.get(0).applyTo(other, land);
            abilities.get(1).applyTo(other, land);
            if (!other.isAlive() && other.getRace() != 'N') {
                other.applyAbilitiesTo(this, land);
                winXPAndLevelUpFrom(other);
            }
        }
    }

    public void winXPAndLevelUpFrom(Hero killed) {
        if(this.isAlive()) {
            winXp(killed);
            while (canLevelUp()) {
                levelUp();
            }
        }
    }

    public void simulateDamageOn(Hero hero, Character land) {
        abilities.get(0).simulateOn(hero, land);
        abilities.get(1).simulateOn(hero, land);
    }

    private boolean canLevelUp() {
        return xp > xpThreshold;
    }

    private int getLevel() {
        return level;
    }

    private void winXp(Hero other) {
        xp += Math.max(0, 200 - (level - other.getLevel()) * 40);
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

    void moveTo(Character direction) {
        switch (direction) {
            case 'U': row--; break;
            case 'D': row++; break;
            case 'L': col--; break;
            case 'R': col++; break;
        }
    }

    public void prepareForNextRound() {
        onCoolDown = false;
        abilities.get(0).refresh();
    }

    int getCol() {
        return col;
    }

    int getRow() {
        return row;
    }

    private boolean isOnCoolDown(){
        return onCoolDown;
    }

    @Override
    public String toString() {
        if(isAlive()) {
            return race + " " + level + " " + xp + " " + hp + " " +
                    row + " " + col;
        } else {
            return race + " dead";
        }
    }
}
