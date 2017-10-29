package loop;

import java.util.HashMap;
import java.util.Map;

abstract class Ability implements BasicAbility {

    class RaceModifier { // TODO ar trebui Race modiifer doar sa extinda clasa map?
        private final Map<Character, Float> map = new HashMap<Character, Float>();

        RaceModifier(final Float rogue, final Float knight,
                     final Float pyromancer, final Float wizard) {
            map.put('R', rogue);
            map.put('K', knight);
            map.put('P', pyromancer);
            map.put('W', wizard);
            map.put('N', 1f);
        }

        Float get(final Character key) {
            return map.get(key);
        }
    }

    class LandModifier {
        private final Character preferredLand;
        private final Float modifier;

        LandModifier(final Character preferredLandP, final Float modifierP) {
            this.preferredLand = preferredLandP;
            this.modifier = modifierP;
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
