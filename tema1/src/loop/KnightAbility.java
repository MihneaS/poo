package loop;

public abstract class KnightAbility extends Ability {
    KnightAbility() {
        landModifier = new LandModifier('L', 1.15f);
    }
}
