package loop;

abstract class RogueAbility extends Ability {

    RogueAbility() {
        landModifier = new LandModifier('W', 1.15f);
    }
}
