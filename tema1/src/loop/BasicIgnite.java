package loop;

abstract class BasicIgnite extends PyromancerAbility {

    private static final float RM_ROGUE = 0.8f;
    private static final float RM_KNIGHT = 1.2f;
    private static final float RM_PYROMANCER = 0.9f;
    private static final float RM_WIZARD = 1.05f;

    BasicIgnite() {
        super();
        raceModifier = new RaceModifier(RM_ROGUE, RM_KNIGHT,
                RM_PYROMANCER, RM_WIZARD);
    }
}
