package loop;

import java.lang.Math;

public final class Deflect extends WizardAbility implements InstantAbility {

    private Float percent = 0.35f;
    private static final Float BONUS_PERCENT_PER_LEVEL = 0.02f;
    private static final Float MAX_PERCENT = 0.7f;
    private final Hero owner;

    Deflect(Hero owner) { //adjust for execute
        super();
        this.owner = owner;
        raceModifier = new RaceModifier(1.2f,1.4f, 1.3f, 0f);
    }

    @Override
    public void applyTo(Hero hero, Character land) {
        if (hero.race != 'W') {
            int damage;
            PuppetHero puppet = new PuppetHero(owner.getHp(),
                    owner.getMaxHp());
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
