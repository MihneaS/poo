package loop;

import java.util.ArrayList;
import java.util.List;

public final class Terrain {

    final class Cell {
        private char type;
        private List<Hero> heroes = new ArrayList<Hero>();
        private List<Hero> deadHeroes = new ArrayList<Hero>();

        Cell(final char type) {
            this.type = type;
        }

        char getType() {
            return type;
        }

        Hero otherHeroThen(final Hero thisHero) {
            if (heroes.size() > 2) {
                for (Hero hero: heroes) {
                    if (!hero.isAlive()) {
                        deadHeroes.add(hero);
                    }
                }
                heroes.removeAll(deadHeroes);
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

        void addHero(final Hero hero) {
            heroes.add(hero);
        }

        void removeHero(final Hero hero) {
            heroes.remove(hero);
        }
    }

    private Cell[][] map;

    public Terrain(final List<String> list, final int n, final int m) {
        map = new Cell[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map[i][j] = new Cell(list.get(i).charAt(j));
            }

        }
    }

    private Cell getCellOf(final Hero hero) {
        return map[hero.getRow()][hero.getCol()];
    }

    public void addHero(final Hero hero) {
        getCellOf(hero).addHero(hero);
    }

    public void removeHero(final Hero hero) {
        getCellOf(hero).removeHero(hero);
    }
    public void moveHero(final Hero hero, final Character direction) {
        if (!hero.isStunned() && hero.isAlive()) {
            getCellOf(hero).removeHero(hero);
            hero.moveTo(direction);
            getCellOf(hero).addHero(hero);
        }
    }

    public Hero otherHeroNextTo(final Hero thisHero) {
        return  getCellOf(thisHero).otherHeroThen(thisHero);
    }

    public Character getLandType(final Hero hero) {
        return getCellOf(hero).getType();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Cell[] c : map) {
            for (Cell d : c) {
                result.append(d.toString());
            }
            result.append("\n");

        }
        return result.toString();
    }
}
