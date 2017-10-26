package loop;

import java.util.HashMap;
import java.util.Map;

public abstract class Ability {

    class RaceModifier { // TODO ar trebui Race modiifer doar sa extinda clasa map?
        private final Map<Character, Double> map = new HashMap<Character, Double>();

        RaceModifier(Double rogue, Double knight,
                     Double pyromancer, Double wizard) {
            map.put('R', rogue);
            map.put('K', knight);
            map.put('P', pyromancer);
            map.put('W', wizard);
            map.put('N', 1d);
        }

        Double get(Character key) {
            return map.get(key);
        }
    }

    class LandModifier {
        private final Character preferredLand;
        private final Double modifer;

        LandModifier(Character preferredLand, Double modifer) {
            this.preferredLand = preferredLand;
            this.modifer = modifer;
        }

        Double get (Character land) {
            if (land == preferredLand) {
                return modifer;
            } else {
                return 1d;
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
