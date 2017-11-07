/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

abstract class RogueAbility extends Ability {
    static final Character PREFERRED_LAND = 'W';
    static final float MODIFIER = 1.15f;

    RogueAbility() {
        landModifier = new LandModifier(PREFERRED_LAND, MODIFIER);
    }
}
