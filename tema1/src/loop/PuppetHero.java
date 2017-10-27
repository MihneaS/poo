package loop;

public final class PuppetHero extends Hero {

    PuppetHero() {
        hp = 0;
        race = 'N';
    }

    @Override
    void reciveDamage(int damage) {
        hp += damage;
    }

    public int getReceivedDamage() {
        return hp;
    }
}
