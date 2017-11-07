/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

final class SlamOverTime extends Ability implements OverTimeEffect {
    SlamOverTime(final Hero hero) {
        hero.stun();
        turns = 1;
    }

    public void applyTo(final Hero hero) {
        if (--turns == 0) {
            hero.unStun();
            hero.finishOvertimeEffect();
        }
    }

    public void levelUp() { }
}
