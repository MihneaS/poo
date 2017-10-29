package loop;

public final class PuppetHero extends Hero {

    int receivedDamage = 0;

    PuppetHero(int hp, int maxHp) {
        this.hp = hp;
        this.maxHp = maxHp;
        race = 'N';
    }

    @Override
    void reciveDamage(int damage) {
        receivedDamage += damage;
    }

    public int getReceivedDamage() {
        return receivedDamage;
    }
}
