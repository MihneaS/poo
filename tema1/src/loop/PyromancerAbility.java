/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

abstract class PyromancerAbility extends  Ability {
    static final Character PREFFERED_LAND = 'V';
    static final float MODIFIER = 1.25f;

    PyromancerAbility() {
        landModifier = new LandModifier(PREFFERED_LAND, MODIFIER);
    }
}

