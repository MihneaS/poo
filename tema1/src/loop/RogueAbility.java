package loop;

abstract class RogueAbility extends Ability {

    static final Character PREFFERED_LAND = 'W';
    static final float MODIFIER = 1.15f;

    RogueAbility() {
        landModifier = new LandModifier(PREFFERED_LAND, MODIFIER);
    }
}
