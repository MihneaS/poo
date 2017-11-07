/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

import java.util.HashMap;
import java.util.Map;

import static loop.Hero.NA_RACE;

abstract class Ability {
    protected class RaceModifier {
        private final Map<Character, Float> map =
                new HashMap<Character, Float>();

        RaceModifier(final Float rogue, final Float knight,
                     final Float pyromancer, final Float wizard) {
            map.put('R', rogue);
            map.put('K', knight);
            map.put('P', pyromancer);
            map.put('W', wizard);
            map.put(NA_RACE, 1f);
        }

        Float get(final Character key) {
            return map.get(key);
        }
    }

    protected class LandModifier {
        private final Character preferredLand;
        private final float modifier;

        LandModifier(final Character preferredLand, final Float modifier) {
            this.preferredLand = preferredLand;
            this.modifier = modifier;
        }

        Float get(final Character land) {
            if (land == preferredLand) {
                return modifier;
            } else {
                return 1f;
            }
        }

        Character getPreferredLand() {
            return preferredLand;
        }
    }

    protected RaceModifier raceModifier;
    protected LandModifier landModifier;
    protected int turns;
    protected int damageDealtThisRound = 0;
    protected boolean usedThisRound = false;

    public final void refresh() {
        damageDealtThisRound = 0;
        usedThisRound = false;
    }
}
