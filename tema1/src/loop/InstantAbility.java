package loop;

public interface InstantAbility extends BasicAbility{
    void applyTo(Hero hero, Character land);
    default void simulateOn(Hero puppet, Character land) {
        applyTo(puppet, land
        );
    }
}
