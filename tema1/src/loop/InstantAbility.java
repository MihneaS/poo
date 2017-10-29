package loop;

interface InstantAbility extends BasicAbility{
    void applyTo(final Hero hero, final Character land);
    default void simulateOn(final Hero puppet, final Character land) {
        applyTo(puppet, land
        );
    }
}
