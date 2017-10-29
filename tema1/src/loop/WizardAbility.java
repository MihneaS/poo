package loop;

abstract class WizardAbility extends Ability {

    static final Character PREFFERED_LAND = 'D';
    static final float MODIFIER = 1.1f;

    WizardAbility() {
        landModifier = new LandModifier(PREFFERED_LAND, MODIFIER);
    }
}
