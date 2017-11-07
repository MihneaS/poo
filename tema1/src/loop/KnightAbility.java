/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

abstract class KnightAbility extends Ability {
    static final Character PREFFERED_LAND = 'L';
    static final float MODIFIER = 1.15f;

    KnightAbility() {
        landModifier = new LandModifier(PREFFERED_LAND, MODIFIER);
    }
}
