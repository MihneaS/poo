package loop;

abstract class KnightAbility extends Ability {
    KnightAbility() {
        landModifier = new LandModifier('L', 1.15f);
    }
}
