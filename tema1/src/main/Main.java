package main;

import decodedfileio.implementations.FileReader;
import decodedfileio.implementations.FileWriter;
import decodedfileio.interfaces.*;

import loop.*;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n, m, p, r;
        List<String> inputMap;
        String moveCommands;
        IReader input;
        IWriter output;
        Terrain terrain;
        List<Hero> heroes = new ArrayList<Hero>();

        if (args.length == 0) {
            args = new String[2];
            String test = "fightWRW";
            args[0] = "/home/mihnea/facultate/poo/tema1/src/checker/resources/in/" + test + ".in";
            args[1] = "/home/mihnea/facultate/poo/tema1/src/checker/resources/out/" + test + ".out";
        }

        try {
            // Initializize IO objects
            input = new FileReader(args[0]);
            output = new FileWriter(args[1]);

            // Read and create terrain
            n = input.nextInt();
            m = input.nextInt();
            inputMap = new ArrayList<String>(n);
            for (int i = 0; i < n; ++i) {
                inputMap.add(input.nextWord());
            }
            terrain = new Terrain(inputMap, n, m);

            //  Read and initializize heros
            p = input.nextInt();
            for (int i = 0; i < p; ++i) {
                heroes.add(new Hero(input.nextWord().charAt(0),
                        input.nextInt(),
                        input.nextInt()));
                terrain.addHero(heroes.get(i));
            }

            //  Read and execute rounds
            r = input.nextInt();
            List<String> aux = new ArrayList<String>(r);
            for (int i = 0; i < r; ++i) {
                //  Apply over time effect to heroes
                for (Hero hero : heroes) {
                    hero.wearOffCoolDown();
                    Hero attacker = terrain.otherHeroNextTo(hero);
                    if (attacker == null) {
                        attacker = new SentinelHero();
                    }
                    hero.applyOverTimeEffect();
                }

                // Move heroes
                moveCommands = input.nextWord();
                for (int j = 0; j < p; ++j) {
                    if (heroes.get(j).isAlive()
                            && !heroes.get(j).isStunned()) {
                        terrain.moveHero(heroes.get(j),
                                moveCommands.charAt(j));
                    }
                }

                //  FIGHT
                for (int j = 0; j < p; ++j) {
                    Hero thisHero;
                    thisHero = heroes.get(j);
                    if (thisHero.isAlive()) {
                        Hero otherHero;
                        otherHero = terrain.otherHeroNextTo(thisHero);
                        if (otherHero != null && otherHero.isAlive()) {
                            thisHero.applyAbilitiesTo(otherHero,
                                    terrain.getLandType(thisHero));
                            if (!otherHero.isAlive()) {
                                terrain.removeHero(otherHero);
                            }
                        }
                    }
                }
            }

            //  Write output
            for (Hero hero: heroes) {
                output.writeWord(hero.toString() + "\n");
                System.out.print("\n" + hero.toString());
            }
            System.out.println();

            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
