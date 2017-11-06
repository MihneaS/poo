package loop;

interface InstantAbility extends BasicAbility {

    void applyTo(Hero hero, Character land);

    default void applyTo(final PuppetHero puppet, final Character land) {
        applyTo((Hero) puppet, land);
    }

    void levelUp();
}
