package loop;

abstract class WizardAbility extends Ability{
    WizardAbility() {
        landModifier = new LandModifier('D', 1.1f);
    }
}
