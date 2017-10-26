package loop;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Terrain {

    final class Cell{
        char type;
        List<Hero> heroes = new ArrayList<Hero>();
        List<Hero> deadHeroes = new ArrayList<Hero>();

        Cell(char type) {
            this.type = type;
        }

        public char getType() {
            return type;
        }

        public Hero otherHeroThen(Hero thisHero) {
            if(heroes.size() > 2) {
                for (Hero hero: heroes) {
                    if(!hero.isAlive()) {
                        deadHeroes.add(hero);
                    }
                }
                for (Hero hero: deadHeroes) {
                    heroes.remove(hero);
                }
                deadHeroes.clear();
            }
            if (heroes.size() == 2) {
                if (heroes.get(0) == thisHero) {
                    return heroes.get(1);
                } else {
                    return heroes.get(0);
                }
            } else if (heroes.size() == 1) {
                if (heroes.get(0) != thisHero) {
                    return heroes.get(0);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }

        public void addHero(Hero hero) {
            heroes.add(hero);
        }

        public void removeHero(Hero hero) {
            heroes.remove(hero);
        }
    }

    private Cell[][] map;

    public Terrain(List<String> list, int n, int m) {
        map = new Cell[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map[i][j] = new Cell(list.get(i).charAt(j));
            }

        }
    }

    private Cell getCellOf(Hero hero) {
        return map[hero.getRow()][hero.getCol()];
    }

    public void addHero(Hero hero) {
        getCellOf(hero).addHero(hero);
    }

    public void removeHero(Hero hero) {
        getCellOf(hero).removeHero(hero);
    }
    public void moveHero(Hero hero, Character direction) {
        if (!hero.isStunned() && hero.isAlive()) {
            getCellOf(hero).removeHero(hero);
            hero.moveTo(direction);
            getCellOf(hero).addHero(hero);
        }
    }

    public Hero otherHeroNextTo(Hero thisHero) {
        return  getCellOf(thisHero).otherHeroThen(thisHero);
    }

    public Character getLandType(Hero hero) {
        return getCellOf(hero).getType();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Cell[] c : map) {
            for (Cell d : c) {
                result.append(d.toString());
            }
            result.append(String.format("\n"));

        }
        return result.toString();
    }
}
