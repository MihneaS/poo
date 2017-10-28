package loop;

import java.util.HashMap;
import java.util.Map;

public abstract class Ability {

    class RaceModifier { // TODO ar trebui Race modiifer doar sa extinda clasa map?
        private final Map<Character, Float> map = new HashMap<Character, Float>();

        RaceModifier(Float rogue, Float knight,
                     Float pyromancer, Float wizard) {
            map.put('R', rogue);
            map.put('K', knight);
            map.put('P', pyromancer);
            map.put('W', wizard);
            map.put('N', 1f);
        }

        Float get(Character key) {
            return map.get(key);
        }
    }

    class LandModifier {
        private final Character preferredLand;
        private final Float modifer;

        LandModifier(Character preferredLand, Float modifer) {
            this.preferredLand = preferredLand;
            this.modifer = modifer;
        }

        Float get (Character land) {
            if (land == preferredLand) {
                return modifer;
            } else {
                return 1f;
            }
        }

        public Character getPreferredLand() {
            return preferredLand;
        }
    }

    protected RaceModifier raceModifier;
    protected LandModifier landModifier;
    protected int turns;

}
