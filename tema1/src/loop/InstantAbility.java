/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

interface InstantAbility {
    void applyTo(Hero hero, Character land);

    default void applyTo(final PuppetHero puppet, final Character land) {
        applyTo((Hero) puppet, land);
    }

    void levelUp();

    void refresh();
}
