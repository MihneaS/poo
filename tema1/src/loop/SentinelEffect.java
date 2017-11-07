/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package loop;

/**
 * Implementeaza OverTimeEffect cu functii care nu fac nimic.
 * Este folosita pe post de valoare default a unui OverTimeEffect pentru
 * a evita verificarile cu null la chemarea unui OverTimeEffect
 */
class SentinelEffect implements OverTimeEffect {
    public void applyTo(final Hero hero) { }

    public void levelUp() { }
}
