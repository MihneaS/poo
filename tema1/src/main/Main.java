/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

package main;

import decodedfileio.implementations.FileReader;
import decodedfileio.implementations.FileWriter;
import decodedfileio.interfaces.IReader;
import decodedfileio.interfaces.IWriter;

import loop.Hero;
import loop.Terrain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Main {
    private Main() { } //role of this avoid [HideUtilityClassConstructor] error

    public static void main(final String[] args) {
        int n, m, p, r;
        List<String> inputMap;
        String moveCommands;
        IReader input;
        IWriter output;
        Terrain terrain;
        List<Hero> heroes = new ArrayList<Hero>();

        try {
            input = new FileReader(args[0]);
            output = new FileWriter(args[1]);

            n = input.nextInt();
            m = input.nextInt();
            inputMap = new ArrayList<String>(n);
            for (int i = 0; i < n; ++i) {
                inputMap.add(input.nextWord());
            }
            terrain = new Terrain(inputMap, n, m);

            p = input.nextInt();
            for (int i = 0; i < p; ++i) {
                heroes.add(new Hero(input.nextWord().charAt(0),
                        input.nextInt(),
                        input.nextInt()));
                terrain.addHero(heroes.get(i));
            }

            r = input.nextInt();
            for (int i = 0; i < r; ++i) {
                for (Hero hero : heroes) {
                    hero.prepareForNextRound();
                    hero.applyOverTimeEffect();
                }

                moveCommands = input.nextWord();
                for (int j = 0; j < p; ++j) {
                    if (heroes.get(j).isAlive()
                            && !heroes.get(j).isStunned()) {
                        terrain.moveHero(heroes.get(j),
                                moveCommands.charAt(j));
                    }
                }

                for (int j = 0; j < p; ++j) {
                    Hero thisHero;
                    thisHero = heroes.get(j);
                    if (thisHero.isAlive()) {
                        Hero otherHero;
                        otherHero = terrain.otherHeroNextTo(thisHero);
                        if (otherHero != null && otherHero.isAlive()) {
                            thisHero.fight(otherHero,
                                    terrain.getLandType(thisHero));
                            if (!thisHero.isAlive()) {
                                terrain.removeHero(thisHero);
                            }
                            if (!otherHero.isAlive()) {
                                terrain.removeHero(otherHero);
                            }
                        }
                    }
                }
            }

            for (Hero hero: heroes) {
                output.writeWord(hero.toString() + "\n");
            }

            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
