package loop;

public final class Fireblast extends PyromancerAbility implements InstantAbility{

    private int damage = 350;
    private static final int BONUS_DAMAGE_PER_LEVEL = 50;

    Fireblast() {
        super();
        raceModifier = new RaceModifier(0.8f, 1.2f, 0.9f, 1.05f);
    }

    @Override
    public void applyTo(Hero hero, Character land) {
        int modifiedDamage = (int) Math.round(damage *
                raceModifier.get(hero.race) * landModifier.get(land));
        hero.reciveDamage(modifiedDamage);
    }

    @Override
    public void levelUp() {
        damage += BONUS_DAMAGE_PER_LEVEL;
    }
}

