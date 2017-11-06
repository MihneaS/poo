package loop;

abstract class BasicParalysis extends RogueAbility {

    private static final float RM_ROGUE = 0.9f;
    private static final float RM_KNIGHT = 0.8f;
    private static final float RM_PYROMANCER = 1.2f;
    private static final float RM_WIZARD = 1.25f;

    BasicParalysis() {
        super();
        raceModifier = new RaceModifier(RM_ROGUE, RM_KNIGHT,
                RM_PYROMANCER, RM_WIZARD);
    }
}
