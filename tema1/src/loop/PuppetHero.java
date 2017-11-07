/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

final class PuppetHero extends Hero {
    private int receivedDamage = 0;

    PuppetHero(final int hp, final int maxHp) {
        this.hp = hp;
        this.maxHp = maxHp;
        race = NA_RACE;
    }

    @Override
    public void beAffectedBy(final InstantAbility ability, final Character land) {
        ability.applyTo(this, land);
    }

    @Override
    public void receiveDamage(final int damage) {
        receivedDamage += damage;
    }

    int getReceivedDamage() {
        return receivedDamage;
    }
}
