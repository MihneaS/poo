package loop;

interface InstantAbility extends BasicAbility {
    void applyTo(Hero hero, Character land);
    default void simulateOn(final Hero puppet, final Character land) {
        applyTo(puppet, land
        );
    }
}
