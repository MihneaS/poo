package loop;

import java.lang.Math;

public final class Deflect extends WizardAbility implements InstantAbility {

    private Double percent = 0.35;
    private static final Double BONUS_PERCENT_PER_LEVEL = 0.02;
    private static final Double MAX_PERCENT = 0.7;

    Deflect() {
        super();
        raceModifier = new RaceModifier(1.2,1.4, 1.3, 0d);
    }

    @Override
    public void applyTo(Hero hero, Character land) {
        if (hero.race != 'W') {
            int damage;
            PuppetHero puppet = new PuppetHero();
            hero.simulateDamageOn(puppet, land);
            damage = (int) Math.round(puppet.getReceivedDamage() * percent *
                    raceModifier.get(hero.race) * landModifier.get(land));
            hero.reciveDamage(damage);
        }
    }

    @Override
    public void levelUp() {
        percent = Math.min(percent + BONUS_PERCENT_PER_LEVEL, MAX_PERCENT);
    }
}
