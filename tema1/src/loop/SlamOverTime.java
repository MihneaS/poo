package loop;

public final class SlamOverTime extends Ability implements OverTimeEffect {

    SlamOverTime(Hero hero) {
        hero.stun();
        turns = 1;
    }

    public void applyTo(final Hero hero) {
        if (--turns == 0) {
            hero.unStun();
            hero.finishOvertimeEffect();
        }
    }

    public void levelUp() {}
}
