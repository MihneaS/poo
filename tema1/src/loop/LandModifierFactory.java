package loop;

import java.util.HashMap;
import java.util.Map;

final class LandModifierFactory {
    static final Character P_PREFFERED_LAND = 'V';
    static final float P_LAND_MODIFIER = 1.25f;
    static final Character K_PREFFERED_LAND = 'L';
    static final float K_LAND_MODIFIER = 1.15f;
    static final Character R_PREFFERED_LAND = 'W';
    static final float R_LAND_MODIFIER = 1.15f;
    static final Character W_PREFFERED_LAND = 'D';
    static final float W_LAND_MODIFIER = 1.1f;

        private Map<Character, Float> modifiers =
                new HashMap<Character, Float>() {{
            put('P', P_LAND_MODIFIER);
            put('K', K_LAND_MODIFIER);
            put('R', R_LAND_MODIFIER);
            put('W', W_LAND_MODIFIER);
        }};
        private Map<Character, Character> prefferedLand =
                new HashMap<Character, Character>() {{
            put('P', P_PREFFERED_LAND);
            put('K', K_PREFFERED_LAND);
            put('R', R_PREFFERED_LAND);
            put('W', W_PREFFERED_LAND);
        }};

        Ability.LandModifier build (Character race) {
            return new Ability().LandModifier(prefferedLand.get(race),
                    modifiers.get(race));
        }
    }
