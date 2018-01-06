/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.builders;

final class Parser {
    private static final int HEX_BASE = 16;
    private static final int ALPHA_FIRST_POSITION = 24;
    private final String[] words;
    private int i = 0;

    Parser(String[] wordsP) {
        this.words = wordsP;
    }

    String nextWord() {
        return words[i++];
    }

    int nextInt() {
        return Integer.parseInt(nextWord());
    }

    int nextColor() {
        String rgb = nextWord();
        int alpha = nextInt();
        int aux = Integer.parseInt(rgb.substring(1), HEX_BASE);
        aux += alpha << ALPHA_FIRST_POSITION;
        return aux;
    }

    void parsePointsVector(final int[] xs, final int[] ys,
                                           final int n) {
        for (int i = 0; i < n; ++i) {
            xs[i] = nextInt();
            ys[i] = nextInt();
        }
    }
}
