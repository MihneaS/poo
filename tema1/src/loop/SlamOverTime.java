package loop;

public final class SlamOverTime extends Ability implements OverTimeEffect {

    SlamOverTime(Hero hero) {
        hero.stun();
        turns = 1;
    }

    public void applyTo(Hero defender, Hero attacker) {
        if (--turns == 0) {
            defender.unStun();
            defender.finishOvertimeEffect();
        }
    }

    public void levelUp() {}
}
