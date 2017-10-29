package loop;

final class PuppetHero extends Hero {

    private int receivedDamage = 0;

    PuppetHero(final int hpP, final int maxHpP) {
        this.hp = hpP;
        this.maxHp = maxHpP;
        race = NA_RACE;
    }

    @Override
    void reciveDamage(final int damage) {
        receivedDamage += damage;
    }

    int getReceivedDamage() {
        return receivedDamage;
    }
}
